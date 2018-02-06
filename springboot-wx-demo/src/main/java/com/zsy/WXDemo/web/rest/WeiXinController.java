package com.zsy.WXDemo.web.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zsy.WXDemo.common.Constant;
import com.zsy.WXDemo.domain.wx.AccessToken;
import com.zsy.WXDemo.domain.wx.CreateMenu;
import com.zsy.WXDemo.domain.wx.MenuOne;
import com.zsy.WXDemo.domain.wx.MenuTwo;
import com.zsy.WXDemo.domain.wx.WeiXinActionInfo;
import com.zsy.WXDemo.domain.wx.WeiXinQRCode;
import com.zsy.WXDemo.domain.wx.WeiXinScene;
import com.zsy.WXDemo.domain.wx.WxCheck;
import com.zsy.WXDemo.utils.CheckoutUtil;
import com.zsy.WXDemo.utils.HttpRequestUtil;
import com.zsy.WXDemo.utils.QRCodeUtils;

@RestController
public class WeiXinController {

	@Value("${wx.appID}")
	private String appID;
	
	@Value("${wx.appsecret}")
	private String appsecret;
	
	/**
	 * 获取 token
	 */
	@Value("${wx.access_token}")
	private String token_path;
	
	/**
	 * 创建菜单 url
	 */
	@Value("${wx.createMenu}")
	private String createMenuUrl;
	
	/**
	 * 删除菜单
	 */
	@Value("${wx.deleteMenu}")
	private String deleteMenuUrl;
	
	/**
	 * 生成二维码url
	 */
	@Value("${wx.qr.getpath}")
	private String qrCodePath;
	
	/**
	 * 生成二维码图片url
	 */
	@Value("${wx.qr.ticket.getpath}")
	private String qrCodeTicketPath;
	
	/**
	 * 授权  获得用户 code
	 */
	@Value("${wx.user.code.getpath}")
	private String authCodeUrl;
	
	
	@RequestMapping(value="/wx")
	public void index(WxCheck check,HttpServletResponse response){
		if(null!=check){
			 if (check.getSignature() != null && CheckoutUtil.checkSignature(check.getSignature(), check.getTimestamp(), check.getNonce())) {
	             System.out.println(check.getEchostr()); 
	             OutputStream out;
	             response.setContentType("text/html;charset=UTF-8");
	             try {
					out = response.getOutputStream();
					 out.write(check.getEchostr().getBytes("UTF-8"));
		             out.flush();
		             out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	            
	            }			
		}
	}
	
	
	
	/**
	 * 获取微信token
	 * @return
	 */
	@RequestMapping("/getToken")
	public String getToken(){
		String token=null;
		try {
			token= HttpRequestUtil.getAccessToken(token_path,appID, appsecret);
			if(null!=token){
				AccessToken accessToken=(AccessToken) JSON.parseObject(token,AccessToken.class);
				token=accessToken.getToken();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return token;
		}
		
		
	}
	
	/**
	 * 创建菜单
	 */
	@RequestMapping("/createMenu")
	public void createMenu(){
		MenuOne codeMenu=new MenuOne();
		codeMenu.setName("获取二维码");
		codeMenu.setType(Constant.MENU_CLICK);
		codeMenu.setKey("V001_GET_EWM");
		codeMenu.setUrl("http://uh5njq.natappfree.cc/qrimg");
		
		MenuOne actionMenu=new MenuOne();
		actionMenu.setName("活动");
//		actionMenu.setType(Constant.MENU_VIEW);
		
		List<MenuTwo> subBtns=new ArrayList<MenuTwo>();
		MenuTwo applyMenu=new MenuTwo();
		applyMenu.setName("歌唱比赛");
		applyMenu.setType(Constant.MENU_VIEW);
		applyMenu.setUrl("http://uh5njq.natappfree.cc/apply");
		subBtns.add(applyMenu);
		
		actionMenu.setSub_button(subBtns);
		CreateMenu createMenu=new CreateMenu();
		List<MenuOne> buttons=new ArrayList<MenuOne>();
		buttons.add(codeMenu);
		buttons.add(actionMenu);
		createMenu.setButtons(buttons);
		
		String json=JSON.toJSON(createMenu).toString();
		TreeMap<String, String> map=new TreeMap<String, String>();
		map.put("access_token", getToken());
		
		HttpRequestUtil.HttpDefaultExecute(RequestMethod.POST.toString(), createMenuUrl, map, json);
		
	}
	
	
	@RequestMapping("/deletemenu")
	public void deleteMenu(){
		TreeMap<String, String> map=new TreeMap<String, String>();
		map.put("access_token", getToken());
		String result=HttpRequestUtil.HttpDefaultExecute(RequestMethod.GET.toString(), deleteMenuUrl, map, null);
	    System.out.println(result);
	}
	
	/**
	 * 生成指定跳转地址的微信二维码地址
	 * @param applyUrl
	 * @return
	 */
	@RequestMapping("/generateWXUrl")
	public String generateWXUrl(String applyUrl){
		
		TreeMap<String, String> map=new TreeMap<String, String>();
		map.put("appid", appID);
		map.put("redirect_uri", URLEncoder.encode(applyUrl));
		map.put("response_type", "code");
		map.put("scope", "snsapi_bas");
		map.put("state","123#wechat_redirect");
		String realUrl=null;
		
		try {
			realUrl=HttpRequestUtil.setParmas(map, authCodeUrl,"");
			System.out.println(realUrl);
			WeiXinScene scene=new WeiXinScene();
			scene.setScene_str(realUrl);
			realUrl=getQRImg(scene);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return realUrl;
	}
	
	
	/**
	 * 获取二维码
	 * @return
	 */
	@RequestMapping("/getqrcode")
	public String getQRCode(WeiXinScene scene){
		
		WeiXinQRCode   xinQRCode=new WeiXinQRCode();
		
		xinQRCode.setExpire_seconds(180L);
		xinQRCode.setAction_name(Constant.QR_CODE_LIMIT);
		
		WeiXinActionInfo actionInfo=new WeiXinActionInfo();
		actionInfo.setScene(scene);
		
		xinQRCode.setAction_info(actionInfo);
		
		TreeMap<String, String> map=new TreeMap<String, String>();
		map.put("access_token", getToken());
		
		String result="";
		try {
			result = QRCodeUtils.createTempTicket(qrCodePath ,xinQRCode,map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	/**
	 * 获取二维码图片
	 */
	@RequestMapping("/getqrimg")
	public String getQRImg(WeiXinScene scene){
		String url="";
		try {
			String ticket=getQRCode(scene);
			url=QRCodeUtils.showQrcode(qrCodeTicketPath, ticket);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return url;
		}
	}
	
}

package com.zsy.WXDemo.utils;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.zsy.WXDemo.domain.wx.WeiXinQRCode;
import com.zsy.WXDemo.domain.wx.WeiXinResult;

public class QRCodeUtils {
	
	/** 
	 * 创建临时带参数二维码 
	 * @param accessToken 
	 * @expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。 
	 * @param sceneId 场景Id 
	 * @return 
	 * @throws Exception 
	 */  
	public static String createTempTicket(String url, WeiXinQRCode weiXinQRCode,TreeMap<String,String> map) throws Exception {  
	    WeiXinQRCode wxQRCode = null;  
	      
	    String data = JSON.toJSONString(weiXinQRCode);  
	    data = HttpRequestUtil.HttpDefaultExecute(RequestMethod.POST.toString(),url,map,data);  
	    try {  
	        wxQRCode = JSON.parseObject(data, WeiXinQRCode.class);  
	    } catch (Exception e) {  
	        wxQRCode = null;  
	        e.printStackTrace();  
	    }  
	    return wxQRCode==null?null:wxQRCode.getTicket();  
	  
	}  
	
	/** 
	 * 获取二维码ticket后，通过ticket换取二维码图片展示 
	 * @param ticket 
	 * @return 
	 */  
	public static String showQrcode(String url,String ticket){  
	    Map<String,String> params = new TreeMap<String,String>();  
	    params.put("ticket", HttpRequestUtil.urlEncode(ticket, HttpRequestUtil.DEFAULT_CHARSET));  
	    try {  
	        url = HttpRequestUtil.setParmas(params,url,"");  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return url;  
	}  
	  
	/** 
	 * 获取二维码ticket后，通过ticket换取二维码图片 
	 * @param ticket 
	 * @param savePath  保存的路径,例如 F:\\test\test.jpg 
	 * @return      Result.success = true 表示下载图片下载成功 
	 */  
	public static WeiXinResult showQrcode(String ticket,String url,String savePath) throws Exception{  
	    TreeMap<String,String> params = new TreeMap<String,String>();  
	    params.put("ticket", HttpRequestUtil.urlEncode(ticket, HttpRequestUtil.DEFAULT_CHARSET));  
	    WeiXinResult result = HttpRequestUtil.downMeaterMetod(params,RequestMethod.GET.toString(),url,savePath);  
	    return result;  
	}  

}

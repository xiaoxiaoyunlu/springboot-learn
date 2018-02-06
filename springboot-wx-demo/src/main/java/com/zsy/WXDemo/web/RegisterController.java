package com.zsy.WXDemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsy.WXDemo.common.Code;
import com.zsy.WXDemo.common.Constant;
import com.zsy.WXDemo.domain.db.Result;
import com.zsy.WXDemo.domain.db.User;
import com.zsy.WXDemo.service.IUserService;

@Controller
public class RegisterController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	@RequestMapping("/apply")
	public String register(User user, Model model) {
		// 通过授权获取该用户的，微信open_id,user_name,address,大赛类别，第几届
		user.setType(Constant.COMPETION_TYPE);
		user.setCount(Constant.COMPETION_FIRST);
		user.setOpen_id("1213456789");
		user.setPhone("13459065381");
		user.setUser_name("xiaoxiaoynlu");
		model.addAttribute("user", user);
		return "apply";
	}

	@RequestMapping("/save")
	@ResponseBody
	public Result save(User user) {
		Result result = null;
		String message = null;
		try {
			int check=userService.checkRegister(user.getOpen_id());
			if(check!=1){
				userService.register(user);
				message = "报名成功";
				result = new Result(message);
			}else {
				message = "您已报名！";
				result = new Result(message);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			result = new Result(Code.SYSTEM_ERROR.getCode(),
					Code.SYSTEM_ERROR.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/qrimg")
	public String arImg(Model model){
		String url="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQGo7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyRXV5NEJMZXRmOWgxanpudjFxMS0AAgQvF19aAwS0AAAA";
		model.addAttribute("qrimg", url);
		return "qrimg";
	}

}

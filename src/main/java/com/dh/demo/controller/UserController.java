package com.dh.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.dh.demo.common.ReturnMap;
import com.dh.demo.entity.User;
import com.dh.demo.service.userservice.UserService;
import com.dh.demo.util.ConstantUtil;
import com.dh.demo.util.JWTUtils;

@Controller
@RequestMapping(value="/user/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="login.do")
	 ReturnMap<User> login( HttpServletRequest request,@RequestParam(value="username") String username,@RequestParam(value="pwd") String pwd,
			@RequestParam(value="checked") String checked){
		ReturnMap<User> rm=new ReturnMap<User>();
		if(username==null||username.length()==0||pwd==null||pwd.length()==0){
			rm.setRetcode(ConstantUtil.ERRORCODE);
			rm.setRetmessage("�û����������벻��Ϊ��");
			return rm;
		}
		try{
			User user=userService.login(username, pwd);
			if(user==null){
				rm.setRetcode(ConstantUtil.ERRORCODE);
				rm.setRetmessage("�û������������");
				return rm;
			}
//			request.getSession();
			String token= JWTUtils.createToken(username, pwd, user.getUserId());//��֤�ɹ��� ����token
			rm.setToken(token);
			rm.setRetcode(ConstantUtil.SUCCESSCODE);
		}catch(Exception e){
			e.printStackTrace();
			rm.setRetcode(ConstantUtil.ERRORCODE);
			rm.setRetmessage("��½ʱ�����쳣!");
		}
		return rm;
	}
	
	@ResponseBody
	@RequestMapping(value="fun1.do")
	public ReturnMap fun1(HttpServletRequest request,HttpServletResponse response){
		
		ReturnMap returnMap=new ReturnMap();
		returnMap.setRetcode(ConstantUtil.SUCCESSCODE);
		return returnMap;
	}

	 
}

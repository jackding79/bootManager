package com.dh.demo.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * jwt json web token 组成
 * header 头部  1.声明类型 jwt 2.声明加密算法
 * plaload 载荷  存放有效信息的地方
 * singnature 签名   将header和playload经过base64转化后通过.连接,然后通过header中声明的加密方式对secret加密再用.连接
 * 
 *   
 * 一般在请求头放入token  
 * @author 素衣闻香
 *
 */
public class JWTUtils {
	public static String SECRET="com.dh.demo";
	/**
	 * 用username pwd 和userid生成token 返回前端
	 * @param username
	 * @param pwd
	 * @param userid
	 * @return
	 * @throws IllegalArgumentException
	 * @throws JWTCreationException
	 * @throws UnsupportedEncodingException
	 */
	public static String createToken(String username,String pwd,String userid) throws IllegalArgumentException, JWTCreationException, UnsupportedEncodingException{
		Date sngdate=new Date();//token签发时间
		Calendar nowdate=Calendar.getInstance();
		nowdate.add(Calendar.SECOND, 60);
		Date expdate=nowdate.getTime();//token过期时间
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("alg", "HS256");
		map.put("typ", "JWT");
		String token=JWT.create().withHeader(map).withClaim("username", username)
					.withClaim("pwd", pwd).withClaim("userid", userid).withExpiresAt(expdate).withIssuedAt(sngdate)
					.sign(Algorithm.HMAC256(SECRET));
		return token;
	}
	/**
	 * 验证token
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Claim> verifyToken(String token) throws Exception{
		JWTVerifier verifier=JWT.require(Algorithm.HMAC256(SECRET)).build();
		DecodedJWT jwt=null;
		try{
		jwt=verifier.verify(token);
		}catch(TokenExpiredException e){
			throw new TokenExpiredException("凭证过期!");
		}catch(JWTDecodeException e){
			throw new JWTDecodeException("token验证失败");
		}		
		return jwt.getClaims();
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		/*
		 * String token = JWTUtils.createToken("jack","123456","1");
		 * 
		 * System.out.println(token); Thread.sleep(5000); //正常测试 Map<String, Claim>
		 * verifyToken = JWTUtils.verifyToken(token); String asString =
		 * verifyToken.get("username").asString(); System.out.println(asString);
		 */
		 List<String> list=new ArrayList<String>();
		 list.add("ddd");
		 list.add("ddddddd");
		 System.out.println(JSONArray.toJSONString(list));
		 System.out.println(list.toArray()) ;
	}
	
	
	
	
	
	
	
	
	
	

	
	
 }

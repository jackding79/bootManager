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
 * jwt json web token ���
 * header ͷ��  1.�������� jwt 2.���������㷨
 * plaload �غ�  �����Ч��Ϣ�ĵط�
 * singnature ǩ��   ��header��playload����base64ת����ͨ��.����,Ȼ��ͨ��header�������ļ��ܷ�ʽ��secret��������.����
 * 
 *   
 * һ��������ͷ����token  
 * @author ��������
 *
 */
public class JWTUtils {
	public static String SECRET="com.dh.demo";
	/**
	 * ��username pwd ��userid����token ����ǰ��
	 * @param username
	 * @param pwd
	 * @param userid
	 * @return
	 * @throws IllegalArgumentException
	 * @throws JWTCreationException
	 * @throws UnsupportedEncodingException
	 */
	public static String createToken(String username,String pwd,String userid) throws IllegalArgumentException, JWTCreationException, UnsupportedEncodingException{
		Date sngdate=new Date();//tokenǩ��ʱ��
		Calendar nowdate=Calendar.getInstance();
		nowdate.add(Calendar.SECOND, 60);
		Date expdate=nowdate.getTime();//token����ʱ��
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("alg", "HS256");
		map.put("typ", "JWT");
		String token=JWT.create().withHeader(map).withClaim("username", username)
					.withClaim("pwd", pwd).withClaim("userid", userid).withExpiresAt(expdate).withIssuedAt(sngdate)
					.sign(Algorithm.HMAC256(SECRET));
		return token;
	}
	/**
	 * ��֤token
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
			throw new TokenExpiredException("ƾ֤����!");
		}catch(JWTDecodeException e){
			throw new JWTDecodeException("token��֤ʧ��");
		}		
		return jwt.getClaims();
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		/*
		 * String token = JWTUtils.createToken("jack","123456","1");
		 * 
		 * System.out.println(token); Thread.sleep(5000); //�������� Map<String, Claim>
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

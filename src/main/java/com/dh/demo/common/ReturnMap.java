package com.dh.demo.common;

import java.util.List;

public class ReturnMap<T> {
	private String retcode;
	private String retmessage;
	private String token;
	private T entity;
	private List<T> enlist;
	public ReturnMap(String retcode,String retmessage){
		this.retcode=retcode;
		this.retmessage=retmessage;
	}
	public ReturnMap(String retcode,String retmessage,T entity){
		this.retcode=retcode;
		this.retmessage=retmessage;
		this.entity=entity;
	}
	public ReturnMap(String retcode,String retmessage,List<T> enlist){
		this.retcode=retcode;
		this.retmessage=retmessage;
		this.enlist=enlist;
		
	}
	public ReturnMap(){
		
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	public String getRetmessage() {
		return retmessage;
	}
	public void setRetmessage(String retmessage) {
		this.retmessage = retmessage;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public List<T> getEnlist() {
		return enlist;
	}
	public void setEnlist(List<T> enlist) {
		this.enlist = enlist;
	}
}

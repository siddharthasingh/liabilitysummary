package com.cub.ao.loan.vo;

import java.util.List;

public class AOUpdatedAccountsInfo {
	private String message;
    
    private List<String> jsonAccountInfoList;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<String> getJsonAccountInfoList() {
		return jsonAccountInfoList;
	}
	public void setJsonAccountInfoList(List<String> jsonAccountInfoList) {
		this.jsonAccountInfoList = jsonAccountInfoList;
	}
    
}

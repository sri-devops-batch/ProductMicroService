package com.skj.gtest.dto;
import org.springframework.stereotype.Component;

@Component
public class ErrorDTO  implements MyDTO{
	private String errorMsg;

	public ErrorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDTO(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "ErrorDTO [errorMsg=" + errorMsg + "]";
	}





}
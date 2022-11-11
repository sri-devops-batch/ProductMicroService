package com.skj.gtest.exception;

public class AllExceptionDTO {
	private String msg;
private String userInput;
private String dateAndTime;
public AllExceptionDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public AllExceptionDTO(String msg, String userInput, String dateAndTime) {
	super();
	this.msg = msg;
	this.userInput = userInput;
	this.dateAndTime = dateAndTime;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getUserInput() {
	return userInput;
}
public void setUserInput(String userInput) {
	this.userInput = userInput;
}
public String getDateAndTime() {
	return dateAndTime;
}
public void setDateAndTime(String dateAndTime) {
	this.dateAndTime = dateAndTime;
}
@Override
public String toString() {
	return "AllExceptionDTO [msg=" + msg + ", userInput=" + userInput + ", dateAndTime=" + dateAndTime + "]";
}


}
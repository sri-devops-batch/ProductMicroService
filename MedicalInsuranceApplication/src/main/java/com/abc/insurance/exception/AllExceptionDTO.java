package com.abc.insurance.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllExceptionDTO {
	private String msg;
	private String adminInput;
	private String dateAndTime;
}
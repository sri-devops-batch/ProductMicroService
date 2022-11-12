package com.abc.insurance.dto;

import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DefaultResponseDTO {
	private String insuranceName;
	private int  hId;
	private String clientName;
	private String remarks;
	
}
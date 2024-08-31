package com.fds.exception;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	
	private String code;
	private String message;
	private LocalDateTime date;
	public ErrorResponse(String code, String message) {
		this.code = code;
		this.message = message;
		this.date =LocalDateTime.now();
	}
	
	
}

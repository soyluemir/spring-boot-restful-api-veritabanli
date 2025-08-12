package com.emirhansoylu.exception;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class ApiError<T> {
	
	private String id;
	
	private Date errorTime;
	
	private T errors;

}

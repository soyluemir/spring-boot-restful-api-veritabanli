package com.emirhansoylu.exception;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  //exceptionlar bu sınıfın üstünden handle edilecek
public class GlobalExceptionHandler {
	//exception yakalayıcısı anatasyonu
	
	
	private List<String> addMapValue(List<String> list , String newValue){
		list.add(newValue);
		return list;
	}
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class) // fırlatılan exception classının adını veriyoruz
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		//	ex.getBindingResult().getAllErrors(); //bütün hata mesajları bunun içerisinde//exceptionu parametre olarak geçirdik çünkü exception 
																							//içindeki değerlere erişmek için field mesajalr gibi 
		Map<String, List<String>> errorsMap = new HashMap<>();         
																																		
		for (ObjectError objError : ex.getBindingResult().getAllErrors()) {  // her tipimin ObjectError tipinde
			String fieldName = ((FieldError)objError).getField(); // hata fırlatılan değişkenin adını veriyor örn firstname
		if (errorsMap.containsKey(fieldName)) {
			errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objError.getDefaultMessage()));
			
		}
			errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
		
		}
		return ResponseEntity.badRequest().body(createApiError(errorsMap));
		
	}

	private <T> ApiError<T> createApiError(T errors) {
		ApiError<T> apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date(0));
		apiError.setErrors(errors);
		
		return apiError;
	}
																						

}

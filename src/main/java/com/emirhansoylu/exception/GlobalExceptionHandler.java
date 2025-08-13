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
		list.add(newValue);  // gelen listeye newvalueyi ekle diyoruz basitçe
		return list;
	}
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class) // fırlatılan exception classının adını veriyoruz
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		//	ex.getBindingResult().getAllErrors(); //bütün hata mesajları bunun içerisinde//exceptionu parametre olarak geçirdik çünkü exception 
																							//içindeki değerlere erişmek için field mesajalr gibi 
		Map<String, List<String>> errorsMap = new HashMap<>();        //String kısmı firstname liststring kısmı ise hataları temsil ediyo  
																																		
		for (ObjectError objError : ex.getBindingResult().getAllErrors()) {  // her tipimin ObjectError tipinde
			String fieldName = ((FieldError)objError).getField(); // hata fırlatılan değişkenin adını veriyor örn firstname
		if (errorsMap.containsKey(fieldName)) {
			errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objError.getDefaultMessage()));
			// eğer o değişkenle ilgil izaten daha önce hata varsa buraya giriyo 
		}
			errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
		 
			// daha önce bu hata yoksa fieldname diyerek firstName belirliyoruz daha sonra liste ismi olan addmapvalueyi yazıyoruz list yerine MAPTE
		 // ADDMAPVALUE İLE DE HATAMESAJINI ALIYORUZ yeni arraylist oluşturuyo
		}  
		
		return ResponseEntity.badRequest().body(createApiError(errorsMap)); 
		// badrequest fırlatıyoruz 400badrequest dönüyo yani  aşağıdaki fonksiyonu dönüyoz onla birlikte
		
	}

	private <T> ApiError<T> createApiError(T errors) {
		ApiError<T> apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString()); //random id atıyoruz
		apiError.setErrorTime(new Date(0));  
		apiError.setErrors(errors); //parametre olara gelen erroru setliyoruz
		
		return apiError;
	}
																						

}

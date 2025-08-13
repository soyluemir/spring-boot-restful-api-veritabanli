package com.emirhansoylu.services.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emirhansoylu.dto.DtoHome;
import com.emirhansoylu.dto.DtoRoom;
import com.emirhansoylu.entities.Home;
import com.emirhansoylu.entities.Room;
import com.emirhansoylu.repository.HomeRepository;
import com.emirhansoylu.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {
	
	@Autowired
	private HomeRepository homeRepository;

	@Override
	public DtoHome findHomeById(Long id) {
		DtoHome dtoHome = new DtoHome();
		
	Optional<Home> optional =	homeRepository.findById(id);
	if (optional.isEmpty()) {
		return null;
		
	}  //eğer veritabanından homealdıysam
	Home dbHome = optional.get();
	List<Room> dbRooms = optional.get().getRoom(); //dbden gelen homun içinde rooms listesi var onu dön
	BeanUtils.copyProperties(dbHome, dtoHome);
	if (dbRooms!=null && !dbRooms.isEmpty()) {  //odalar null değilse ve doluysa her seferinde dön aşağıdaki forda
		for (Room room : dbRooms) {
			DtoRoom dtoRoom = new DtoRoom(); //her seferinde dto room oluştur ve veritabanındaki roomu dtorooma kopyala
			BeanUtils.copyProperties(room, dtoRoom);
			dtoHome.getRooms().add(dtoRoom);    //getrooms arraylistine bu dtroomu kopyala
		}
		
		
	}
	return dtoHome;
	
	}
	
	

}

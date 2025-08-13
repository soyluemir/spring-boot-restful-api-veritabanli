package com.emirhansoylu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emirhansoylu.entities.Home;

@Repository
public interface HomeRepository  extends JpaRepository<Home, Long>{
	// home tablosu üzerinden çalıştıracağız

}

package com.wipcamp.gameservice.repository;

import com.wipcamp.gameservice.model.Item_Types;

import com.wipcamp.gameservice.model.Items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ItemRepository extends JpaRepository<Items,String> {

//	@Query(
//			value = "SELECT * FROM ITEMS i WHERE i.id = \"i01\"",
//			nativeQuery = true)
//	Collection<Items> findAllDecorationItems();

}

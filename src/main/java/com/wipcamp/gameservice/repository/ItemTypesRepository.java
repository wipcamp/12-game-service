package com.wipcamp.gameservice.repository;

import com.wipcamp.gameservice.model.Item_Types;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemTypesRepository extends JpaRepository<Item_Types,String> {
}

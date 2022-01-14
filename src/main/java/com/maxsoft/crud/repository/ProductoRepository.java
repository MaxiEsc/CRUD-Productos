package com.maxsoft.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxsoft.crud.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}

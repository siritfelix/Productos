package com.proyectointegrador.productos.Dao;

import java.util.List;

import com.proyectointegrador.productos.Entity.Producto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductoDao extends CrudRepository<Producto,Integer> {
    @Override
    public List<Producto> findAll();
    List<Producto> findByDescripcionContaining(String descripcion);

}
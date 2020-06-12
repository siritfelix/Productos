package com.proyectointegrador.productos.Service;

import java.util.List;

import com.proyectointegrador.productos.Dao.ProductoDao;
import com.proyectointegrador.productos.Entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServ implements IProductoServ {
    @Autowired
    ProductoDao productoDao;

    @Override
    public List<Producto> ListarProductos() {    

        return productoDao.findAll();
    }

    @Override
    public Producto BuscarPorId(Integer id) {
        
        return productoDao.findById(id).get();
    }

    @Override
    public Producto CrearProducto(Producto producto) {
        productoDao.save(producto);
        return producto;
    }
    
    @Override
    public Producto EliminarProducto(Integer id) {
        Producto producto= productoDao.findById(id).get();
        productoDao.delete(producto);        
        return producto;
    }

    @Override
    public List<Producto> BuscarPorDescripcion(String  descripcion) {
        
        return productoDao.findByDescripcionContaining(descripcion);
    }
    
}
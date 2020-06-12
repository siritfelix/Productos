package com.proyectointegrador.productos.Service;

import java.util.List;

import com.proyectointegrador.productos.Entity.Producto;

public interface IProductoServ {
    public List<Producto> ListarProductos();
    public Producto BuscarPorId(Integer id);
    public Producto CrearProducto(Producto producto);
    public Producto EliminarProducto(Integer id);
    public List<Producto> BuscarPorDescripcion(String descripcion);
}
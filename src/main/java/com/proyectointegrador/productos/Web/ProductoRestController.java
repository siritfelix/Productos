package com.proyectointegrador.productos.Web;

import java.util.Date;
import java.util.List;

import com.proyectointegrador.productos.Entity.Producto;
import com.proyectointegrador.productos.Service.IProductoServ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("api/productos")
public class ProductoRestController {
    @Autowired
    IProductoServ productoServ;

    @GetMapping("/listar-productos")
    public List<Producto> ListarProductos() {
        try {
            List<Producto> Productos = productoServ.ListarProductos();
            return Productos;
        } catch (Exception e) {
            return null;
        }

    }

    @GetMapping("/buscar")
    public Producto BuscarPorId(@RequestParam Integer id) {
        try {
            Producto producto = productoServ.BuscarPorId(id);
            return producto;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/crear")
    public Producto CrearProducto(@RequestBody Producto producto) {
        try {
            producto.setFechaAlta(new Date());
            productoServ.CrearProducto(producto);
            return producto;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/actualizar")
    public Producto ActualizarProducto(@RequestBody Producto producto) {
        try {
            Producto producto2 = productoServ.BuscarPorId(producto.getId());
            if (producto2 != null) {
                producto.setFechaAlta(producto2.getFechaAlta());
                return productoServ.CrearProducto(producto);
            } else
                return null;

        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/eliminar")
    public Producto EliminarProducto(@RequestParam Integer id) {
        try {
            return productoServ.EliminarProducto(id);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/listar-productos-descripcion")
    public List<Producto> ListarProductosPorDescripcion(@RequestParam String descripcion) {
        try {
            List<Producto> Productos = productoServ.BuscarPorDescripcion(descripcion);
            return Productos;
        } catch (Exception e) {
            return null;
        }

    }

}
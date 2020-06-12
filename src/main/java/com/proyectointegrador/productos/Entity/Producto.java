package com.proyectointegrador.productos.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="productos")
public class Producto {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String descripcion;
    private Double precio;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaAlta;
    private Integer cantidad;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
	

}
package com.mx.apiClientesBancomer.service;

import java.sql.Date;
import java.util.List;

import com.mx.apiClientesBancomer.model.Empleados;

public interface EmpleadoServ {

	
	//metodos a implementar
	
	public void guardar(Empleados empleado);
     //creo variable de tipo objeto 	
	public List<Empleados> listar();
	public Empleados buscarId(int idEmple);
	public void editar(Empleados empleado);
	public void eliminarXid(int idEmple); 
	public List<Empleados> buscarXNombre(String empleado);
	public List<Empleados> buscarXfechaNacim(Date empleado);	
	
	
	
	
	
}

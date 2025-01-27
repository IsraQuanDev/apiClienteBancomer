package com.mx.apiClientesBancomer.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository; 


import com.mx.apiClientesBancomer.model.Empleados;


//los repositorios vienen de spring data 
// contienen los metodos del crud
public interface EmpleadosDao extends CrudRepository<Empleados,Integer> {
// <Tabla, Identificador parseado>
	
	// si queremos implementar una logica y tales metodos no se encuentran en CRUD REPOSITORY 
	// Se puede crear la logica, ejemplo por buscar por nombre, en el dao se crea un metodo utilizando el resorte de los repositorios
	
	 // Crear un metodos utilizando el resorte de los repositorios: findBy 
	public List<Empleados> findByNombre(String empleado);
	
	
	
	
	
}

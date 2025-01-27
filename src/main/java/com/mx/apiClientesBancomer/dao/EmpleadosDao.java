package com.mx.apiClientesBancomer.dao;

import org.springframework.data.repository.CrudRepository; 


import com.mx.apiClientesBancomer.model.Empleados;


//los repositorios vienen de spring data 
// contienen los metodos del crud
public interface EmpleadosDao extends CrudRepository<Empleados,Integer> {
// <Tabla, Identificador parseado>
	
	
	
}

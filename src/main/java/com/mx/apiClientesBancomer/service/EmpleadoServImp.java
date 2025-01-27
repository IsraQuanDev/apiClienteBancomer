package com.mx.apiClientesBancomer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.apiClientesBancomer.dao.EmpleadosDao;
import com.mx.apiClientesBancomer.model.Empleados;

//se agrega estereotipo  @Service,
// se indica que se va a realizar un servicio REST --> JSON

@Service 
public class EmpleadoServImp implements EmpleadoServ {

	// Realizar la inyeccion de dependencia
	// tengo acceso a todo lo que tenga esa interface EmpleadosDao
	// @Autowired: permite tener un mejor control de los objetos que se inicializan
	@Autowired
	EmpleadosDao dao;
	
	// Se agregan los metodos
	
	//@Transactional, se utiliza para hacer cambios a la base de datos
	@Transactional
	@Override
	public void guardar(Empleados empleado) {
		// TODO Auto-generated method stub
	
		dao.save(empleado);
		
	}

	@Transactional(readOnly=true) 
	// readOnly=true, solo lectura sin afectar a la base de datos
	// sea agrega cuando no vamos a realizar cambios a la base de datos
	@Override
	public List<Empleados> listar() {
		// TODO Auto-generated method stub
		
		return (List<Empleados>) dao.findAll(); 
		// casteo: cambio de un tipo de valor por otro
	    // polimorfismo puro
	}

	@Override
	public Empleados buscarId(int idEmple) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Empleados empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarXid(int idEmple) {
		// TODO Auto-generated method stub
		
	}
	
	
}

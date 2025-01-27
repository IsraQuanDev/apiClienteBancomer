package com.mx.apiClientesBancomer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.apiClientesBancomer.model.Empleados;
import com.mx.apiClientesBancomer.service.EmpleadoServImp;

// Web service: Es una tecnologia que me permite comunicar 2 componentes
// 2 componentes: Servidor & Cliente 

// @RestController: Nos permite marcar como controlador de solicitudes 
//                  y se utiliza para crear servicios REST 
// Todas las web service de tipo rest trabajan con los json 

// @RequestMapping: se utiliza para asignar solicitudes web a entornos de spring 
//                  o para formar nuestros recursos (url,endpoint)

//@CrossOrigin: es por seguridad para que nuestra aplicacion no sea bloqueado  por el navegador


@RestController
@RequestMapping(path="EmpleadosWebService")
@CrossOrigin  
public class EmpleadosWebService {
	
	@Autowired
	EmpleadoServImp empleadoImp;
	
	
	//Peticiones: Get para listar
	// Necesito formar la URL: Utilizando el protocolo http
	// Como formar las URL: urlServidorLocal/pathMiclase/pathMetodo
	
	
   //  http://localhost:9000/EmpleadosWebService/guardar
	
	@GetMapping(path = "listar")
	public List<Empleados> listar(){
		return empleadoImp.listar();
	}
	
	// http://localhost:9000/EmpleadoWebService/guardar
	@PostMapping(path="guardar") //path del metodo
	public void guardar(@RequestBody Empleados empleado) {
	// dentro de la funcion guardar se ocupa como argumento un objeto, se utilizar @RequestBody, convierte el json a objeto
    // se crea la variable de tipo empleado 
		empleadoImp.guardar(empleado);
	}

	// http://localhost:9000/EmpleadoWebService/buscarXid 
	@PostMapping(path="buscarXid") //path del metodo
	public  Empleados buscar(@RequestBody Empleados empleado) {
	// dentro de la funcion guardar se ocupa como argumento un objeto, se utilizar @RequestBody, convierte el json a objeto
    // se crea la variable de tipo empleado 
		return empleadoImp.buscarId(empleado.getId());		
	}


	// http://localhost:9000/EmpleadoWebService/editar
	@PostMapping(path="editar") //path del metodo
	public void editar(@RequestBody Empleados empleado) {
	// dentro de la funcion guardar se ocupa como argumento un objeto, se utilizar @RequestBody, convierte el json a objeto
    // se crea la variable de tipo empleado 
	           empleadoImp.editar(empleado);		
	}

	
	// http://localhost:9000/EmpleadoWebService/eliminar
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Empleados empleado)
	{
		empleadoImp.eliminarXid(empleado.getId());	
	}
	
	
	// http://localhost:9000/EmpleadoWebService/buscarXNombre
	@PostMapping(path="buscarXNombre") //path del metodo
	public List<Empleados> buscarXNombre(@RequestBody Empleados empleado) {
	// dentro de la funcion guardar se ocupa como argumento un objeto, se utilizar @RequestBody, convierte el json a objeto
    // se crea la variable de tipo empleado 
	          
			return  empleadoImp.buscarXNombre(empleado.getNombre());		
	}

	

	// http://localhost:9000/EmpleadoWebService/buscarXfechaNacim
	@PostMapping(path="buscarXfechaNacim") //path del metodo
	public List<Empleados> buscarXfechaNacim(@RequestBody Empleados empleado) {
	// dentro de la funcion guardar se ocupa como argumento un objeto, se utilizar @RequestBody, convierte el json a objeto
    // se crea la variable de tipo empleado 
	          
			return  empleadoImp.buscarXfechaNacim(empleado.getFechNaci());	
	}
	
	
	


}

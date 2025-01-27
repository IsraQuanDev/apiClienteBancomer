package com.mx.apiClientesBancomer.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	// http://localhost:9000/EmpleadoWebService/listar
	
	@GetMapping(path = "listar")
	public List<Empleados> listar(){
		
		return empleadoImp.listar();
		
	}
	

}

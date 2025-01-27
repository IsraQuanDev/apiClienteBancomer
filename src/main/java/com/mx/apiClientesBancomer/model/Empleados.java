package com.mx.apiClientesBancomer.model;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
CREATE TABLE EMPLEADOS_BVVA(
ID NUMBER PRIMARY KEY,
NOMBRE NVARCHAR2(100) NOT NULL,
APP NVARCHAR2(100) NOT NULL,
APM NVARCHAR2(100),
FECHA_NACI DATE NOT NULL,
CORREO NVARCHAR2(70) NOT NULL 
);
*/

// MAPEAR LA TABLA
// ESTEREOTIPOS O ANOTACIONES ---  estamos ocupando las dependencias

@Entity
@Table(name="EMPLEADOS_BVVA")
@Data // data contiene los getters y setters, to string
@NoArgsConstructor // Constructor vacio
@AllArgsConstructor //Constructor con parametros
//@Getter & @Setter

public class Empleados {
// la clase Empleados representa la tabla EMPLEADOS_BVVA
	
// 3 formas de mapear el campo id o de una tabla
	/*
	@Id
	@Column(name="ID",columnDefinition="NUMBER",nullable=false) 
	private int id;
	*/
//	@Column(name="ID")
//	private int idEmpley;
	
//	private int id; definirlo en minuscula tal y como la tabla

	@Id
	@Column(name="ID",columnDefinition="NUMBER",nullable=false) 
	private Integer id;

	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(100)",nullable=false)
	private String nombre;
	
	@Column(name = "APP", columnDefinition = "NVARCHAR2(100)",nullable=false)
	private String app;
	
	@Column(name = "APM", columnDefinition = "NVARCHAR2(100)",nullable=true)
	private String apm;
	
	@Column(name = "FECHA_NACI", columnDefinition = "NVARCHAR2(100)",nullable=false)
	private Date fechNaci;
	
	@Column(name = "CORREO", columnDefinition = "NVARCHAR2(70)",nullable=false)
	private String correo;
	
	// Si se ocupan datos primitivos, hay que parsearlos y ya pueden recibir valores nulos
	// parsear int -> integer
	// Un tipo de dato primitivo que no esta parceado no recibe valores nulos 
	
	
	
}

 

# API de Gestión de Empleados BBVA

Este proyecto es una API REST desarrollada para gestionar los empleados de BBVA. Permite realizar operaciones CRUD sobre la base de datos de empleados, facilitando la administración de registros como nombres, apellidos, fechas de nacimiento y correos electrónicos.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para el desarrollo de aplicaciones Java basadas en microservicios.
- **Spring Data JPA**: Facilita la integración con la base de datos a través de repositorios.
- **Lombok**: Librería para reducir el código boilerplate, generando automáticamente getters, setters, constructores, etc.
- **Jakarta Persistence API**: Utilizada para el mapeo de entidades a la base de datos.
- **Base de Datos**: Oracle Database, utilizando la tabla `EMPLEADOS_BVVA`.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

### 1. **model**

Define la clase de modelo `Empleados`, que representa la tabla `EMPLEADOS_BVVA` en la base de datos.

- **Clase**: `Empleados`
- **Atributos mapeados**:
  - `id` (Integer)
  - `nombre` (String)
  - `app` (String)
  - `apm` (String, opcional)
  - `fechNaci` (Date)
  - `correo` (String)
  
- **Anotaciones**:
  - `@Entity`, `@Table`: Mapeo de la entidad a la tabla.
  - `@Id`, `@Column`: Configuración de las columnas de la tabla.
  - `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`: Generación automática de métodos y constructores.

### 2. **service**

Contiene la lógica de negocio y la implementación de servicios relacionados con los empleados.

- **Interfaz**: `EmpleadoServ`
  - Métodos definidos:
    - `guardar(Empleados empleado)`
    - `listar()`
    - `buscarId(int idEmple)`
    - `editar(Empleados empleado)`
    - `eliminarXid(int idEmple)`
    - `buscarXNombre(String nombre)`
    - `buscarXfechaNacim(Date fechaNacim)`

- **Clase**: `EmpleadoServImp`
  - Implementa los métodos de la interfaz utilizando el repositorio `EmpleadosDao`.
  - Anotaciones:
    - `@Service`
    - `@Transactional`

### 3. **dao**

Define el repositorio de datos para interactuar con la base de datos.

- **Interfaz**: `EmpleadosDao`
  - Extiende `CrudRepository<Empleados, Integer>`, proporcionando métodos CRUD estándar.
  - Métodos adicionales:
    - `findByNombre(String nombre)`: Permite buscar empleados por su nombre.

### 4. **controller**

Define los endpoints de la API REST.

- **Clase**: `EmpleadosWebService`
  - Anotaciones:
    - `@RestController`: Indica que la clase es un controlador REST.
    - `@RequestMapping`: Define la ruta base para el servicio.
    - `@CrossOrigin`: Permite solicitudes desde dominios externos.
  - Endpoints definidos:
    - `GET /EmpleadosWebService/listar`: Lista todos los empleados.
    - `POST /EmpleadosWebService/buscarXNombre`: Busca empleados por nombre.
    - `POST /EmpleadosWebService/buscarXfechaNacim`: Busca empleados por fecha de nacimiento.

## Tabla de Base de Datos

La API interactúa con la siguiente tabla en la base de datos Oracle:

```sql
CREATE TABLE EMPLEADOS_BVVA (
  ID NUMBER PRIMARY KEY,
  NOMBRE NVARCHAR2(100) NOT NULL,
  APP NVARCHAR2(100) NOT NULL,
  APM NVARCHAR2(100),
  FECHA_NACI DATE NOT NULL,
  CORREO NVARCHAR2(70) NOT NULL
);
```

## Endpoints

### 1. **`GET /EmpleadosWebService/listar`**
- **Descripción**: Obtiene la lista completa de empleados.
- **Respuesta**: JSON con todos los registros de la tabla `EMPLEADOS_BVVA`.

### 2. **`POST /EmpleadosWebService/buscarXNombre`**
- **Descripción**: Busca empleados por nombre.
- **Cuerpo de la solicitud**:
  ```json
  {
    "nombre": "Juan"
  }
  ```
- **Respuesta**: JSON con los empleados que coinciden con el nombre proporcionado.

### 3. **`POST /EmpleadosWebService/buscarXfechaNacim`**
- **Descripción**: Busca empleados por fecha de nacimiento.
- **Cuerpo de la solicitud**:
  ```json
  {
    "fechNaci": "1985-12-15"
  }
  ```
- **Respuesta**: JSON con los empleados que coinciden con la fecha de nacimiento proporcionada.

## Instrucciones para Ejecutar el Proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/apiClientesBancomer.git
   ```
   
2. Accede al directorio del proyecto:
   ```bash
   cd apiClientesBancomer
   ```

3. Importa el proyecto en tu IDE favorito (como IntelliJ IDEA o Eclipse).

4. Asegúrate de tener una base de datos Oracle configurada y accesible. Si es necesario, configura las credenciales de la base de datos en el archivo `application.properties`.

5. Ejecuta la aplicación con el siguiente comando:
   ```bash
   mvn spring-boot:run
   ```

6. La API estará disponible en `http://localhost:9000`.

 

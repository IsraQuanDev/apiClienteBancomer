# apiClientesBancomer

Este proyecto es una API REST para gestionar los empleados de BBVA, permitiendo realizar operaciones CRUD sobre la base de datos de empleados.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para el desarrollo de aplicaciones Java.
- **Spring Data JPA**: Para la integración con la base de datos.
- **Lombok**: Para reducir el código boilerplate en las clases de modelo.
- **Jakarta Persistence API**: Para el mapeo de entidades.
- **Base de datos**: Oracle Database (tabla `EMPLEADOS_BVVA`).

---

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

### 1. **model**
Define la clase de modelo `Empleados` que representa la tabla `EMPLEADOS_BVVA` de la base de datos.

- **Clase:** `Empleados`
- **Atributos mapeados:**
  - `id` (Integer)
  - `nombre` (String)
  - `app` (String)
  - `apm` (String, opcional)
  - `fechNaci` (Date)
  - `correo` (String)
- Anotaciones utilizadas:
  - `@Entity`, `@Table`: Mapeo de la tabla.
  - `@Id`, `@Column`: Configuración de las columnas.
  - `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`: Generación de métodos y constructores.

### 2. **service**
Contiene la lógica de negocio y la implementación de servicios.

- **Interfaz:** `EmpleadoServ`
  - Métodos definidos:
    - `guardar(Empleados empleado)`
    - `listar()`
    - `buscarId(int idEmple)`
    - `editar(Empleados empleado)`
    - `eliminarXid(int idEmple)`

- **Clase:** `EmpleadoServImp`
  - Implementa los métodos de la interfaz utilizando el repositorio `EmpleadosDao`.
  - Anotaciones utilizadas:
    - `@Service`
    - `@Transactional`

### 3. **dao**
Define el repositorio de datos para interactuar con la base de datos.

- **Interfaz:** `EmpleadosDao`
  - Extiende `CrudRepository<Empleados, Integer>` para proporcionar operaciones CRUD estándar.

### 4. **controller**
Define los endpoints de la API REST.

- **Clase:** `EmpleadosWebService`
  - Anotaciones utilizadas:
    - `@RestController`
    - `@RequestMapping`
    - `@CrossOrigin`
  - Endpoints definidos:
    - `GET /EmpleadosWebService/listar`: Lista todos los empleados.

---

## Tabla de Base de Datos

La API está diseñada para interactuar con la siguiente tabla en Oracle:

```sql
CREATE TABLE EMPLEADOS_BVVA (
  ID NUMBER PRIMARY KEY,
  NOMBRE NVARCHAR2(100) NOT NULL,
  APP NVARCHAR2(100) NOT NULL,
  APM NVARCHAR2(100),
  FECHA_NACI DATE NOT NULL,
  CORREO NVARCHAR2(70) NOT NULL
);

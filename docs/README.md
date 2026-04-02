# 🗂️ Sistema Administrativo — Proyecto Final de POO

> Prototipo de sistema de gestión empresarial desarrollado en **Java** con principios de **Programación Orientada a Objetos**, integración con **MySQL** y una interfaz gráfica construida con **Swing**.

Desarrollado como proyecto final de la materia *Programación Orientada a Objetos* en la  
**Facultad de Ciencias Físico Matemáticas — Universidad Autónoma de Nuevo León (UANL)**  
📅 Noviembre 2025

---

## 📋 Tabla de contenidos

- [Descripción general](#-descripción-general)
- [Características principales](#-características-principales)
- [Arquitectura del sistema](#-arquitectura-del-sistema)
- [Tecnologías y dependencias](#-tecnologías-y-dependencias)
- [Requisitos del sistema](#-requisitos-del-sistema)
- [Instalación y configuración](#-instalación-y-configuración)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Base de datos](#-base-de-datos)
- [Documentación técnica](#-documentación-técnica)
- [Autores](#-autores)

---

## 📌 Descripción general

El **Sistema Administrativo** es una aplicación de escritorio orientada a la gestión integral de operaciones empresariales. En su versión actual, cubre la **administración del capital humano** de una empresa: registro, consulta, modificación y baja de empleados, con capacidad de expansión hacia módulos de ventas, inventario, contabilidad y compras.

El sistema fue diseñado con una visión **modular y escalable**, lo que le permite crecer e integrarse con nuevas áreas de la empresa sin comprometer la estructura existente.

---

## ✨ Características principales

- **Gestión de empleados**: altas, bajas, búsquedas y modificaciones de registros de personal
- **Interfaz gráfica** intuitiva construida con Java Swing
- **Conexión dinámica a base de datos**: soporte para múltiples conexiones/sucursales mediante `Conexiones_Multiples`
- **Validación de datos**: campos validados antes de enviarse a la base de datos (CURP, RFC, correo, teléfono, etc.)
- **Exportación de tablas**: exportación de registros a archivos CSV desde la vista de listado
- **Autocompletado de dirección**: integración con la **API Dipomex** para rellenar colonia, municipio y estado a partir del código postal
- **Asignación automática de ID**: el sistema consulta la base de datos para asignar el siguiente ID de empleado sin duplicados
- **Limpieza y reinicio de formularios**: lógica recursiva para limpiar todos los campos de una ventana automáticamente
- **Arquitectura preparada para expansión**: tablas de artículos, ventas, compras, insumos, proveedores, mercados y facturas ya definidas en la BD

---

## 🏗️ Arquitectura del sistema

El sistema sigue una arquitectura **multicapa** inspirada en el patrón **MVC (Modelo–Vista–Controlador)**:

| Capa | Componentes |
|---|---|
| **Presentación** | `Principal`, `W_Administrar_Empleados`, `W_Empleados`, `W_Listado_Empleados`, `W_Entrada`, `W_Cambiar_Conexiones` |
| **Lógica / Negocio** | `LimpiezaPadre`, `LimpiezaEmpleados` |
| **Datos** | `Conexion`, `Conexiones_Multiples` |
| **Entrada** | `ProyectoPIAPOO` (clase `main`) |

### Clases principales

- **`ProyectoPIAPOO`** — Punto de entrada de la aplicación. Inicializa el entorno gráfico y establece el flujo de ejecución.
- **`Principal`** — Núcleo visual con menú principal (`JMenuBar`). Desde aquí se accede a todos los módulos.
- **`W_Administrar_Empleados`** — Gestiona las operaciones CRUD sobre empleados.
- **`W_Empleados`** — Formulario detallado de edición de datos individuales de cada empleado.
- **`W_Listado_Empleados`** — Vista tabular de todos los empleados con búsqueda filtrada y exportación a CSV.
- **`Conexion`** — Gestiona la conexión JDBC con MySQL; centraliza todas las consultas SQL.
- **`Conexiones_Multiples`** — Permite cambiar dinámicamente entre distintas bases de datos (sucursales).
- **`LimpiezaPadre`** — Clase abstracta base con métodos genéricos de inicialización y limpieza de ventanas.
- **`LimpiezaEmpleados`** — Hereda de `LimpiezaPadre` y especializa la validación y limpieza de formularios de empleados.

---

## 🛠️ Tecnologías y dependencias

| Tecnología | Uso |
|---|---|
| **Java SE** | Lenguaje principal del sistema |
| **Java Swing** | Interfaz gráfica de usuario |
| **JDBC** | Comunicación con la base de datos |
| **MySQL** | Motor de base de datos relacional |
| **MySQL Connector/J** | Driver para conectar Java con MySQL |
| **Dipomex API** | Autocompletado de direcciones por código postal (México) |
| **NetBeans / IntelliJ IDEA** | IDE recomendado para desarrollo |

**Paquetes Java utilizados:**
```
java.lang    — tipos primitivos y excepciones
java.util    — colecciones, listas, estructuras de datos
java.io      — lectura/escritura de archivos
java.sql     — comunicación con base de datos
javax.swing  — componentes de interfaz gráfica
```

---

## 💻 Requisitos del sistema

### Hardware
- Procesador: Intel Pentium o superior
- RAM: 4 GB o más
- Almacenamiento: 500 MB mínimo para instalación + 1 GB para datos

### Software
- Windows 10 u 11 (recomendado)
- Java JDK 8 o superior
- MySQL 8.0 o superior
- MySQL Workbench (u otro cliente MySQL)
- NetBeans IDE o IntelliJ IDEA

### Conectividad
- Conexión a Internet requerida para el uso de la **API Dipomex**
- Conexión local a MySQL para operaciones de base de datos

---

## ⚙️ Instalación y configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/J-Cazz/Sistema-Administrativo-POO.git
cd Sistema-Administrativo-POO
```

### 2. Crear la base de datos

1. Abre **MySQL Workbench** y crea una nueva conexión llamada `BD_Inventario`
2. Abre una nueva pestaña de consultas SQL
3. Copia y ejecuta el contenido del archivo:
   ```
   sql/SQLScript_BD_Inventario.sql
   ```
4. Esto creará automáticamente el esquema `bd_inventario` con todas sus tablas, procedimientos almacenados y triggers

> ⚠️ Si el script falla por permisos, ejecuta MySQL Workbench como administrador.

### 3. Abrir el proyecto en el IDE

1. Abre **NetBeans** o **IntelliJ IDEA**
2. Selecciona *Abrir proyecto* y navega a la carpeta del repositorio
3. Agrega la dependencia `mysql-connector-java-x.x.x.jar` en las librerías del proyecto
   - Ruta típica: `C:\Program Files\MySQL\Connector J 8.0\`

### 4. Configurar la conexión a la base de datos

Localiza el archivo `Conexion.java` en el paquete principal y modifica la línea de conexión:

```java
// Línea 15 en Conexion.java
conexion = DriverManager.getConnection(
    "jdbc:mysql://localhost/bd_inventario",
    "root",
    "TU_CONTRASEÑA_AQUI"  // <-- reemplaza aquí
);
```

> ⚠️ No modifiques el nombre `bd_inventario` en la cadena de conexión.

### 5. Ejecutar el sistema

1. Localiza la clase `ProyectoPIAPOO.java` (contiene el método `main`)
2. Ejecuta con **Run** o `Shift + F6` en NetBeans
3. Para verificar la conexión: menú **Evaluar → Conexión**
4. Si la conexión es exitosa, aparecerá una confirmación en pantalla

---

## 📁 Estructura del proyecto

```
Sistema-Administrativo-POO/
├── src/
│   └── com/mycompany/proyectopiapoo/
│       ├── ProyectoPIAPOO.java          # Clase main
│       ├── Principal.java               # Menú principal
│       ├── Conexion.java                # Gestión de conexión JDBC
│       ├── Conexiones_Multiples.java    # Cambio dinámico de BD
│       ├── W_Administrar_Empleados.java # CRUD de empleados
│       ├── W_Empleados.java             # Formulario de empleado
│       ├── W_Listado_Empleados.java     # Vista de tabla + exportar
│       ├── W_Entrada.java               # Pantalla de entrada
│       ├── W_Cambiar_Conexiones.java    # Selector de sucursal
│       ├── LimpiezaPadre.java           # Clase base de limpieza
│       └── LimpiezaEmpleados.java       # Limpieza específica de empleados
├── lib/
│   └── mysql-connector-java-x.x.x.jar
├── sql/
│   └── SQLScript_BD_Inventario.sql      # Script completo de la BD
├── docs/
│   └── Manual_Tecnico.pdf               # Documentación técnica completa
└── README.md
```

---

## 🗄️ Base de datos

La base de datos `bd_inventario` fue diseñada con motor **InnoDB**, con soporte para transacciones e integridad referencial, usando `utf8mb4` para compatibilidad completa con español.

### Tablas incluidas

| Tabla | Descripción |
|---|---|
| `empleados` | Núcleo del sistema. Almacena datos completos del personal |
| `articulos` | Catálogo de productos (módulo futuro) |
| `insumos` | Materiales y recursos de producción (módulo futuro) |
| `proveedores` | Datos de proveedores vinculados a insumos |
| `compra_encab` | Encabezados de órdenes de compra |
| `compra_detalle` | Detalle de productos por orden de compra |
| `venta_encab` | Encabezados de transacciones de venta |
| `venta_detalle` | Artículos vendidos por transacción |
| `mercados` | Puntos de venta y clientes |
| `saldo_empresa` | Bitácora de saldos diarios (caja chica) |
| `facturas` | Registro fiscal de transacciones |

### Procedimientos almacenados

- **`Conteo_de_ciudades`** — Cuenta el número de ciudades asociadas a un estado específico
- **`Reporte_Listado_Articulos`** — Genera reporte consolidado de artículos cruzando catálogo, insumos y proveedores

---

## 📄 Documentación técnica

El proyecto incluye un **Manual Técnico completo** elaborado como entrega académica, disponible en `docs/Manual_Tecnico.pdf`. Contiene:

- Descripción detallada del sistema y sus módulos
- Diagrama UML completo de clases
- Diagrama Entidad-Relación de la base de datos
- Script SQL completo con comentarios
- Requerimientos de hardware y software
- Guía de instalación técnica paso a paso
- Ejemplos de código de métodos clave (`LeerNumEmpleado`, `exportarTablaCSV`, `limpiarCampos`)

---

## 👥 Autores

| Nombre | Matrícula |
|---|---|
| Jorge Castillo Acosta | 2132842 |
| Melina Sánchez Ávila | 2120543 |

**Universidad Autónoma de Nuevo León**  
Facultad de Ciencias Físico Matemáticas  
Materia: Programación Orientada a Objetos  
📅 Monterrey, N.L. — Noviembre 2025

---

> 💡 *Este proyecto fue desarrollado con fines académicos y constituye un prototipo funcional con capacidad de expansión hacia un sistema empresarial completo.*

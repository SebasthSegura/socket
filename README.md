# 🔌 Proyecto Socket en Java

¡Bienvenido al proyecto **Socket en Java**! 🌐  

Este proyecto implementa un cliente y servidor en Java utilizando **Sockets**. Se organiza bajo el patrón **MVC (Modelo-Vista-Controlador)** para separar la lógica de negocio, la interfaz gráfica y el control de flujo.  

---

## 🚀 Estructura del Proyecto

```plaintext
socked/

├── build.xml

├── manifest.mf

├── build/

│   └── classes/

│       ├── MainApp.class

│       └── com/

│           └── sebas/

│               ├── controller/

│               │   ├── ClienteController.class

│               │   └── ServerController.class

│               ├── model/

│               │   └── ProcessorNumber.class

│               └── view/

│                   ├── ClienteView.class

│                   └── ServerView.class

├── nbproject/

│   ├── build-impl.xml

│   ├── genfiles.properties

│   ├── project.properties

│   ├── project.xml

│   └── private/

│       ├── private.properties

│       └── private.xml

├── src/

│   ├── MainApp.java

│   └── com/

│       └── sebas/

│           ├── controller/

│           │   ├── ClienteController.java

│           │   └── ServerController.java

│           ├── model/

│           │   └── ProcessorNumber.java

│           └── view/

│               ├── ClienteView.java

│               └── ServerView.java

└── README.md
```

---

## 🔧 Tecnologías y Librerías

Este proyecto utiliza **Java** y las siguientes herramientas:

* **Java Networking (`java.net.Socket`, `java.net.ServerSocket`)**: Para la comunicación entre cliente y servidor.
* **Java Swing:** Para las interfaces gráficas de usuario del cliente y servidor.
* **NetBeans (Archivos `nbproject/`)**: Proyecto configurado para ser usado en este IDE.

---

## ✨ Características Principales

* **Servidor multicliente**: Permite que varios clientes se conecten al servidor simultáneamente.
* **Cliente con GUI**: Interfaz amigable para enviar y recibir mensajes.
* **Separación en MVC**:
  - **Model**: Contiene la lógica principal (ej. `ProcessorNumber`).
  - **View**: Ventanas gráficas (`ClienteView`, `ServerView`).
  - **Controller**: Coordina las acciones (`ClienteController`, `ServerController`).
* **Gestión de errores**: Manejo de excepciones y desconexiones inesperadas para evitar bloqueos.

---

## 🧵 Hilo de Ejecución

El servidor utiliza **hilos (Threads)** para manejar múltiples clientes simultáneamente.  
Cada cliente conectado es atendido en un hilo independiente, lo que permite enviar y recibir mensajes sin bloquear al resto de conexiones.  

---

## ▶️ Ejecución del Proyecto

1. **Ejecutar el Servidor**  
   - Compilar y ejecutar `ServerView.java` desde el paquete `view`.  
   - Esto abrirá la ventana del servidor y quedará a la espera de conexiones de clientes.

2. **Ejecutar el Cliente**  
   - Compilar y ejecutar `ClienteView.java`.  
   - Se podrá conectar al servidor y enviar mensajes.  

3. **Comunicación**  
   - Una vez conectado, el cliente puede enviar datos que serán procesados y respondidos por el servidor.  

---

## 📂 Organización del Código

- **`MainApp.java`**: Punto de entrada principal del proyecto.  
- **`controller/`**: Contiene la lógica que coordina la interacción entre modelo y vista.  
- **`model/`**: Lógica de negocio y procesamiento (ej. `ProcessorNumber`).  
- **`view/`**: Interfaces gráficas para servidor y cliente.  

---

## 👨‍💻 Autor

Proyecto desarrollado por **Sebasth Segura** ✨  

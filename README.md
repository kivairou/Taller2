# Taller 02 – Pokémon Simulación Game

## Descripción del Proyecto
Este proyecto corresponde al **Taller 2 del curso de POO (Programación Orientada a Objetos)**.  
El objetivo es desarrollar un software de Polémon interactivo en **Java** utilizando los principios de la **Programación Orientada a Objetos (POO)**. El sistema gestiona capturas, combates, exploracion de hábitats y progresión de gimnasios mediante la lectura y escritura de archivos de texto.

El sistema se basa en una arquitectura de capas y utiliza el patrón de diseño **SINGLETON** para el motor principal del juego, asegurando una gestión centralizada de los datos:
- **Pokedex.txt**: Base de datos con estadísticas y tiupos de todos los Pokémon.
- **Habitats.txt**: Listado de zonas disponibles para la exploración.
- **Gimnasios.txt/Alto Mando.txt**: Configuración de los desafíos y entrenadores rivales.
- **Registros.txt**: Persistencia del progreso del jugador (equipo, medallas y estado).
---

## Integrantes
- Kevin Zamora Riquelme – RUT: 21.578.521-1 – Usuario GitHub: kivairou 
- Tomás Zepeda Velasquez - RUT: 21.789.061-6 - Usuario GitHub: tomaszepeda2411

---

## Estructura del proyecto

```
├── src/
│   ├── dominio/              # Clases de entidad (Modelos de datos)
│   │   ├── Pokemon.java      # Atributos y stats de los Pokémon
│   │   ├── Jugador.java      # Perfil del usuario y su lista de Pokémon
│   │   ├── Gimnasio.java     # Datos de los Líderes de Gimnasio
│   │   └── AltoMando.java    # Datos de los miembros del Alto Mando
│   │
│   └──  logica/              # Capa de procesamiento y reglas
│        ├── Sistema.java     # Contrato de operaciones del sistema
│        ├── SistemaImpl.java # Motor principal (Singleton) y gestión de archivos
│        ├── TablaTipos.java  # Matriz de efectividad y multiplicadores
|        └── App.java         # Clase principal, gestión de entrada y menús
│   
│   
├── Pokedex.txt               # Base de datos de Pokémon
├── Habitats.txt              # Archivo de zonas de captura
├── Gimnasios.txt             # Datos de los 8 líderes
├── Alto Mando.txt            # Datos del desafío final
├── Registros.txt             # Archivo de persistencia (Guardado)
└── README.md                 # Documentación del proyecto
```

---
## Instrucciones de Ejecución
### En Visual Studio Code
1. Abre VS Code y selecciona **File > Open Folder**.  
   Elige la carpeta raíz del proyecto (donde está `src/`).
2. Instala la extensión **Java Extension Pack** si no la tienes.
3. Abre el archivo `App.java` dentro de `src/`.
4. Haz clic en el botón **Run** que aparece arriba del método `main`.
5. El programa se ejecutará en la terminal integrada de VS Code.

### En Eclipse
1. Abre Eclipse y selecciona **File > New > Java Project**.
2. Asigna un nombre al proyecto (ejemplo: `Taller02`).
3. Copia la carpeta `src/` y los archivos dentro del proyecto.
4. Asegúrate de que `App.java` esté dentro del paquete `src`.
5. Haz clic derecho sobre `App.java` → **Run As > Java Application**.
6. El programa se ejecutará en la consola de Eclipse.

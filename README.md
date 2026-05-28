# mvc-java

Ejercicio básico de fundamentos de programación en Java usando una arquitectura por capas (MVC + servicio + repositorios).

## Objetivo didáctico
- Operadores básicos
- Estructuras de control
- Ciclos
- Métodos
- `String.format`
- Repositorios en memoria con `List` y `Map`

## Estructura
- `model`: entidad `Registro`
- `repository`: `ListRegistroRepository` y `MapRegistroRepository`
- `service`: reglas de negocio básicas y estadísticas
- `view`: entrada/salida por consola y métodos para leer tipos básicos
- `controller`: flujo del menú y coordinación

## Compilar y ejecutar
```bash
cd /tmp/workspace/mzamora-cnftc/mvc-java
mkdir -p /tmp/workspace/mzamora-cnftc/mvc-java/out
javac -d out $(find src/main/java -name "*.java")
java -cp out org.example.mvc.App
```
# prueba-gestor-tareas
Guía para ejecución de Aplicación BackEnd

1.Instalar motor de Base de Datos Postgres
2.Crear Base de Datos
3.Ejecutar script.sql incluído en el directorio raíz
4.Compilar aplicación (Java 1.8 y Gradle 6.5). Comando: gradle build
5.Crear las siguientes variables de entorno:
Unix:
export DBURL=<URL donde está alojada la Base de Datos>
export DBPORT=<Puerto Base de Datos>
export DBNAME=<Nombre de Base de Datos>
export USERNAMEDB=<usuario Base de Datos>
export PASSWORDDB=<Contraseña Base de Datos>
  
Windows:
set DBURL=<URL donde está alojada la Base de Datos>
set DBPORT=<Puerto Base de Datos>
set DBNAME=<Nombre de Base de Datos>
set USERNAMEDB=<usuario Base de Datos>
set PASSWORDDB=<Contraseña Base de Datos>
  
6. Ejecutar aplicación con: java -jar build/libs/gestortareas-0.0.1-SNAPSHOT.jar
  por defecto la aplicación está diseñada para operar en el puerto 8090
7. documentación swagger disponible en: http://<url>:8090/swagger-ui.html
  si ejecuta en localhost lo encontrará en: http://localhost:8090/swagger-ui.html
8.puede empezar a realizar operaciones


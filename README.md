# Dukes-GN-Backend 
Backend Gestor de Notass

# Tabla de contenido
1. [Colaboradores](#colaboradores)
2. [Tecnologias](#tecnologias)
3. [Instalacion](#instalacion)
4. [General Info](#general-info)


## Colaboradores
***
Lista de Colaboradores
* Andres Felipe Castañeda Lopez. Backend
* Doris Mosquera Lozano. Backend
* Juan Vargas. Frontend
* Juan Toro. Full Stack
* Santiago A. Viana. Frontend
* Juan David Rojas QA
* Alejandro Lopez. Scrum Master



# Despliegue Heroku
URL: https://dukes-gn-backend.herokuapp.com/api/heroku/deploy

![image](https://user-images.githubusercontent.com/47374753/175788842-123d2766-bad3-46cc-9a61-1fcdec4114b3.png)

## Tecnologias
***
Lista de tecnologias utilizadas en el proyecto:
* [Java](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html): Version 11
* [Spring Boot](https://spring.io/projects/spring-boot): Version 2.7.1
* [Spring WebFlux](spring-boot-starter-webflux)
* [junit](https://junit.org/junit5/): Version 4.13

## Instalacion 🏄
***
```
Pasos para instalar 
```
> Clona el repositorio:
```
$ git clone https://github.com/AndresGratus/Dukes-GN-Backend.git
$ cd ../path/to/the/file
```
> Instala las dependencias:
```
$ npm install
```
> Correr:
```
$ npm start
```

## General Info 🔐
***
Desarrollar un MVP funcional, para gestionar y visualizar gráficamente las notas de los estudiantes matriculados en las ligas de entrenamiento de Sofka U durante su periodo académico.

### Metodologia Scrum 
Equipo 7 - Duke's: https://trello.com/b/YT3Fu29s/equipo-7-dukes

### Caracteristicas:
- Conexion base de datos MongoAtlas
- Pruebas unitarias Backend
- Uso de Swagger

 ### Servicio-Controller
![image](https://user-images.githubusercontent.com/91640921/176894496-8fc604fd-242a-4921-ae8d-fabc0ce4f352.png)
### Test 
![image](https://user-images.githubusercontent.com/91640921/176896293-18b104f0-fbc7-4d36-b93b-66149b877448.png)


### Cómo usar:
1. Ir a la rama "main"
2. Clonar el repositorio o descargarlo como archivo zip(Recuerda que debes descomprimir el archivo zip).
3. Luego de tener el proyecto en su espacio de trabajo, proceda a abrirlo en su entorno de desarrollo.
4. Dirijase a la carpeta "/src/main/java/org/sofka/app/DukesGN/ y ejecute la clase "DukesGnApplication" (Esto hará que funcione toda la parte del backend)
5. Para visualizar la api en Swagger, dirijase a este link desde su navegador favorito http://localhost:8080/swagger-ui.html

### Swagger
![image](https://user-images.githubusercontent.com/91640921/176948261-3d9cb55a-c2c5-4ff5-b35c-d083c52e423a.png)
***
### module-controller
![image](https://user-images.githubusercontent.com/91640921/176948362-b19d4a34-ff27-494b-a1e2-45a87a87a892.png)
#### Get /api/module/list
![image](https://user-images.githubusercontent.com/91640921/176953297-f03e5f4e-fb08-494d-9b2a-bc4518bf8d8d.png)
#### Post api/module/create
![image](https://user-images.githubusercontent.com/91640921/176953618-c5f51f9b-d970-4677-8ecd-82f34a082b9c.png)
#### Put /api/module/update/{module_id}
![image](https://user-images.githubusercontent.com/91640921/176954523-e7fe110e-c9dd-46e7-90fd-08b41ed90e3d.png)

***
### program-controller
![image](https://user-images.githubusercontent.com/91640921/176948562-23e2d755-8bc4-4289-84e2-c467e8834883.png)
#### Post /api/program/create
![image](https://user-images.githubusercontent.com/91640921/176952397-b0e0268e-db71-41b5-be78-69354894742d.png)
#### Get /api/program/list
![image](https://user-images.githubusercontent.com/91640921/176952637-25485b9a-95b1-4b3f-a282-66757510bfd2.png)
#### Get /api/program/get/id
![image](https://user-images.githubusercontent.com/91640921/176952972-cabad3d4-0c68-4de6-8a35-a1181279d559.png)

***
### course-controller
![image](https://user-images.githubusercontent.com/91640921/176948635-e5ac0670-13d4-41db-9c7e-74f5e9ed32d4.png)
#### Post /api/course/create
![image](https://user-images.githubusercontent.com/91640921/176955139-a922d9c4-b5fe-4e63-8dc9-5506c64e112a.png)

***
### heroku-deploy
![image](https://user-images.githubusercontent.com/91640921/176948753-96e9ec59-de6f-486c-a92e-21169d37371b.png)
***
### Schemas
![image](https://user-images.githubusercontent.com/91640921/176949050-4a5cf42a-59ef-47e2-86f3-1327f959f56a.png)

---

![Screen Shot 2022-07-01 at 10 42 55 AM](https://user-images.githubusercontent.com/90350943/176927048-51da3319-3356-4748-a9bc-a811ccb78a42.png)




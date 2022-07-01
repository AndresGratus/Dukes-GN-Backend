package org.sofka.app.DukesGN.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.sofka.app.DukesGN.dto.CourseDto;
import org.sofka.app.DukesGN.service.implementation.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/course")
public class CourseController {

    /**
     * Se inyecta el servicio de Course
     */
    @Autowired
    private CourseService courseService;

    /**
     * Endpoint para crear un course
     *
     * @param courseDto
     * @return Mono<ResponseEntity < Mono < CourseDto>>>
     */
    @Operation(summary = " --> Endpoint que nos permite Crear un curso")
    @ApiResponse(responseCode = "200", description = "Se creo el curso")
    @PostMapping("/create")
    public Mono<ResponseEntity<Mono<CourseDto>>> createCourse(@RequestBody CourseDto courseDto) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(courseService.createCourse(courseDto))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear el curso");
        }

    }

    /**
     * Endpoint para obtener un Course por id
     *
     * @param course_id
     * @return Mono<ResponseEntity < Mono < CourseDto>>>
     */
    @Operation(summary = " --> Endpoint que nos permite obtener un curso por id")
    @ApiResponse(responseCode = "200", description = "Se obtuvo el curso por el id")
    @GetMapping("/get/{course_id}")
    public Mono<ResponseEntity<Mono<CourseDto>>> getCoursebyId(@PathVariable("course_id") String course_id) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(courseService.getCourse(course_id))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener el curso");
        }
    }

    /**
     * Endpoint para eliminar un course id
     *
     * @param course_id
     * @return Mono<ResponseEntity < Mono < Void>>>
     */

    @Operation(summary = " --> Endpoint que nos permite eliminar un curso por id")
    @ApiResponse(responseCode = "200", description = "Se elimino el curso")
    @DeleteMapping("/delete/{course_id}")
    public Mono<ResponseEntity<Mono<Void>>> deleteCourse(@PathVariable("course_id") String course_id) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(courseService.deleteCourse(course_id))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se puede obtener el curso por el id");
        }
    }

    /**
     * Endpoint para guardar una lista de course
     *
     * @param courseDtoList
     * @return Mono<ResponseEntity < Flux < List < CourseDto>>>>
     */

    @Operation(summary = " --> Endpoint que nos guardar una lista de respuestas")
    @ApiResponse(responseCode = "200", description = "se guardo la lista de cursos")
    @PostMapping("/saveAll")
    public Mono<ResponseEntity<Flux<List<CourseDto>>>> saveAllCourse(@RequestBody List<CourseDto> courseDtoList) {

        try {
            return Mono
                    .just(
                            ResponseEntity
                                    .ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .body(courseService.saveAllCourse(courseDtoList))
                    );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo gurdar la lista de course");
        }

    }

    /**
     * Endpoint para listar todos los cursos
     *
     * @return Mono<ResponseEntity < Flux < CourseDto>>>
     */

    @Operation(summary = " --> Endpoint que nos permite listar todos los cursos")
    @ApiResponse(responseCode = "200", description = "Se listaron los cursos")
    @GetMapping("/list")
    public Mono<ResponseEntity<Flux<CourseDto>>> listAllCourse() {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(courseService.listCourses())
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudieron listar los cursos");
        }

    }

    /**
     * Endpoint para listar los course por id
     *
     * @param id_program
     * @return Mono<ResponseEntity < Flux < CourseDto>>>
     */

    @Operation(summary = " --> Endpoint que nos permite obtener un curso por el id del programa")
    @ApiResponse(responseCode = "200", description = "Se listo el curso por el id del programa")
    @GetMapping("/program/{id_program}")
    public Mono<ResponseEntity<Flux<CourseDto>>> getCourseByIdProgram(@PathVariable("id_program") String id_program) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(courseService.listCourses()
                                    .filter(courseDto -> Objects.equals(courseDto.getId_program(), id_program)))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo listar los cursos por el id del programa");
        }

    }


}

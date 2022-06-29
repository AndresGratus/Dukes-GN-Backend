package org.sofka.app.DukesGN.controller;

import org.sofka.app.DukesGN.dto.CourseDto;
import org.sofka.app.DukesGN.service.impletation.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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


}

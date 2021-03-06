package org.sofka.app.DukesGN.service;

import org.sofka.app.DukesGN.dto.CourseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ICourseService {

    /**
     * Crear Curso
     *
     * @param courseDto
     * @return Mono<CourseDto>
     */
    Mono<CourseDto> createCourse(CourseDto courseDto);

    /**
     * Mostrar Curso por Id
     *
     * @param id_course
     * @return Mono<CourseDto>
     */
    Mono<CourseDto> getCourse(String id_course);

    /**
     * Listar Cursos por Id del Coach
     *
     * @return Flux<CourseDto>
     */
    Flux<CourseDto> listCourses();

    /**
     * Eliminar un Curso por Id
     *
     * @param id_course
     * @return Mono<CourseDto>
     */
    Mono<Void> deleteCourse(String id_course);

    /**
     * Guardar una lista de Course
     * @param courseDtoList
     * @return
     */
    Flux<List<CourseDto>> saveAllCourse(List<CourseDto> courseDtoList);

}

package org.sofka.app.DukesGN.service;

import org.sofka.app.DukesGN.dto.CourseDto;
import org.sofka.app.DukesGN.repository.CourseRepository;
import org.sofka.app.DukesGN.service.ICourseService;
import org.sofka.app.DukesGN.util.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseService implements ICourseService {
    /**
     * Se inyecta el repositorio de course
     */
    @Autowired
    private CourseRepository courseRepository;

    /**
     * Se inyecta el mapper de course
     */
    private CourseMapper courseMapper;

    public CourseService() {
        this.courseMapper = new CourseMapper();
    }

    /**
     * Servicio para crear un curso
     *
     * @param courseDto
     * @return Mono<CourseDto>
     */
    @Override
    public Mono<CourseDto> createCourse(CourseDto courseDto) {
        return courseRepository
                .save(courseMapper
                        .fromCourseDtoToCourse()
                        .apply(courseDto))
                .map(courseMapper
                        .fromCourseToCourseDto());
    }

    /**
     * Servicio para obtener un course
     *
     * @param id_course
     * @return Mono<CourseDto>
     */
    @Override
    public Mono<CourseDto> getCourse(String id_course) {
        return courseRepository
                .findById(id_course)
                .map(courseMapper
                        .fromCourseToCourseDto());
    }

    @Override
    public Flux<CourseDto> listCourses(String id_coach) {
        return null;
    }

    /**
     * Servicio para eliminar un course
     * @param id_course
     * @return Mono<Void>
     */
    @Override
    public Mono<Void> deleteCourse(String id_course) {
        return courseRepository
                .deleteById(id_course);
    }
}

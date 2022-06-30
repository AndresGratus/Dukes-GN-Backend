package org.sofka.app.DukesGN.service.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sofka.app.DukesGN.collection.Course;
import org.sofka.app.DukesGN.dto.CourseDto;
import org.sofka.app.DukesGN.util.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CourseServiceTest {
    /**
     * Inyección del Servicio del Curso
     */
    @Autowired
    CourseService courseService;

    /**
     * Se instancia el Mapper del Curso
     */
    CourseMapper courseMapper = new CourseMapper();

    @BeforeEach
    void setUp() {
        courseService = mock(CourseService.class);
    }

    /**
     *  Test de crear Course por id
     */
    @Test
    void createCourse() {

        var course = new Course();
        course.setId_course("C-0001");
        course.setId_program("P-001");
        course.setName("Curso 1");
        course.setPercentage(35D);

        var courseDto = courseMapper.fromCourseToCourseDto().apply(course);

        when(courseService.createCourse(courseDto)).thenReturn(Mono.just(courseDto));

        StepVerifier.create(courseService.createCourse(courseDto))
                .expectSubscription()
                .expectNext(courseDto)
                .verifyComplete();

        verify(courseService).createCourse(any(CourseDto.class));
    }

    /**
     *  Test de obtener Course por id
     */
    @Test
    void getCourse() {

        var course = new Course();
        course.setId_course("C-0001");
        course.setId_program("P-001");
        course.setName("Curso 1");
        course.setPercentage(35D);

        var courseDto = courseMapper.fromCourseToCourseDto().apply(course);

        when(courseService.getCourse(courseDto.getId_course()))
                .thenReturn(Mono.just(courseDto));

        StepVerifier.create(courseService.getCourse(courseDto.getId_course()))
                .expectSubscription()
                .expectNextMatches( c -> {
                    assert c.getId_course().equals(course.getId_course());
                    return true;
                })
                .verifyComplete();

        verify(courseService).getCourse(any(String.class));
    }

    /**
     *  Test para listar cursos
     */
    @Test
    void listCourses() {
        var course = new Course();
        course.setId_course("C-0001");
        course.setId_program("P-001");
        course.setName("Curso 1");
        course.setPercentage(35D);

        var courseDto = courseMapper.fromCourseToCourseDto().apply(course);

        when(courseService.listCourses())
                .thenReturn(Flux.just(courseDto));

        StepVerifier.create(courseService.listCourses())
                .expectSubscription()
                .expectNextMatches(c -> {
                    assert c.getName().equals(course.getName());
                    return true;
                })
                .verifyComplete();

        verify(courseService).listCourses();
    }

    /**
     *  Test para eliminar un Course por id
     */
    @Test
    void deleteCourse() {

        var course = new Course();
        course.setId_course("C-0001");
        course.setId_program("P-001");
        course.setName("Curso 1");
        course.setPercentage(35D);

        var courseDto = courseMapper.fromCourseToCourseDto().apply(course);

        when(courseService.deleteCourse(courseDto.getId_course()))
                .thenReturn(Mono.empty());

        StepVerifier.create(courseService.deleteCourse(courseDto.getId_course()))
                .expectSubscription()
                .expectNext()
                .verifyComplete();

        verify(courseService).deleteCourse(courseDto.getId_course());
    }

    /**
     *  Test para guardar todos los Courses
     */
    @Test
    void saveAllCourse() {

        var course1 = new Course();
        course1.setId_course("C-0001");
        course1.setId_program("P-001");
        course1.setName("Curso 1");
        course1.setPercentage(35D);

        var course1Dto = courseMapper.fromCourseToCourseDto().apply(course1);

        var course2 = new Course();
        course2.setId_course("C-0001");
        course2.setId_program("P-001");
        course2.setName("Curso 1");
        course2.setPercentage(35D);

        var course2Dto = courseMapper.fromCourseToCourseDto().apply(course2);

        var listCoursesDto = List.of(course1Dto, course2Dto);

        when(courseService.saveAllCourse(listCoursesDto))
                .thenReturn(Flux.just(listCoursesDto));

        StepVerifier.create(courseService.saveAllCourse(listCoursesDto))
                .expectSubscription()
                .expectNext(listCoursesDto)
                .verifyComplete();

        verify(courseService).saveAllCourse(listCoursesDto);
    }
}
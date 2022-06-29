package org.sofka.app.DukesGN.util.mapper;

import org.sofka.app.DukesGN.collection.Course;
import org.sofka.app.DukesGN.dto.CourseDto;

import java.util.function.Function;

public class CourseMapper {

    /**
     * Metodo que nos permite transformar la colección curso a su equivalente en Dto
     *
     * @return CourseDto
     */
    public Function<Course, CourseDto> fromCourseToCourseDto() {
        return course -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setId_course(course.getId_course());
            courseDto.setId_program(course.getId_program());
            courseDto.setName(course.getName());
            courseDto.setPercentage(course.getPercentage());
            return courseDto;
        };
    }

    /**
     * Metodo que nos permite transformar el Dto curso a su equivalente en la Colección
     *
     * @return Course
     */
    public Function<CourseDto, Course> fromCourseDtoToCourse() {
        return courseDto -> {
            Course course = new Course();
            course.setId_course(courseDto.getId_course());
            course.setId_program(courseDto.getId_program());
            course.setName(courseDto.getName());
            course.setPercentage(courseDto.getPercentage());
            return course;
        };
    }


}

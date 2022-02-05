package io.pragra.learning.pragravisit.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.CourseApi;
import io.swagger.model.CourseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CourseContoller implements CourseApi {

    List<CourseDto> courseDtos = new ArrayList<>();

    @Override
    public ResponseEntity<CourseDto> addCourse(CourseDto body) {

        body.setId((int)(Math.random()*100));
        courseDtos.add(body);
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<List<CourseDto>> courseGet(String coursename) {
        return ResponseEntity.status(200).body(courseDtos.stream().filter(courseDto -> courseDto.getName().equals(coursename)).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<CourseDto> getCourseById(Long courseId) {
        return ResponseEntity.status(HttpStatus.OK).body(courseDtos.stream().filter(c->c.getId()==courseId.intValue()).findAny().get());
    }
}

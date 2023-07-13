package com.woorifisa.seminar.controller;

import static org.springframework.http.HttpStatus.OK;

import com.woorifisa.seminar.dto.clazz.ClassBasicResponse;
import com.woorifisa.seminar.dto.common.CommonResponse;
import com.woorifisa.seminar.service.ClassService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @GetMapping
    public ResponseEntity<CommonResponse<List<ClassBasicResponse>>> retrieveAllClasses() {

        List<ClassBasicResponse> classes = classService.findAllClasses();

        return CommonResponse.create(OK, classes);
    }

}

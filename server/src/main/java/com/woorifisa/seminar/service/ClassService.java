package com.woorifisa.seminar.service;

import static java.util.stream.Collectors.toList;

import com.woorifisa.seminar.dto.clazz.ClassBasicResponse;
import com.woorifisa.seminar.dto.seminartype.SeminarTypeBasicResponse;
import com.woorifisa.seminar.entity.Clazz;
import com.woorifisa.seminar.repository.ClassesRepository;
import com.woorifisa.seminar.repository.SeminarTypeRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassService {

    private final SeminarTypeRepository seminarTypeRepository;
    private final ClassesRepository classesRepository;

    public List<ClassBasicResponse> findAllClasses() {

        // Map<Clazz, List<SeminarType>> classSeminar = seminarTypeRepository.findAllByClassId()
        //                                                                   .stream()
        //                                                                   .collect(groupingBy(SeminarType::getClazz));

        List<Clazz> classes = classesRepository.findAllWithSeminarType();

        List<ClassBasicResponse> resp = new ArrayList<>();
        for (Clazz c : classes) {
            List<SeminarTypeBasicResponse> list = c.getSeminarTypes()
                                                   .stream()
                                                   .map(SeminarTypeBasicResponse::from)
                                                   .collect(toList());
            ClassBasicResponse cb = ClassBasicResponse.from(c, list);
            resp.add(cb);
        }

        return resp;
    }

}

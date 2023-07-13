package com.woorifisa.seminar.dto.clazz;

import com.woorifisa.seminar.dto.seminartype.SeminarTypeBasicResponse;
import com.woorifisa.seminar.entity.Clazz;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ClassBasicResponse {

    private final Long id;
    private final String name;
    private final List<SeminarTypeBasicResponse> seminarTypes;

    public static ClassBasicResponse from(Clazz clazz, List<SeminarTypeBasicResponse> resp) {
        return new ClassBasicResponse(clazz.getId(), clazz.getName(), resp);
    }

}

package com.example.xesqye.specifications;

import com.example.xesqye.entity.parts.Parts;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class PartsSpecification {

    @And({
            @Spec(path = "type", params = "type", spec = Equal.class),
            @Spec(path = "cost", params = "cost.max", spec = LessThanOrEqual.class),
            @Spec(path = "cost", params = "cost.min", spec = GreaterThanOrEqual.class),
            @Spec(path = "title", params = "title", spec = LikeIgnoreCase.class),
            @Spec(path = "created_date", params = {"after","before"}, spec = Between.class),
    })
    public static interface PartsSpec extends Specification<Parts> { }

}

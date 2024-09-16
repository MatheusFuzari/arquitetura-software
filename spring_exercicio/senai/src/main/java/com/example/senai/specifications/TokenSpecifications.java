package com.example.senai.specifications;

import com.example.senai.entity.Token;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class TokenSpecifications {

    @Or({
        @Spec(path = "name", params = "name", spec = LikeIgnoreCase.class),
        @Spec(path = "price", params = "min", spec = GreaterThanOrEqual.class),
        @Spec(path = "price", params = "max", spec = LessThanOrEqual.class)
    })
    public static interface TokenSpec extends Specification<Token> {}
}

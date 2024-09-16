package com.example.senai.specifications;

import com.example.senai.entity.User;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

    @And({
            @Spec(path = "cpf", params = "cpf", spec = EqualIgnoreCase.class),
            @Spec(path = "username", params = "username", spec = LikeIgnoreCase.class),
            @Spec(path = "birthday", params = "birthday", spec = EqualDay.class)
    })
    public static interface UserSpec extends Specification<User> {}
}

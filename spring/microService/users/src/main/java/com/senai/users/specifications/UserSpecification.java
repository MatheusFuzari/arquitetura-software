package com.senai.users.specifications;

import com.senai.users.entity.User;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    @And({
        @Spec(path = "name", params = "name", spec = LikeIgnoreCase.class),
        @Spec(path = "cpf", params = "cpf", spec = Equal.class),
        @Spec(path = "phone", params = "phone", spec = Equal.class),
        @Spec(path = "birthdate", params = {"birthdateStart", "birthdateEnd"}, spec = Between.class)
    })

    public static interface UserSpec extends Specification<User> { }
}

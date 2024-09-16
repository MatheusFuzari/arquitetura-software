package com.example.senai.specifications;

import com.example.senai.entity.AccountToken;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class AccountTokenSpecifications {
    @And({
            @Spec(path = "amount", params = "min", spec = GreaterThanOrEqual.class),
            @Spec(path = "amount", params = "max", spec = LessThanOrEqual.class)
            
    })
    public static interface AccountTokenSpec extends Specification<AccountToken> {}

}

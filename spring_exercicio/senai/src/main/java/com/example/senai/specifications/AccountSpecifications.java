package com.example.senai.specifications;

import com.example.senai.entity.Account;
import com.example.senai.entity.User;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.EqualDay;
import net.kaczmarzyk.spring.data.jpa.domain.EqualIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecifications {
    @And({
            @Spec(path = "metamask_id", params = "metamask", spec = Equal.class),
    })
    public static interface AccountSpec extends Specification<Account> {}
}

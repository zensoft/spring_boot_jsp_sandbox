package com.tomek.domain.service;

import com.tomek.domain.model.User;
import javaslang.collection.List;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by tomek on 11.03.17.
 */
//@Component
public class UserNameFormatter {

    @Value("${username.split.character}")
    private String splitCharacter;

    public UserNameFormatter() {
        System.out.println("UserNameFormatter");
    }

    public String format(User user) {
        return List.of(user.getName().split(" "))
                .map(s -> {
                    return s.toUpperCase();
                })
                .intersperse(splitCharacter)
                .mkString();
    }

}

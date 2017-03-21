package com.tomek.util;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;

/**
 * Created by tomek on 20.03.17.
 */
public class ServletContextUtil {

    public static ServletContext getServletContext() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getServletContext();
    }


    public static <T> T getAttribute(String beanName) {
        return (T) getServletContext().getAttribute(beanName);
    }

    public static void printAllAttributes() {

        FluentIterable
                .of(getServletContext().getAttributeNames())
                .filter(input -> {

                    FluentIterable.of(input)
                            .filter(input1 -> {
                                System.out.println("===========  " + input1);
                                return true;
                            })
                            .toList();

                    System.out.println("------- " + input);
                    return false;
                })
                .toList();


    }

}

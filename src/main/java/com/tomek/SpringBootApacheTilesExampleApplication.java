package com.tomek;

import com.google.common.collect.FluentIterable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.util.AntPathMatcher;

import java.util.Map;
import java.util.function.Consumer;


@SpringBootApplication
public class SpringBootApacheTilesExampleApplication extends SpringBootServletInitializer {

    private static Class applicationClass = SpringBootApacheTilesExampleApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApacheTilesExampleApplication.class, args);
//        System.out.println("ok");
//        String path = "/user/{name:.+}";
//        String req = "/user/tomek.!@dsa#dsa$sd%^&asd*(dsa)ds:s\"d;ddd's,ss.aaa<d>f?f'hu";
//        AntPathMatcher antPathMatcher = new AntPathMatcher();
//        boolean match = antPathMatcher.match(path, req);
//        System.out.println(match);
//        Map<String, String> stringStringMap = antPathMatcher.extractUriTemplateVariables(path, req);
//        FluentIterable.from(stringStringMap.entrySet())
//                .forEach(new Consumer<Map.Entry<String, String>>() {
//                    @Override
//                    public void accept(Map.Entry<String, String> stringStringEntry) {
//                        System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
//                    }
//                });
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

}

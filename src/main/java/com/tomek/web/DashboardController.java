package com.tomek.web;

import java.util.*;

import com.tomek.domain.model.User;
import com.tomek.domain.priceformating.PriceFormatter;
import com.tomek.util.ServletContextUtil;
import javaslang.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {

    @Autowired
    private MessageSource messageSource;

    private final PriceFormatter priceFormatter;

    public DashboardController(PriceFormatter priceFormatter) {
        this.priceFormatter = priceFormatter;
    }

    @RequestMapping(value = {"/", "/{name}"}, method = RequestMethod.GET)
    public ModelAndView dashboard(
            HttpServletRequest request,
            @PathVariable String name
            //@PathVariable Optional<String> name
    ) {


        Map<String, String> uriTemplateVars =
                (Map<String, String>) request.getAttribute(
                        HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        System.out.println(uriTemplateVars);

        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
        System.out.println(name);

        ModelAndView model = new ModelAndView();
        model.addObject("users", getUsers());

        //System.out.println(messageSource.getClass());

        //System.out.println(messageSource.getMessage("page.label",new Object[]{}, Locale.US));

        //ServletContextUtil.printAllAttributes();

        User user = new User();
        user.setEmail("123");
        user.setName("John2");
        user.setAddress("Bangalore, Karnataka");

        model.addObject("user", user);

        model.setViewName("dashboard");
        return model;
    }

    private List getUsers() {
        User user = new User();
        user.setEmail("123");
        user.setName("John Doe");
        user.setAddress("Bangalore, Karnataka");
        User user1 = new User();
        user1.setEmail("2.5");
        user1.setName("Amit Singh");
        user1.setAddress("Chennai, Tamilnadu");
        User user2 = new User();
        user2.setEmail("185.59");
        user2.setName("Bipul Kumar");
        user2.setAddress("Bangalore, Karnataka");
        User user3 = new User();
        user3.setEmail("prakashranjan@gmail.com");
        user3.setName("Prakash Ranjan");
        user3.setAddress("Chennai, Tamilnadu");
        return Arrays.asList(user, user1, user2, user3);
    }

    @RequestMapping("/slang/{foo}")
    @ResponseBody
    public String javaslang(ServletRequest request, @PathVariable Integer foo) {
        int dividend = getFromParam(request.getParameter("dividend"));
        int divisor = getFromParam(request.getParameter("divisor"));

        Map<String, String> uriTemplateVars =
                (Map<String, String>) request.getAttribute(
                        HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        System.out.println(uriTemplateVars);

        System.out.println(dividend);
        System.out.println(divisor);

        Integer orElse = divide(dividend, divisor)
                .getOrElse(-1);
        return "ok " + orElse;
    }

    private int getFromParam(String param) {
        return Try.of(() -> {
            return parseInt(param);
        }).getOrElse(1);
    }

    private Integer parseInt(String s) {
        return Integer.parseInt(s);
    }

    Try<Integer> divide(Integer dividend, Integer divisor) {
        return Try.of(() -> dividend / divisor);
    }

}


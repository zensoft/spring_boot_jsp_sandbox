package com.tomek.config;

import com.tomek.domain.priceformating.PriceFormatter;
import com.tomek.domain.service.UserNameFormatter;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by tomek on 11.03.17.
 */
//@Configuration
public class ContextJspConfig implements ServletContextInitializer {


    private final UserNameFormatter userNameFormatter;
    private final PriceFormatter priceFormatter;

    public ContextJspConfig(UserNameFormatter userNameFormatter, PriceFormatter priceFormatter) {
        this.userNameFormatter = userNameFormatter;
        this.priceFormatter = priceFormatter;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("onStartup");
        servletContext.setAttribute("userNameFormatter", userNameFormatter);
        servletContext.setAttribute("priceFormatter", priceFormatter);
    }
}

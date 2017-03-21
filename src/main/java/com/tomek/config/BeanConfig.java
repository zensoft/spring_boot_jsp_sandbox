package com.tomek.config;

import com.tomek.domain.priceformating.PriceFormatter;
import com.tomek.domain.priceformating.PriceHandler;
import com.tomek.domain.priceformating.handlers.NumberPriceHandler;
import com.tomek.domain.priceformating.handlers.StringPriceHandler;
import com.tomek.domain.priceformating.impl.DefaultPriceFormatter;
import com.tomek.domain.service.UserNameFormatter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfig {

    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[]{"/ui/tiles/tiles.xml"});
        return tiles;
    }

    @Bean
    PriceHandler priceHandler() {
        NumberPriceHandler numberPriceHandler = new NumberPriceHandler(null);
        StringPriceHandler stringPriceHandler = new StringPriceHandler(numberPriceHandler);
        return stringPriceHandler;
    }

    @Bean
    public UserNameFormatter userNameFormatter() {
        return new UserNameFormatter();
    }

    @Bean
    PriceFormatter priceFormatter() {
        return new DefaultPriceFormatter(priceHandler());
    }

    @Bean
    public ServletContextInitializer initializer() {
        return new ServletContextInitializer() {

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setAttribute("userNameFormatter", userNameFormatter());
                servletContext.setAttribute("priceFormatter", priceFormatter());
            }
        };
    }


}

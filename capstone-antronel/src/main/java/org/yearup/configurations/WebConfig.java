package org.yearup.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

    @Configuration
    public class WebConfig implements WebMvcConfigurer
    {
        @Override
        public void addCorsMappings(CorsRegistry registry)
        {
            registry
                    .addMapping("/**")
                    .allowedOrigins("http://localhost:63342")   // your front-end URL
                    .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                    .allowCredentials(true);
        }
    }


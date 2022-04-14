package com.saschakiefer.clients;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class ClientsConfig {
}

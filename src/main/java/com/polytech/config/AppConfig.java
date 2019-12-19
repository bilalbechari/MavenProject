package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.data.JdbcRepository;
import com.polytech.data.StoryRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Bean
    DataSource dataSource() {
        HikariConfig configuration = new HikariConfig();
        configuration.setUsername(username);
        configuration.setPassword(password);
        configuration.setJdbcUrl(url);
        return new HikariDataSource(configuration);
    }

    @Bean
    StoryRepository storyRepository(){
        return new JdbcRepository(dataSource());
    }

    @Bean
    PublicationService publicationService(){
        return new PublicationService(storyRepository());
    }
}

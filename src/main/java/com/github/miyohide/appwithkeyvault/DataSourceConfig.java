package com.github.miyohide.appwithkeyvault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${app-database-url}")
    private String databaseUrl;
    @Value("${app-database-user}")
    private String databaseUser;
    @Value("${app-database-password}")
    private String databasePassword;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(this.databaseUrl);
        dataSourceBuilder.username(this.databaseUser);
        dataSourceBuilder.password(this.databasePassword);

        return dataSourceBuilder.build();
    }
}

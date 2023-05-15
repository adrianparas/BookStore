package com.snva;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatasourceAccess {
    public static HikariDataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/book_store_db");
        config.setUsername("root");
        config.setPassword("ace#2000");
        return new HikariDataSource(config);
    }
    
}

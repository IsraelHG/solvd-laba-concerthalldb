package com.solvd.laba.database.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyBatisConfig {
    public static final Logger LOGGER = LogManager.getLogger(MyBatisConfig.class.getName());
    private static final String MYBATIS_CONFIG_FILE = "mybatis-config.xml";
    private static final String DB_CREDENTIALS_FILE = "src/main/resources/mybatisdb.properties";
    private static volatile SqlSessionFactory sqlSessionFactory;

    private static final Properties props = new Properties();

    static {
        try {
            InputStream input = new FileInputStream(DB_CREDENTIALS_FILE);
            props.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file.");
        }
    }

    /**
     * Returns the singleton instance of SqlSessionFactory.
     *
     * @return The SqlSessionFactory instance.
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            synchronized (MyBatisConfig.class) {
                if (sqlSessionFactory == null) {
                    try (InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_FILE)) {
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, props);
                    } catch (IOException e) {
                        LOGGER.error("Error loading MyBatis configuration file: " + MYBATIS_CONFIG_FILE);
                        e.printStackTrace();
                    }
                }
            }
        }
        return sqlSessionFactory;
    }
}

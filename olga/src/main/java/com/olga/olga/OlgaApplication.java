package com.olga.olga;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OlgaApplication {
//private static  final Logger logger= LogManager.getLogger(OlgaApplication.class.getName());

    public static void main(String[] args) {
//
//		logger.debug("This is a debug message");
//		logger.info("This is an info message");
//		logger.warn("This is a warn message");
//		logger.error("This is an error message");
//		logger.fatal("This is a fatal message");
        SpringApplication.run(OlgaApplication.class, args);
    }

}

package com.sct.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.sct.config","com.sct.dao","com.sct.rest.controller"}) 
public class SctSpringBootApp 
{
    public static void main( String[] args )
    {
    		SpringApplication.run(SctSpringBootApp.class, args);
    }
}

package com.sct.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 */
@EnableAutoConfiguration
@ComponentScan(value="com.sct.rest.controller")
public class SctSpringBootApp 
{
    public static void main( String[] args )
    {
    		SpringApplication.run(SctSpringBootApp.class, args);
    }
}

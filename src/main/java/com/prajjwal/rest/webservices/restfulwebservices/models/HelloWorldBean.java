package com.prajjwal.rest.webservices.restfulwebservices.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HelloWorldBean {
    String name;
}

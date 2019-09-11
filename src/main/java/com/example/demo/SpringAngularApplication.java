package com.example.demo;

import com.cmeza.sdgenerator.annotation.SDGenerator;
import  org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SDGenerator(
        entityPackage = "com.example.demo.Model",
        repositoryPackage = "com.example.demo.Repository",
        repositoryPostfix = "Repository",
        managerPostfix = "Manager",
        onlyAnnotations = false,
        debug = false,
        overwrite = false
)
@SpringBootApplication
public class SpringAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAngularApplication.class, args);
    }

}

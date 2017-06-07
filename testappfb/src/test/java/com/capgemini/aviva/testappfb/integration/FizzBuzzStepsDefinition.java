package com.capgemini.aviva.testappfb.integration;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.aviva.testappfb.FizzBuzzController;


@SpringBootTest(classes = FizzBuzzController.class)
@RunWith(SpringRunner.class)
public @interface FizzBuzzStepsDefinition {
}

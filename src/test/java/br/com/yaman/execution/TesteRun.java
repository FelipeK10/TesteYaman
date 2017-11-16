package br.com.yaman.execution;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class) 
@CucumberOptions( features = ".\\src\\test\\resources\\feature", 
format = {"pretty", "html:target/Destination"},
glue = { "br.com.yaman.steps" })
public class TesteRun { 
	
}
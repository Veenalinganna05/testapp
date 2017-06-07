package com.capgemini.aviva.testappfb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.SwaggerFeature;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.aviva.testappfb.service.FizzBuzz;
import com.capgemini.aviva.testappfb.service.FizzBuzzImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@Path("/fizzbuzz")
public class FizzBuzzController {
	private static int lastcount;

	@Value("${cxf.path:/aviva/*}")
	private String cxfPath;

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private FizzBuzz fizzBuzz;

	@Bean
	public ServletRegistrationBean cxfServletRegistrationBean() {
		return new ServletRegistrationBean(new CXFServlet(), cxfPath);
	}

	@Bean
	public Server jaxRsServer() {
		// Find all beans annotated with @Path
		List<Object> serviceBeans = new ArrayList<>(ctx.getBeansWithAnnotation(Path.class).values());
		
		
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setBus(ctx.getBean(SpringBus.class));
		factory.setAddress("/");
		factory.setServiceBeans(serviceBeans);
		factory.setProvider(new JacksonJaxbJsonProvider());
		return factory.create();

	}
	

	public static void main(String[] args) {
		SpringApplication.run(FizzBuzzController.class, args);
		if (args.length > 0) {
			lastcount = Integer.parseInt(args[0]);

			// FizzBuzz.printFizzBuzz(lastcount).forEach(System.out::println);
		}
	}

	@Bean
	public FizzBuzz getFizzBuzz() {
		return new FizzBuzzImpl();
	}

	
	
	@GET
	@Path("/{number}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> fizzBuzz(@PathParam("number") int lastcount) {
		if(fizzBuzz.isValidateCount(lastcount)){
			return fizzBuzz.printFizzBuzz(lastcount);
		}else {
			throw new WebApplicationException("Value is not in the range limit");
		}
	}
	
	@GET
	@Path("/day/{number}?date={date}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> fizzBuzzDay(@PathParam("number") int lastcount, @QueryParam("date") CharSequence date) {
		if(fizzBuzz.isValidateCount(lastcount)){
			return fizzBuzz.printFizzBuzzDay(lastcount, date);
		}else {
			throw new WebApplicationException("Value is not in the range limit");
		}
	}

	@GET
	@Path("/day/{number}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> fizzBuzzDay(@PathParam("number") int lastcount) {
		if(fizzBuzz.isValidateCount(lastcount)){
			return fizzBuzz.printFizzBuzzDay(lastcount);
		}else {
			throw new WebApplicationException("Value is not in the range limit");
		}
	}

}

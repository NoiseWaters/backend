package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect // an aspect is a modularization of a concern that cuts across multiple classes
@Configuration // this tells Spring to configure this aspect into the global ApplicationContext
public class Aspects {

	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass()); // from slf4j

	// 1. Use advice to declare WHEN we want to do something @Before @After @Around
	@Before("execution(* com.revature.service.UserService.register*(..))") // SpEL - Spring Expression Language
	public void before(JoinPoint joinPoint) {

		// this is advice + when to do is as defined by @Before
		log.info("Registering User");

		log.info("Intercepted method call of {}", joinPoint);

	}
	
	@AfterReturning(value="execution(* com.revature.service.UserService.register*(..))", returning="result")
	public void afterRegister(JoinPoint joinPoint, Object result) {
		log.info("{} returned value {}", joinPoint, result);
	}
	
	@AfterThrowing("execution(* com.revature.service.UserService.register*(..))") // SpEL - Spring Expression Language
	public void afterBadRegister(JoinPoint joinPoint) {

		log.warn("Failed registration of {}", joinPoint);

	}
	
	@Before("execution(* com.revature.service.UserService.getByUsername*(..))") // SpEL - Spring Expression Language
	public void login(JoinPoint joinPoint) {

		// this is advice + when to do is as defined by @Before
		log.info("Logging in");

		log.info("Intercepted method call of {}", joinPoint);
	}
	
	@AfterReturning(value="execution(* com.revature.service.UserService.getByUsername*(..))", returning="result")
	public void afterLogin(JoinPoint joinPoint, Object result) {
		log.info("{} returned value {}", joinPoint, result);
	}
	
	@AfterThrowing("execution(* com.revature.service.UserService.getByUsername*(..))") // SpEL - Spring Expression Language
	public void afterBadLogin(JoinPoint joinPoint) {

		log.warn("Failed login of at {}", joinPoint);

	}
	
	@Before("execution(* com.revature.service.UserService.add*(..))") // SpEL - Spring Expression Language
	public void save(JoinPoint joinPoint) {

		// this is advice + when to do is as defined by @Before
		log.info("Updating songs");

		log.info("Intercepted method call of {}", joinPoint);
	}
	
	@AfterReturning(value="execution(* com.revature.service.UserService.add*(..))", returning="result")
	public void afterSave(JoinPoint joinPoint, Object result) {
		log.info("{} returned value {}", joinPoint, result);
	}
	
	@Before("execution(* com.revature.service.UserService.remove*(..))") // SpEL - Spring Expression Language
	public void delete(JoinPoint joinPoint) {

		// this is advice + when to do is as defined by @Before
		log.info("Updating songs");

		log.info("Intercepted method call of {}", joinPoint);
	}
	
	@After(value="execution(* com.revature.service.UserService.remove*(..))")
	public void afterDelete(JoinPoint joinPoint) {
		log.info("{} deleted user", joinPoint);
	}

}
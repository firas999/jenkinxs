package tn.esprit.spring.config;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sun.istack.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger logger = Logger.getLogger(LoggingAspect.class);
	
	//@Before("execution(public * *(..))")
	//@Before("execution(* tn.esprit.spring..*.*(..))")
	//@Before("execution(* set*(..))")
	//@Before("execution(Modifiers-pattern ? Ret-type-pattern Declaring-type-pattern?Name-pattern(param-pattern) Throws-pattern?)")

    /*@Before("execution(* tn.esprit.spring.services.*.*(..))")
	public void logmethodentry(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		logger.info("in method "+name);
		
		
	}*/
/*
	//calculer le temps dexecution dune methode 
	@Around("execution(* tn.esprit.spring.services.*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
	long start = System.currentTimeMillis();
	Object obj = pjp.proceed();
	long elapsedTime = System.currentTimeMillis() - start;
	logger.info("Method execution time: " + elapsedTime + " milliseconds.");
	return obj;
	}
	*/
	
	//Afficher message apres une execution valide
	@After("execution(* tn.esprit.spring.services.*.ajouter*(..))")
	public void logmethodexit(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		logger.info("Gestion match : ajout realise avec succes ");
		
	}
	/*
	Afficher message apres l"execution qlq soit le resultat 
	@AfterReturning("execution(* tn.esprit.spring.services.*.*(..))")
	public void hattakenfammaerr(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		logger.info("bel erreur wala blech "+name);
		
	}
	//Afficher message apres exception
	@AfterThrowing("execution(* tn.esprit.spring.services.*.*(..))")
	public void justekenfammaerr(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		logger.info("ken fel err "+name);
		
	}*/
	//Afficher message apres methode precise
	/*@After("execution(* tn.esprit.spring.services.*.ajouterFormateur*(..))")
	public void apres(JoinPoint thisJoinPoint) {
		logger.info("*************************");
		logger.info("*************************");		logger.info("*************************");
		logger.info("Out of the method (After)" + thisJoinPoint.getSignature().getName());
		logger.info("*************************");		logger.info("*************************");
	}*/



}
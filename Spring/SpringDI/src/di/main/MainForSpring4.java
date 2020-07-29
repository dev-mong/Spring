package di.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import di.service.ChangePasswordService2;
import di.service.MemberRegisterService2;

public class MainForSpring4 {

	private static GenericXmlApplicationContext ctx = null;

	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx7.xsml");

		MemberRegisterService2 mrService1= ctx.getBean("memberregSvc",MemberRegisterService2.class);
		
		MemberRegisterService2 mrService2= ctx.getBean("memberregSvc",MemberRegisterService2.class);
		
		boolean chk1 = mrService1 == mrService2;
			
		System.out.println("mrService 1=> mrService2 => "+chk1);
		
		ChangePasswordService2 chService = ctx.getBean("memberPwSvc",ChangePasswordService2.class);

		ChangePasswordService2 chService2 = ctx.getBean("memberPwSvc",ChangePasswordService2.class);
		
		boolean chk2 = chService == chService2;
		
		System.out.println("mrService 1=> mrService2 => "+chk2);

	}

}

package eunzzi01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * TransportationWalk transportationWalk = new TransportationWalk();
		 * transportationWalk.move();
		 */
		
		// applicationContext.xml에 bean 설정 했으니 new 키워드 활용하여 객체 생성할 필요 x
		
		// 스프링 컨테이너에 접근하기
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		
		// 컨테이너에 있는 bean 가져와서 변수에 담아주기
		// ctx.getBean("bean id",데이터 타입);
		TransportationWalk transportationWalk = ctx.getBean("tWalk",TransportationWalk.class);
		transportationWalk.move();
		
		// 외부 리소스 사용시 반드시 리소스 반환을 해줘야함
		ctx.close();
	}

}

package ems.member.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ems.member.dao.StudentDao;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

// dao, service만 관리되는 설정 파일
@Configuration
@Import({ MemberConfig2.class, MemberConfig3.class })
public class MemberConfig1 {

	// <bean id="studentDao" class="ems.member.dao.StudentDao" ></bean>
	// bean 객체임을 알려주기 위한 어노테이션
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}

	/*
	 * <bean id="registerService" class="ems.member.service.StudentRegisterService">
	 * <constructor-arg ref="studentDao" ></constructor-arg> </bean>
	 */
	@Bean
	public StudentRegisterService registerService() {
		// 생성자를 가져옴 (constructor-arg)
		return new StudentRegisterService(studentDao());
	}

	/*
	 * <bean id="modifyService" class="ems.member.service.StudentModifyService">
	 * <constructor-arg ref="studentDao" ></constructor-arg> </bean>
	 */
	@Bean
	public StudentModifyService modifyService() {
		// 생성자를 가져옴 (constructor-arg)
		return new StudentModifyService(studentDao());
	}

	/*
	 * <bean id="deleteService" class="ems.member.service.StudentDeleteService">
	 * <constructor-arg ref="studentDao" ></constructor-arg> </bean>
	 */
	@Bean
	public StudentDeleteService deleteService() {
		// 생성자를 가져옴 (constructor-arg)
		return new StudentDeleteService(studentDao());
	}

	/*
	 * <bean id="selectService" class="ems.member.service.StudentSelectService">
	 * <constructor-arg ref="studentDao" ></constructor-arg> </bean>
	 */
	@Bean
	public StudentSelectService selectService() {
		// 생성자를 가져옴 (constructor-arg)
		return new StudentSelectService(studentDao());
	}

	/*
	 * <bean id="allSelectService"
	 * class="ems.member.service.StudentAllSelectService"> <constructor-arg
	 * ref="studentDao" ></constructor-arg> </bean>
	 */
	@Bean
	public StudentAllSelectService allSelectService() {
		// 생성자를 가져옴 (constructor-arg)
		return new StudentAllSelectService(studentDao());
	}

}

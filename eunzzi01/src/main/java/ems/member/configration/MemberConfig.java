package ems.member.configration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDao;
import ems.member.service.EMSInformationService;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

// applicationContext.xml 파일을 대신할 java파일
// xml파일과 동일하게 스프링 컨테이너 생성
@Configuration
public class MemberConfig {

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

	/*
	 * <bean id="dataBaseConnectionInfoDev"
	 * class="ems.member.DataBaseConnectionInfo"> <property name="jdbcUrl"
	 * value="jdbc:oracle:thin:@localhost:1521:xe" /> <property name="userId"
	 * value="scott" /> <property name="userPw" value="tiger" /> </bean>
	 */
	// 데이터베이스 커넥션 부분
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
		DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
		infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		infoDev.setUserId("eunzzidevid");
		infoDev.setUserPw("eunzzidevpw");
		return infoDev;
	}

	/*
	 * <bean id="dataBaseConnectionInfoReal"
	 * class="ems.member.DataBaseConnectionInfo"> <property name="jdbcUrl"
	 * value="jdbc:oracle:thin:@192.168.0.1:1521:xe" /> <property name="userId"
	 * value="masterid" /> <property name="userPw" value="masterpw" /> </bean>
	 */
	@Bean
	public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
		DataBaseConnectionInfo infoReal = new DataBaseConnectionInfo();
		infoReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
		infoReal.setUserId("eunzzirealid");
		infoReal.setUserPw("eunzzirealpw");
		return infoReal;
	}

	@Bean
	public EMSInformationService informationService() {
		EMSInformationService info = new EMSInformationService();
		info.setInfo("Education Management System program was developed in 2021.");
		info.setCopyRight("COPYRIGHT(C) 2021 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		info.setVer("The version is 1.0");
		info.setsYear(2021);
		info.setsMonth(9);
		info.setsDay(14);
		info.seteYear(2021);
		info.seteMonth(9);
		info.seteDay(15);

		// list 타입의 값을 위해 ArrayList 사용
		ArrayList<String> developers = new ArrayList<>();
		developers.add("lee");
		developers.add("eun");
		developers.add("jin");
		developers.add("best");
		developers.add("zzang");
		info.setDevelopers(developers);

		// Map 구조의 값을 위해 Map 사용
		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("lee", "lee@spring.org");
		administrators.put("jin", "jin@spring.org");
		info.setAdministrators(administrators);

		Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<String, DataBaseConnectionInfo>();
		dbInfos.put("dev", dataBaseConnectionInfoDev());
		dbInfos.put("real", dataBaseConnectionInfoReal());
		info.setDbInfos(dbInfos);

		return info;
	}

}

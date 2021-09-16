package ems.member.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;

// databaseconnection만 관리되는 설정 파일
@Configuration
public class MemberConfig2 {

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

}

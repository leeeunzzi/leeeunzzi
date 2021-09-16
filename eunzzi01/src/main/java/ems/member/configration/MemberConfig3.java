package ems.member.configration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.service.EMSInformationService;

// util만 관리되는 설정 파일
@Configuration
public class MemberConfig3 {

	// dbInfos에 참조 할 메소드 추가
	@Autowired
	DataBaseConnectionInfo dataBaseConnectionInfoDev;

	@Autowired
	DataBaseConnectionInfo dataBaseConnectionInfoReal;

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
		dbInfos.put("dev", dataBaseConnectionInfoDev);
		dbInfos.put("real", dataBaseConnectionInfoReal);
		info.setDbInfos(dbInfos);

		return info;
	}

}

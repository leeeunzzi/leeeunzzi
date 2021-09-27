<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>memJoinOk</h1>
	<%-- 	ID : ${memId}<br />
	PW : ${memPw}<br />
	Mail : ${memMail} <br />
	Phone : ${memPhone} <br /> --%>

	<%-- 	<!-- Member.java의 getter -->
	ID : ${member.memId}
	<br /> PW : ${member.memPw}
	<br /> Mail : ${member.memMail}
	<br /> Phone : ${member.memPhone1} - ${member.memPhone2} -
	${member.memPhone3}
	<br /> --%>
	<!-- Member.java의 getter -->
	ID : ${mem.memId}
	<br /> PW : ${mem.memPw}
	<br /> Mail : ${mem.memMail}
	<br /> Phone : ${mem.memPhone1} - ${mem.memPhone2} - ${mem.memPhone3}
	<br />

	<a href="/pjtex/resources/html/memJoin.html"> Go MemberJoin </a>
</body>
</html>

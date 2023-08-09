<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@page import="com.digit.hibernateServlet.bean.UserDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	session = request.getSession();
	List userList = (List) session.getAttribute("inactiveUser");
	Iterator itr = userList.iterator();

	
	%>
	
	<form action="changeUserActive" method="post">
		<select name="userId">
		<%
		while (itr.hasNext()) {
			UserDetails sd = (UserDetails) itr.next();
			out.println("<option value='"+sd.getU_id()+"'>" + sd.getU_name()+"</option>");
		}
		%>
		</select>
		<input type="submit"> 
	</form>

</body>
</html>
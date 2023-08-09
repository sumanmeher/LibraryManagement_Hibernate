<%@page import="com.digit.hibernateServlet.bean.BookDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	session = request.getSession();
	List userList = (List) session.getAttribute("inactiveBooks");
	Iterator itr = userList.iterator();

	while (itr.hasNext()) {
		BookDetails sd = (BookDetails) itr.next();
		out.println("Details: <BR>" + sd.getB_name()+"<BR>");

	}
	%>

</body>
</html>
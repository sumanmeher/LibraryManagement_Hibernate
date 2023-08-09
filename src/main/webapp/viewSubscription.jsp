
<%@page import="com.digit.hibernateServlet.bean.SubscriptionDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscription Details</title>
</head>
<body>
	<%
	session = request.getSession();
	List userList = (List) session.getAttribute("viewSubscription");
	Iterator itr = userList.iterator();

	while (itr.hasNext()) {
		SubscriptionDetails sd = (SubscriptionDetails) itr.next();
		out.println("Details: <BR>" + sd.getSub_id()+"<BR>"+ sd.getU_id()+"<BR>"+sd.getAmount()+"<BR>"+sd.getInvoice_no()+"<BR>"+sd.getDate());

	}
	%>

</body>
</html>
<%@page import="com.digit.hibernateServlet.bean.PurchaseHistoryDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase History</title>
</head>
<body>
	<%
	session = request.getSession();
	List userList = (List) session.getAttribute("viewPurchaseHistory");
	Iterator itr = userList.iterator();

	while (itr.hasNext()) {
		PurchaseHistoryDetails phd = (PurchaseHistoryDetails) itr.next();
		out.println("Details: <BR>" + phd.getP_id() + "<BR>" + phd.getB_id() + "<BR>" + phd.getB_name() + "<BR>"
		+ phd.getU_id() + "<BR>" + phd.getAmount()+ "<BR>"+ phd.getInvoice_no());

	}
	%>

</body>
</html>
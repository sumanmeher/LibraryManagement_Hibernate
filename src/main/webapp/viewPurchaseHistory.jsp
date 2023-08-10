<%@page import="com.digit.hibernateServlet.bean.PurchaseHistoryDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%
	session = request.getSession();
	List userList = (List) session.getAttribute("viewPurchaseHistory");
	Iterator itr = userList.iterator();

	
	%>

	<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor//.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <link href="assets/css/style.css" rel="stylesheet">

</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center justify-content-lg-between">

      <h1 class="logo me-auto me-lg-0"><a href="index.html">Gp<span>.</span></a></h1>

      <a href="#about" class="get-started-btn scrollto">Get Started</a>

    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container">

      

        <div class="row">
          
          <div class="col-6 pt-4 pt-lg-0 order-2 order-lg-1 content" style="color:white;">
            <h3>All Purchase</h3>

				<div class="container mt-4">
            <div class="card mb-4">
                <div class="card-body">
                    <!--Table-->
                    <table class="table table-hover">
                        <!--Table head-->
                        <thead class="mdb-color darken-3">
                            <tr >
                                <th>Purchase Id</th>
                                <th>Book Id</th>
                                <th>Book Name</th>
                                <th>User Id</th>
                                <th>Amount</th>
                                <th>Invoice No.</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <%
                           	
                            
                        	 while (itr.hasNext()) {
                         		PurchaseHistoryDetails sd = (PurchaseHistoryDetails) itr.next();
                         		out.println("<tr>");
                        		out.println("<td>"+sd.getP_id()+"</td>");
                        		out.println("<td>"+sd.getB_id()+"</td>");
                        		out.println("<td>"+sd.getB_name()+"</td>");
                        		out.println("<td>"+sd.getU_id()+"</td>");
                        		out.println("<td>"+sd.getAmount()+"</td>");
                        		out.println("<td>"+sd.getInvoice_no()+"</td>");
                        		out.println("</tr>");
                        		
                        		
                        	}
                            
                            %>
                        </tbody>
                        <!--Table body-->
                    </table>
                    <!--Table-->
                </div>
            </div>

        </div>
				
				
          </div>
        </div>

    </div>
  </section><!-- End Hero -->


    

</body>

</html>
	
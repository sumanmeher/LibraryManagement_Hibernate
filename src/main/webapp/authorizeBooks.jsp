<%@page import="com.digit.hibernateServlet.bean.BookDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	session = request.getSession();
	List userList = (List) session.getAttribute("inactiveBooks");
	Iterator itr = userList.iterator();

	
	%>
	

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Authorize Book</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <link href="https://vectorified.com/images/library-book-icon-2.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

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

  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center justify-content-lg-between">

      <h1 class="logo me-auto me-lg-0"><a href="adminMenu.jsp">Library Management<span>.</span></a></h1>

      <a href="Logout" class="get-started-btn scrollto">Logout</a>

    </div>
  </header>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container">

      <div class="row justify-content-center"  >
        <div class="col-xl-6 col-lg-8">
          <h1>Authorize Book<span>.</span></h1>
        </div>
      </div>

      <div class="row gy-4 mt-5 justify-content-center mb-5" style="color:white;">
       <div class="col-3 form-box">
       <h3>Choose the Book</h3>
      <form action="changeBookActive" method="post">
       <select name="bookId" class="form form-control">
		<%
		while (itr.hasNext()) {
			BookDetails sd = (BookDetails) itr.next();
			out.println("<option value='"+sd.getB_id()+"'>" + sd.getB_name()+"</option>");

		}
		%>
		</select><br>

		
		<input type="submit" class="btn btn-success">
	</form>
        </div>
      </div>

    </div>
  </section>

  <footer id="footer">
    

    <div class="container">
      <div class="copyright">
        &copy; Library Management. All rights reserved. Digit Insurance
      </div>
      
    </div>
  </footer>


  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <script src="assets/js/main.js"></script>

</body>

</html>
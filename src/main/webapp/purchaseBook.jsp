<%@page import="com.digit.hibernateServlet.bean.BookDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%
	session = request.getSession();
	List userList = (List) session.getAttribute("allBooks");
	Iterator itr = userList.iterator();
	%>

	
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Purchase</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="https://vectorified.com/images/library-book-icon-2.png" rel="icon">
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

  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center justify-content-lg-between">

      <h1 class="logo me-auto me-lg-0"><a href="userMenu.html">Library Management<span>.</span></a></h1>

      <a href="Logout" class="get-started-btn scrollto">Logout</a>

    </div>
  </header><!-- End Header -->
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container">

      <div class="row justify-content-center"  >
        <div class="col-xl-6 col-lg-8">
          <h1>Purchase Book<span>.</span></h1>
        </div>
      </div>

      <div class="row gy-4 mt-5 justify-content-center mb-5" style="color:white;">
       <div class="col-3 form-box">
       <h2>Select a Book</h2>
      <form action="PurchaseBookFinal" method="post">
		<select name="b_id" class="form form-control mt-3">
			<%
			while (itr.hasNext()) {
				BookDetails sd = (BookDetails) itr.next();
				out.println("<option value='" + sd.getB_id() + "'>" + sd.getB_name() + "</option>");

			}
			%>
		</select>
		<br>
		 <input type="submit" class="btn btn-success">
	</form>
        </div>
      </div>

    </div>
  </section><!-- End Hero -->

  <footer id="footer">
    

    <div class="container">
      <div class="copyright">
        &copy; Library Management. All rights reserved. Digit Insurance
      </div>
      
    </div>
  </footer><!-- End Footer -->

  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>
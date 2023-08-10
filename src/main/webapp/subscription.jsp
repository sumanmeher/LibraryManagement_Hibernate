<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Subscription</title>
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
  
  <style>
  li{
  	color:white;
  	list-style-type:none;
  }
  </style>
  
</head>

<body>

  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center justify-content-lg-between">

      <h1 class="logo me-auto me-lg-0"><a href="index.html">Library Management<span>.</span></a></h1>

      <a href="Logout" class="get-started-btn scrollto">Logout</a>

    </div>
  </header><!-- End Header -->
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container">

      <div class="row justify-content-center"  >
        <div class="col-xl-6 col-lg-8">
          <h1 style="font-size:43px;">Subscription Plan<span>.</span></h1>
        <br>
        
        <div class="subscription-plan">
  <ul>
    <li>
      <strong style="color: white;">Plan Name:</strong> Silver<br>
      <strong style="color: white;">Rate:</strong> &#8377; 299/month<br><br>
    </li>
    <li>
      <strong style="color: white;">Plan Name:</strong> Gold<br>
      <strong style="color: white;">Rate:</strong> &#8377;999/month<br><br>
    </li>
    <li>
      <strong style="color: white;">Plan Name:</strong> Diamond<br>
      <strong style="color: white;">Rate:</strong> &#8377; 1599/month<br><br>
    </li>
  </ul>
</div>
        
        
        </div>
      </div>

      <div class="row gy-4 mt-5 justify-content-center mb-5" style="color:white;">
       <div class="col-2">
      	<form action="subscription">
		<select name="subscriptionType" class="form form-control">
			<option value="silver">Silver</option>
			<option value="gold">Gold</option>
			<option value="diamond">Diamond</option>
		</select><br>
		<input type="submit" class="btn btn-success">
	</form>
        </div>
      </div>

    </div>
  </section><!-- End Hero -->

  <main id="main">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Here</title>
<link rel="stylesheet" href="css/registration_style.css"></link>
</head>
<body>
<div class="container">
	
		<div id="form-section">
			<form id="myForm" method="post" action=RegistrationServlet>
				<div id="form-head">Register !!</div>
				<input class="my-inputs" type="text" name=firstName placeholder="First Name" required>
				<input class="my-inputs" type="text" name=lastName placeholder="Last Name" required>
				<input class="my-inputs" type="text" name=country placeholder="Country">
				<input class="my-inputs" type="text" name=state placeholder="State">
				<input class="my-inputs" type="text" name=city placeholder="City">
				<input class="my-inputs" type="text" name=address placeholder="Address">
				<input class="my-inputs" type="text" name=zipCode placeholder="ZIP Code">
				<input class="my-inputs" type="text" name=phone placeholder="Phone No.">
				<input class="my-inputs" type="text" name=userID placeholder="Userlogin ID" required>
				<input class="my-inputs" type="password" name=userPassword placeholder="Password" required>
				<input class="my-inputs"  id="submitForm" type="submit" value="Register !!">
				
				
			</form>
		</div>
</div>

</body>
</html>
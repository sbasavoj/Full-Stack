<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center" >
		<form name="registerationfrm" action="RegistrationServlet" method="post">
			<table>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><input type="number" name="age"></td>
				</tr>
				<tr>
					<td>Email Id:</td>
					<td><input type="number" name="emailId"></td>
				</tr>
				<tr>
					<td>Mobile Number:</td>
					<td><input type="number" name="mobileNo"></td>
				</tr>
				<tr>
					<td>Gender:</td>
				</tr>
				<tr>
					<td><input type="radio" name="gender" value="Male">Male<br>
						<input type="radio" name="gender" value="Female">Female<br>
						<input type="radio" name="gender" value="Other">Other<br>
					</td>
				</tr>
				<tr>
					<td>Communication Mode:</td>
					<td><input type="checkbox" name="communicationMode" value="E-mail">Mail<br>
						<input type="checkbox" name="communicationMode" value="Mobile">Mobile<br>
						<input type="checkbox" name="communicationMode" value="WhatsApp">WhatsApp<br>
						<input type="checkbox" name="communicationMode" value="Post">Post<br>
					</td>
				</tr>
				<tr>
					<td>Graduation: <select name="graduation">
							<option  value="B.Tech">B.Tech</option>
							<option  value="Bsc">Bsc</option>
							<option  value="BE.Communication">BE.Communication</option>
							<option  value="BE.ComputerScience">BE.ComputerScience</option>
							<option  value="BE.Civil">BE.Civil</option>
							<option  value="BE.Electrical">BE.Electrical</option>
							<option  value="BE.Instrumentation">BE.Instrumentation</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Re-Enter Password:</td>
					<td><input type="password" name="rPassword"></td>
					<tr>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
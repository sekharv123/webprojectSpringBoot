<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<title><tiles:insertAttribute name="title" /></title>
<style>
	#footer {
		position: fixed;
		bottom: 0;
		width: 100%;
		/* Height of the footer*/ 
		height: 40px;
		background: grey;
		text-align: center;
	}

</style>
</head>
<body>

	<tiles:insertAttribute name="header" />
	<br />
	<tiles:insertAttribute name="body" />
	<br />
	<tiles:insertAttribute name="footer" />

</body>
</html>
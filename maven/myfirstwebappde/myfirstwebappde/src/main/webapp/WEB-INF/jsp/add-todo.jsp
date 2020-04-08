<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>add todos</title>
 <link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css"
	    		rel="stylesheet">	

</head>
<body>


<h1>Add Todo Page</h1>
<div class= "container">   

 <form:form method="post" modelAttribute="todo">
 <form:hidden path ="id"/>
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input path="desc" type="text" class="form-control" required="required"/>
				<form:errors path="desc" cssClass="text-warning"/>
			</fieldset>
		
			<fieldset class="form-group">
				<form:label path="targetDate">Traget Date</form:label>
				<form:input path="targetDate" type="text" class="form-control" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"/>
			</fieldset>
			
				
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
		

</div>
<script src="webjars/jquery/3.4.0/jquery.min.js"></script>
	    <script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	   
</body>
</html>
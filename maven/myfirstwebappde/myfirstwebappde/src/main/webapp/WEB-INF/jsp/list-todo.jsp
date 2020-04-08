


<%@include file='common/header.jsp' %>

 <%@include file='common/navigation.jsp' %>
 
 



<div class= "container">


<table class ="table table-striped">
     
    <thead>
    <tr>
       <th>Description</th>
       <th>TargetDate</th>
       <th>Status</th>
    </tr>
    </thead>
    
    <tbody>
    
    <c:forEach items ="${todos}" var="todo">
    <tr>
    <td>${todo.desc }</td>
    <td><fmt:formatDate value ="${todo.targetDate }" pattern="dd/MM/yyyy"/></td>
    <td>${todo.done }</td>
    <td><a class ="btn btn-success" type ="button" href ="/update-todo?id=${todo.id }">UPDATE</a>
    <td><a class ="btn btn-warning" type ="button" href ="/delete-todo?id=${todo.id }">DELETE</a>
    </tr>
    </c:forEach>
    
    </tbody>
</table>
</div>

<div>
<a role="button" class="btn-default" href='/add-todo'>Add Todo</a></div>

	<script src="webjars/jquery/3.4.0/jquery.min.js"></script>
	    <script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	  
	  </body>
</html>
  
		

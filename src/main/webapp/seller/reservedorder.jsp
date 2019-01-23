<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>

<div class="jumbotron text-center">
  <h1>View Reserved Order</h1> 


   
</div>
<!-- Container (Contact Section) -->
<div class="container">
    <div class="row">
    <div style=padding-top:0px;>
    <font color="green">${Succ}</font>
</div>
<table class="table table-hover">
    <thead>
      <tr>
        <th>Product Name</th>
        <th>Firstname</th>
        <th>LastName</th>
        <th>Store</th>
        <th>Collected</th>
        <th>Mark As Collected</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${sellorder}" var="b"> 
      <tr>
        <td>${b.productname}</td>
        <td>${b.firstname}</td>
        <td>${b.lastname}</td>
        <td>${b.storename}</td>
        <td>${b.status}</td>
        <td>
        <a href="/collected/${b.orderlineid}">
			<button type="button" class="btn btn-danger">Collected</button>
		</a>
		</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  
   </div>
</div>


<%@ include file="footer.jsp"%>

<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>

<!-- Container (Contact Section) -->
<div class="container">
    <div class="row">
  <div class="col-md-12" style="padding-top:100px">
		    <h1> My Orders</h1>
		<legend></legend>
		</div>
		

<table class="table table-hover">
    <thead>
      <tr>
        <th>Order ID </th>
        <th>OrderDate</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${orders}" var="b"> 
      <tr>
        <td>${b.ID}</td>
        <td>${b.orderdate}</td>
        <td>
        <a href="/vieworder/${b.ID}">
			<button type="button" class="btn btn-danger">View</button>
		</a>
		</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
<div class="col-md-12" style="padding-top:10px">
		<legend></legend>
		

</div>
</div>







<%@ include file="footer.jsp"%>
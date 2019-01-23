<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>

<!-- Container (Contact Section) -->
<div class="container">
    <div class="row">
  <div class="col-md-12" style="padding-top:100px">
		    <h1> Reserved Item</h1>
		<legend></legend>
		</div>
		

<table class="table table-hover">
    <thead>
      <tr>
        <th>Product Name</th>
        <th>Pick up Store</th>
        <th>Price</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${orderline}" var="b"> 
      <tr>
        <td>${b.productname}</td>
        <td>${b.storname}</td>
        <td>£${b.price}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
<div class="col-md-12" style="padding-top:10px">
		<legend></legend>
		

</div>
</div>







<%@ include file="footer.jsp"%>
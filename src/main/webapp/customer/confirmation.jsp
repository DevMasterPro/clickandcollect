<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>
<div class="jumbotron text-center">
  <h1>Confirmation</h1> 
   <h3> The table below demonstrate the list of product you are going to reserve </h3> 
   <h4> Please click the submit button once you are happy to reserve the items...</h4>
  </div>
  
  <div class="container">
<div class="row">
 <div class="col-md-12" style="padding-top:20px">
		<h1>Products</h1>
		<legend></legend>
		
		<font color="green">${productdeletet}</font>
		</div>
<table class="table table-hover">
    <thead>
      <tr>
        <th>Product name</th>
        <th>Quantity</th>
        <th>Price</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${confirm}" var="b"> 
      <tr>
        <td>${b.name}</td>
        <td>${b.quantity}</td>
        <td>£${b.price}</td>
       
      </tr>
    </c:forEach>
    </tbody>
  </table>
<div class="col-md-12" style="padding-top:10px">
		<legend></legend>
		
		<div class="col-md-06" Style="float:left;">
			<h5> <b>Total: £${total}</b></h5>
		</div>
		<div class="col-md-06" Style="margin: 0px 900px auto;">
		<a href="/order">
			<button type="button" class="btn btn-success">Submit</button></a>
		</div>
		</div>




</div>

</div>
  
  
  
  
  

<%@ include file="footer.jsp"%>

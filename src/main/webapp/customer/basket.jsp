<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>
<div class="jumbotron text-center">
  <h1>Shopping cart</h1> 
 
 </div>
<div class="container">
<div class="row">
 <div class="col-md-12" style="padding-top:100px">
	
		<legend></legend>
		
		<font color="green">${productdeletet}</font>
		</div>
<table class="table table-hover">
    <thead>
      <tr>
        <th>Product name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Delete </th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${basketofproduct}" var="b"> 
      <tr>
        <td>${b.name}</td>
        <td>${b.quantity}</td>
        <td>£${b.price}</td>
        <td>
        <a href="/deleteproduct/${b.ID}">
			<button type="button" class="btn btn-danger">Delete</button>
		</a>
		</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
<div class="col-md-12" style="padding-top:10px">
		<legend></legend>
		
		<div class="col-md-06" Style="float:left;">
			<h5> <b>Total: £${total}</b></h5>
		</div>
			<div class="col-md-06" Style="margin: 0px 850px auto;">
		
	
		<%
		int getCount = (Integer)session.getAttribute("checktotal");
		
		if(getCount <= 0) { %>
	
		<a href="/reserve">
			<button type="button" class="btn btn-success" disabled>Reserve Item</button></a>
		
		<% 

		System.out.println("Hello in if condition");
		System.out.println("hello session:" + session.getAttribute("checktotal"));
		}
		
		else {
		%>
		<a href="/reserve">
			<button type="button" class="btn btn-success"  >Reserve Item</button></a>
		
		
		<%   System.out.println("Hello in else condition"); 	System.out.println("hello session:" + session.getAttribute("checktotal"));} %>
		</div>
		
		
		</div>




</div>

</div>


<%@ include file="footer.jsp"%>
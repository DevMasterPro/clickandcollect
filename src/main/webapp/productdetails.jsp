<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>

<div class="container">
<div class="row">
 <div class="col-md-12" style="padding-top:100px">
		<h1>Product Details Page</h1>
		<legend></legend>
		
		<font color="green">${addedtoshopingcart}</font>
		</div>


	<div class="col-lg-12" style="margin-top: 20px;">
			<div class="col-lg-4 item-photo" style="float: left;">
			<img src="/imgs/product.jpg"alt="ALT NAME" class="img-thumbnail" />

			</div>

			<c:forEach items="${productdetail}" var="dt">





				<div class="col-lg-8" style="float: left;">

					<div class="col-lg-8">

						<h4>Name</h4>${dt.productname}


					</div>








					<div class="col-lg-8">

						<h4>Product Info</h4>


						<p>${dt.productinfo}</p>


					</div>

					<div class="col-lg-8">

						<h4>Price:</h4>
						<p>
							<label> £</label>${dt.price}</p>

					</div>




<form method="POST" action="/shoppingcart">
					<div class="col-lg-8">
					<div class="col-md-4" style="float: left;">
						
						<div class="form-group">
							 <input class="form-control" placeholder="Enter Quantity" name="quantity" type="text" autofocus="" required>
							  <input class="form-control"  name="name" type="hidden" autofocus="" value="${dt.productname}" >
							  <input class="form-control"  name="price" type="hidden" autofocus="" value="${dt.price}" >
							  <input class="form-control"  name="id" type="hidden" autofocus="" value="${dt.ID}" >
							</div>
							
						</div>
						
						<div class="col-md-4" style="float: right;">
							
								<button type="submit" class="btn btn-success">Add To Basket</button>
							</a>
						</div>


					</div>
					</form>



				</div>
		
			
		<div class="col-lg-12" style="margin-top: 10px; margin-bottom: 10px;">

			<h4>Description</h4>
			<div style="width: 100%; border-top: 1px solid silver">
				<p style="padding: 15px;">
					<small> ${dt.productdesc} </small>
				</p>

			</div>
		</div>

		</c:forEach>
</div>


</div>


</div>














<%@ include file="footer.jsp"%>
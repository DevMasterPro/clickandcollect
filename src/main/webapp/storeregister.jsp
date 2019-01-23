<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>

<div class="jumbotron text-center">
	<h1>Register Seller</h1>
</div>
<!-- Container (Contact Section) -->
<div class="container-fluid">
	<div class="row">

		<div id="contact" class="container-fluid bg-grey">
			
			<div class="row ">
				<div class="col-sm-7">
					<div class="row ">

						<form role="form" method="post" action="/storeregister">

							<div class="col-sm-6 form-group col-sm-push-5">
								<input class="form-control" id="fname" name="fname"
									placeholder="First Name" type="text" required>
							</div>
							<div class="col-sm-6 form-group col-sm-push-5">

								<input class="form-control" id="sname" name="sname"
									placeholder="Surname" type="text" required>
							</div>
							<div class="col-sm-6 form-group col-sm-push-5"">

								<input class="form-control" id="email" name="email"
									placeholder="Type in your Email" type="email" required>
							</div>
							<!-- password box -->
							<div class="col-sm-6 form-group col-sm-push-5"">

								<input class="form-control" name="pass" placeholder="Password"
									type="password" value="">
							</div>
							<div class="col-sm-6 form-group col-sm-push-5"">

								<input class="form-control" id="phonenum" name="phonenum"
									placeholder="Phone number" type="tel" required>
							</div>

							<div class="col-sm-6 form-group col-sm-push-5"">

								<input class="form-control" id="City" name="City"
									placeholder="City" type="tel" required>
							</div>


							<div class="col-sm-6 form-group col-sm-push-5"">

								<input class="form-control" id="Add1" name="Add1"
									placeholder="Address Line 1" type="tel" required>
							</div>

							<div class="col-sm-6 form-group col-sm-push-5"">

								<input class="form-control" id="postcode" name="postcode"
									placeholder="postcode" type="tel" required>
							</div>
							<div class="col-sm-6 form-group col-sm-push-5"">

								<input class="form-control" id="Add2" name="Add2"
									placeholder="Address Line 2" type="tel" required>
							</div>



							<div class="row">
								<div class="col-sm-12 form-group col-sm-push-5">
									<font color="Red">${emailexists}</font> <font color="Green">${succ}</font>
								</div>
							</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-12 form-group col-sm-push-5">
							<button class="btn btn-default pull-right tn-success "
								value="register" name="register" type="submit">Register</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>






		<br>
		<br>


	</div>

</div>





<%@ include file="footer.jsp"%>
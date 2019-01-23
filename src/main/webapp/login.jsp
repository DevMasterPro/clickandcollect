<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>


<div class="jumbotron text-center">
  
  
 
    

   
</div>
<!-- Container (Contact Section) -->
<div class="container-fluid">
    <div class="row">
    

<div id="contact" class="container-fluid bg-grey">
  <h2 class="text-center">Longin</h2>
  <div class="row ">
    <div class="col-sm-7">
      <div class="row ">

         <form role="form" method="post" action="/login">
          
          
          <div class=" col-sm-12 form-group col-sm-push-5" style="padding-bottom:0px;">
			<label>Select Login Type: </label>
			<select name ="type"  style="padding-left:20px;" required>
			      <option value="">None</option>
			      <option value="customer">Customer</option>
			      <option value="seller">Seller</option>
			      <option value="admin">Admin</option>
    			</select>
         
          </div>
          <div class=" col-sm-12 form-group col-sm-push-5">
            <input class="form-control" id="email"  name="email" placeholder="Type in your Email" type="email" required>
          </div>
        <!-- password box -->
        
          <div class="col-sm-12 form-group col-sm-push-5">
              <input class="form-control"  name="pass" placeholder="Password" type="password" value="">
          </div> 
          <div class="col-sm-12 form-group col-sm-push-5">
        <font color="Red"> ${errorLogin}</font>
          </div> 
         
         
        
      </div><br>
      <div class="row">
        <div class="col-sm-12 form-group col-sm-push-5">
          <button class="btn btn-default pull-right btn-success " value="login" name="login" type="submit" >Submit</button>
      
        </div>
      
      </div>
          </form>
    </div>
  </div>
</div>

  
   </div>

</div>



<%@ include file="footer.jsp"%>
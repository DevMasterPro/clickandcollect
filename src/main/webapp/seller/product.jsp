<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>


<div class="jumbotron text-center">
  
   
</div>
<!-- Container (Contact Section) -->
<div class="container-fluid">
    <div class="row">
    
<div id="contact" class="container-fluid bg-grey">
  <h2 class="text-center">Create product</h2>
  <div class="row ">
    <div class="col-sm-7">
      <div class="row ">

         <form role="form" method="post" action="/product">

<div class="col-sm-12 form-group col-sm-push-5">
           

          <label>Select Store: </label>
			<select name ="storeid"  style="padding-left:20px;" required>
			      	<option value="">None</option>
			     <c:forEach items="${store}" var="s">
			      	<option value="${s.ID}">${s.storename}</option>
			   	 </c:forEach>
    			</select>
          </div>



          <div class="col-sm-12 form-group col-sm-push-5">
            <input class="form-control" id="productname" name="productname" placeholder="Product name" type="text" required>
          </div>
          
          <div class="col-sm-12 form-group col-sm-push-5">
 
            <textarea class="form-control" id="productinfo" name="productinfo" placeholder="Product Info"  required></textarea>
          </div>
          
           <div class="col-sm-12 form-group col-sm-push-5">
 
            <textarea class="form-control" id="productdesc" name="productdesc" placeholder="Product Description"  required></textarea>
          </div>
          
          <div class="col-sm-12 form-group col-sm-push-5"">
            <input class="form-control" id="image"  name="image" placeholder="Type in the image name" type="text" required>
          </div>
          
          <div class="col-sm-12 form-group col-sm-push-5"">
      
              <input class="form-control"  name="cost" placeholder="Price" type="text" value="">
          </div>
             
      
      <div class="row">
        <div class="col-sm-12 form-group col-sm-push-5">
         <font color="Red">${emailexists}</font>
          <font color="Green">${succ}</font>
        </div>
      </div>
      
      
      </div><br>
      <div class="row">
        <div class="col-sm-12 form-group col-sm-push-5">
          <button class="btn btn-default pull-right btn-success " value="register" name="register" type="submit" >submit</button>
        </form>
        </div>
      </div>
    </div>
  </div>
</div>
<br><br>

  
   </div>

</div>









<%@ include file="footer.jsp"%>

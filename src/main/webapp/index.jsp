<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>

<div class="jumbotron text-center">
  <h1>Click and collect service</h1> 
  <p>One click away!</p> 
 
      <form method="POST" action="/search">
    <div class="input-group add-on">
      <input type="text" class="form-control" name="value" size="50" placeholder="Enter your postcode to find local coner shops" required>

      <div class="input-group-btn">
        <button class="btn btn-success" type="submit"><i class="glyphicon glyphicon-search"></i>Find Store</button>
      
      </div>
    </div>
  </form>

   
</div>
<!-- Container (Contact Section) -->
<div class="container">
    <div class="row">
    
    <div class="row">
    		<h3><font color="Black"> ${nostorefound}</font></h3>
    </div>

<br><br>

  


<!-- Container (Contact Section) -->

            <c:forEach  items="${allStore}" var="s"> 
          <div class="col-md-3" style ="margin-bottom :10px">
                <div class="thumbnail">
                    <img src="imgs/store.jpg"alt="ALT NAME" class="img-thumbnail" />
                    <div class="caption">
                    <div class="col-sm-6">
                    <h4>${s.storename}</h4>
                    </div>
                    <div class="col-sm-6">
                        <p align="center"> <a href="/product/${s.ID}" class="btn btn-default btn-block">View Store</a>
                        </p>
                       </div>
                    </div>
                </div>
               </div>
                </c:forEach>
   

                 </div>

</div>



<%@ include file="footer.jsp"%>

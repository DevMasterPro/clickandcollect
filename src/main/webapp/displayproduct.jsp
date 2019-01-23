<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>


<!-- Container (Contact Section) -->
<div class="container">
    <div class="row">
  <div class="col-md-12" style="padding-top:100px">
		    <h1> Products For Store ${storename}</h1>
		<legend></legend>
		</div>

    
    <div class="row">
    		<h3><font color="Black"> ${noproductfound}</font></h3>
    </div>

<br><br>

<!-- Container (Contact Section) -->

            <c:forEach  items="${allproduct}" var="s"> 
          <div class="col-md-3" style ="margin-bottom :10px">
                <div class="thumbnail">
                    <img src="/imgs/product.jpg"alt="ALT NAME" class="img-thumbnail" />
                    <div class="caption">
                    <div class="col-sm-6">
                    <h5>${s.productname}</h5>
                    </div>
                    <div class="col-sm-6">
                        <p align="center"> <a href="/productdetails/${s.ID}" class="btn btn-default btn-block">View</a>
                        
                        </p>
                       </div>
                    </div>
                </div>
               </div>
                </c:forEach>
                 </div>

</div>



<%@ include file="footer.jsp"%>

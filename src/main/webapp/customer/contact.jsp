<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>



<div class="jumbotron text-center">
  <h1>Contact</h1> 
 
 </div>
<!-- Container (Contact Section) -->
<div id="contact" class="container-fluid bg-grey">

  <div class="row">
    <div class="col-sm-5">
      <p>Contact us and we'll get back to you within 24 hours.</p>
       <p><span class="glyphicon glyphicon-map-marker"></span> London, UK</p>
      <p><span class="glyphicon glyphicon-phone"></span> +02079653458</p>
      <p><span class="glyphicon glyphicon-envelope"></span> CandC@candc.com</p>
    </div>
    <div class="col-sm-7">
    <form method ="POST" action="/logcontact">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
      
      <div class="row">
      <font color="Green">${succ}</font>
      </div>
      <div class="row">
        <div class="col-sm-12 form-group">
          <button class="btn btn-default pull-right" type="submit">Send</button>
        </div>
        </div>
        </form>
      </div>
    </div>
  </div>
</div>





<%@ include file="footer.jsp"%>
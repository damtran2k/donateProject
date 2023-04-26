<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
  <link
    href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
    rel="stylesheet"
    type="text/css"
  />
  <link
    href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/css/datepicker.min.css"
    rel="stylesheet"
    type="text/css"
  />
  <link
    href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/1.8/css/bootstrap-switch.css"
    rel="stylesheet"
    type="text/css"
  />
  <link
    href="https://davidstutz.github.io/bootstrap-multiselect/css/bootstrap-multiselect.css"
    rel="stylesheet"
    type="text/css"
  />
  <script
    src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"
    type="text/javascript"
  ></script>
  <script
    src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.0/js/bootstrap.min.js"
    type="text/javascript"
  ></script>
  <script
    src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/js/bootstrap-datepicker.min.js"
    type="text/javascript"
  ></script>
  <script
    src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/1.8/js/bootstrap-switch.min.js"
    type="text/javascript"
  ></script>
  <script
    src="https://davidstutz.github.io/bootstrap-multiselect/js/bootstrap-multiselect.js"
    type="text/javascript"
  ></script>
   <script src="${pageContext.request.contextPath}/assets/manageCategory/confirmCancel.js"></script>
   
</head>
<body>

	  <%@ include file="adminHeader.jsp" %>
  <div class="container">
    <div class="panel panel-primary dialog-panel">
      
        <h3>Donate</h3>
      
      <div class="panel-body">
        <form class="form-horizontal" action="addCategory" role="form" method="post">    
     
          <div class="form-group">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
              >Fund Name</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    name="fundName"
                    placeholder="Fund Name"
                    type="text"
                    value=""
                    readonly="readonly"
                  />
                </div>
              </div>
          </div>
          </div>
           <div class="form-group">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
              >Money</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    name="money"
                    placeholder="Donate Money"
                    type="text"
                  />
                </div>
              </div>
          </div>
          </div>
          <div class="form-group">
            <label
              class="control-label col-md-2 col-md-offset-2"
              for="id_comments"
              >Message</label
            >
            <div class="col-md-6">
              <textarea
                class="form-control"
                id="id_comments"
                name="description"
                placeholder="Additional comments"
                rows="3"
                
              >Together we can make a difference!</textarea>
            </div>
          </div>  
          <div class="form-group">         
        	<p style="color: red; text-align: center;">${error}</p>
            <div class="col-md-offset-4 col-md-3">
              <button class="btn-lg btn-primary" type="submit">
                Donate
              </button>
              </form>
            <button class="btn-lg btn-primary" type="button" onclick="confirmCancel()" style="margin-left: 10px;">Cancel</button>        
          </div>
      </div>
    </div>
  </div>
 
	<script src="/Donation/src/main/webapp/assets/manage/confirmCancel.js"></script>
	<script src="assets/js/main.js"></script>
</body>
    
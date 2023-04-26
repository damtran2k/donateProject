<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
  
  <link rel="stylesheet" href="style_regis.css" />
</head>
<body>
	<c:choose>
	    <c:when test="${sessionScope.user.role == 'Admin' }">
	        <%@ include file="adminHeader.jsp" %>
	    </c:when>
	    <c:otherwise>
	        <script>
	            alert("Your account Can't access this page");
	
	            setTimeout(function() {
	                window.location.href = "index.jsp";
	            }); 
	        </script>
	    </c:otherwise>
	</c:choose>	
  <div class="container">
    <div class="panel panel-primary dialog-panel">
      <div class="panel-heading">
        <h5>Add Fund</h5>
      </div>
      <div class="panel-body">
        <form class="form-horizontal" role="form" action="addFund" method="post">

          <div class="form-group">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
              >Name</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    name="name"
                    placeholder="Name"
                    type="text" value=""
                  />
                </div>
              </div>
          </div>
          <div class="form-group">
            <label
              class="control-label col-md-2 col-md-offset-2"
              for="id_accomodation" 
              >Category</label
            >
            <div class="col-md-2">
              <select class="form-control" id="id_accomodation" name="category">
             	<c:forEach items="${listC }" var="c">
             			<option>${c.name }</option>
             	</c:forEach>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label
              class="control-label col-md-2 col-md-offset-2"
              for="id_accomodation"
              >Foundation</label
            >
            <div class="col-md-2">
              <select class="form-control" id="id_accomodation" name="foundation">
              <c:forEach items="${listF }" var="f">
              		<option>${f.name }</option>
              </c:forEach>

              </select>
            </div>
          </div>
          <div class="form-group">
            <label
              class="control-label col-md-2 col-md-offset-2"
              for="id_comments"
              >Description</label
            >
            <div class="col-md-6">
              <textarea
                class="form-control"
                id="id_comments"
                placeholder="Additional comments"
                rows="3" name="description"
              ></textarea>
            </div>
          </div>
          <div class="form-group">
            <label
              class="control-label col-md-2 col-md-offset-2"
              for="id_comments"
              >Content</label
            >
            <div class="col-md-6">
              <textarea
                class="form-control"
                id="id_comments"
                placeholder="Additional comments"
                rows="3" name="content"
              ></textarea>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
              >Image Url</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    placeholder="Link Image"
                    type="text" name="imgURL"
                  />
                </div>
              </div>
              <div class="form-group internal"></div>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
              >Expect donate Money</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    placeholder="Expect donate Money"
                    type="text" name="expectMoney"
                  />
                </div>
              </div>
              <div class="form-group internal"></div>
            </div>
          </div>
          
          <div class="form-group">
            <label
              class="control-label col-md-2 col-md-offset-2"
              for="id_checkin"
              >Created Date</label
            >
            <div class="col-md-8">
              <div class="col-md-3">
                <div class="form-group internal input-group">
                  <input class="form-control datepicker" id="id_checkin"  name="createdDate"/>
                  <span class="input-group-addon">
                    <i class="glyphicon glyphicon-calendar"></i>
                  </span>
                </div>
              </div>
              <label class="control-label col-md-2" for="id_checkout"
                >End Date</label
              >
              <div class="col-md-3">
                <div class="form-group internal input-group">
                  <input class="form-control datepicker" id="id_checkout" name="endDate" />
                  <span class="input-group-addon">
                    <i class="glyphicon glyphicon-calendar"></i>
                  </span>
                </div>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label
              class="control-label col-md-2 col-md-offset-2"
              for="id_accomodation"
              >Status</label
            >
            <div class="col-md-2">
              <select class="form-control" id="id_accomodation" name="status">
                <option>Active</option>
                <option>Nonactive</option>
              </select>
            </div>
          </div>
          <div class="form-group">
          <p style="color: red; text-align: center;">${error}</p>
            <div class="col-md-offset-4 col-md-3">
              <button class="btn-lg btn-primary" type="submit">
                Register
              </button>
            </div>
            
          </div>
        </form>
      </div>
    </div>
  </div>
  <script src="assets/js/main.js"></script>
</body>
    
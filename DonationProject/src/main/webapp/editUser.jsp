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
        <form class="form-horizontal" role="form" action="/DonationProject/editUser?id=${user.id }" method="post">

          <div class="form-group">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
              >UserName</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    name="username"
                    placeholder="Username"
                    type="text" value="${user.username }"
                    readonly="readonly"
                  />
                </div>
              </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
              >Email</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    name="email"
                    placeholder="Email"
                    type="text" value="${user.email}"
                    readonly="readonly"
                  />
                </div>
              </div>
          </div>
          <div class="form-group">
            <label
              class="control-label col-md-2 col-md-offset-2"
              for="id_accomodation" 
              >Role</label
            >
            <div class="col-md-2">
              <select class="form-control" id="id_accomodation" name="role">
             	
             			<option value="User" ${user.role == 'User' ? 'selected' : ''}>User</option>
             			<option value="Admin" ${user.role == 'Admin' ? 'selected' : ''}>Admin</option>
             	
              </select>
            </div>
          </div>     
          <div class="form-group">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
              >FullName</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    name="fullname"
                    placeholder="FullName"
                    type="text" value="${user.name }"
                  />
                </div>
              </div>
          </div>
			 <div class="form-group">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
              >Phone</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    name="phone"
                    placeholder="Phone"
                    type="text" value="${user.phone }"
                  />
                </div>
              </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
              >Address</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    placeholder="Address"
                    type="text" name="address"
                    value="${user.address }"
                  />
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
                <option value="Active" ${user.status == 'Active' ? 'selected' : ''}>Active</option>
								<option value="NonActive"
									${user.status =='NonActive' ? 'selected' : '' }>NonActive</option>
              </select>
            </div>
          </div>
          <div class="form-group">
          <p style="color: red; text-align: center;">${error}</p>
            <div class="col-md-offset-4 col-md-3">
              <button class="btn-lg btn-primary" type="submit">
                Update
              </button>
              </form>
              <button class="btn-lg btn-primary" type="button" onclick="confirmCancel()" style="margin-left: 10px;">Cancel</button>
            </div>
            
          </div>
        
        
      </div>
    </div>
  </div>
  <script src="${pageContext.request.contextPath}/assets/manageUser/confirmCancel.js"></script>
</body>
    
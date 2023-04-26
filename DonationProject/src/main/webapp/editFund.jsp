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
   <script
		src="/Donation/src/main/webapp/assets/manageFund/confirmCancel.js"></script>
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
        <h5>Edit Fund</h5>
      </div>
      <div class="panel-body">
        <form class="form-horizontal" role="form"
         action="/DonationProject/editFund?id=${fund.id }" method="post">
            <label class="control-label col-md-2 col-md-offset-2" for="id_email"
                >ID</label
            >
            <div class="col-md-6">
              <div class="form-group">
                <div class="col-md-11">
                  <input
                    class="form-control"
                    id="id_email"
                    placeholder="ID" name="id"
                    type="text" value="${fund.id }" readonly="readonly"
                  />
                </div>
              </div>
          </div>
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
                    placeholder="Name" name="name"
                    type="text" value="${fund.name }"
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
              <select class="form-control" id="id_accomodation" name="category" >
                <c:forEach items="${listC }" var="c">          		
             			<option >${c.name }</option>
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
              >${fund.description }</textarea>
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
              >${fund.content }</textarea>
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
                    placeholder="Link Image" name="img_url"
                    type="text" value="${fund.img_url }"
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
                    placeholder="Expect donate Money" name="expectMoney"
                    type="text" value="${fund.expectDonateMoney }"
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
                  <input class="form-control datepicker" name="createdDate"
                  id="id_checkin"  value="${fund.createdDate }"/>
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
                  <input class="form-control datepicker" name="endDate"
                  id="id_checkout"  value="${fund.endDate }"/>
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
                <option value="Active" ${fund.status == 'Active' ? 'selected' : ''}>Active</option>
								<option value="NonActive"
									${fund.status =='NonActive' ? 'selected' : '' }>NonActive</option>
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
  <script src="${pageContext.request.contextPath}/assets/manageFund/confirmCancel.js"></script>
</body>
    
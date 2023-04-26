<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<link
		href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
		rel="stylesheet" type="text/css" />
	<link
		href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/css/datepicker.min.css"
		rel="stylesheet" type="text/css" />
	<link
		href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/1.8/css/bootstrap-switch.css"
		rel="stylesheet" type="text/css" />
	<link
		href="https://davidstutz.github.io/bootstrap-multiselect/css/bootstrap-multiselect.css"
		rel="stylesheet" type="text/css" />
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/js/bootstrap-datepicker.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/1.8/js/bootstrap-switch.min.js"
		type="text/javascript"></script>
	<script
		src="https://davidstutz.github.io/bootstrap-multiselect/js/bootstrap-multiselect.js"
		type="text/javascript"></script>
	<script
		src="/Donation/src/main/webapp/assets/manageFoundation/confirmCancel.js"></script>
		
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

			<h3>Edit Foundation</h3>

			<div class="panel-body">
				<form class="form-horizontal"
					action="editFoundation?id=${f.id }" role="form"
					method="post">
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2"
							for="id_email">ID</label>
						<div class="col-md-6">
							<div class="form-group">
								<div class="col-md-11">
									<input class="form-control" id="id_email" name="id"
										placeholder="ID" type="text" value="${f.id }"
										readonly="readonly" />
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2"
							for="id_email">Name</label>
						<div class="col-md-6">
							<div class="form-group">
								<div class="col-md-11">
									<input class="form-control" id="id_email" name="name"
										value="${f.name }" placeholder="Name" type="text" />
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2"
							for="id_email">Email</label>
						<div class="col-md-6">
							<div class="form-group">
								<div class="col-md-11">
									<input class="form-control" id="id_email" name="email"
										value="${f.email }" placeholder="Email" type="text" />
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2"
							for="id_comments">Description</label>
						<div class="col-md-6">
							<textarea class="form-control" id="id_comments"
								name="description" placeholder="Additional comments" rows="3">${f.description }</textarea>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2 col-md-offset-2"
							for="id_accomodation">Status</label>
						<div class="col-md-2">
							<select class="form-control" id="id_accomodation" name="status">
								<option value="Active" ${f.status == 'Active' ? 'selected' : ''}>Active</option>
								<option value="NonActive"
									${f.status =='NonActive' ? 'selected' : '' }>NonActive</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<p style="color: red; text-align: center;">${error}</p>
						<div class="col-md-offset-4 col-md-3">
							<button class="btn-lg btn-primary" type="submit">Update
							</button>
				</form>

				<button class="btn-lg btn-primary" type="button"
					onclick="confirmCancel1()" style="margin-left: 10px;">Cancel</button>

			</div>



		</div>
	</div>
	<script type="text/javascript">
		function confirmCancel1() {

			if (confirm("Are you sure you want to cancel?")) {
				redirectToManageFoundation();
			}
		}

		function redirectToManageFoundation() {
			window.location.href = "listFoundationController";
		}
		</script>
	<script
		src="/Donation/src/main/webapp/assets/manageFoundation/confirmCancel.js"></script>
		<script src="assets/js/main.js"></script>
</body>

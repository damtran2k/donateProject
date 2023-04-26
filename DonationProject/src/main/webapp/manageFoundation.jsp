<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
    />
    <!-- Bootsrap -->
     <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="assets/manage/style.css">
    <script src="assets/manageFoundation/delete.js"></script>
    <script src="assets/manageFoundation/selectedDelete.js"></script>
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
    <div class="container-xl">
    <div  style="display: flex; justify-content: center; align-items: center;">
    	<form action="searchF" method="get" style="margin-top: 20px;">
		<input  type="text" id="search" name="search" value="${txtSearch }">
		<button type="submit">Search</button>
	</form>
	
	</div>
		${message }
      <div class="table-responsive">
        <div class="table-wrapper">
          <div class="table-title">
            <div class="row">
              <div class="col-sm-6">
                <h2>Manage <b>Foundation</b></h2>
              </div>
				
              <div class="col-sm-6">
              
                
                
               	 <a class="btn btn-danger" href="#"
               	  onclick="deleteSelectedItems()">
                  	<i class="material-icons">&#xE15C;</i> <span>Delete</span>
                </a>
                
                
                <a
                  href="addFoundation.jsp"
                
                  class="btn btn-success"
                  ><i class="material-icons">&#xE147;</i>
                  <span>Add item</span></a
                >
               
              </div>
            </div>
          </div>
          <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th>
                  <span class="custom-checkbox">
                    <input type="checkbox" id="selectAll" />
                    <label for="selectAll"></label>
                  </span>
                </th>
                <th>ID</th>
                <th class="col-md-2">Name</th>
                <th class="col-md-2">Email</th>
                <th class="col-md-5">Description</th>
                <th>Status</th>
                <th>Actions</th>
              </tr>
            </thead>
          		  <form id="deleteItemsForm" action="deleteManyF" method="post">
            	<tbody>
            	  <c:forEach items="${list }" var="f">
              <tr>
                <td>
              
                  <span class="custom-checkbox">
                 		<input
                      type="checkbox"
                      id="itemIds"
                      name="options1"
                      value="${f.id }"
                    />                               
                    <label for="checkbox1"></label>
                  </span>
                  	
                </td>
                <td>${f.id }</td>
                <td>${f.name }</td>
                <td>${f.email }</td>
                <td>${f.description }</td>
                <td>${f.status }</td>

                <td>
                  <a href="editFoundation?id=${f.id}" class="edit" 
                    ><i
                      class="material-icons"
                      title="Edit"
                      >&#xE254;</i
                    ></a
                  >
                 <a
                    href="#"
                    class="delete"
                    onclick="confirmDeleteF(${f.id })"
                    ><i
                      class="material-icons"
                      data-toggle="tooltip"
                      title="Delete"
                      >&#xE872;</i
                    ></a>
                </td>
              </tr>
              </c:forEach>
            </tbody>
              </form>
          </table>
          <div class="clearfix">
            <div class="hint-text">
              Showing <b>${amount }</b> out of <b>${count }</b> entries
            </div>
            <ul class="pagination">
            <c:forEach begin="1" end="${endPage }" var="i">
            	<li class="page-item"><a href="/DonationProject/listFoundationController?index=${i }" class="page-link">${i }</a></li>
            </c:forEach>
             
            </ul>
          </div>
        </div>
      </div>
    </div>
    <script src="assets/manage/script.js"></script>
    <script src="assets/js/main.js"></script>
    
  </body>
</html>

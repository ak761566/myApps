<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Project</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
.container {
	width: 100%;
	height: 800px;
	margin: 0;
	padding: 0;
}

.navbar {
	width: 100%;
	height: 5%;
	border-radius: 0;
}

.left-col {
	width: 49%;
	height: 90%;
	float: left;
	border: 1px solid;
	background-color: #f1f1f1;
}

.right-col {
	width: 2%;
	height: 90%;
	float: left;
	border: 1px solid;
	overflow: auto;
	background-color: #f1f1f1;
}

.center-col {
	width: 49%;
	height: 90%;
	float: left;
	border: 1px solid;
}

.footer {
	max-width: 100%;
	height: 5%;
}
form{
	width: 40%;
	align: center;
}

.form-div{
	width: 100%
	padding: 10%;
	margin:20px 0px 100px 200px;
}
.users-div{
	width: 100%
	padding: 10%;
	margin:20px 0px 100px 50px;
	float:auto;

}
</style>

</head>
<body>
        <div class="container">
            <div class="navbar  navbar-inverse">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">Logo</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Projects</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/ithakaProjectManagementApp/admin/dashboard"><span class="glyphicon glyphicon-log-in"></span>DashBoard</a></li>
                        <li><a href="/ithakaProjectManagementApp/logout">Logout</a></li>
                    </ul>
                </div>
            </div>
             <div class="left-col">
                    <c:choose>
                    	<c:when test="${empty inventorylist}">
                    		<h3>No Streams in the database !</h3>
                    	</c:when>
                    	<c:otherwise>
                    		
                    			<div class="">
                    				<table class="table tanle-reponsive">
                    					<tr>
                    						<th>Setup Number</th>
                    						<th>Stream Name</th>
                    						<th>Complexity</th>
                    						<th>Stream Type</th>
                    						<th>Batch Count</th>
                    						<th>Kick Off Date</th>
                    						<th>Due Date</th>
                    						<th>Delivery Status</th>
                    					</tr>
                    					<c:forEach items="${inventorylist}" var="inventory">
                    						<tr>
                    							<td>${inventory.setupNo}</td>
                    							<td>${inventory.streamName}</td>
                    							<td>${inventory.Complexity}</td>
                    							<td>${inventory.streamType}</td>
                    							<td>${inventory.batchCount}</td>
                    							<td>${inventory.kickOffDate}</td>
                    							<td>${inventory.dueDate}</td>
                    							<td>${inventory.streamStatus}</td>
                    						</tr>			
                    					</c:forEach>
                    				</table>
                    			
                    			</div>
                    		
                    	</c:otherwise>
                    </c:choose>
                    
              </div>     
              <div class="center-col">
                  <div class="form-div">
              	<form name='newUserform' action="/ithakaProjectManagementApp/admin/project/save" method="POST">
					<div class="container" id="frm">
						<div class="form-group">
        					<label for="setupNo">Setup Number</label>
        					<input type="text" class="form-control" placeholder="Setup Number"
        						 id="setupNo" name="setupNo"
        						  title="Required Pattern SETUP-XXXX"  required/>
        						  
        						<label for="streamName">Stream Name</label>
        						<input type="text" class="form-control" placeholder="Stream Name"
        							 id="streamName" name="streamName"
        						  	title="Stream Name"  required/>
        						
        						<label for="streamType">Stream Type</label>
        						<br/>
        						<select name="streamType" required="required">
									<option value="new">New Setup</option>
									<option value="maintenace">Maintenace</option>
								</select>
        						  	
        						<label for="complexity">Complexity</label>
        						<br/>
        						<select name="Complexity" required="required">
									<option value="easy">Easy</option>
									<option value="medium">Medium</option>
									<option value="complex">Complex</option>		        						
        						</select>
        						<label for="batchCount">Batch Count</label>
        						<input type="text" class="form-control" placeholder="Number Of Batches"
        							 id="batchCount" name="batchCount"
        						  	title="only digits"  required/>
        						  	
        						<label for="kickOffDate">Kick Off Date</label>
        						<input type="text" class="form-control" placeholder="DD-MM-YYYY"
        							 id="kickOffDate" name="kickOffDate"
        						  	title="date should be in the format of DD-MM-YYYY"  required/>
        						  	
        						 <label for="dueDate">Due Date</label>
        						<input type="text" class="form-control" placeholder="DD-MM-YYYY"
        							 id="dueDate" name="dueDate"
        						  	title="date should be in the format of DD-MM-YYYY"  required/>
    					</div>
    					
    					<button type="submit" class="btn btn-primary">Add Stream</button>
    					<button type="reset" class="btn btn-primary">Reset</button>						
					</div>
				</form>
				</div>
                  
              </div>
              <div class="right-col ">
             </div>
            <div class="footer">
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
    </body>
</html>
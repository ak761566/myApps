<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new Stream</title>
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
	width: 20%;
	height: 90%;
	float: left;
	border: 1px solid;
	background-color: #f1f1f1;
}

.right-col {
	width: 20%;
	height: 90%;
	float: left;
	border: 1px solid;
	overflow: auto;
	background-color: #f1f1f1;
}

.center-col {
	width: 60%;
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
                        <li><a href="/ithakaProjectManagementApp/admin/dashboard"><span class="glyphicon glyphicon-log-in"></span>Dashboard</a></li>
                        <li><li><a href="/ithakaProjectManagementApp/logout"><span class="glyphicon glyphicon-log-in"></span>LogOut</a></li>
                    </ul>
                </div>
            </div>
             <div class="left-col">
              </div>     
              <div class="center-col">
              <div class="form-div">
              	<form name='newUserform' action="" method='POST'>
					<div class="container" id="frm">
						<div class="form-group">
        					<label for="inputsetupNo">Setup No</label>
        					<input type="text" class="form-control" placeholder="Enter Setup No"
        						 id="inputsetupNo" name="setupNo" pattern="SETUP\-[0-9]{3,}" 
        						 title="Enter valid SETUP NO Please"  required/>
    					</div>
    					<div class="form-group">
        					<label for="inputSreamName">Stream Name</label>
        					<input type="text" class="form-control" placeholder="Enter Stream Name" id="inputSreamName" pattern="[A-Za-z]{3,}" name="streamName" 
        					 required/>
    					</div>
    					<div class="form-group">
        					<label for="inputstreamType">Stream Type</label>
        					<select name="streamType" required>
        						<option value="New">New</option>
        						<option value="Maintenance">Maintenance</option>
        					</select>
    					</div>
    					<div class="form-group">
        					<label for="inputComplexity">Complexity</label>
        					<select name="Complexity" required>
        						<option value="easy">Easy</option>
        						<option value="medium">Medium</option>
        						<option value="complex">Complex</option>
        					</select>
    					</div>
    					<div class="form-group">
        					<label for="inputBatchCount">Batch Count</label>
        					<input type="password" class="form-control" placeholder="Enter Batch Count" id="inputBatchCount" pattern="[0-9]+" name="batchCount"  required/>
    					</div>
    				
    					<div class="form-group">
        					<label for="inputkickOffDate">Kick Off Date</label>
        					<input type="text" class="form-control" placeholder="Enter Date in DD-MM-YYYY" id="inputkickOffDate" pattern="[0-9]{1,2}\-[0-9]{1,2}\-[0-9]{4}" 
        					title="Date should be in DD-MM-YYYY" name="kickOffDate"  required/>
    					</div>
    					<div class="form-group">
        					<label for="inputdueDate">Due Date</label>
        					<input type="text" class="form-control" placeholder="Enter Due Date" id="inputdueDate" name="dueDate"  
        					pattern="[0-9]{1,2}\-[0-9]{1,2}\-[0-9]{4}" title="Date should be in DD-MM-YYYY"  required/>
    					</div>
    					<div class="form-group">
        					<label for="inputdeliveryDate">Delivery Date</label>
        					<input type="text" class="form-control" placeholder="Enter Deliver Date" id="inputdeliveryDate" name="deliveryDate"  
        					pattern="[0-9]{1,2}\-[0-9]{1,2}\-[0-9]{4}" title="Date should be in DD-MM-YYYY"/>
    					</div>
    					<div class="form-group">
        					<label for="inputstreamStatus">Stream Status</label>
        					<input type="text" class="form-control" placeholder="Enter Stream Status" id="inputstreamStatus" pattern="[A-Za-z]{3,}" name="streamStatus"/>
    					</div>
    					<div class="form-group">
        					<label for="inputiterations">Iteration Count</label>
        					<input type="text" class="form-control" placeholder="Iteration Count" id="inputstreamStatus" pattern="[0-9]+" name="iterations"/>
    					</div>
    					<button type="submit" class="btn btn-primary">Register</button>
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
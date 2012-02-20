<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../js/jsrender.js"></script>
<link rel="stylesheet" type="text/css" href="../style/main.css" media="screen" />

<script id="stopDetailsTemplate" type="text/html">
        <tr>
            <td>{{=id}}</td> 
            <td><b>{{=name}}</b></td> 
            <td><i>{{=description}}</i> </td>
			<td><i>{{=latitude}}</i> </td>
			<td><i>{{=lontitude}}</i> </td>
        </tr>
</script>
</head>
<body>

<div id="stylized" class="myform">
<form id="addStopForm" name="form">
<h1>Add a Stop form</h1>
<p>Information for a Stop</p>

    <fieldset>
        <legend>Add a Stop </legend>
        <div>
            <label for="name">Stop Name</label>
            <input type="text" id="stopName" name="stopName">
        </div>
        <div>
            <label for="stopId">Stop Id</label>
            <input type="text" id="stopId" name="stopId">
        </div>
        <div>
            <label for="stopDesc">Stop Description</label>
            <input type="text" id="stopDesc" name="stopDesc">
        </div>
        <div>
            <label for="stopLatitude">Latitude</label>
            <input type="text" id="stopLatitude" name="stopLatitude">
        </div>
        <div>
            <label for="stopLongitude">Longitude</label>
            <input type="text" id="stopLongitude" name="stopLongitude">
        </div>
    </fieldset>
    <input id="addStopDetails" name="addStopDetails" type="button" value="Add Stop"/>
    <div class="spacer"></div>
</form>
</div>
<div name="stopDetailsList">
	<table id="stopDetailsTbl">
		<tr>
			<th>Stop Id</th>
			<th>Stop Name</th>
			<th>Stop Desc</th>
			<th>Stop Latitude</th>
			<th>Stop Longitude</th>
		</tr>
	</table>
	<div id="noStopDetails">
		No data available for Stops
	</div>
</div>

<script>
function renderTable() {
	$("#stopDetailsTbl").hide();
	$("#noStopDetails").hide();
	$.ajax({
	    type: "GET",
	    url: "getStopDetails.do",
	    success: function(stopDetails) {
	    	if (stopDetails && stopDetails.length > 0) {
	    		$("#stopDetailsTbl").show();
	    		$("#stopDetailsTbl").append($("#stopDetailsTemplate").render(stopDetails));	
	    	} else {
	    		$("#noStopDetails").show();
	    	}	    	
	    }
	  });
}

function test() {
	
	$.ajax({
	    type: "POST",
	    url: "create.do",
	    contentType: 'application/json', 	
	    data: JSON.stringify({
	    		    'name': $("input#stopName").val(),
		    		'id' : $("input#stopId").val(),
		    		'description' : $("input#stopDesc").val(),
		    		'details': "dsdadada",
		    		'latitude' : $("input#stopLatitude").val(),
		    		'lontitude' : $("input#stopLongitude").val()  
	    		}),
	    success: function(stopDetails) {
	    	$("#stopDetailsTbl").append($("#stopDetailsTemplate").render(stopDetails));
	    }
	  });
	
}
$(document).ready(function(){
	renderTable();
	$('#addStopDetails').click(test);		
});
  

</script>
</body>
</html>
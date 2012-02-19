<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../js/jsrender.js"></script>

<script id="GolferTemplate1" type="text/html">
        {{=ID}}: <b>{{=Name}}</b> <i>{{=Birthday}}</i> <br />
</script>

<script id="GolferTemplate2" type="text/html">
        <tr>
            <td>{{=ID}}</td> 
            <td><b>{{=Name}}</b></td> 
            <td><i>{{=Birthday}}</i> </td>
        </tr>
</script>
</head>
<body>
Hello, <%= request.getAttribute("name") %>!

<form>
    <fieldset>
        <legend>Stop Management</legend>
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
</form>
<div name="stopDetailsList">
	<table>
		<tr>
			<th>Stop Name</th>
			<th>Stop Desc</th>
			<th>Stop Latitude</th>
			<th>Stop Longitude</th>
		</tr>
		<tr>
			<td>Stop A</td>
			<td>Stop Desc</td>
			<td>23 56 99</td>
			<td>89 77 09</td>
		</tr>
	</table>
</div>

<div id="GolferDiv"></div><br />
<table id="GolferTable"></table>
    
<script>

function renderTable() {
	
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
	    success: function() {
	      $('#contact_form').html("<div id='message'></div>");
	      $('#message').html("<h2>Contact Form Submitted!</h2>")
	      .append("<p>We will be in touch soon.</p>")
	      .hide()
	      .fadeIn(1500, function() {
	        $('#message').append("<img id='checkmark' src='images/check.png' />");
	      });
	    }
	  });
	
	
	var Golfers = [
	               { ID: "1", "Name": "Bobby Jones", "Birthday": "1902-03-17" },
	               { ID: "2", "Name": "Sam Snead", "Birthday": "1912-05-27" },
	               { ID: "3", "Name": "Tiger Woods", "Birthday": "1975-12-30" }
	               ];
	
	$("#GolferDiv").html($("#GolferTemplate1").render(Golfers));
    $("#GolferTable").html($("#GolferTemplate2").render(Golfers))
	
}
$(document).ready(function(){
	$('#addStopDetails').click(test);		
});
  

</script>
</body>
</html>
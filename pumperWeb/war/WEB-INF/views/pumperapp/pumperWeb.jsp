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
            <td>{{=stopId}}</td> 
            <td><b>{{=name}}</b></td> 
            <td><i>{{=desc}}</i> </td>
			<td><i>{{=latitude}}</i> </td>
			<td><i>{{=longitude}}</i> </td>
			<td><a id="configureStop" class="gradientbuttons button">Configure</a></td>
        </tr>
</script>
</head>
<body>

<div id="loadingDiv">
<h1>Loading....</h1>
</div>

<div name="stopDetailsList" >
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
	<div class="gradientbuttons"><a id="addAStop" class="gradientbuttons button">Add a Stop</a>
	</div>
</div>


<div id="addStopDetailsDiv" class="stylized">
	<form id="addStopForm" name="form">
	<h1>Add a Stop</h1>
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
	            <label for="stopLatitude">Latitude<span class="small">34 56' 89"</span></label>
	            <input type="text" id="stopLatitude" name="stopLatitude">
	        </div>
	        <div>
	            <label for="stopLongitude">Longitude<span class="small">34 56' 89"</span></label>
	            <input type="text" id="stopLongitude" name="stopLongitude">
	        </div>
	    </fieldset>
	    <input id="addStopDetails" name="addStopDetails" type="button" value="Create"/>
	    <div class="spacer"></div>
	</form>
</div>


<div id="addTank" class="stylized">
	<form id="addTankForm" name="form">
	<h1>Add a tank to a stop</h1>
	<p>Tank Info</p>
	
	    <fieldset>
	        <legend>Add a tank </legend>
	        <div>
	            <label for="name">Tank Name</label>
	            <input type="text" id="tankName" name="tankName">
	        </div>
	        <div>
	            <label for="equipmentId">Equipment Id</label>
	            <input type="text" id="equipmentId" name="equipmentId">
	        </div>
	        <div>
	            <label for="equipmentDesc">Equipment Description</label>
	            <input type="text" id="equipmentDesc" name="equipmentDesc">
	        </div>
	        <div>
	            <label for="topStart">top<span class="small">34 56' 89"</span></label>
	            <input type="text" id="topStart" name="topStart">
	        </div>
	        <div>
	            <label for="bottomStart">top<span class="small">34 56' 89"</span></label>
	            <input type="text" id="bottomStart" name="bottomStart">
	        </div>
	        <div>
	            <label for="bbDesc">top<span class="small">34 56' 89"</span></label>
	            <input type="text" id="bbDescStart" name="bbDescStart">
	        </div>
	        <div>
	            <label for="useCalc">top<span class="small">34 56' 89"</span></label>
	            <input type="text" id="useCalcStart" name="useCalcStart">
	        </div>
	        <div>
	            <label for="stopLongitude">Longitude<span class="small">34 56' 89"</span></label>
	            <input type="text" id="stopLongitude" name="stopLongitude">
	        </div>
	    </fieldset>
	    <input id="addStopDetails" name="addStopDetails" type="button" value="Create"/>
	    <div class="spacer"></div>
	</form>
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



function fetchStops() {
	
	$.ajax({
	    type: "POST",
	    url: "create.do",
	    contentType: 'application/json', 	
	    data: JSON.stringify({
	    		    'name': $("input#stopName").val(),
		    		'stopId' : $("input#stopId").val(),
		    		'desc' : $("input#stopDesc").val(),
		    		'details': "dsdadada",
		    		'latitude' : $("input#stopLatitude").val(),
		    		'longitude' : $("input#stopLongitude").val()  
	    		}),
	    success: function(stopDetails) {
	    	$("#stopDetailsTbl").append($("#stopDetailsTemplate").render(stopDetails));
	    }
	  });
	
}
$(document).ready(function(){
	renderTable();
	$('#addStopDetails').click(fetchStops);
	
	$('#loadingDiv')
	.hide()  // hide it initially
	.ajaxStart(function() {
	    $(this).show();
	})
	.ajaxStop(function() {
	    $(this).hide();
	});
	
	$('#addStopDetailsDiv').hide();
	
	
	$('#addAStop').click(function() {
	  $('#addStopDetailsDiv').slideToggle('slow', function() {
	    console.log("animation complete");
	  });
	});
	
});
  

</script>
</body>
</html>
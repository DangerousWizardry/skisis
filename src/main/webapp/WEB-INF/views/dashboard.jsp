<%-- 
    Document   : dashboard
    Created on : 6 mars 2020, 12:52:31
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Tableau de Bord administration</title>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="../assets/style.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous|Raleway|Roboto+Condensed&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body class="admin">
<nav class="admin"><div class="logo"><img src="../assets/ski.png">SKISIS</div><div><a href="">Home</a></div><div><a href="${pageContext.request.contextPath}/app/categorieEditor">Edition Catégorie</a></div><div><a href="${pageContext.request.contextPath}/app/produitEditor">Edition Produit</a></div></nav>
<div class="admin-grid">
	<div class="set-option">
		<div class="date-range-tool">
			<p>Choisissez votre champ d'analyse</p>
			<div class="date-picker-group"><input type="date" id="from" name="from"><input type="date" id="to" name="to"></div>
			<div id="slider-range"></div>
		</div>
	</div>
	<div id="bar-chart-ca-customer">
		
	</div>
	<div id="bar-chart-ca">
		
	</div>
	<div id="bar-chart-ca-country">
		
	</div>
</div>

<script>
	$( "#slider-range" ).slider({
      range: true,
      min: ${firstAndLastOrderDate[0]},
      max: ${firstAndLastOrderDate[1]},
      values: [ ${firstAndLastOrderDate[0]}, ${firstAndLastOrderDate[1]} ],
	  create: function( event, ui ) {
		  let from = new Date(${firstAndLastOrderDate[0]});
		  let to = new Date(${firstAndLastOrderDate[1]});
		  $("#from").val(from.getFullYear()  + "-" + ("0"+(from.getMonth()+1)).slice(-2) + "-" + ("0" + from.getDate()).slice(-2));
		  $("#to").val(to.getFullYear()  + "-" + ("0"+(from.getMonth()+1)).slice(-2) + "-" + ("0" + to.getDate()).slice(-2));
	  },
      slide: function( event, ui ) {
		  from = new Date(ui.values[0]);
		  to = new Date(ui.values[1]);
		  $("#from").val(from.getFullYear()  + "-" + ("0"+(from.getMonth()+1)).slice(-2) + "-" + ("0" + from.getDate()).slice(-2));
		  $("#to").val(to.getFullYear()  + "-" + ("0"+(from.getMonth()+1)).slice(-2) + "-" + ("0" + to.getDate()).slice(-2));
      },
	  stop: function( event, ui ) {
		  drawGraph(ui.values[0],ui.values[1]);
	  }
    });
	$("#from").change(manualDateChangeHandler);
	$("#to").change(manualDateChangeHandler);
	google.charts.load('current', {packages: ['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawGraph);
function manualDateChangeHandler(){
	let from = new Date($("#from").val());
	let to = new Date($("#to").val());
	$( "#slider-range" ).slider('values',0,from.getTime());
	$( "#slider-range" ).slider('values',1,to.getTime());
}
async function drawGraph(from=null,to=null) {
	var data = await fetch("${pageContext.request.contextPath}/app/caparcategorie?"+(from==null?"":"from="+from+"&")+(to==null?"":"to="+to)).then(data => {
		return data.json();
	}).then(json => {
		json.unshift(['Catégorie', "Chiffre d'affaire",]);
		console.log(json);
		return google.visualization.arrayToDataTable(json);
	});
    var options = {
        title: "Chiffre d'affaire par catégorie",
		animation:{
			duration : 500,
			startup:1
		},
        chartArea: {width: '70%'},
        vAxis: {
          title: 'C.A.',
          minValue: 0,
		  format: 'currency',
        },
        hAxis: {
          title: 'Catégories',
		  slantedTextAngle:90,
		  showTextEvery:1
        },
		bars: 'vertical'
      };
      var chart1 = new google.visualization.ColumnChart(document.getElementById('bar-chart-ca'));
      chart1.draw(data, options);
	  data = await fetch("${pageContext.request.contextPath}/app/caparpays?"+(from==null?"":"from="+from+"&")+(to==null?"":"to="+to)).then(data => {
		return data.json();
	}).then(json => {
		json.unshift(['Pays', "Chiffre d'affaire",]);
		console.log(json);
		return google.visualization.arrayToDataTable(json);
	});
    var options = {
        title: "Chiffre d'affaire par pays",
		animation:{
			duration : 500,
			startup:1
		},
        chartArea: {width: '70%'},
        vAxis: {
          title: 'C.A.',
          minValue: 0,
		  format: 'currency',
        },
        hAxis: {
          title: 'Pays',
		  slantedTextAngle:90,
		  showTextEvery:1
        },
		bars: 'vertical'
      };
      var chart2 = new google.visualization.ColumnChart(document.getElementById('bar-chart-ca-country'));
      chart2.draw(data, options);
	  data = await fetch("${pageContext.request.contextPath}/app/caparclient?"+(from==null?"":"from="+from+"&")+(to==null?"":"to="+to)).then(data => {
		return data.json();
	}).then(json => {
		json.unshift(['Clients', "Chiffre d'affaire",]);
		console.log(json);
		return google.visualization.arrayToDataTable(json);
	});
    var options = {
        title: "Chiffre d'affaire par client",
		animation:{
			duration : 500,
			startup:1
		},
        chartArea: {width: '70%'},
        vAxis: {
          title: 'C.A.',
          minValue: 0,
		  format: 'currency',
        },
        hAxis: {
          title: 'Clients',
		  slantedTextAngle:90,
		  showTextEvery:1
        },
		bars: 'vertical'
      };
      var chart3 = new google.visualization.ColumnChart(document.getElementById('bar-chart-ca-customer'));
      chart3.draw(data, options);
    }

</script>
</body>
</html>

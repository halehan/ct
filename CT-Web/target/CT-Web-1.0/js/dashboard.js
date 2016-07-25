function post_ajax_data(url, encodedata, success)
{
$.ajax({
type:"POST",
url:url,
data :encodedata,
dataType:"json",
restful:true,
contentType: 'application/json',
cache:false,
timeout:20000,
async:true,
beforeSend :function(data) { },
success:function(data){
success.call(this, data);
},
error:function(data){
alert("Error In Connecting");
}
});
}

//GET and DELETE Ajax
function ajax_data(type, url, success)
{
$.ajax({
type:type,
url:url,
dataType:"json",
restful:true,
cache:false,
timeout:20000,
async:true,
beforeSend :function(data) { },
success:function(data){
success.call(this, data);
},
error:function(data){
alert("Error In Connecting");
}
});
}


function studyAll(data,ChartType)
{
var c=ChartType;
var jsonData=data;

google.load("visualization", "1", {packages:["corechart"], callback: drawVisualization});
function drawVisualization() 
{
var dataCandidate = new google.visualization.DataTable();
var dataEnrolled = new google.visualization.DataTable();

dataCandidate.addColumn('string', 'studyName');
dataCandidate.addColumn('number', 'count');

dataEnrolled.addColumn('string', 'studyName');
dataEnrolled.addColumn('number', 'count');

$.each(jsonData.chart, function(i,jsonData)
{
	var candidateCount=jsonData.candidateCount;
	var enrolledCount=jsonData.enrolledCount;
	
	
	var studyName=jsonData.studyName;
		console.log('name ' + studyName);
		console.log('value ' + candidateCount);

dataCandidate.addRows([ [studyName, candidateCount]]);
dataEnrolled.addRows([ [studyName, enrolledCount]]);
});

var optionsCandidates = {
title : "Patient Candidates",
colorAxis: {colors: ['#54C492', '#cc0000']},
datalessRegionColor: '#dedede',
defaultColor: '#dedede'
};

var optionsEnrolled = {
title : "Patients Enrolled",
colorAxis: {colors: ['#54C492', '#cc0000']},
datalessRegionColor: '#dedede',
defaultColor: '#dedede'
};

var chart;
var chartCandidate;
var chartEnrolled

chartCandidate = new google.visualization.PieChart(document.getElementById('piechart_ctStudyCand'));
chartEnrolled = new google.visualization.PieChart(document.getElementById('piechart_ctStudyEnrolled'));

chartCandidate.draw(dataCandidate, optionsCandidates);
chartEnrolled.draw(dataEnrolled, optionsEnrolled);
}
}

function chartProgress(data,ChartType)
{
var c=ChartType;
var jsonData=data;
google.load("visualization", "1", {packages:["corechart"], callback: drawVisualization});
function drawVisualization() 
{
var data = new google.visualization.DataTable();
data.addColumn('string', 'Status');
data.addColumn('number', 'Count');
$.each(jsonData.chart, function(i,jsonData)
{
var value=jsonData.count;
var name=jsonData.status;
console.log('value ' + value);
console.log('name ' + name);
data.addRows([ [name, value]]);
});


var options = {
		title : "Patient Candidate Progress",
        is3D: false,
        colors: ['red', 'green']
      };



var chart;
chart = new google.visualization.PieChart(document.getElementById('piechart_ct'));

chart.draw(data, options);
}
}



function getData () {
   
     
     var pendingUrl = "patient/list";
     var newUrl = "patient/list/new";
     var expiredUrl = "patient/list/expired";
     var enrolledUrl = "patient/list/all/enrolled";
     var trialsUrl = 'study/list/read';
     var self = this;
     self.viewModel = {}; 
     self.Patients = {};
     self.Trials = {};
     self.New = {};
     self.Enrolled = {};
     self.Current = {};
     var studyUrlx = "studypatients.html?id=";
     var currentStudyName = "";
    
    
     var studyData = $.getJSON(trialsUrl, function (studyData) {
                Trials = ko.mapping.fromJS(studyData);
                ko.applyBindings(Trials, document.getElementById("trials"));
                
    	});
     
     var currentData = $.getJSON(pendingUrl, function (currentData) {
    	 Current = ko.mapping.fromJS(currentData);
         ko.applyBindings(Current, document.getElementById("all"));
	}); 
    	
     
    var expiredData = $.getJSON(expiredUrl, function (expiredData) {
                Patients = ko.mapping.fromJS(expiredData);
                ko.applyBindings(Patients, document.getElementById("expired"));
    	}); 
    
  
    var newData = $.getJSON(newUrl, function (newData) {
         New = ko.mapping.fromJS(newData),
     	 ko.applyBindings(New, document.getElementById("new"));
         
    });
    
    var enrolledData = $.getJSON(enrolledUrl, function (enrolledData) {
    	Enrolled = ko.mapping.fromJS(enrolledData),
    	 ko.applyBindings(Enrolled, document.getElementById("enrolled"));
        
   });
    
   
}
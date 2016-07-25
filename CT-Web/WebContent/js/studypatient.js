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

function chartGoals(data)
{
var jsonData=data;

google.load("visualization", "1", {packages:['corechart', 'bar'], callback: drawVisualization});
function drawVisualization() 

{
var data = new google.visualization.DataTable();
data.addColumn('string', 'Study');
data.addColumn('number', 'Enrolled');
data.addColumn('number', 'Candidate');
data.addColumn('number', 'Goal');

$.each(jsonData.chart, function(i,jsonData)
{
	
var study=jsonData.study;
var enrolled=jsonData.enrolledCount;
var candidate=jsonData.candidateCount;
var goal=jsonData.goalCount;

console.log('Study =  ' + study);
console.log('Enrolled Count = ' + enrolled);
console.log('Candidate Count = ' + candidate);
console.log('Goal = ' + goal);

data.addRows([ [study, enrolled, candidate, goal]]);
});


var options = {
        title: 'Study Goals',
        chartArea: {width: '50%'},
        hAxis: {
          title: 'Study Goal Progress',
          minValue: 0
        },
        vAxis: {
          title: 'Study Name'
        }
      };

var chart = new google.visualization.BarChart(document.getElementById('chart_goals'));
chart.draw(data, options);

}
}


function chartDocs(data)
{
var jsonData=data;
google.load("visualization", "1", {packages:["corechart"], callback: drawVisualization});
function drawVisualization() 
{
var data = new google.visualization.DataTable();
data.addColumn('string', 'Doctor');
data.addColumn('number', 'Count');
$.each(jsonData.chart, function(i,jsonData)
{
var value=jsonData.count;
var name=jsonData.doctor;
console.log('value ' + value);
console.log('name ' + name);
data.addRows([ [name, value]]);
});


var optionsCandidates = {
		title : "Patients Per Doctor",
		colorAxis: {colors: ['#54C492', '#cc0000']},
		datalessRegionColor: '#dedede',
		defaultColor: '#dedede'
		};



var chart;
chart = new google.visualization.PieChart(document.getElementById('piechart_doc'));

chart.draw(data, optionsCandidates);
}
}


function chartDocsEnrolled(data)
{
var jsonData=data;
google.load("visualization", "1", {packages:["corechart"], callback: drawVisualization});
function drawVisualization() 
{
var data = new google.visualization.DataTable();
data.addColumn('string', 'Doctor');
data.addColumn('number', 'Count');
$.each(jsonData.chart, function(i,jsonData)
{
var value=jsonData.count;
var name=jsonData.doctor;
console.log('value ' + value);
console.log('name ' + name);
data.addRows([ [name, value]]);
});


var optionsCandidates = {
		title : "Patient candidate per doctor",
		colorAxis: {colors: ['#54C492', '#cc0000']},
		datalessRegionColor: '#dedede',
		defaultColor: '#dedede'
		};



var chart;
chart = new google.visualization.PieChart(document.getElementById('piechart_docEnrolled'));

chart.draw(data, optionsCandidates);
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
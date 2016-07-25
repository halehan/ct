
    google.load("visualization", "1", {packages:["corechart"]});
    google.setOnLoadCallback(drawStudies);

    function drawStudies() {
      var data = google.visualization.arrayToDataTable([
        ['Task', 'Study'],
        ['On Schedule',     10],
        ['Expired',      2]
      ]);
      
      var options = {
        title: 'Patient Enrollment Workflow',
        is3D: false,
        colors: ['green', 'red']
      };

      var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
      chart.draw(data, options);

      }

	google.load("visualization", "1", {packages:["corechart"]});
    google.setOnLoadCallback(drawChart);

    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['Task', 'Patient Enrollment'],
        ['On Schedule',     10],
        ['Expired',      2]
      ]);
      
      var options = {
        title: 'Patient Enrollment Workflow',
        is3D: false,
        colors: ['green', 'red']
      };

      var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
      chart.draw(data, options);

      }
   
    google.load("visualization", "1", {packages:["corechart"]});
    google.setOnLoadCallback(drawEnrollment); 

    function drawEnrollment() {
      var enrollmentData = google.visualization.arrayToDataTable([
        ['Task', 'Study Enrollment Patients'],
        ['Study Enrollment Goal',     10],
        ['Current Enrollment',      6]
      ]);
      
      var enrollmentOptions = {
        title: 'Study Enrollment Patients',
        is3D: false,
        colors: ['green', 'blue']
        
      };

      var enrollmentChart = new google.visualization.PieChart(document.getElementById('piechart_3d2'));
      enrollmentChart.draw(enrollmentData, enrollmentOptions);

      }
    
    google.load("visualization", "1", {packages:["corechart"]});
    google.setOnLoadCallback(drawAllStudies);

    function drawAllStudies() {
      var data = google.visualization.arrayToDataTable([
        ['Task', 'Study'],
        ['Alcon Dry Macular',     10],
        ['Merck Junky Eye',      7],
        ['Allergan Blind Eye',      14],
        ['Amgen Wet Macluar',      9],
        ['Regeneron Wet Macluar',      20],
        ['Bausch & Lomb Wet Macluar',      5]
        
      ]);
      
      var options = {
        title: 'Study Sponsor Totals',
        is3D: false,
      };

      var chart = new google.visualization.PieChart(document.getElementById('studySponsorAll'));
      chart.draw(data, options);

      }
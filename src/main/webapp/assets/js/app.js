$(document).ready(function() {
  var searchData = {
      'name': ['sandipan', 'uttam', 'subhajit'],
      'designation': ['MS', 'MD', 'MBBS'],
      'location': ['kolkata', 'mumbai', 'delhi'],
      'specialist': ['skin', 'ENT', 'aurthopedic'],
      'experiance': []     
  }
  
  $("#designation").autocomplete({
    source: searchData.designation
  });
  $("#speciality").autocomplete({
    source: searchData.specialist
  });
  $("#designation").autocomplete({
    source: searchData.designation
  });
});

function setData() {
  var name = $('#name').val(),
      speciality = $('#speciality').val(),
      venue = $('#venue').val(),
      designation = $('#designation').val(),
      fees = $('#fees').val(),
      date = $('#date').val(),
      time = $('#time').val(),
      day = $('#day').val(),
      url = 'www.xxx.com';
  var data = JSON.stringify({
      'name':         name,
      'speciality':   speciality,
      'venue':        venue,
      'designation':  designation,
      'fees':         fees,
      'date':         date,
      'time':         time,
      'day':          day
  });
  var ss = 'ss';
  $.ajax({
    type: 'POST',
    url: url,
    async: false,
    data: data,
    contentType: 'application/json',
    dataType: 'json',
    success: function(data) {
      alert('search is successfull');
    }, 
    error: function() {
      alert('search is unsuccessfull');
    }
  });
}


function saveData() {
  var name = $('#saveName').val(),
      speciality = $('#saveSpeciality').val(),
      venue = $('#venue').val(),
      designation = $('#saveDesignation').val(),
      fees = $('#saveFees').val(),
      date = $('#saveDate').val(),
      time = $('#saveTime').val(),
      day = $('#saveDay').val(),
      url = 'www.xxx.com';
  var data = JSON.stringify({
      'name':         name,
      'speciality':   speciality,
      'venue':        venue,
      'designation':  designation,
      'fees':         fees,
      'date':         date,
      'time':         time,
      'day':          day
  });
  var ss = 'ss';
  $.ajax({
    type: 'POST',
    url: url,
    async: false,
    data: data,
    contentType: 'application/json',
    dataType: 'json',
    success: function(data) {
      alert('data successfully saved');
    }, 
    error: function() {
      alert('There is some problem to save data.');
    }
  });
}
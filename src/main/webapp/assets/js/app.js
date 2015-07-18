function saveData() {
  var formName = $('#form-name').val(),
      formRegistration = $('#form-registration').val(),
      formQualification = $('#form-qualification').val(),
      formSpecialization = $('#form-specialization').val(),
      formPhone = $('#form-phone').val(),
      formEmail = $('#form-email').val(),
      formCity = $('#form-city').val(),
      formAddress = $('#form-address').val(),
      formAboutYourself = $('#form-about-yourself').val(),
      url = 'www.xxx.com';
  var data = JSON.stringify({
      'name':           formName,
      'registration':   formRegistration,
      'qualification':  formQualification,
      'specialization': formSpecialization,
      'phone':          formPhone,
      'email':          formEmail,
      'city':           formCity,
      'address':        formAddress,
      'aboutYourself':  formAboutYourself,
  });
  $.ajax({
    type: 'POST',
    url: url,
    async: false,
    data: data,
    contentType: 'application/json',
    dataType: 'json',
    success: function(data) {
      window.location.assign("../address.html");
    }, 
    error: function() {
      window.location.assign("address.html");
    }
  });
}

function addDay() {
  var addressElm = $('<form class="form-inline" class="doctor-address"><div class="form-group"><select class="form-control" id="form-day"><option class="placeholder">Select day</option><option>Sunday</option><option>Monday</option><option>Tuesday</option><option>Wednesday</option><option>Thursday</option><option>Friday</option><option>Saturday</option></select></div><div class="form-group"><label class="sr-only" for="form-time-from">Time from</label><input type="time" name="form-time-from" placeholder="Time from" class="form-control" id="form-time-from"></div><div class="form-group"><label class="sr-only" for="form-time-to">Time to</label><input type="time" name="form-time-to" placeholder="Time to" class="form-control" id="form-time-to"></div><button class="btn" onclick="deleteDay()">X</button></form>');
  $('.doctor-address:last').after(addressElm);
}

function addAddress() {
  
}

function saveAddress() {
  /*var formName = $('#form-name').val(), 

  
  var data = JSON.stringify({
    'name' : formName,
    'registration' : formRegistration,
    'qualification' : formQualification,
    'specialization' : formSpecialization,
    'phone' : formPhone,
    'email' : formEmail,
    'city' : formCity,
    'address' : formAddress,
    'aboutYourself' : formAboutYourself,
  });
  $.ajax({
    type : 'POST',
    url : url,
    async : false,
    data : data,
    contentType : 'application/json',
    dataType : 'json',
    success : function(data) {
      window.location.assign("../address.html");
    },
    error : function() {
      window.location.assign("address.html");
    }
  });*/
}
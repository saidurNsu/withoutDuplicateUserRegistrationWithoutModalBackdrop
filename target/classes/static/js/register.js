jQuery('#myModal').on('shown.bs.modal', function() {
    jQuery(this).data('bs.modal').options.backdrop = 'static';// For outside click of modal.
//    jQuery(this).data('bs.modal').options.keyboard = false;// For ESC button.
})


//function onChange() {
function checkPass() {
  const password = document.querySelector('input[name=password]');
  const confirm = document.querySelector('input[name=confirm]');
  if (confirm.value === password.value) {
    confirm.setCustomValidity('');
  } else {
    confirm.setCustomValidity('Passwords do not match');
  }
}


var password = document.getElementById("password")
  , confirm_password = document.getElementById("confirm_password");

function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

var myInput = document.getElementById("password");
var confirmPassword = document.getElementById("confirm_password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

<!--// When the user clicks on the password field, show the message box-->
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

confirmPassword.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

<!--// When the user clicks outside of the password field, hide the message box-->
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";

}

<!--// When the user starts to type something inside the password field-->
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
}

<!--  // Validate capital letters-->
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

<!--  // Validate numbers-->
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }

<!--  // Validate length-->
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}

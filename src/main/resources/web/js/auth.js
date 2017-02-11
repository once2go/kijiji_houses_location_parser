$( document ).ready(function() {
	var name = window.localStorage.getItem("lc_home_displayName");
	var photo = window.localStorage.getItem("lc_home_photoURL"); 
	var id = window.localStorage.getItem("lc_home_uid"); 
	var token = window.localStorage.getItem("lc_home_token");

	if(token && id && name && photo) {
		showProfile(name, photo);
		showSaving();
		setTimeout(getParams, 1000);
	}  
});

function sign_in_google(){
	  var provider = new firebase.auth.GoogleAuthProvider();
	  firebase.auth().signInWithPopup(provider).then(function(result) {
	  var token = result.credential.accessToken;
	  var user = result.user;
	  window.localStorage.setItem("lc_home_token", token);
	  window.localStorage.setItem("lc_home_uid", user.uid);
	  window.localStorage.setItem("lc_home_photoURL", user.photoURL);
	  window.localStorage.setItem("lc_home_displayName", user.displayName);
	  showProfile(user.displayName, user.photoURL);
	  showSaving();
	  setTimeout(getParams, 1000)
	}).catch(function(error) {
	  var errorCode = error.code;
	  var errorMessage = error.message;
	  console.log(errorCode + " " + errorMessage)
	});
}

function showProfile(name, photoUrl) {
  $("#user_name").html('<img src="'+ photoUrl +'" class="u-thumb">' + name + ' <span class="caret"></span>');
  $("#block_signin").empty();
  $("#block_signin").append('<li class="disabled"><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>');
  $("#block_signin").append('<li><a onclick="show_f_dialog()"><span class="glyphicon glyphicon-envelope"></span> Send feedback</a></li>');
  $("#block_signin").append('<li class="divider"></li><li><a onclick="signOut()">Sign Out</a></li>');  
}

function showSignIn() {
  $("#user_name").html('<span class="glyphicon glyphicon-user"></span>Sign In<span class="caret"></span>');
  $("#block_signin").empty();
  $("#block_signin").append('<li><a onclick="sign_in_google()">Sign In with Google</a></li>');
  $("#block_signin").append('<li role="presentation" class="disabled"><a>Sign In with Facebook</a></li>');

  $('#pressets').html('');
  $('#block_save').remove();
}

function signOut() {
	firebase.auth().signOut().then(function() {
		window.localStorage.removeItem("lc_home_displayName");
		window.localStorage.removeItem("lc_home_photoURL");
		window.localStorage.removeItem("lc_home_uid");
		window.localStorage.removeItem("lc_home_token");
		showSignIn();
	}, function(error) {
	  	console.log(error.message)
	});
}

function showSaving() {
	$('.block_button').append('<div class="col-lg-6" id="block_save"><div class="input-group">'
		+'<span class="input-group-btn"><button class="btn btn-info" type="button" id="save-presset">Save parameters as:</button></span>'
		+'<input type="text" class="form-control" id="preset-name" placeholder="Presset name"></div></div>').on('click', '#save-presset', saveCurent);
}

function show_f_dialog() {
 $('#fback-modal').modal('show');
}

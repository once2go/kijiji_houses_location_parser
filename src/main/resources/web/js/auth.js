$( document ).ready(function() {

});

function sign_in_google(){
  var provider = new firebase.auth.GoogleAuthProvider();
  provider.addScope('https://www.googleapis.com/auth/plus.login');
  firebase.auth().signInWithPopup(provider).then(function(result) {
  // This gives you a Google Access Token. You can use it to access the Google API.
  var token = result.credential.accessToken;
  alert(token)

  // The signed-in user info.
  var user = result.user;
  alert(user.email)
  // ...
}).catch(function(error) {
  // Handle Errors here.
  var errorCode = error.code;
  alert(errorCode)
  var errorMessage = error.message;
  alert(errorMessage)
  // The email of the user's account used.
  var email = error.email;
  alert(email)
  // The firebase.auth.AuthCredential type that was used.
  var credential = error.credential;
  alert(credential)
  // ...
});
}
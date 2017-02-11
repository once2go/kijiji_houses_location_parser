function getParams() {
	var userId = firebase.auth().currentUser.uid;
	firebase.database().ref('user/' + userId + "/query").once("value", function(snapshot) {
	  $('#pressets').html('');
	  snapshot.forEach(function(childSnapshot) {
	    var childKey = childSnapshot.key;
	    var childData = childSnapshot.val();

	    $('#pressets').append('<div class="block_button" id="bl' + childKey + '"></div>')
	    $('#bl'+childKey).append('<button type="button" class="btn btn-default" id="' + childKey + '" > Use "' + childData.name + '" presset created at '+ childData.date +'</button>')
		    .on("click", '#'+childKey ,function() {
		    	$( "#search_option" ).find('label').removeClass('active');
		    	$("input[name=options][value='"+ childData.search_type+"']").prop('checked', 'checked').parent().addClass('active');
		    	$('#price_from').val(childData.price_from);
				$('#price_till').val(childData.price_till);
	        	$('#lat_start').val(childData.lat_start);
	        	$('#lat_end').val(childData.lat_end);
	        	$('#lon_start').val(childData.lon_start);
	        	$('#lon_end').val(childData.lon_end);
		    })
		$('#bl'+childKey).append('<button class="btn btn-danger" id="rmi'+childKey+'" type="button">remove</button>')
		    .on('click', "#rmi" + childKey, function() {
		    	firebase.database().ref('user/' + userId + "/query/" + childKey).remove()
		    	.then(function(){
		    		$('#bl'+ childKey).remove()
		    	})
		    	.catch(function(error){
	    			console.log("Cant remove " + error);
   				});
		    })
		});
	  }).catch(function(error){
	    alert("Data could not be retrived." + error);
   });
}

function saveParams(name, type, priceFrom, priceTill, latStart, latEnd, lonStart, lonEnd) {
  var d = new Date();
  var userId = firebase.auth().currentUser.uid;
  firebase.database().ref('user/' + userId + "/query").push({
  	name : !name ? "No name" : name,
    search_type: type,
    price_from: priceFrom,
    price_till : priceTill,
    lat_start : latStart,
    lat_end : latEnd,
    lon_start : lonStart,
    lon_end : lonEnd, 
    date : d.toLocaleString()
  }).then(function(){
    getParams();
  })
  .catch(function(error){
	    console.log("Data could not be saved." + error);
   });

}

function saveCurent() {
	saveParams($('#preset-name').val().trim(),
		    $('input[name=options]:checked', '#search_option').val(),
			$('#price_from').val().trim(),
			$('#price_till').val().trim(),
	        $('#lat_start').val().trim(),
	        $('#lat_end').val().trim(),
	        $('#lon_start').val().trim(),
	        $('#lon_end').val().trim() 
		);
}

function sendFeedBack(msg) {
  var d = new Date();
  var userId = firebase.auth().currentUser.uid;
  var mail = firebase.auth().currentUser.email;
  firebase.database().ref('feedback/' + userId + "/messages").push({
  	mail : mail,
    message: msg,
    date : d.toLocaleString()
  }).then(function(){
	   console.log("send ok")
  })
  .catch(function(error){
	    console.log("Data could not be saved." + error);
   });
}
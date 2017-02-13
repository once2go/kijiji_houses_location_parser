$( document ).ready(function() {
	$("#progress_bar").hide();
    $( "#search" ).click(function() {
    	$("#result_list").empty();
  		var $btn = $(this).button('loading');
  		$("#progress_bar").show();
	    $.ajax({
        url: "/",
        type: "POST",
        headers: { 'x-u-auth': window.localStorage.getItem("lc_home_uid") },
        contentType : 'application/json',
        data: JSON.stringify({ 
        	"search_type": $('input[name=options]:checked', '#search_option').val(),
        	"price_from": $('#price_from').val().trim(),
	        "price_till": $('#price_till').val().trim(),
	        "lat_start": $('#lat_start').val().trim(),
	        "lat_end": $('#lat_end').val().trim(),
	        "lon_start" : $('#lon_start').val().trim(),
	        "lon_end": $('#lon_end').val().trim() 
        	 }),
        success: function (response) {
           	  $btn.button('reset')
           	  $("#progress_bar").hide();
           	  if (checkJSON(response)) { 
           	  	   var data = $.parseJSON(response);
           	  	   if($.isEmptyObject(data)) {
           	  	   		$("#result_list").append('<li class="list-group-item list-group-item-info">No matches</li>')
           	  	   } else {
           	  	   	$.each(data, function(key, item) {
	              	$("#result_list").append('<a target="_blank" href="'+item.link+'"class="list-group-item list-group-item-success">'
	              		+item.title+'<span class="badge">' + item.price + '</span></a>');
	    		  	});
           	  	 }
           	  } else {
           	  	var errorList = response.split(";");
           	  	$.each(errorList, function(key, description) {
           	  		if (description) {
           	  			$("#result_list").append('<li class="list-group-item list-group-item-warning">'+description+'</li>')           	  			
           	  		}
           	  	});
           	  }
        },
        error: function(jqXHR, textStatus, errorThrown) {
		   $("#progress_bar").hide();
		   $("#result_list").append('<li class="list-group-item list-group-item-danger">'+jqXHR+'</li>')
           $btn.button('reset')
        }
       });	
	});

    $("#feedback-send-btn").click(function() {
      sendFeedBack($("#feedback-msg").val())
      $('#fback-modal').modal('hide');
      $("#feedback-msg").val('');
    });
});


var checkJSON = function(m) {

   if (typeof m == 'object') { 
      try{ m = JSON.stringify(m); }
      catch(err) { return false; } }

   if (typeof m == 'string') {
      try{ m = JSON.parse(m); }
      catch (err) { return false; } }

   if (typeof m != 'object') { return false; }
   return true;

};

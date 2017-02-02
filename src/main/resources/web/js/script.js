$( document ).ready(function() {

	$("#progress_bar").hide();

    $( "#search" ).click(function() {
    	$("#result_list").empty();
  		var $btn = $(this).button('loading');
  		$("#progress_bar").show();
	    $.ajax({
        url: "/",
        type: "POST",
        contentType : 'application/json',
        data: JSON.stringify({ 
        	"search_type": $('input[name=options]:checked', '#search_option').val(),
        	"price_from": $('#price_from').val(),
	        "price_till": $('#price_till').val(),
	        "lat_start": $('#lat_start').val(),
	        "lat_end": $('#lat_end').val(),
	        "lon_start" : $('#lon_start').val(),
	        "lon_end": $('#lon_end').val() 
        	 }),
        success: function (response) {
           	  $btn.button('reset')
           	  $("#progress_bar").hide();
           	  var data = $.parseJSON(response);
              $.each(data, function(key, item) {
              	$("#result_list").append('<a target="_blank" href="'+item.link+'"class="list-group-item list-group-item-success">'
              		+item.title+'<span class="badge">' + item.price + '</span></a>');
    		  });
        },
        error: function(jqXHR, textStatus, errorThrown) {
		   $("#progress_bar").hide();
		   $("#result_list").append('<li class="list-group-item list-group-item-danger">'+textStatus+'</li>')
           $btn.button('reset')
        }
       });	
	});
});

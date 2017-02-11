<div class="block_input">

<h4>Property type</h4>
<div class="btn-group" data-toggle="buttons" id="search_option">
  <label class="btn btn-primary active">
    <input type="radio" name="options" value="rooms" checked>Rooms
  </label>
  <label class="btn btn-primary">
    <input type="radio" name="options" value="condos">Condos
  </label>
  <label class="btn btn-primary">
    <input type="radio" name="options" value="houses">Houses
  </label>
</div>


<h4>Price</h4>
<div class="row">
  <div class="col-md-6">
  	<div class="input-group">
	  <span class="input-group-addon">From</span> 
	  <input id="price_from" type="text" class="form-control" value="200" aria-label="Amount (to the nearest dollar)">
  	  <span class="input-group-addon">c$</span>
	</div>
  </div>
  <div class="col-md-6">
  	  	<div class="input-group">
	  	 <span class="input-group-addon">To</span> 
	 	 <input id="price_till" type="text" class="form-control" value="750" aria-label="Amount (to the nearest dollar)">
  	 	 <span class="input-group-addon">c$</span>
	</div>
  </div>
</div>
<h4>Cordinates</h4>
<div class="row">
  <div class="col-md-6">
  	<div class="input-group">
	  <span class="input-group-addon">Start from X</span> 
	  <input id="lat_start" type="text" class="form-control" value="43.643028">
	</div>
  </div>
    <div class="col-md-6">
  	<div class="input-group">
	  <span class="input-group-addon">End at X</span> 
	  <input id="lat_end" type="text" class="form-control" value="43.675007">
	</div>
  </div>
</div>
<div class="row">
  <div class="col-md-6">
  	  	<div class="input-group">
	  	 <span class="input-group-addon">Start from Y</span> 
	 	 <input id="lon_start" type="text" class="form-control" value="-79.427273">
	</div>
  </div>
  <div class="col-md-6">
  	  	 <div class="input-group">
	  	 <span class="input-group-addon">End at Y</span> 
	 	 <input id="lon_end" type="text" class="form-control" value="-79.364445">
	</div>
  </div>
</div>

<div class="block_button row">
<div class="col-lg-6">
	<button type="button" id="search" data-loading-text="Searching..." class="btn btn-primary" autocomplete="off">
  		Search
	</button>
</div>


</div>

</div>
<ul class="list-group" id="result_list"></ul>



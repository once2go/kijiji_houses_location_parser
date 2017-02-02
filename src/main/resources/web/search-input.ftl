<h4>Property type</h4>
<div class="btn-group" data-toggle="buttons" id="search_option">
  <label class="btn btn-primary active">
    <input type="radio" name="options" value="condos" autocomplete="off" checked>Condos
  </label>
  <label class="btn btn-primary">
    <input type="radio" name="options" value="houses" autocomplete="off">Houses
  </label>
</div>

<h4>Price</h4>
<div class="row">
  <div class="col-md-6">
  	<div class="input-group">
	  <span class="input-group-addon">From</span> 
	  <input id="price_from" type="text" class="form-control" value="1000" aria-label="Amount (to the nearest dollar)">
  	  <span class="input-group-addon">c$</span>
	</div>
  </div>
  <div class="col-md-6">
  	  	<div class="input-group">
	  	 <span class="input-group-addon">Till</span> 
	 	 <input id="price_till" type="text" class="form-control" value="2000" aria-label="Amount (to the nearest dollar)">
  	 	 <span class="input-group-addon">c$</span>
	</div>
  </div>
</div>
<h4>Cordinates</h4>
<div class="row">
  <div class="col-md-6">
  	<div class="input-group">
	  <span class="input-group-addon">Start from X</span> 
	  <input id="lat_start" type="text" class="form-control" value="43.719537">
	</div>
  </div>
    <div class="col-md-6">
  	<div class="input-group">
	  <span class="input-group-addon">End at X</span> 
	  <input id="lat_end" type="text" class="form-control" value="43.781840">
	</div>
  </div>
</div>
<div class="row">
  <div class="col-md-6">
  	  	<div class="input-group">
	  	 <span class="input-group-addon">Start from Y</span> 
	 	 <input id="lon_start" type="text" class="form-control" value="-79.321688">
	</div>
  </div>
  <div class="col-md-6">
  	  	 <div class="input-group">
	  	 <span class="input-group-addon">End at Y</span> 
	 	 <input id="lon_end" type="text" class="form-control" value="-79.233601">
	</div>
  </div>
</div>


<button type="button" id="search" data-loading-text="Searching..." class="btn btn-primary" autocomplete="off">
  Search
</button>

<div class="progress" id="progress_bar">
  <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="45"aria-valuemin="0" aria-valuemax="100" style="width: 100%">
  </div>
</div>

<ul class="list-group" id="result_list"></ul>



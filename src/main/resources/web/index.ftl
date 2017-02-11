<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>
  <#include "nav.ftl">
  <#include "feedback.ftl">
  <div class="row">
  	<div class="progress" id="progress_bar">
  	<div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="45"aria-valuemin="0" aria-valuemax="100" 	style="width: 100%">
  	</div>
</div>
      <div class="col-md-6"><#include "search-input.ftl"></div>
      <div class="col-md-6"><#include "description.ftl"></div>
  </div>

</body>
</html>

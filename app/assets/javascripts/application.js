// This is a manifest file that'll be compiled into application.js, which will include all the files
// listed below.
//
// Any JavaScript/Coffee file within this directory, lib/assets/javascripts, vendor/assets/javascripts,
// or vendor/assets/javascripts of plugins, if any, can be referenced here using a relative path.
//
// It's not advisable to add code directly here, but if you do, it'll appear at the bottom of the
// the compiled file.
//
// WARNING: THE FIRST BLANK LINE MARKS THE END OF WHAT'S TO BE PROCESSED, ANY BLANK LINE SHOULD
// GO AFTER THE REQUIRES BELOW.
//
//= require jquery
//= require jquery_ujs

$(document).on("click", "#submit_link", function(e) {
	e.preventDefault();
	$("#form").submit();
});

$(document).ready(function() {
	$(document).find('#todo_creation').hide();
	
	$(document).on("click", "#show_div", function(e)  {
		$(document).find('#show_div').hide();
		$(document).find('#todo_creation').show();
	});
	
	$(document).on("click", "#hide_div", function(e)  {
		$(document).find('#todo_creation').hide();
		$(document).find('#show_div').show();
	});
});
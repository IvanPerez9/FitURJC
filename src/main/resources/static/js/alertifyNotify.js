$(document).ready(function(){
	$(".simple_confirmSign").click(function(){
		button = this;
		alertify.confirm("Quieres apuntarte a este curso", function(e){
			if(e){
				alertify.alert("Apuntado al curso: " + $(button).data('coursename'));
				document.location = "courses/" + $(button).data('idschedule') + "/add";
			}else{
				alertify.alert("No apuntado");
			}
		});
	});
	$(".simple_confirmQuit").click(function(){
		button = this;
		alertify.confirm("Quieres quitarte de este curso", function(e){
			if(e){
				alertify.alert("Desapuntado del curso: " + $(button).data('coursename'));
				document.location = "courses/" + $(button).data('idschedule') + "/delete";
			}else{
				alertify.alert("Ok, sigues apuntado");
			}
		});
	});
});

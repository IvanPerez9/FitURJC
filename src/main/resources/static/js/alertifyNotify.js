$(document).ready(function(){
	$(".simple_confirmSign").click(function(){
		button = this;
		alertify.confirm("Do you want to sign up for this course?", function(e){
			if(e){
				alertify.alert("Subscribed to the course: " + $(button).data('coursename'));
				document.location = "courses/" + $(button).data('idschedule') + "/add";
			}else{
				alertify.alert("No enrolled");
			}
		});
	});
	$(".simple_confirmQuit").click(function(){
		button = this;
		alertify.confirm("Do you really want to unsubscribe?", function(e){
			if(e){
				alertify.alert("Unsubscribed to the course: " + $(button).data('coursename'));
				document.location = "courses/" + $(button).data('idschedule') + "/delete";
			}else{
				alertify.alert("Ok, you're still subscribed");
			}
		});
	});
});

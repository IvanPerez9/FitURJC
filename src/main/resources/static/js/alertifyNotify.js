$(document).ready(function(){
	$(".simple_confirmSign").click(function(){
		button = this;
		alertify.confirm("Do you want to sign up for this course?", function(e){
			if(e){
				alertify.alert("subscribed to the course: " + $(button).data('coursename'));
				document.location = "courses/" + $(button).data('idschedule') + "/add";
			}else{
				alertify.alert("no enrolled");
			}
		});
	});
	$(".simple_confirmQuit").click(function(){
		button = this;
		alertify.confirm("Do you really want to unsubscribe?", function(e){
			if(e){
				alertify.alert("unsubscribed to the course: " + $(button).data('coursename'));
				document.location = "courses/" + $(button).data('idschedule') + "/delete";
			}else{
				alertify.alert("Ok, you're still subscribed");
			}
		});
	});
});

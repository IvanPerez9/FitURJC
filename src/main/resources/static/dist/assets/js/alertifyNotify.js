// $(document).ready(function(){
// 	$(".simple_confirmSign").click(function(){
// 		button = this;
// 		alertify.confirm("Do you want to sign up for this course?", function(e){
// 			if(e){
// 				alertify.alert("Subscribed to the course: " + $(button).data('coursename'));
// 				document.location = "courses/" + $(button).data('idschedule') + "/add";
// 			}else{
// 				alertify.alert("No enrolled");
// 			}
// 		});
// 	});
// 	$(".simple_confirmQuit").click(function(){
// 		button = this;
// 		alertify.confirm("Do you really want to unsubscribe?", function(e){
// 			if(e){
// 				alertify.alert("Unsubscribed to the course: " + $(button).data('coursename'));
// 				document.location = "courses/" + $(button).data('idschedule') + "/delete";
// 			}else{
// 				alertify.alert("Ok, you're still subscribed");
// 			}
// 		});
// 	});
//
// 	// Alert to delete o save in Admin page. Not used, just in case. Add js and css to the html if necessary
//
// 	$(".simple_confirmSignDelete").click(function(){
// 		button = this;
// 		alertify.confirm("Do you want to delete this?", function(e){
// 			if(e){
// 				alertify.alert("Delete ");
// 				document.location = "/adminPage/manageUsers/delete/id";
// 			}else{
// 				alertify.alert("Delete Cancelled");
// 			}
// 		});
// 	});
// 	$(".simple_confirmSave").click(function(){
// 		button = this;
// 		alertify.confirm("Do you really want to save?", function(e){
// 			if(e){
// 				alertify.alert("Succesfully saved ");
// 				document.location = "/manageUsers";
// 			}else{
// 				alertify.alert("Unsaved changes");
// 			}
// 		});
// 	});
//
// });
function showDialogEnroll(element) {
    var button = element;
    alertify.confirm("Do you want to sign up for this course?", function(e){
        if(e){
            alertify.alert("Subscribed to the course: " + $(button).data('coursename'));
            document.location = "courses/" + $(button).data('idschedule') + "/add";
        }else{
            alertify.alert("No enrolled");
        }
    });
}

function showDialogUnEnroll(element) {
    var button = element;
    alertify.confirm("Do you really want to unsubscribe?", function(e){
        if(e){
            alertify.alert("Unsubscribed to the course: " + $(button).data('coursename'));
            document.location = "courses/" + $(button).data('idschedule') + "/delete";
        }else{
            alertify.alert("Ok, you're still subscribed");
        }
    });
}

function showDialogSoldOut(element) {
    alertify.alert("Full course Try another time.");
}


function deleteUser(element) {
    var button = element;
    alertify.confirm("Delete user?", function(e){
        if(e){
            alertify.alert("Deleted: " + $(button).data('username'));
            document.location = "manageUsers/delete/" + $(button).data('iduser');
        }else{
            alertify.alert("Not deleted");
        }
    });
}


function saveUser(element) {
    alertify.alert("User save");
}

function deleteCourse(element) {
    var button = element;
    alertify.confirm("Delete course?", function(e){
        if(e){
            alertify.alert("Deleted: " + $(button).data('coursename'));
            document.location = "manageCourses/delete/" + $(button).data('idcourse');
        }else{
            alertify.alert("Not deleted");
        }
    });
}


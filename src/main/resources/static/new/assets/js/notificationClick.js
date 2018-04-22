$('#notify').click(function(){
	$.bootstrapGrowl("Signed up!.", {
		allow_dismiss: true,
		type: 'success',
		align: 'left'
	});
});
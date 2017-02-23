$(document).ready(function() {
	$('#button').click(function() {
		$.ajax({
			url : 'game',
			type : 'POST',
			success : function(responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});


});
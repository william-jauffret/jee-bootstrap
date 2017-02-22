$(document).ready(function() {
	$('#userName').blur(function() {
		$.ajax({
			url : 'GameJDDServlet',
			data : {
				userName : $('#userName').val()
			},
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});
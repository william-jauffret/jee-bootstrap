$(document).ready(function() {
	$('#button').click(function() {
		$.ajax({
			url : 'game',
			data : {
				userName : $('#userName').val()
			},
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});
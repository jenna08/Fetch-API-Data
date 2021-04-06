
$(document).ready(function() {
        $('#userName').blur(function(event) {
                var name = $('#userName').val();
              /*  $.get('GetUserServlet', {
                        userName : name
                }, function(responseText) {
                        $('#ajaxGetUserServletResponse').text(responseText);
                });*/

		$.ajax({
			type: "GET",
			url: 'http://localhost:8080/temp_1/GetUserServlet',
			dataType: 'json',
			success: function (responseText) {
				$('#ajaxGetUserServletResponse').text(JSON.stringify(responseText));
			}
		});
	});
});


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
					//contentType: 'application/json',
					dataType: 'json',
					success: function (responseText) {
						$('#ajaxGetUserServletResponse').text(JSON.stringify(responseText));
					}
				});
				
				/* Method 3
				$.ajax({
					type: "GET",
					url: 'https://reqres.in/api/users/2',
					//contentType: 'application/json',
					dataType: 'json',
					data: {userName : name},
					success: function (responseText) {
						$('#ajaxGetUserServletResponse').text(JSON.stringify(responseText));
					}
				});*/
				
				// Method 1
				/*$.ajax({
					type: "GET",
					url: 'GetUserServlet',
					data: {userName : name},
					success: function (responseText) {
						$('#ajaxGetUserServletResponse').text(responseText);
					}
				});*/
				
				/* Method 2
				$.get("GetUserServlet", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
			        var $ul = $("<ul>").appendTo($("#ajaxGetUserServletResponse")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
			        $.each(responseJson, function(index, item) { // Iterate over the JSON array.
			            $("<li>").text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
			        });
			    });*/
        });
});

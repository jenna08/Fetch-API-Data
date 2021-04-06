# Fetch-API-Data
Fetch data from API using AJAX &amp; Servlet <br />
<br />
Sample javascript AJAX request -<br />
$.ajax({ <br />
					type: "GET", // Method Type POST/GET <br />
					url: 'http://localhost:8080/temp_1/GetUserServlet', <br />
					dataType: 'json', <br />
					success: function (responseText) { <br />
						$('#idOfHtmlElem').text(JSON.stringify(responseText)); <br />
					} <br />
}); <br />

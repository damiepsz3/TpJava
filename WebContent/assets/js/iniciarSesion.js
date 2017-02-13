$(document).ready(function() {
		$('#ingresar').click(function(event) {
			var usuario = $('#user').val();
			var contrasena = $('#pass').val();
			$.ajax({
                type: "POST",
                url: "LoginServlet",
                data: {
                	username: usuario,
                	password: contrasena
                },
                dataType: "json",
               
                success: function(json) {
                	console.log(json);
                },
			})
		})
});	
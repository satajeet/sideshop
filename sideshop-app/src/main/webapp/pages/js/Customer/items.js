function login() {
	var loginName = document.getElementById("LoginName").value;
	var password = document.getElementById("Password").value;
	var jsonNode = "{ \"loginName\":\""+ loginName+"\", \"password\": \""+password+"\" }";
	if(loginName=='Satajeet'){
		window.location.href = "html/admin.html";
	}
	if(loginName=='Tamal'){
		window.location.href = "html/shop.html";
	}
	if(loginName=='Sampa'){
		window.location.href = "html/customer.html";
	}
}

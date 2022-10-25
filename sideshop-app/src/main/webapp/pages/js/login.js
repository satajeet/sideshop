function login() {
	var loginName = document.getElementById("LoginName").value;
	var password = document.getElementById("Password").value;
	var jsonNode = "{ \"loginName\":\""+ loginName+"\", \"password\": \""+password+"\" }";
	alert(jsonNode);
	if(loginName=='Satajeet'){
		window.location.href = "pages/html/admin.html";
	}
	if(loginName=='Tamal'){
		window.location.href = "pages/html/shop.html";
	}
	if(loginName=='Sampa'){
		window.location.href = "pages/html/Customer/customerdetails.html";
	}
}

function login() {
	var xhr = new XMLHttpRequest();
	var url = 'http://localhost:8081/sideshop-api/v1/shop/shops';
	xhr.open("GET", url, true);
	xhr.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			var response = this.responseText;
			alert(response);
			console.log(this.responseText);
		}
	}
	xhr.send();
}

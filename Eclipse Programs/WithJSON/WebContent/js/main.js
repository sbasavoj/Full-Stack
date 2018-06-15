// JavaScript Document

var xhr = new XMLHttpRequest();

//xhr.open("GET", "data.json", true);
xhr.open("GET", "http://localhost:8088/api/v1/shipwrecks", true);

xhr.send();

xhr.onreadystatechange = function(){
	console.log(xhr.readyState);
	console.log(xhr.status);
}

xhr.onload = function(){
	
	var data = JSON.parse(xhr.responseText);
	console.log(data);
//	console.log(data.first);
//	console.log(data.last);
//	console.log(data.served);
}




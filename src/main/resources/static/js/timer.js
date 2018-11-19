if (document.cookie.length == 0) {
    Cookies.set('val', '10');
}


var time = Cookies.get('val');

function odliczanie()
	{
		document.getElementById("zegar").innerHTML =
		 time;

		 setTimeout("odliczanie()",1000);
		 time++;
		 Cookies.set('val', time);
	}
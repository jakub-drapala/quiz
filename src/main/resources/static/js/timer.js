let time = localStorage.getItem('time');
function odliczanie()
	{
	console.log(localStorage.getItem('time'));

		document.getElementById("zegar").innerHTML = time;

		 setTimeout("odliczanie()",1000);
		 time++;
		 Cookies.set('val', time);
		 localStorage.setItem('time', time);
	}
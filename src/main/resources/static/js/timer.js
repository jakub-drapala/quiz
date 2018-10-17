    var minutes = 60;
    var seconds = 1;
    var endOfTest = 0;
    var timesUp = 0;


    function countdown()
    {
	    if(minutes<=0&&sekunda<=0)
	    {
		    document.getElementById('timer').innerHTML='Koniec czasu - nastąpi przekierowanie do strony z wynikami';
		    timesUp = 1;
		    document.getElementById("formegzamin").submit();
	    }

	    seconds=seconds-1;
	    if (seconds<0) {seconds=59; minutes=minutes-1;}
	    if (minutes<0) {minutes=59;}

	    if(minutes>=0&&seconds>=0)
	    {
		    document.getElementById('timer').innerHTML='Czas jaki pozostał do zakończenia egzaminu &rarr; '+minutes+' min '+seconds+' sek' ;
		    setTimeout("countdown()",1000);
	    }
    }

	 window.onload = countdown;


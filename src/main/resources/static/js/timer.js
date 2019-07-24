let currentTime = localStorage.getItem('currentValue');
let timer = document.querySelector('#timer');
function countUp() {
    timer.innerHTML = currentTime;
    currentTime++;
    localStorage.setItem('currentValue', currentTime);
    setTimeout("countUp()", 1000);
}
countUp();
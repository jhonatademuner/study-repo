function timer(){
    function createTimer(seconds){
        const initialTime = new Date(seconds * 1000);
        return initialTime.toLocaleTimeString("pt-BR", {
            hour12: false,
            timeZone: "gmt"
        })
    }

    const timer = document.querySelector(".timer");
    let seconds = 0;
    let intervalo;

    function startTimer(){
        intervalo = setInterval(function(){
            seconds ++;
            timer.innerHTML = createTimer(seconds);
        }, 1000);
    }

    document.addEventListener("click", function(e){

        const clickedElement = e.target;

        if(clickedElement.classList.contains('startBtn')){
            clearInterval(intervalo);
            startTimer();
            timer.classList.remove('stoped');
        }

        if(clickedElement.classList.contains('pauseBtn')){
            clearInterval(intervalo);
            timer.classList.add('stoped');
        }

        if(clickedElement.classList.contains('resetBtn')){
            clearInterval(intervalo);
            seconds = 0;
            timer.innerHTML = "00:00:00";
            timer.classList.remove('stoped');
        }
    })
}
timer();

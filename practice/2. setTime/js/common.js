'use strict'

let count = 0;
let min = 0;
let t = null;
let timerIsOn = 0;
let domTable = document.querySelector("#stop-watch-wrap");

function timeOut(){
    if(min > 0){
        document.querySelector("#stop-watch").innerHTML = `${min}:${count}`;
    }else{
        document.querySelector("#stop-watch").innerHTML = `${count}`;
    }
    count += 1
    if(count == 60){
        min += 1;
        count += 1;
    }
    t = setTimeout(timeOut, 1000);
}
// setTimeout: 타이머가 만료된 뒤 실행할 function입니다.

function startCount(){
    if(timerIsOn == 0){
        timerIsOn = 1;
        timeOut();
    }
}
function stopCount(){
    clearTimeout(t);
    timerIsOn = 0;
}
function resetCount(){
    document.querySelector("#stop-watch").innerHTML = 0;
    count = 0;
    clearTimeout(t);
}
// clearTimeout : 취소할 시간 제한의 식별자입니다
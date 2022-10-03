'use strict'
let pos = 0;
let id = null;
let elem = document.querySelector(".Squere_box");
let on = 0;

function startMove(){
    if(on == 0){
        on = 1;
        id = setInterval(moveFunc, 20);
        function moveFunc(){
            pos ++;
            elem.style.left = `${pos}px`;
        }
    }
}
// setInterval : 밀리초마다 실행되는 함수입니다. 첫 번째 실행은 밀리초 후에 발생합니다.

function stopMove(){
    clearInterval(id);
    on = 0;
}

function returnMove(){
    clearInterval(id);
    on = 0;
    pos = 0;
    elem.style.left = `${0}px`;
}
// clearInterval : 취소하려는 반복 작업의 식별자입니다.


let circle = document.getElementsByClassName("circle_box")[0];
let xMove = 0, yMove = 0, xDirection = 1, yDirection = 1;
let moveIntervar = setInterval(move, 5);

function move(){
    xMove += 1 * xDirection;
    yMove += 1 * yDirection;
    if(xMove > window.innerWidth - 101 || xMove < 0){
        xDirection = xDirection * (-1);
    }
    if(yMove > window.innerHeight - 101 || yMove < 0){
        yDirection = yDirection * (-1) ;
    }
    circle.style.left = `${xMove}px`;
    circle.style.top = `${yMove}px`;
}
'use strict'

function textColorChange(){
    document.querySelector("p").style.color = "blue";
}

function innerTxt(){
    let inputNum = document.querySelector("#input-text").value;
    document.querySelector(".content > h2 > p").innerHTML = inputNum;
    document.querySelector(".content > p").innerHTML = "hello QuerySelector";
}

/**
 * 자바스크립트 선택요소에는 getElementById와 querySelector가 있다.
 * getElementById 은 HTMLCollection을 반환하고
 * querySelector 는 NodeList를 리턴한다.
 * 
 * 따라서 더욱 구체적으로 선택자를 선택하려면 querySelector를 쓴다!
 */

// border 생성
function borderAdd(){
    document.querySelector(".content-table td").style.border = "1px solid #000";
}

function borderChange(){
    document.querySelector(".content-table td").style.border = "3px solid blue";
}
function borderDel(){
    document.querySelector(".content-table td").style.border = "none";
}
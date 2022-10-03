'use strict'

function textFunc(){

    // // class 단일추가
    //document.querySelector("#text").classList.add("change-bg");

    // // class 다중추가
    // document.querySelector("#text").classList.add("change-bg", "change-font-style", "change-width");

    // //단일삭제
    //document.querySelector("#text").classList.remove("change-width");

    //다중삭제
    document.querySelector("#text").classList.remove("change-bg", "change-font-style", "change-width");

    /**
     * classList 사용은 공백으로 구분된 문자열인 element.className을 통해 
     * 엘리먼트의 클래스 목록에 접근하는 방식을 대체하는 방법으로 
     * 속성 자체는 읽기 전용이지만 add(), remove(), replace() 및 toggle() 
     * 메서드를 사용하여 연관된 속성을 수정할 수 있다.
     * 
     * 반환값은 DOMTokenList 이며,
     * DOMTokenList 인터페이스는 공백으로 구분된 토큰 집합을 나타냅니다.
     * 
     * 기존 클래스 속성에 접근후 또다른 클래스를 추가하여 조작하고 싶을때 사용하기 편한게 만드는 기능
     */
}

function sideMenuSlide(){
    let elem = document.querySelector("#sidemenu")
    let check = elem.getAttribute("class");
    elem.classList.toggle("on");
//     if(check == "on"){ // on class가 있을때
//         //on을 삭제하는 코드
//         document.querySelector("#sidemenu").remove("class");
//         console.log(menu);
//         elem.classList.remove("on");
//     }else{
//     //on을 추가하는 코드
//         document.querySelector("#sidemenu").add("class");
//         console.log(menu);
//         elem.classList.add("on");
//     }
}
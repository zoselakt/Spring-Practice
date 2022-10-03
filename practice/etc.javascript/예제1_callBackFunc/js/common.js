'use strict'

/*
    익명함수 : function(){}
    선언적함수 : function funcName(){}
    재귀함수: function funcName(){ 자신의네임(funcName) }

콜백함수
- 다른 함수의 매개변수로 사용되거나, event로 특정시점에 호출되는 함수 / 비동기적으로 작동될때 사용

CallBack 함수란 이름 그대로 나중에 호출되는 함수를 말한다.
콜백함수라고 해서 그 자체로 특별한 선언이나 문법적 특징을 가지고 있지는 않다.
어떤 이벤트가 발생했거나 특정 시점에 도달했을 때 시스템에서 호출하는 함수를 말한다.

대표적인 콜백 함수의 사용 예로는 자바스크립트에서 이벤트 핸들러 처리이다.

Callback을 활용한 비동기적 프로그래밍
비동기적 테크닉 : 소중한 싱글스레드의 멈춤을 방지한다. 즉 블록킹을 방지하여 싱글스레드가 논블록킹으로 동작하게 한다.

비동기적 테크닉을 사용하는 경우
1.사용자 이벤트 처리

브라우저 화면에서 발생하는 사용자의 이벤트는 예측이 불가능하다.
따라서 이런 화면이벤트를 관리담당하는 녀석에게 우리는 특정이벤트가 발생할 때 호출을 원하는 내용을 callback 함수에 전달하게 된다.

2.네트워크 응답 처리

화면단에서 서버에게 요청을 보냈을 때, 그 응답이 언제 올지 알 수 없다.
따라서 이런 서버에 대한 응답처리 등도 비동기적으로 처리해야 한다.

3.파일을 읽고 쓰는 등의 파일 시스템 작업

4.의도적으로 시간 지연을 사용하는 기능(알람 등)

위와 같이 이벤트 등을 기다리는데 하나뿐인 소중한 스레드를 사용한다면, 또 서버의 응답을 기다리기 위해 하나뿐인 소중한 스레드를 사용한다면…
사용자는 멈춰져 있는 화면을 보게되는 것이다.
위와 같이 스레드의 블록킹을 야기하는 작업은 필수적으로 비동기적 프로그래밍을 해야 한다.
*/

function avgCalc(a,b,c){
    let sum = a+b;

    c(sum) // 함수실행 / 작동전
    // return sum;
}

// 익명함수로 콜백함수 호출
// console.log(avgCalc(1,2));
avgCalc(10,30,function(num){ // 작동호출
    let avg = num / 2; //작동값
    console.log(avg); //작동후
});

//arrow function으로 실행하기
// avgCalc( => {})
avgCalc(20,40,(num) => {
    let avgNum = num / 2;
    console.log(avgNum);
});

// 선언적함수로 콜백함수 호출
function avg(num){
    let avg = num/2;
    console.log(avg);
}

avgCalc(50, 100, avg);
/* let num = 50+100 / avg(sum)*/

//  ?? use Strict 사용시 주의점 : ES5와 ES6간 use strict로 값이 달라질수있다.
window.onload = function(){
    document.getElementById('wrap').innerHTML = myFunction();
    function myFunction(){
        return this;
    }
}


function multiple(a,b,c){
    let mul = a*b;
   return c(mul); // 리턴 - 정상리턴출력
}

function square(result){
    console.log(result);
    return result; // 리턴 - 부모에게
}

multiple(10, 20, square); // 함수 호출 출력
console.log(multiple(10, 20, square)); // 콘솔로 리턴값 출력
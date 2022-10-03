'use strict'

// 코드 작업순서 (node생성순서)

window.onload = function(){
    init(); // 초기화코드
    // input(); 
    // label();
}

function init(){
    let btn = document.createElement('div'); // div태그 생성
    btn.id = 'btn';
    btn.removeAttribute('id'); // 속성삭제
    let text = document.createTextNode('click'); // 텍스트추가
    btn.append(text); // div태그안에 click 텍스트 추가

    let contain = document.createElement('div'); //상위div태그만들기
    contain.classList.add('wrap') // 클래스이름 생성
    contain.append(btn)  // div(wrap)안에 div(click)태그로 감싸기

    document.body.append(contain); //출력
    
    let divBox = document.createElement('div');
    divBox.prepend(document.createTextNode('div-box'));
    document.body.append(contain);
    document.body.append(divBox);

    //인풋태그추가
    // let inputM = document.createElement('input')
    // inputM.id = 'male';
    // inputM.setAttribute('type', 'checkbox')
    // inputM.prepend(document.createTextNode('남자'));
    // contain.prepend(inputM);
    
    //레이블태그 - 남자추가
    // let inputLabelM = document.createElement('label')
    // inputLabelM.id = 'gender';
    // inputLabelM.setAttribute('for', 'male')
    // inputLabelM.prepend(document.createTextNode('남자'));
    // contain.prepend(inputLabelM);

    //레이블태그 - 여자추가
    // let inputW = document.createElement('input')
    // inputW.id = 'female';
    // inputW.setAttribute('type', 'checkbox')
    // inputW.prepend(document.createTextNode('남자'));
    // contain.prepend(inputW);

    // let inputLabelW = document.createElement('label')
    // inputLabelW.id = 'gender';
    // inputLabelW.setAttribute('for', 'Female')
    // inputLabelW.prepend(document.createTextNode('여자'));
    // contain.prepend(inputLabelW);

    //공통부분 함수로 만들기
    function input(input, gender){
        let inputT = document.createElement(input);
        inputT.id = gender;

        inputT.setAttribute('type', 'checkbox');
        contain.prepend(inputT);
    }
    function label(label, gender){
        let inputLabel = document.createElement(label);
        inputLabel.setAttribute('for', gender);
        inputLabel.prepend(document.createTextNode(gender))
        
        inputLabel.id= 'gender';
        contain.prepend(inputLabel);
    }
    input("input", "female");
    label('label','여자');

    input("input", "male");
    label('label','남자');

    //강사작성 공통부분
    function createInputFunc(id, type){
            let elem = document.createElement('input');
            elem.id = id;
            
            elem.setAttribute('type', type);
            return elem;
        }
        function createInputFunc2(id, forVal, txt){
            let inputLabel = document.createElement('label');
            inputLabel.setAttribute('for', forVal);
            inputLabel.prepend(document.createTextNode(txt));
            inputLabel.id= id;
            contain.prepend(inputLabel);
        }
        // createInputFunc('female', 'checkbox', 'contain');
        createInputFunc2('gender', 'female', '여성 ');
        contain.prepend(createInputFunc('female', 'checkbox'));
        createInputFunc2('gender', 'male', '남성');
        contain.prepend(createInputFunc('male', 'checkbox'));
}
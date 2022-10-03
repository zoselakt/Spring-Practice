
    /*
    출처: https://araikuma.tistory.com/609 [프로그램 개발 지식 공유:티스토리]

    prepend : 선택된 요소의 첫번째에 새로운 요소나 콘텐츠를 추가한다.
    let elemNum = $("p#first");
    elemNum.prepend("<span>hi</span>")

    prependTo(...) 다른 태그 안의 맨앞으로 이동한다.
    $(".items:last-child").prependTo("#wrap");

    append: 선택된 요소의 마지막에 새로운 요소나 콘텐츠를 추가한다.
    elemNum.append("<span>hi</span>")

    appendTo(...) 다른 태그 안의 맨뒤로 이동한다.
    $("strong").appendTo("p"); // 스트롱을 p태그에 넣는다
    $(".items:nth-child(3)").appendTo("#wrap")
*/
$(function(){
    let elemP = [];
    elemP.push("<span> hi </span>");
    elemP.push("<img src='./img/build.png'>");
    elemP.push("<span> hi </span>");
    elemP.push("<img src='./img/watch.png'>");
    console.log(elemP)

    let elemP1 = [];
    elemP1.push("<div> hi </div>");
    elemP1.push("<img src='./img/build.png'>");
    elemP1.push("<div> hi </div>");
    elemP1.push("<img src='./img/watch.png'>");
    console.log(elemP1)

    $("ul li:nth-child(1) a").prepend(elemP[0])
    $("ul li:nth-child(2) a").prepend(elemP[1])
    $("ul li:nth-child(3) a").append(elemP[2])
    $("ul li:nth-child(4) a").append(elemP[3])
    $("ul li:nth-child(5) a").prependTo(elemP1[0])
    $("ul li:nth-child(6) a").prependTo(elemP1[1])
    $("ul li:nth-child(7) a").appendTo(elemP1[2])
    $("ul li:nth-child(8) a").appendTo(elemP1[3])

    for(let i=0; i<=elemP.length; i++){
        let count = i + 1
        $("ul li:nth-child("+count+") a").prepend(elemP[i])
    }
    for(let i=0; i<=elemP1.length; i++){
        let count = i + 1
        $("ul li:nth-child("+count+") a").prepend(elemP1[i])
    }

     // eq 명령어를 사용하여 변경 / 메서드 체인
    //  let elem = $("ul li")

    // for(let i=0; i<=elem.length; i++){
    //     $("ul li").eq(i).find("a").prepend(elemP[i])
    // }

    // $(".items").eq(1).text();
})
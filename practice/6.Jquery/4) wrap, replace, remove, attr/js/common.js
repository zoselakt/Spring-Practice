$(function(){

    //wrap(...) 태그를 다른 태그로 묶는다.
    $("strong").wrap("<h2></h2>"); //개별로 각각의 h2태그를 생성하여 묶인다.

    //wrapAll(...) 태그 전체를 모아서 다른 태그로 묶는다.
    $("h2").wrapAll("<header></header>"); // 한번에 태그를 묶는다. / 파일 내 모든요소를 끌고와 묶겨질수 있으니 주의

    //wrapInner(...) 자식 태그/텍스트를 다른 태그로 묶는다.
    $(".wrap-inner").wrapInner("<div class='inner'></div>");  //지정클래스에 요소를 묶는다.
    
    //replaceWith(...) 태그를 다른 태그로 변경한다.
    $("h2").replaceWith('<h2>remove</h2>');

    //remove() 태그를 제거한다.
    $(".box").remove();
    
    // p태그를 "<span class='box'>test box </span>"으로 변경
    $("p").replaceWith("<span class='box'> textbox </span>")
    console.log($(".box").text())

    // .items태그를 "<a href='http://naver.com'></a>로 변경
    $(".items").replaceWith("<a href='http://naver.com'></a>");
    // 변경된 a태그를 remove로 삭제
    $("a").remove();

    // attr(...) 지정한 속성값을 가져온다.
    // attr을 사용하여 id 또는 class명을 지정할 수 있다.
    let attrNum = document.querySelector("#wrap-id").getAttribute('class');
    let num = $("#wrap-id").attr('class');
    let wrapIn = $(".wrap-inner").attr('id');
    
    console.log(attrNum)
    console.log(num)
    console.log(wrapIn)

    // attr(... , ...) 지정한 속성값을 변경한다.

    // removeAttr(...) 지정한 속성을 제거한다.

})
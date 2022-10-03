
$(function(){
    // before(...) 태그 앞에 HTML을 삽입한다.
    // after(...) 태그 뒤에 HTML을 삽입한다.

    $("p#first").before("<h2>HTML</h2>")
    $("head").after("<h2>HTML</h2>")
    $("p#second").after("<h2>JavaScript</h2>").before("<h2>CSS3</h2>");

    // insertBefore(...) 다른 태그의 앞으로 이동한다.
    // insertAfter(...) 다른 태그의 뒤로 이동한다
    $("#wrap").insertBefore("span"); // wrap을 span의 앞에 넣는다.

    //items5를 items3앞으로 이동
    $("div:nth-child(5)").insertBefore("div:nth-child(3)");

    //strong태그를 items3 자리 뒤로 이동시키세요.
    $("strong").insertAfter("div:nth-child(4)")
});
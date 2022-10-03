'use strict'

/*
jquery - css셀렉터
    태그: $("태그명")
    id셀렉터: $("#id명")
    클래스: $(" .클래스네임")
    자손: $("태그1 #태그2(id선택) .태그3(class선택) >태그4(태그선택)")
    유니버셜(전체선택자): $("*")
    그룹: $("셀렉터1, 셀렉터2"
*/
$(function(){
    $("li").css('color','red');
    $("#first").css("color", "blue");
    $("li#third").css("background-color", "green");
})

// jquery 정규표현식
$(function(){
    $("[class ^= 's'] a").css("color", "red")
    // rd 문자로 끝나는 title의 a태그 텍스트 색상을 blue로 변경
    $("[class $= 'rd'] a").css("color", "blue")
    // com로 끝나는 href속성을 갖고있는 요소의 텍스트 색상을 yellow로 변경
    $("[href $= 'com']").css("color", "blue")
    //net으로 끝나는 href속성을 갖고있는 요소의 텍스트 색상을 green으로 변경
    $("[href $= 'net']").css("color", "green")
    // th 문자를 포함한 title 속성을 갖고 있는 요소의 텍스트 색상을 purple로 변경
    $("[class *= 'fo'] a").css("color", "aqua")
})
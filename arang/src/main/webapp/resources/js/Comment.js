$(function(){
    //댓글쓰기 버튼 (버튼을 눌러서 id값이 넘어와서 실행되는 자바스크립트 구문)
    listReply();       
    $("#btnReply").click(function(){
        
    var r_content = $("#r_content").val();    //댓글의 내용
    var member_bno =  "${dto.member_bno}";
    var params = {"r_content" : r_content, "member_bno" : member_bno};
    
    
    $.ajax({
        type: "post", //데이터를 보낼 방식
        url: "reply_insert.do", //데이터를 보낼 url
        data: params, //보낼 데이터
    
        
        success: function(data){//데이터를 보내는 것이 성공했을 시 출력되는 메시지
            alert("댓글이 등록되었습니다.");
            listReply2();
                }
            });
        });
//댓글 목록을 출력하는 함수
function listReply(){
    $.ajax({
        type: "get",    //get방식으로 자료를 전달
        url: "reply_list.do?member_bno=${dto.member_bno}&curPage=${curPage}&search_option=${search_option}&keyword=${keyword}",    //컨트롤러에 있는 list.do로 맵핑되고 게시글 번호도 같이 보낸다.
        success: function(result){    //자료를 보내는것이 성공했을때 출력되는 메시지
            
            //댓글목록을 실행한 결과를 가져온다.
        $("#listReply").html(result);
            }
        });
}
function listReply2(){
    $.ajax({
        type: "get",
        contentType: "application/json",
        url: "reply_list_json.do?member_bno=${dto.member_bno}",
        success: function(result){
            console.log(result);
            var output="<table>";
            for(var i in result){
                var repl=result[i].replytext;
                repl = repl.replace(/  /gi,"&nbsp;&nbsp;");//공백처리
                repl = repl.replace(/</gi,"&lt;"); //태그문자 처리
                repl = repl.replace(/>/gi,"&gt;");
                repl = repl.replace(/\n/gi,"<br>"); //줄바꿈 처리
                
                output += "<tr><td>"+result[i].name;
                date = changeDate(result[i].regdate);
                output += "("+date+")";
                output += "<br>"+repl+"</td></tr>";
            }
                output+="</table>";
                $("#listReply").html(output);
        }
    });
}
});
$(function(){
 
    //댓글 수정 버튼
    $("#btn_reply_Update").click(function(){
    if(confirm("수정 하시겠습니까?")){
        
    //수정하는데 필요한 정보들, 댓글 번호, 글 내용, 작성자 아이디, 게시글 번호를 변수에 저장한다.
        var rno = $("#rno").val();
        var r_content = $("textarea#r_content").text();
        var user_id = $("#user_id").val();
        var member_bno = $("#member_bno").val();
        
    //게시글 세부 페이지로 포워딩을 하기위해 페이지 관련 값들을 변수에 저장해서 컨트롤러로 보낸다.
        var curPage = $("#curPage").val();
        var search_option = $("#search_option").val();
        var keyword = $("#keyword").val();
        
        //페이지 관련 값들과 댓글 수정에 필요한 값들을 url로 전송한다.
        document.form1.action="reply_update.do?rno="+rno+"&r_content="+encodeURI(r_content)+"&user_id="+user_id+"&member_bno="+member_bno+"&curPage="+curPage+"&search_option="+search_option+"&keyword="+keyword;
        document.form1.submit();
        
        
        alert("댓글이 수정되었습니다.")
                }
        });
 
    
    //댓글 삭제 버튼
    $("#btn_reply_Delete").click(function(){
        
        if(confirm("삭제 하시겠습니까?")){
        
        //댓글 삭제를 하기위해 댓글 번호, 글 번호, 댓글 내용, 그리고 게시글 세부 페이지로 포워딩 하기 위해 페이지 관련 값들을 변수에 저장한다.
            var rno = $("#rno").val();
            var member_bno = $("#member_bno").val();
            var content = $("textarea#r_content").text();
            var curPage = $("#curPage").val();
            var search_option = $("#search_option").val();
            var keyword = $("#keyword").val();
            
            
            //url로 삭제에 필요한 변수들을 보낸다.
            document.form1.action="reply_delete.do?rno="+rno+"&member_bno="+member_bno+"&curPage="+curPage+"&search_option="+search_option+"&keyword="+keyword;
            
            document.form1.submit();
            
            alert("댓글이 삭제되었습니다.")
            
        }
    });
});
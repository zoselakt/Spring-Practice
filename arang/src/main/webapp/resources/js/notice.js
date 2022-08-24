var page = 1;                       
var searchKey = ''; 

$.ajax({	
	type : 'POST',	url : "notice", 
	dataType : "json",        
	data : {	       
	 'page' : page,	        
	 'searchKeyword' : searchKey	
	 },	
success : function (result) {
	respone = result.lists;          	       	 
	paging = result.paging;             
	
$("데이터가 삽입될 객체 table").empty();    

if(respone.length == 0){
	$("데이터가 삽입될 tbody").append("<td colspan=20 style='padding:30px;'>데이터가 없습니다.</td>");	       	
	}else{                                    
	_.each(respone, function(item){
		var contentHtml = _.template($('데이터가 삽입될 템플릿').html(), item ); 
		$("데이터가 삽입될 tbody").append(contentHtml);	      
		});			       	
	}
	$(".pagination").empty();//페이징에 필요한 객체내부를 비워준다.
	
	  // 페이지가 1페이지 가아니면 첫페이지로가는버튼활성화
	if(paging.page != 1){            
		$(".pagination").append("<li class=\"goFirstPage\"><a><<</a></li>"); 
	}else{	        	
		$(".pagination").append("<li class=\"disabled\"><a><<</a></li>"); 
	}	        
	//첫번째 블럭이 아니면 뒤로가기 활성화
	if(paging.block != 1){
		$(".pagination").append("<li class=\"goBackPage\"><a><</a></li>");        
	}else{
	$(".pagination").append("<li class=\"disabled\"><a><</a></li>");        
	}
	//시작페이지부터 종료페이지까지 반복문
	for(var i = paging.startPage ; i <= paging.endPage ; i++){       
	 	if(paging.page == i){ //현재페이지가 반복중인 페이지와 같다면 버튼활성화             
	 	  	$(".pagination").append("<li class=\"disabled active\"><a>"+i+"</a></li>");    
	 	}else{	        	
	 		$(".pagination").append("<li class=\"goPage\" data-page=\""+i+"\"><a>"+i+"</a></li>"); 
		}
    }	        
 //전체페이지블럭수가 현재블럭수보다 작을때
 	if(paging.block < paging.totalBlock){           
 		 $(".pagination").append("<li class=\"goNextPage\"><a>></a></li>"); 
 	 }else{	        	
 	 	$(".pagination").append("<li class=\"disabled\"><a>></a></li>"); 
	 }        
	     
	 if(paging.page < paging.totalPage){                
	 //현재페이지가 전체페이지보다 작을때        		
	 $(".pagination").append("<li class=\"goLastPage\"><a>>></a></li>"); 
	    //마지막페이지로 가기 버튼 활성화        	
	  }else{        	
	  $(".pagination").append("<li class=\"disabled\"><a>>></a></li>");
	          //마지막페이지로 가기 버튼 비활성화        
	  	}
	  	//첫번째 페이지로 가기 버튼 이벤트        	
	  	$(".goFirstPage").click(function(){		       	
	  	page = 1;		       	
	  	pageFlag = 1;		       	
	  	$("상단 ajax를 함수로 만들어 재귀호출");		       	
	  	pageFlag = 0;	        
	  	});
	  	//뒷페이지로 가기 버튼 이벤트		
	  	$(".goBackPage").click(function(){		   
	  	   	page = Number(paging.startPage) - 1;		   
	  	    pageFlag = 1;		  
	  	$("상단 ajax를 함수로 만들어 재귀호출");	
	  	 	pageFlag = 0;	        });
	  	  	//클릭된 페이지로 가기 이벤트
	  	$(".goPage").click(function(){		
			page = $(this).attr("data-page");		
			pageFlag = 1;		     
		$("상단 ajax를 함수로 만들어 재귀호출");	
			pageFlag = 0;	
		});
		//다음페이지로 가기 클릭이벤트	
		$(".goNextPage").click(function(){	
			page = Number(paging.endPage) + 1;		
			pageFlag = 1;		    
		$("상단 ajax를 함수로 만들어 재귀호출");	
			pageFlag = 0;	     
		});
		//마지막페이지로 가기 클릭이벤트	       
		$(".goLastPage").click(function(){	        	
			page = paging.totalPage;	        	
			pageFlag = 1;		       	
			$("상단 ajax를 함수로 만들어 재귀호출");		      	
			pageFlag = 0;	        
		});	    
	}    
});




	  	
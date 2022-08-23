$(function() {
    $('#search-input').on('change', function () {    
        term = $(this).val();        
        if (term != "") {
            jQuery.ajax({
                type: "GET",
                url: "notice",
                cache: false,
                data: {
                    title: $("#option1").val()
                },
                success: function (obj) {
				//테이블 초기화
				$('#selectAll > body').empty();
				
                    var data = JSON.parse(obj);
                    $.each(data, function (k, v) {
                        $('<option></option>').val(k).text(v).appendTo(getSearchList());
                    });
                },
                error: function (xhr, status, error) {
                    console.log("ERROR!!!");
                }
            });            
        } else {    
            $("select[name=board_btn]").attr("disabled",true);        
        }
        $(this).closest('form').submit();
    });
});

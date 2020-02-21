
/*提交回复*/
function post() {
    var questionId = $('#question-id').val();
    var content = $('#comment_content').val();

    if (!content){
        alert("不能回复空内容~~~");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 1
        }),
        success: function (response) {
            if (response.code == 200) {
                /*$('#comment_section').hide();*/
                window.location.reload();
            } else {
                //没有登录
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if(isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=fec656c52294597a4924&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable",true);
                    }
                } else {
                    alert(response.message);
                }
            }
            // console.log(response);
        },
        dataType: "json"
    });
    console.log(questionId);
    console.log(content);

}

/*展开二级评论*/
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);
    /*comments.toggleClass("in");*/
    var collapse = e.getAttribute("data-collapse");
    if (collapse){
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    }else {
        //展开二级评论
        comments.addClass("in");
        //标记二级评论展开状态
        e.setAttribute("data-collapse","in");
        e.classList.add("active")
    }
}
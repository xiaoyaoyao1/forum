function post() {
    var questionId = $('#question-id').val();
    var content = $('#comment_content').val();

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
                $('#comment_section').hide();
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
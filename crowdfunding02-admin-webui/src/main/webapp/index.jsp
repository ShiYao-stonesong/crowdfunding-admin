<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="layer/layer.js"></script>
    <%--    以下文章是解释为什么要引入这个空标签的原因
    https://blog.csdn.net/weixin_42309521/article/details/97534783

    总结：
    发现原因了
    首先原来引入script标签的方式
    <script src="jquery/jquery-2.1.1.min.js"/>
    这种标签的闭合方式，jsp可能无法识别，结果整个文档之后的所有内容都写到了script标签里面

    解决办法
    <script src="jquery/jquery-2.1.1.min.js"></script>
    改成这样的写法就行了
    --%>
    <%--    <script></script>--%>
</head>
<body>

<a href="${pageContext.request.contextPath}/test/ssm.html">测试SSM整合环境</a>
<br>
<button id="btn1">Send [5,8,12] One</button>
<button id="btn5">点我弹窗</button>

<script type="text/javascript">

    $(function () {
        $("#btn1").click(function () {
            var array = [5, 8, 12];
            console.log(array.length);
            var requestBody = JSON.stringify(array);

            let student = {
                "id": 123,
                "name": "mark"
            }
            console.log(requestBody.length);
            var requestBody = JSON.stringify(student)
            $.ajax({
                "url": "send/array.json",
                "type": "post",
                "data": requestBody,
                "contentType": "application/json;charset=UTF-8",
                "dataType": "json",
                "success": function (response) {
                    console.log("成功");
                    console.log(response);
                    // alert(response);
                },
                "error": function (response) {
                    console.log("失败");
                    console.log(response);
                    // alert(response);
                }
            });

        });


        $("#btn5").click(function () {
            layer.msg("Layer的弹窗");
        });
    });

</script>

</body>
</html>

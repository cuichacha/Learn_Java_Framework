<%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 12/5/20
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="javascript:void(0);" id="testAjax">访问springmvc后台controller</a>
<br/>
<a href="javascript:void(0);" id="testAjaxPojo">访问springmvc后台controller，传递Json格式POJO</a>
<br/>
<a href="javascript:void(0);" id="testAjaxList">访问springmvc后台controller，传递Json格式List</a>
<br/>
<a href="javascript:void(0);" id="testAjaxReturnString">访问springmvc后台controller，返回字符串数据</a>
<br/>
<a href="javascript:void(0);" id="testAjaxReturnJson">访问springmvc后台controller，返回Json数据</a>
<br/>
<a href="javascript:void(0);" id="testAjaxReturnJsonList">访问springmvc后台controller，返回Json数组数据</a>
<br/>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>
    $("#testAjax").click(function () {
        $.ajax({
            type: "POST",
            url: "Test4.do",
            data: "ajax message",
            dataType: "text",
            contentType: "application/text"
        });
    });

    $("#testAjaxPojo").click(function () {
        $.ajax({
            type: "POST",
            url: "Test5.do",
            data: '{"name":"Sam", "age":0}',
            dataType: "text",
            contentType: "application/json"
        });
    });

    $("#testAjaxList").click(function () {
        $.ajax({
            type: "POST",
            url: "Test6.do",
            data: '[{"name":"Sam","age":39},{"name":"Tom","age":40}]',
            dataType: "text",
            contentType: "application/json"
        });
    });

    $("#testAjaxReturnString").click(function () {
        $.ajax({
            type: "POST",
            url: "Test7.do",
            success: function (data) {
                alert(data);
            }
        });
    });

    $("#testAjaxReturnJson").click(function () {
        $.ajax({
            type: "POST",
            url: "Test8.do",
            success: function (data) {
                alert(data);
                alert(data['name'] + " ,  " + data['age']);
            }
        });
    });

    $("#testAjaxReturnJsonList").click(function () {
        $.ajax({
            type: "POST",
            url: "Test9.do",
            success: function (data) {
                alert(data);
                alert(data.length);
                alert(data[0]["name"]);
                alert(data[1]["age"]);
            }
        });
    });
</script>
</html>

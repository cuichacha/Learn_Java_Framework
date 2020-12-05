<%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 12/5/20
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/FileUpload.do" method="post" enctype="multipart/form-data">
    <%--文件上传表单的name属性值一定要与controller处理器中方法的参数对应，否则无法实现文件上传--%>
    上传LOGO：<input type="file" name="file"/><br/>
    上传照片：<input type="file" name="file1"/><br/>
    上传任意文件：<input type="file" name="file2"/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>

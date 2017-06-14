<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>威海金之木渔具有限公司</title>
    <script type="text/javascript" src="../js/lib/jquery-3.2.0.slim.min.js"></script>
    <script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/index.css">
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder">
    <tr align="center">
        <td height="145" colspan="4">
            <jsp:include page="public/main_top.jsp"/>
        </td>
    </tr>
    <tr>
        <td colspan="4" align="center">
            <jsp:include page="public/main_body.jsp"/>
        </td>
    </tr>
    <tr>
        <td colspan="4" align="center">
            <jsp:include page="public/main_bottom.jsp"/>
        </td>
    </tr>

</table>
</body>
</html>
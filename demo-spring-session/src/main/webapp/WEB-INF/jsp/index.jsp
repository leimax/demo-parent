<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="java.util.UUID" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!private static final String SESSION_KEY = "DEMO";%>
<%
    String sessionValue = (String) session.getAttribute(SESSION_KEY);
    if (StringUtils.isEmpty(sessionValue)) {
        session.setAttribute(SESSION_KEY, UUID.randomUUID());
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html; charset=UTF-8">
    <title>测试Session共享</title>
</head>
<body>
<h1 style="color:red">
    显示当前用户：<%=session.getAttribute(SESSION_KEY)%>
</h1>
</body>
</html>
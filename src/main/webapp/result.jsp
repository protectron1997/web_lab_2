<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>MATRIX</title>
    <meta charset="UTF-8">
    <link href="index.css" rel="stylesheet" type="text/css">
</head>

<body>
    <div class="flex-container">
        <jsp:include page="/include/header.jsp" />

        <div class="flex-body">

            <button onclick="window.location.href='${pageContext.request.contextPath}/index.jsp';">Вернуться</button>
            <div class="main-content-of-lab">
                <jsp:include page="/include/lastDotTable.jsp" />


            </div>
        </div>



        <jsp:include page="/include/footer.jsp" />

    </div>
</body>
</html>
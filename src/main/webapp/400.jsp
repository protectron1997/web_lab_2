<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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


                <div class="main-content-of-lab">
                    <h3>40X</h3>
                </div>



                <div class="main-content-of-lab">
                    <img src="400.jpg" width="400" height="300">
                </div>

                <div class="main-content-of-lab">
                    <button onclick="window.location.href='${pageContext.request.contextPath}/index.jsp';">Вернуться на главную страницу</button>
                </div>

            </div>



            <jsp:include page="/include/footer.jsp" />
        </div>
    </body>

    </html>
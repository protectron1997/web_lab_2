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
                    <div id="news">
                        <p>Теребов Святослав Дмитриевич</p>
                        <p>P3230 variant 374781</p>
                    </div>

                    <div class="main-content-of-lab">
                        <div class="input-container">
                            <form id="coordinates-form" method="POST" enctype="multipart/form-data"
                                action="${pageContext.request.contextPath}/controller" onsubmit="return validateY()">

                                <div id="x-input">
                                    <div>
                                        <label>X:</label>
                                        <input type="hidden" id="x" name="x" value="">
                                        <c:forEach var="i" items="-3,-2,-1,0,1,2,3,4,5">
                                            <button type="button" onclick="setXValue(${i})">${i}</button>
                                        </c:forEach>
                                        <script type="text/javascript">
                                            function setXValue(value) {
                                                document.getElementById('x').value = value;
                                            }
                                        </script>
                                    </div>

                                </div>

                                <div id="y-input">
                                    <label>Y:</label>
                                    <input id="y" name="y" type="text" maxlength="2" placeholder="от -5 до 3">
                                </div>

                                <div id="r-input">
                                    <div>
                                        <label>R:</label>
                                        <c:forEach var="r" items="1,1.5,2,2.5,3">
                                            <div>
                                                <input type="radio" id="r-${r}" name="r" value="${r}">
                                                <label for="r-${r}">${r}</label>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>

                                <div id="file-input">
                                    <div>
                                        <label>file:</label>
                                        <div><input name="fileAc" type="file" /></div>
                                    </div>
                                </div>

                                <button class="submit-button" type="submit">Отправить</button>
                            </form>
                            <div id="send-status"></div>
                        </div>

                        <div class="plot">
                            <jsp:include page="/include/plot.jsp" />
                        </div>
                    </div>

                    <div class="main-content-of-lab">
                        <jsp:include page="/include/table.jsp" />
                    </div>
                </div>

                <jsp:include page="/include/footer.jsp" />
            </div>

            <script type="text/javascript" src="plot-cords.js"></script>
            <script type="text/javascript" src="dot-drawer.js"></script>
            <script type="text/javascript">
                function validateY() {
                    var yValue = parseFloat(document.getElementById('y').value);
                    var statusDiv = document.getElementById('send-status');
                    statusDiv.innerHTML = "";

                    if (isNaN(yValue) || yValue < -5 || yValue > 3) {
                        statusDiv.innerHTML = "Значение Y должно быть в диапазоне от -5 до 3.";
                        return false;
                    }
                    return true;
                }
            </script>
        </body>

        </html>
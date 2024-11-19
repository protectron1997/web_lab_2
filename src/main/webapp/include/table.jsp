<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div>
        <table id="table-status-table" border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>time_exec</th>
                <th>date</th>
                <th>res</th>
            </tr>

            <jsp:useBean id="history" scope="session" class="beans.DataDotsBean" />
            <%-- "${dataDotsBean.toString()}" --%>
                <c:forEach var="item" items="${dataDotsBean.dataDots}">
                    <tr>
                        <td>${item.x}</th>
                        <td>${item.y}</th>
                        <td>${item.r}</th>
                        <td>${item.time}</th>
                        <td>${item.date}</th>
                        <td>${item.status}</th>
                    </tr>
                </c:forEach>


        </table>
    </div>
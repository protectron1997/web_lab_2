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



                    <tr>
                        <td>${lastDot.x}</th>
                        <td>${lastDot.y}</th>
                        <td>${lastDot.r}</th>
                        <td>${lastDot.time}</th>
                        <td>${lastDot.date}</th>
                        <td><h3>${lastDot.status}</h3></th>
                    </tr>



        </table>
    </div>
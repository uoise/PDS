<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <h2>Designs</h2>
    <p></p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>TargetId</th>
            <th>SlaveId</th>
            <th>LossRate(%)</th>
            <th>Count</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="Design" items="${Designs}">
            <tr onclick="location.href='/design/${Design.id}'">
                <td>${Design.id}</td>
                <td>${Design.targetProduct.id}</td>
                <td>${Design.slaveProduct.id}</td>
                <td>${Design.lossRate}</td>
                <td>${Design.count}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="/js/design.js"/>
<%@ include file="../layout/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <h2>Company</h2>
    <p></p>
    <button type="button" class="btn btn-primary" onclick="location.href='/company/insertform'">Create</button>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="Company" items="${Companys}">
            <%--            <tr onclick="location.href='/company/${Company.name}'">--%>
            <td>${Company.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="/js/company.js"/>
<%@ include file="../layout/footer.jsp" %>
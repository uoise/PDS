<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <h2>Products</h2>
    <button type="button" class="btn btn-primary" onclick="location.href='/product/insertform'">Create</button>
    <p></p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Standard</th>
            <th>Unit</th>
            <th>Price</th>
            <th>Comapny</th>
            <th>Username</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="Product" items="${Products}">
            <tr onclick="location.href='/product/${Product.id}'">
                <td>${Product.id}</td>
                <td>${Product.name}</td>
                <td>${Product.standard}</td>
                <td>${Product.unit}</td>
                <td>${Product.price}</td>
                <td>${Product.company.name}</td>
                <td>${Product.createUser.username}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="../layout/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <h2>Create Product</h2>
    <form action="/action_page.php">
        <input type="hidden" id="id" value="${Product.id}"/>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="name" class="form-control" value="${Product.name}" placeholder="Input Name" id="name">
        </div>

        <div class="form-group">
            <label for="standard">Standard</label>
            <input type="standard" class="form-control" value="${Product.standard}" placeholder="Input Standard"
                   id="standard">
        </div>

        <div class="form-group">
            <label for="unit">Unit</label>
            <input type="unit" class="form-control" value="${Product.unit}" placeholder="Input Unit" id="unit">
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" class="form-control" value="${Product.price}" placeholder="Input Price" id="price">
        </div>

        <div class="form-group">
            <label for="company">Company</label>
            <select type="company" class="form-control" placeholder="Choose Company" id="company">
                <option value="" selected disabled hidden>Choose Company</option>
                <c:forEach var="Company" items="${Companys}">
                    <option value="${Company.name}"
                            <c:if test="${Company.name eq Product.company.name}">selected</c:if>>${Company.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="container" align="center">
            <button type="button" class="btn btn-primary" id="btn-product-update">Update</button>
            <button type="button" class="btn btn-warning" onclick="location.href='/product'">Cancel</button>
        </div>
    </form>
</div>
<p></p>
<script src="/js/product.js"></script>
<%@ include file="../layout/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <h2>Create Product</h2>
    <form action="/action_page.php">
        <input type="hidden" id="id" value="${design_info.id}"/>
        <input type="hidden" id="targetProductId" value="${design_info.targetProduct.id}"/>
        <input type="hidden" id="slaveProductId" value="${design_info.slaveProduct.id}"/>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="name" class="form-control" value="${design.productDTO.name}" readonly id="name">
        </div>

        <div class="form-group">
            <label for="standard">Standard</label>
            <input type="standard" class="form-control" value="${design.productDTO.standard}" readonly id="standard">
        </div>

        <div class="form-group">
            <label for="count">Count</label>
            <input type="number" class="form-control" value="${design.count}" placeholder="Input Count" id="count">
        </div>

        <div class="form-group">
            <label for="unit">Unit</label>
            <input type="unit" class="form-control" value="${design.productDTO.unit}" readonly id="unit">
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" class="form-control" value="${design.productDTO.price}" readonly id="price">
        </div>

        <div class="form-group">
            <label for="lossRate">LossRate(%)</label>
            <input type="number" class="form-control" value="${design.lossRate}" placeholder="Input LossRate"
                   id="lossRate">
        </div>

        <div class="form-group">
            <label for="company">Company</label>
            <input type="company" class="form-control" value="${design.productDTO.company}" readonly id="company">
        </div>

        <div class="container" align="center">
            <button type="button" class="btn btn-primary" id="btn-design-update">Update</button>
            <button type="button" class="btn btn-warning" onclick="history.back()">Cancel</button>
        </div>
    </form>
</div>
<p></p>
<script src="/js/design.js"></script>
<%@ include file="../layout/footer.jsp" %>
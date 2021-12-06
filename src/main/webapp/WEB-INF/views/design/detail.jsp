<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../layout/header.jsp" %>
<div class="container">
    <div class="col-sm-6">
        <h2>Target Product</h2>
        <div class="panel panel-default">
            <div class="panel-heading">Name</div>
            <div class="panel-body">${targetProduct.name}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Standard</div>
            <div class="panel-body">${targetProduct.standard}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Unit</div>
            <div class="panel-body">${targetProduct.unit}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Price</div>
            <div class="panel-body">${targetProduct.price}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Company</div>
            <div class="panel-body">${targetProduct.company.name}</div>
        </div>
    </div>
    <div class="col-sm-6">
        <h2>Slave Product</h2>
        <div class="panel panel-default">
            <div class="panel-heading">Name</div>
            <div class="panel-body">${slaveProduct.productDTO.name}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Standard</div>
            <div class="panel-body">${slaveProduct.productDTO.standard}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Unit</div>
            <div class="panel-body">${slaveProduct.productDTO.unit}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Price</div>
            <div class="panel-body">${slaveProduct.productDTO.price}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Company</div>
            <div class="panel-body">${slaveProduct.productDTO.company}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">LossRate(%)</div>
            <div class="panel-body">${slaveProduct.lossRate}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Count</div>
            <div class="panel-body">${slaveProduct.count}</div>
        </div>
    </div>
</div>
<script src="/js/product.js"/>
<script src="/js/design.js"/>
<%@ include file="../layout/footer.jsp" %>
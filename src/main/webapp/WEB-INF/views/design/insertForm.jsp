<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <div class="col-sm-2">
        <h2>Product</h2>
        <input type="hidden" id="id" value="${targetProduct.id}"/>
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
            <div class="panel-body">${Detail.targetProduct.price}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Company</div>
            <div class="panel-body">${Detail.targetProduct.company}</div>
        </div>
    </div>
    <div class="col-sm-5">
        <h2>Current Design</h2>
        <p></p>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Standard</th>
                <th>Unit</th>
                <th>Price</th>
                <th>Company</th>
                <th> </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="SlaveDTO" items="${Detail.slaveProducts}">
                <tr onclick="location.href='/product/${SlaveDTO.slaveProduct}'">
                    <td>${SlaveDTO.slaveProduct}</td>
                    <td>${SlaveDTO.productDTO.name}</td>
                    <td>${SlaveDTO.productDTO.standard}</td>
                    <td>${SlaveDTO.productDTO.unit}</td>
                    <td>${SlaveDTO.productDTO.price}</td>
                    <td>${SlaveDTO.productDTO.company}</td>
                    <td onclick="event.cancelBubble=true">
                        <div class="btn-group">
                            <button id="" type="button" class="btn btn-warning" onclick="location.href='../detail/'">
                                <span class="glyphicon glyphicon-repeat"/>
                            </button>
                            <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-remove"/>
                            </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-sm-5">
        <h2>Add Design</h2>
        <p></p>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Standard</th>
                <th>Unit</th>
                <th>Price</th>
                <th>Company</th>
                <th> </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="SlaveDTO" items="${Detail.slaveProducts}">
                <tr onclick="location.href='/product/${SlaveDTO.slaveProduct}'">
                    <td>${SlaveDTO.slaveProduct}</td>
                    <td>${SlaveDTO.productDTO.name}</td>
                    <td>${SlaveDTO.productDTO.standard}</td>
                    <td>${SlaveDTO.productDTO.unit}</td>
                    <td>${SlaveDTO.productDTO.price}</td>
                    <td>${SlaveDTO.productDTO.company}</td>
                    <td onclick="event.cancelBubble=true">
                        <div class="btn-group">
                            <button id="" type="button" class="btn btn-warning" onclick="location.href='../detail/'">
                                <span class="glyphicon glyphicon-repeat"/>
                            </button>
                            <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-remove"/>
                            </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<p></p>
<script src="/js/design.js"></script>
<%@ include file="../layout/footer.jsp" %>
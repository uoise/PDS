<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../layout/header.jsp" %>


<div class="container">
    <div class="col-sm-4">
        <h2>Product</h2>
        <button type="button" class="btn btn-warning"
                onclick="location.href='/product/updateform/${Detail.targetProduct.id}'">Modify
        </button>
        <button type="button" class="btn btn-danger" id="btn-product-delete">Delete</button>
        <p></p>
        <input type="hidden" id="id" value="${Detail.targetProduct.id}"/>
        <div class="panel panel-default">
            <div class="panel-heading">Name</div>
            <div class="panel-body">${Detail.targetProduct.name}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Standard</div>
            <div class="panel-body">${Detail.targetProduct.standard}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Unit</div>
            <div class="panel-body">${Detail.targetProduct.unit}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Price</div>
            <div class="panel-body">${Detail.targetProduct.price}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">Company</div>
            <div class="panel-body">${Detail.targetProduct.company}</div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">CreateUser</div>
            <div class="panel-body">${Detail.targetProduct.createUser}</div>
        </div>
    </div>
    <div class="col-sm-8">
        <h2>Designs</h2>
        <p></p>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Add Design</button>
        <button type="button" class="btn btn-warning" id="btn-design-update-redirect">Modify Design</button>
        <button type="button" class="btn btn-danger" id="btn-design-delete">Delete Design</button>
        <table class="table table-hover">
            <thead>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Standard</th>
                <th>Company</th>
                <th>Count</th>
                <th>Unit</th>
                <th>Price</th>
                <th>lossRate(%)</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="SlaveDTO" items="${Detail.slaveProducts}">
                <tr onclick="location.href='/product/${SlaveDTO.productDTO.id}'">
                    <td onclick="event.cancelBubble=true">
                        <input type="radio" id="selectedDesign" name="designRow" value="${SlaveDTO.id}">
                    </td>
                    <td>${SlaveDTO.productDTO.name}</td>
                    <td>${SlaveDTO.productDTO.standard}</td>
                    <td>${SlaveDTO.productDTO.company}</td>
                    <td>${SlaveDTO.count}</td>
                    <td>${SlaveDTO.productDTO.unit}</td>
                    <td>${SlaveDTO.productDTO.price}</td>
                    <td>${SlaveDTO.lossRate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Design Total</div>
                    <div class="panel-body">${Detail.total}</div>
                </div>
            </div>
            <div class="col-sm-4">
            <c:choose>
                <c:when test="${(Detail.targetProduct.price - Detail.total) lt 0}">

                    <div class="panel panel-danger">
                        <div class="panel-heading">Total Compare</div>
                        <div class="panel-body">${Detail.targetProduct.price - Detail.total}</div>
                    </div>
                </c:when>
                <c:when test="${(Detail.targetProduct.price - Detail.total) ge 0}">
                    <div class="panel panel-default">
                        <div class="panel-heading">Total Compare</div>
                        <div class="panel-body">${Detail.targetProduct.price - Detail.total}</div>
                    </div>
                </c:when>
            </c:choose>
            </div>
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Loss Total</div>
                    <div class="panel-body">${Detail.lossTotal}</div>
                </div>
            </div>
        </div>
    </div>


    <!-- Modal -->
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add Design</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Standard</th>
                            <th>Unit</th>
                            <th>Price</th>
                            <th>Comapny</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="Product" items="${Products}">
                            <tr>
                                <td>
                                    <input type="radio" id="selectedProduct" name="modalRow" value="${Product.id}">
                                </td>
                                <td>${Product.id}</td>
                                <td>${Product.name}</td>
                                <td>${Product.standard}</td>
                                <td>${Product.unit}</td>
                                <td>${Product.price}</td>
                                <td>${Product.company.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div>
                        <label for="count">Count</label>
                        <input type="number" placeholder="input count" id="count">
                        <label for="lossRate">LossRate(%)</label>
                        <input type="number" placeholder="input lossRate(%)" id="lossRate">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="btn-design-add">Add</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="/js/product.js"></script>
<script src="/js/design.js"></script>
<%@ include file="../layout/footer.jsp" %>
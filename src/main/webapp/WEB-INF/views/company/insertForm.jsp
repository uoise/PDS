<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <h2>Create Company</h2>
    <form>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="name" class="form-control" placeholder="Input Name" id="name">
        </div>

        <div class="container" align="center">
        <button type="button" class="btn btn-primary" id="btn-company-save">Create</button>
        <button type="button" class="btn btn-warning" onclick="location.href='/company'">Cancel</button>
        </div>
    </form>
</div>
<p></p>
<script src="/js/company.js"></script>
<%@ include file="../layout/footer.jsp" %>
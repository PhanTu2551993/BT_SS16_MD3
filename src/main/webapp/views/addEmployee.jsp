<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>INSERT EMPLOYEE</h1>
    <form:form action="insertEmployee" modelAttribute="e" method="post">
        <div class="mb-3">
            <label for="empId" class="form-label">Employee Id</label>
            <form:input path="empId" class="form-control" id="empId"/>
        </div>
        <div class="mb-3">
            <label for="empName" class="form-label">Employee Name</label>
            <form:input path="empName" class="form-control" id="empName"/>
        </div>
        <div class="mb-3">
            <label for="dob" class="form-label">Birthday</label>
            <form:input path="dob" class="form-control" id="dob" type="date"/>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <form:textarea path="address" class="form-control" id="address"/>
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Phone</label>
            <form:input path="phone" class="form-control" id="phone"/>
        </div>
        <button type="submit" class="btn btn-primary">Insert</button>
        <button type="reset" class="btn btn-secondary">Clear</button>
    </form:form>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
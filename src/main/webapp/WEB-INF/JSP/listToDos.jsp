<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%-- For Spring Boot 3+ --%>
<%-- If using Spring Boot 2.x, replace above line with:
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>

<%@ include file="common/headers.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Your Todos are</h1>
    <table class="table">
        <thead>
        <tr>
            <th></th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th>DELETE button</th>
            <th>Update Button</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete ${todo.id}</a></td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update ${todo.id}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>


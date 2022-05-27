
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
    <div class="container-fluid text-center">
        <div>
            <form action="/addStudent" method="post">
                <table class="table table-bordered">
                    <c:if test="${not empty stu.id}">
                        <tr>
                            <td>Student Id:</td>
                            <td><input type="text" name="id" value="${stu.id}" /></td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>Student Name:</td>
                        <td><input type="text" name="name" value="${stu.name}" /></td>
                    </tr>
                    <tr>
                        <td>Student Address:</td>
                        <td><input type="text" name="address" value="${stu.address}" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit" /></td>

                    </tr>
                </table>
            </form>
        </div>
    </div>

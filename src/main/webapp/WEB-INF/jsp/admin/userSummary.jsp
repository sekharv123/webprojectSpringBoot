<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  
<div class="container-fluid">
    <div class="text-right"><a href="/home">Home</a></div>
        <div>
            <table class="table table-striped table-bordered">
                <thead>
                    <tr class="info">
                        <th>UserName</th>
                        <th>Password</th>
                        <th>Role</th>
                   </tr>

                </thead>
                <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>
                                <c:out value="${user.username}" />
                            </td>
                            <td>
                                <c:out value="${user.password}" />
                            </td>
                            <td>
                                <c:out value="${user.role}" />
                            </td>

                       </tr>
                    </c:forEach>


                </tbody>

            </table>

        </div>
    </div>

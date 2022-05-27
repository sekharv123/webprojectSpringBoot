<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
  
<div class="container-fluid">
    <sec:authorize access="hasRole('ADMIN')">
        <c:if test="${fn:length(stlist) gt 1}">
            <div class="text-right"><a href="/deleteAll">Delete All Students</a></div>
        </c:if> 
    </sec:authorize>
        <div>
            <table class="table table-striped table-bordered">
                <thead>
                    <tr class="info">
                        <th>Id</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach var="st" items="${stlist}">
                        <tr>
                            <td>
                                <c:out value="${st.id}" />
                            </td>
                            <td>
                                <c:out value="${st.name}" />
                            </td>
                            <td>
                                <c:out value="${st.address}" />
                            </td>
                            <td><a href="/update/${st.id}">Update</a></td>
                            <td><a href="/delete?id=${st.id}">Delete</a></td>
                        </tr>
                    </c:forEach>


                </tbody>

            </table>

        </div>
    </div>

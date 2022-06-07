<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<div class="container-fluid bg-success">                 
    <div class="text-center" id="titleLabel">
        <h1 style="color:blue;">Student mgmt system</h1>
    </div>
    <sec:authorize access="hasRole('ADMIN')">
        <div class="text-center"><a href="/create">Create Student</a></div>
        <div class="text-right"><a href="/users">Manage Users</a></div>
    </sec:authorize>
    <br>
    <div class="text-right">Welcome, <b>${pageContext.request.remoteUser}</b></div>
    <div class="text-right"><a href="/logout">Logout</a></div>

</div>
<script>
    document.getElementById("titleLabel").onclick = function(){
        window.location.href="/home";
        };
</script>

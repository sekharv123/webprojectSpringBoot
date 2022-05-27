
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
    <div class="container-fluid text-center">
        <div class="text-center">
            <h2>Register new user</h2>
        </div>
        <div>
            <form action="/addUser" method="post">
                <table class="table table-bordered">
                    
                    <tr>
                        <td>User Name:</td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td>Role:</td>
                        <td><input type="text" name="role" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Register" /></td>

                    </tr>
                </table>
            </form>
        </div>
    </div>

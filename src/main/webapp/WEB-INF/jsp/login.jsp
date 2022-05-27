
    <div class="container-fluid text-center">
       <div class="text-center">
           <h2>Login to SMS</h2>
       </div>
        <div>
            <form name='loginForm' id="loginForm" action="/login" method='POST'>
              
              <table class="table table-bordered">
                <span style="color: red;">${msg}</span>
                <tr>
                  <td>UserName:</td>
                  <td><input type='text' name='username' value=''></td>
                </tr>
                <tr>
                  <td>Password:</td>
                  <td><input type='password' name='password' /></td>
                </tr>
                <tr>
                  <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
                </tr>
                <span style="color: red;">${errorMsg}</span>
              </table>
              
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>
    <script>
      $(document).ready(function() {
              
        $('#loginForm').validate({
            rules: {
              username: "required",
              password: "required"
            },
            messages: {
              username: "Please enter user name",
              password: "Please enter password"
    
            },
            submitHandler: function(form) {
                form.submit();
            }
    
            // any other options and/or rules
        });
      });
    </script>
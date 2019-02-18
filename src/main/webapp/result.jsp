<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Result
</h1>
<%
boolean result= (Boolean) request.getAttribute("result");
if(result == true){
    out.println("Login Successful");
} else{
    out.println("Login Failed");
}

%>
</body>
</html>
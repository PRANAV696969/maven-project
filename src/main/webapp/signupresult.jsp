<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Result
</h1>
<%

boolean rowInserted= (Boolean) request.getAttribute("rowInserted");
if(rowInserted == true){
    out.println("SignUp Successful");
} else{
    out.println("SignUp Failed");
}
%>
</body>
</html>
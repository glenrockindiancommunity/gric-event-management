<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>
<div id="mainWrapper">
    <div>
        <div>
            <div>
                <c:url var="loginUrl" value="/login" />
                <form action="${loginUrl}" method="post">
                    <c:if test="${param.error != null}">
                        <div>
                            <p>Invalid username and password.</p>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div>
                            <p>You have been logged out successfully.</p>
                        </div>
                    </c:if>
                    <div>
                        <label for="username"></label>
                        <input type="text" id="username" name="username" placeholder="Enter Username" required>
                    </div>
                    <div>
                        <label for="password"></label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />

                    <div>
                        <input type="submit" value="Log in">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
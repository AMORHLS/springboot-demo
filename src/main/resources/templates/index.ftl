<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Hello World!</title>
    </head>
    <body>
        <br>
        <br>
       <#-- <#if msg??>
            ${msg}
        </#if>
        <#if username??>
            Welcome ${username}!
        </#if>-->
        Welcome ${username}!
        ${msg}

        <br>
        <br>
        <br>
        <br>
        <br>

    </body>
</html>
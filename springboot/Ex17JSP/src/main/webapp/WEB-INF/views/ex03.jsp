<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP심볼들</title>
</head>
<body>
    <%!
        int globalVar = 10;
        public int sum(int a, int b){
            return a+b;
        }
    %>
    <%
        //스크립트릿: jsp안의 자바 코드
        String title = "java coding";
        System.out.println(title);
    %>

    전역변수 : <%=globalVar %> <br>
    타이틀 문자열: <%= title %> <br>
    합계 함수: <%= sum(10, 20) %>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko" >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보 보기/수정</title>
    <script>
        function checkValue(){ //required태그로 대체 가능
            //empty, null, 길이0 체크
            if(!document.userInfo.userId.value){//name으로 작성하면 document.~~ 안 써도 됨
                alert("아이디를 입력하세요.");
                document.getElementById('userId').focus();
                return false; //form태그의 submit 통신이 막힘
            } 
            // if(!document.userInfo.userPw.value){ //required로 대체함
            //     alert("암호를 입력하세요.");
            //     document.getElementById('userPw').focus();
            //     return false; //form태그의 submit 통신이 막힘
            // } 
            return true;
        }
    </script>
</head>
<body>
    <h2>회원 정보 보기/수정 화면</h2>
    <form action="/modifyAction" method="post" name="userInfo" onsubmit="return checkValue();">
        <input value="${member.id}" type="hidden" name="id" id="id"/>
        <input value="${member.userRole}" type="hidden" name="userRole" id="userRole"/>
        <table border="1">
            <tr>
                <td>아이디</td>
                <td>
                    <input value="${member.userId}" type="text" name="userId" id="userId" maxlength="20" />
                </td>
            </tr>
            <tr>
                <td>비번</td>
                <td>
                    <input value="${member.userPw}"type="text" name="userPw" id="userPw" maxlength="20" required/>
                </td>
            </tr>
            <tr>
                <td>이름</td>
                <td>
                    <input value="${member.userName}" type="text" name="userName" id="userName" maxlength="50" />
                </td>
            </tr>
            <tr>
                <td>가입일자</td>
                <td>
                    <input value="${member.joinDate}"type="date" name="joinDate" id="joinDate"/>
                </td>
            </tr>
            <tr>
                <td>권한</td>
                <td>
                    <label for="userRole"> 권한을 선택해주세요.</label>
                        <select name="userRole" required>
                            <option value="ROLE_USER" 
                                <c:if test="${member.userRole eq 'ROLE_USER'}">selected</c:if>
                            >일반회원</option>
                            <option value="ROLE_ADMIN"
                                <c:if test="${member.userRole eq 'ROLE_ADMIN'}">selected</c:if>
                            >관리자</option>
                        </select>
                    
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">회원 정보 수정</button>
                    <button type="button" formaction="/list">회원 목록</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
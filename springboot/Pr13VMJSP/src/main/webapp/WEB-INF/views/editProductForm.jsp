<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko" >
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>자판기 상품 수정</title>
    <!-- 스타일시트 연결하기 -->
    <link href="./index4.css" rel="stylesheet" type="text/css" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!--  부트스트랩 CDN 링크 -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"
    />
  </head>
  <body style="background-color: black">
    <div class="wrap">
      <div class="container">
        <div class="title-box">
          <h2 class="title fw-bold">자판기 상품 수정</h2>
        </div>

        <form action="/editProduct" method="post">
          <!-- 인덱스 생성 -->
          <input type="hidden" name="index" value="${index}" />
          <!-- 상품명 -->
          <div class="form-group">
            <label for="inputName" class="text-white">상품명:</label>
            <input
              type="text"
              class="form-control"
              id="inputName"
              name="inputName"
              value="${products.name}"
              required
            />
          </div>

          <!-- 가격 -->
          <div class="form-group">
            <label for="inputPrice" class="text-white">가격:</label>
            <input
              type="number"
              class="form-control"
              id="inputPrice"
              name="inputPrice"
              value="${products.price}"
              required
            />
          </div>

          <!-- 유통기한 -->
          <div class="form-group">
            <label for="inputLimitDate" class="text-white">유통기한:</label>
            <input
              type="text"
              class="form-control datepicker"
              id="inputLimitDate"
              name="inputLimitDate"
              value="${products.limit_date}"
              required
            />
          </div>

          <!-- 상품 추가 -->
          <div class="addButton">
            <button
              type="submit"
              class="btn btn-dark"
            >
              상품 수정 완료!
            </button>
            <button
              type="button"
              onclick="history.back();"
              class="btn btn-light"
            >
              돌아가기
            </button>
          </div>
        </form>
      </div>
    </div>

    <!--  부트스트랩 CDN 링크 -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.kr.min.js"></script>
    <script>
      $(document).ready(function () {
        $(".datepicker").datepicker({
          format: "yyyy-mm-dd", // 날짜 형식 설정
          language: "kr", // 언어 설정 (한국어)
          autoclose: true, // 선택 후 자동으로 닫힘
        });
      });
    </script>
  </body>
</html>

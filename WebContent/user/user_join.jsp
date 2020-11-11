<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<!--회원가입 폼만 적용되는 css-->
<style type="text/css">
    .table-striped>tbody>tr {
        background-color: #f9f9f9
    }

    .join-form {
        margin: 0 auto;
        padding: 20px;
        width: 50%;
        float: none;
        background-color: white;
    }
    
    
    .form-group > .sel {
        width: 120px;
        display: inline-block;
        
    }
</style>
<section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2 align="center">회원가입<small>(가운데정렬)</small></h2>

                    <form action="joinForm.user" method="post" name="regForm">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" id="id" name = "id" placeholder="아이디를 (영문포함 4~12자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호 (영 대/소문자, 숫자, 특수문자 3종류 이상 조합 8자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password-confrim">비밀번호 확인</label>
                            <input type="password" class="form-control" id="pw-confrim" name="pw_check" placeholder="비밀번호를 확인해주세요.">
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요.">
                        </div>
                        <!--input2탭의 input-addon을 가져온다 -->
                        <div class="form-group">
                            <label for="hp">휴대폰번호</label><br>
                            
                            <input class="form-control sel" name="phone_first" placeholder="010"> -
                            <input class="form-control sel" name="phone_second" placeholder="xxxx"> -
                            <input class="form-control sel" name="phone_third" placeholder="xxxx">
                        
                        </div>
                        <div class="form-group">
                             <label for="hp">이메일</label><br>
                            <input class="form-control sel" name="email">@
                            <select class="form-control sel" name="email_provider">
                                <option>naver.com</option>
                                <option>gmail.com</option>
                                <option>daum.net</option>
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <label for="addr-num">주소</label>
                            <input type="text" class="form-control" id="addr-basic" name="address" placeholder="기본주소">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="addr-detail" name="address_detail" placeholder="상세주소">
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" onclick="submit()">회원가입</button>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block" onclick="location.href='<%=request.getContextPath()%>/login.user'">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    
    <script>
    	function click() {
    		document.regForm.submit();
    	}
    </script>
    
</body>

</html>
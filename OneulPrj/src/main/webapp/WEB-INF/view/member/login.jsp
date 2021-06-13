<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <main>
        <div class="login-box">
            <form class="login-form" method="post">
                <h2 class="login-title">로그인</h2>
                <ul>
                    <li>
                        <input type="text" name="username" placeholder="ID"/>
                    </li>
                    <li>
                        <input type="password" name="password" placeholder="Password"/>
                    </li>
                    <li>
                        <input class="btn-submit" type="submit" value="LOGIN">
                    </li>
                </ul>
            </form>
            <ul class="login-option">
                <a href="signup">회원가입</a>
                <a href="">아이디 찾기</a>
                <a href="">비밀번호 찾기</a>
            </ul>
        </div>
    </main>
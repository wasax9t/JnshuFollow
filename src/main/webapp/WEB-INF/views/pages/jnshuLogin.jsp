<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<script type="text/javascript">

    var curCount;//time left

    $(document).ready(function () {

        $("#loginOrReg").click(function () {
            $(".login").toggle();
            $(".register").toggle();
        });

        $("#getVerificationCode").click(function () {

            var phoneNumber = $("#phoneNumber").val();
            // 设置button效果，开始计时
            curCount=120;
            $("#getVerificationCode").attr("disabled", "true");
            $("#getVerificationCode").text("请在" + curCount + "秒内输入验证码");
            InterValObj = window.setInterval(SetRemainTime, 1000);//每1000ms自动执行
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/action/verificationCode",
                dataType: "json",
                data: {
                    phoneNumber: phoneNumber
                },
                success: function (data) {
                    alert(data);
                }
            });
        });

    });

    function SetRemainTime() {
        if (curCount < 1) {
            window.clearInterval(InterValObj);// 停止计时器
            $("#getVerificationCode").removeAttr("disabled");// 启用按钮
            $("#getVerificationCode").text("重新发送验证码");
        }else {
            curCount--;
            $("#getVerificationCode").text("请在" + curCount + "秒内输入验证码");
        }
    }

    function validate_form(thisform) {

        for (var i = 0; i < thisform.elements.length; i++) {
            if ((thisform.elements[i].type == "text" || thisform.elements[i].type == "password") && thisform.elements[i].value == "") {
                alert(thisform.elements[i].name + "不能为空啦！");
                return false;
            }
        }

        with (thisform) {
//            if(checkUsername(username) == false){
//                alert("用户名已存在");
//                return false;
//            }
            //邮箱做格式判断
            if (checkemail(email) == false) {
                email.focus();
                return false;
            }
        }
        return true;
    }
//    function checkUsername(username) {
//        alert(username);
//        $.ajax({
//            type: "post",
//            url: "/action/checkUsername",
//            dataType: "json",
//            data: {
//                username: username
//            },
//            success: function (data) {
//                alert(data);
//                return data;
//            }
//        });
//    }
    function checkemail(field) {
        var regex = /^[0-9a-zA-Z]*\@[0-9a-zA-Z]*\.com$/;
        with (field) {
            if (regex.test(value) == true) {
                //格式正确
                return true;
            } else {
                //格式错误
                alert("邮箱格式错了哦");
                return false;
            }
        }
    }
</script>

<div class=L&R>

    <button id=loginOrReg>登陆/注册</button>

    <div class="login" style="display: block">
        <h2>用户登陆</h2>
        <form action="doLogin" method="post">
            用户名：<br/> <input type="text" name="username"/> <br/> 密码：<br/>
            <input type="password" name="password"/> <br/> <input
                name="remember-me" type="checkbox"/>30天内自动登录 <br/> <input
                type="submit" value="登录"/>
        </form>

    </div>
    <div class="register" style="display: none">
        <h2>用户注册</h2>
        <form action="doRegister" method="post"
              onsubmit="return validate_form(this)">
            <div>
                <input type="text" name="username" id="username"
                       placeholder="请输入用户名"/>
            </div>
            <div>
                <input type="password" name="password" id="password"
                       placeholder="请输入密码"/>
            </div>
            <div>
                <input type="text" name="email" id="email" placeholder="请输入邮箱"/>
            </div>
            <div>
                <input type="text" name="phoneNumber" id="phoneNumber"
                       placeholder="请输入手机号"/>
                <button id=getVerificationCode type="button">获得验证码</button>
            </div>
            <div>
                <input type="text" name="verificationCode" id="verificationCode"
                       placeholder="请输入验证码"/>
            </div>
            <div>
                <button id=doRegister type="submit">注册</button>
            </div>
        </form>
    </div>
</div>


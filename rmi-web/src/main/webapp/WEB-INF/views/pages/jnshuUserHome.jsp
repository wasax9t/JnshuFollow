<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<script type="text/javascript" src="/static/js/plupload.dev.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#sendEmail").click(function () {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/action/sendEmail",
                dataType: "json",
                data: {
                    email: "wasax9t@126.com"
                },
                success: function (data) {
                    alert(data);
                }
            });
        });

        $("#aliyunOSS").click(function () {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/action/aliyunOSS",
                dataType: "json",
                data: {},
                success: function (data) {
                    alert(data);
                }
            });
        });
    })
</script>

<div class="login">
    <h2>登陆成功,User: ${user.name}</h2>
    welcome to user home page!<br/>
    告诉你一个秘密，下面一丢丢还有一个看不到的退出登陆的按钮，因为这个css下字是白的，而我不会css<br/>
    好消息，我新建了一个css的class选择器，指定了a的颜色，不居中了？who cares<br/>
    <a href="${pageContext.request.contextPath}/logout">退出登录</a>
    <button id="sendEmail" type="button">点我发邮件，会返回sendCloud API的返回值</button>
</div>
<div class="row" style="margin-top: 20px;">
    <input type="hidden" id="domain" value="http://7xocov.com1.z0.glb.clouddn.com/">
    <input type="hidden" id="uptoken_url" value="uptoken">
    <ul class="tip col-md-12 text-mute">
        <li>
            <small>
                JavaScript SDK 基于 Plupload 开发，可以通过 Html5 或 Flash 等模式上传文件至七牛云存储。
            </small>
        </li>
        <li>
            <small>临时上传的空间不定时清空，请勿保存重要文件。</small>
        </li>
        <li>
            <small>Html5模式大于4M文件采用分块上传。</small>
        </li>
        <li>
            <small>上传图片可查看处理效果。</small>
        </li>
        <li>
            <small>本示例限制最大上传文件100M。</small>
        </li>
        <li>
            <small>七牛的JS前端上传不会弄，暂时没用</small>
        </li>
    </ul>
    <div class="col-md-12">
        <div id="container">
            <a class="btn btn-default btn-lg " id="pickfiles" href="#" >
                <i class="glyphicon glyphicon-plus"></i>
                <span>选择文件</span>
            </a>
        </div>
    </div>
</div>
<div>
    <ul>
        <li>
            <b>来试试阿里的OSS吧</b>
        </li>
        <li>
            <button id="aliyunOSS" type="button">试试吧！</button>
        </li>
    </ul>
</div>

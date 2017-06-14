<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<script type="text/javascript" src="/static/js/plupload.dev.js"></script>
<script type="text/javascript" src="/static/js/qiniu.min.js"></script>
<script type="text/javascript" src="/static/js/moxie.js"></script>
<script type="text/javascript" src="/static/js/main.js"></script>
<script type="text/javascript" src="/static/js/ui.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#sendEmail").click(function () {
            $.ajax({
                type: "post",
                url: "/action/sendEmail",
                dataType: "json",
                data: {
                    email: "wasax9t@126.com"
                },
                success: function (data) {
                    alert(data);
                }
            });
        });
        $("#pickfiles").click(function () {
            alert("点了按钮");
            uploader.init
        })
    })

    var progress1;
    var waikuang;
    var img;
    var span;
    var flag = 0;
    var uploader = Qiniu.uploader({
        runtimes: 'html5,flash,html4',    //上传模式,依次退化
        browse_button: 'pickfiles',       //上传选择的点选按钮，**必需**
        uptoken_url: '/action/qiniuToken',            //Ajax请求upToken的Url，**强烈建议设置**（服务端提供）
        // uptoken : '', //若未指定uptoken_url,则必须指定 uptoken ,uptoken由其他程序生成
        // unique_names: true, // 默认 false，key为文件名。若开启该选项，SDK为自动生成上传成功后的key（文件名）。
        // save_key: true,   // 默认 false。若在服务端生成uptoken的上传策略中指定了 `sava_key`，则开启，SDK会忽略对key的处理
        domain: 'http://qiniu-plupload.qiniudn.com/',   //bucket 域名，下载资源时用到，**必需**
        get_new_uptoken: false,  //设置上传文件的时候是否每次都重新获取新的token
        container: 'container',           //上传区域DOM ID，默认是browser_button的父元素，
        max_file_size: '10mb',           //最大文件体积限制
//        flash_swf_url: 'js/plupload/Moxie.swf',  //引入flash,相对路径
        max_retries: 3,                   //上传失败最大重试次数
        dragdrop: true,                   //开启可拖曳上传
        drop_element: 'container',        //拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
        chunk_size: '4mb',                //分块上传时，每片的体积
        auto_start: true,                 //选择文件后自动上传，若关闭需要自己绑定事件触发上传
        init: {
            'FilesAdded': function(up, files) {
                plupload.each(files, function(file) {
                    // 文件添加进队列后,处理相关的事情
                    waikuang = document.createElement("a");
                    waikuang.className = "showPic";
                    waikuang.id=file.name+"hmsg"

                    img= document.createElement("img");
                    span = document.createElement("span");
                    span.className = "closePic";
                    waikuang.appendChild(img);
                    img.style.zIndex=10;
                    waikuang.appendChild(span);
                    progress1 = document.createElement("progress");
                    progress1.max = 100;
                    waikuang.appendChild(progress1);
                    document.getElementById("container").appendChild(waikuang);
                });
            },
            'BeforeUpload': function(up, file) {
                // 每个文件上传前,处理相关的事情
            },
            'UploadProgress': function(up, file) {
                // 每个文件上传时,处理相关的事情
            },
            'FileUploaded': function(up, file, info) {
                // 每个文件上传成功后,处理相关的事情
                // 其中 info 是文件上传成功后，服务端返回的json，形式如
                // {
                //    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
                //    "key": "gogopher.jpg"
                //  }
                // 参考http://developer.qiniu.com/docs/v6/api/overview/up/response/simple-response.html

                // var domain = up.getOption('domain');
                // var res = parseJSON(info);
                // var sourceLink = domain + res.key; 获取上传成功后的文件的Url
            },
            'Error': function(up, err, errTip) {
                alert(err);
                alert(errTip)
            },
            'UploadComplete': function() {
                //队列文件处理完毕后,处理相关的事情
            },
            'Key': function(up, file) {
                // 若想在前端对每个文件的key进行个性化处理，可以配置该函数
                // 该配置必须要在 unique_names: false , save_key: false 时才生效

                var key = "";
                // do something with key here
                return key
            }
        }
    });
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
    </ul>
    <div class="col-md-12">
        <div id="container">
            <a class="btn btn-default btn-lg " id="pickfiles" href="#" >
                <i class="glyphicon glyphicon-plus"></i>
                <span>选择文件</span>
            </a>
        </div>
    </div>
    <div style="display:none" id="success" class="col-md-12">
        <div class="alert-success">
            队列全部文件处理完毕
        </div>
    </div>
    <div class="col-md-12 ">
        <table class="table table-striped table-hover text-left"   style="margin-top:40px;display:none">
            <thead>
            <tr>
                <th class="col-md-4">Filename</th>
                <th class="col-md-2">Size</th>
                <th class="col-md-6">Detail</th>
            </tr>
            </thead>
            <tbody id="fsUploadProgress">
            </tbody>
        </table>
    </div>
</div>

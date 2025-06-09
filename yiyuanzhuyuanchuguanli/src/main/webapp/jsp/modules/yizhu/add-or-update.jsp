<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑医嘱</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">医嘱管理</li>
                        <li class="breadcrumb-item active">编辑医嘱</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">医嘱信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6">
                                        <label>病人管理</label>
                                        <div>
                                            <select id="bingrenSelect" name="bingrenSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>病人名称</label>
                                        <input id="bingrenName" name="bingrenName" class="form-control"
                                               placeholder="病人名称" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>性别</label>
                                        <input id="sexValue" name="sexValue" class="form-control"
                                               placeholder="性别" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>年龄</label>
                                        <input id="bingrenAge" name="bingrenAge" class="form-control"
                                               placeholder="年龄" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>家属联系方式</label>
                                        <input id="bingrenPhone" name="bingrenPhone" class="form-control"
                                               placeholder="家属联系方式" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>患病类型</label>
                                        <input id="huanbingValue" name="huanbingValue" class="form-control"
                                               placeholder="患病类型" readonly>
                                    </div>
                                    <div class="form-group col-md-6" style="display:none;">
                                        <label>医生</label>
                                        <div>
                                            <select id="yishengSelect" name="yishengSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>负责医生姓名</label>
                                        <input id="yishengName" name="yishengName" class="form-control"
                                               placeholder="负责医生姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>医生身份证号</label>
                                        <input id="yishengIdNumber" name="yishengIdNumber" class="form-control"
                                               placeholder="身份证号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>医生手机号</label>
                                        <input id="yishengPhone" name="yishengPhone" class="form-control"
                                               placeholder="手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>医生头像</label>
                                        <img id="yishengPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div id="yonghuDiv1">
                                        <div class="form-group col-md-6">
                                            <label>护士</label>
                                            <div>
                                                <select id="yonghuSelect" name="yonghuSelect"
                                                        class="selectpicker form-control"  data-live-search="true"
                                                        title="请选择" data-header="请选择" data-size="5">
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>姓名</label>
                                            <input id="yonghuName" name="yonghuName" class="form-control"
                                                   placeholder="姓名" readonly>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>身份证号</label>
                                            <input id="yonghuIdNumber" name="yonghuIdNumber" class="form-control"
                                                   placeholder="身份证号" readonly>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>手机号</label>
                                            <input id="yonghuPhone" name="yonghuPhone" class="form-control"
                                                   placeholder="手机号" readonly>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>照片</label>
                                            <img id="yonghuPhotoImg" src="" width="100" height="100">
                                        </div>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="yishengId" name="yishengId" type="hidden">
                                <input id="bingrenId" name="bingrenId" type="hidden">
                                <input id="yonghuId" name="yonghuId" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>医嘱类型名称</label>
                                        <select id="yizhuTypesSelect" name="yizhuTypes" class="form-control">
                                        </select>
                                    </div>
                                    <div class="form-group  col-md-6">
                                        <label>医嘱内容</label>
                                        <input id="zhuyuanfeiyongContentupload" name="file" type="file">
                                        <script id="zhuyuanfeiyongContentEditor" type="text/plain"
                                                style="width:100%;height:230px;"></script>
                                        <script type = "text/javascript" >
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        //相见文档配置属于你自己的编译器
                                        var zhuyuanfeiyongContentUe = UE.getEditor('zhuyuanfeiyongContentEditor', {
                                            toolbars: [
                                                [
                                                    'undo', //撤销
                                                    'bold', //加粗
                                                    'redo', //重做
                                                    'underline', //下划线
                                                    'horizontal', //分隔线
                                                    'inserttitle', //插入标题
                                                    'cleardoc', //清空文档
                                                    'fontfamily', //字体
                                                    'fontsize', //字号
                                                    'paragraph', //段落格式
                                                    'inserttable', //插入表格
                                                    'justifyleft', //居左对齐
                                                    'justifyright', //居右对齐
                                                    'justifycenter', //居中对
                                                    'justifyjustify', //两端对齐
                                                    'forecolor', //字体颜色
                                                    'fullscreen', //全屏
                                                    'edittip ', //编辑提示
                                                    'customstyle', //自定义标题
                                                ]
                                            ]
                                        });
                                        </script>
                                        <input type="hidden" name="zhuyuanfeiyongContent" id="zhuyuanfeiyongContent-input">
                                    </div>
                                    <div class="form-group col-md-12 mb-3">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
</script><script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "yizhu";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var yizhuTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var bingrenOptions = [];
    var yishengOptions = [];
    var yonghuOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

        $('#zhuyuanfeiyongContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('zhuyuanfeiyongContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#yishengId") !=null){
               var yishengId = $("#yishengId").val();
               if(yishengId == null || yishengId =='' || yishengId == 'null'){
                   alert("发布医生不能为空");
                   return;
               }
           }
           if($("#bingrenId") !=null){
               var bingrenId = $("#bingrenId").val();
               if(bingrenId == null || bingrenId =='' || bingrenId == 'null'){
                   alert("接收病人不能为空");
                   return;
               }
           }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';
            }
            httpJson("yizhu/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addyizhu');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function yizhuTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=yizhu_types", "GET", {}, (res) => {
                if(res.code == 0){
                    yizhuTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function bingrenSelect() {
            //填充下拉框选项
            http("bingren/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    bingrenOptions = res.data.list;
                }
            });
        }

        function bingrenSelectOne(id) {
            http("bingren/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                bingrenShowImg();
                bingrenShowVideo();
                bingrenDataBind();
            }
        });
        }
        function yishengSelect() {
            //填充下拉框选项
            http("yisheng/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    yishengOptions = res.data.list;
                }
            });
        }

        function yishengSelectOne(id) {
            http("yisheng/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                yishengShowImg();
                yishengShowVideo();
                yishengDataBind();
            }
        });
        }
        function yonghuSelect() {
            //填充下拉框选项
            http("yonghu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    yonghuOptions = res.data.list;
                }
            });
        }

        function yonghuSelectOne(id) {
            http("yonghu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                yonghuShowImg();
                yonghuShowVideo();
                yonghuDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationYizhutypesSelect(){
            var yizhuTypesSelect = document.getElementById('yizhuTypesSelect');
            if(yizhuTypesSelect != null && yizhuTypesOptions != null  && yizhuTypesOptions.length > 0 ){
                for (var i = 0; i < yizhuTypesOptions.length; i++) {
                    yizhuTypesSelect.add(new Option(yizhuTypesOptions[i].indexName,yizhuTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationbingrenSelect() {
            var bingrenSelect = document.getElementById('bingrenSelect');
            if(bingrenSelect != null && bingrenOptions != null  && bingrenOptions.length > 0 ) {
                for (var i = 0; i < bingrenOptions.length; i++) {
                        bingrenSelect.add(new Option(bingrenOptions[i].bingrenName, bingrenOptions[i].id));
                }

                $("#bingrenSelect").change(function(e) {
                        bingrenSelectOne(e.target.value);
                });
            }

        }

        function initializationyishengSelect() {
            var yishengSelect = document.getElementById('yishengSelect');
            if(yishengSelect != null && yishengOptions != null  && yishengOptions.length > 0 ) {
                for (var i = 0; i < yishengOptions.length; i++) {
                        yishengSelect.add(new Option(yishengOptions[i].yishengName, yishengOptions[i].id));
                }

                $("#yishengSelect").change(function(e) {
                        //yishengSelectOne(e.target.value);
                });
            }

        }

        function initializationyonghuSelect() {
            var yonghuSelect = document.getElementById('yonghuSelect');
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                        yonghuSelect.add(new Option(yonghuOptions[i].yonghuName, yonghuOptions[i].id));
                }

                $("#yonghuSelect").change(function(e) {
                        yonghuSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var yizhuTypesSelect = document.getElementById("yizhuTypesSelect");
        if(yizhuTypesSelect != null && yizhuTypesOptions != null  && yizhuTypesOptions.length > 0 ) {
            for (var i = 0; i < yizhuTypesOptions.length; i++) {
                if (yizhuTypesOptions[i].codeIndex == ruleForm.yizhuTypes) {//下拉框value对比,如果一致就赋值汉字
                        yizhuTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var bingrenSelect = document.getElementById("bingrenSelect");
            if(bingrenSelect != null && bingrenOptions != null  && bingrenOptions.length > 0 ) {
                for (var i = 0; i < bingrenOptions.length; i++) {
                    if (bingrenOptions[i].id == ruleForm.bingrenId) {//下拉框value对比,如果一致就赋值汉字
                        bingrenSelect.options[i+1].selected = true;
                        $("#bingrenSelect" ).selectpicker('refresh');
                    }
                }
            }
            var yishengSelect = document.getElementById("yishengSelect");
            if(yishengSelect != null && yishengOptions != null  && yishengOptions.length > 0 ) {
                for (var i = 0; i < yishengOptions.length; i++) {
                    if (yishengOptions[i].id == ruleForm.yishengId) {//下拉框value对比,如果一致就赋值汉字
                        yishengSelect.options[i+1].selected = true;
                        $("#yishengSelect" ).selectpicker('refresh');
                    }
                }
            }
            var yonghuSelect = document.getElementById("yonghuSelect");
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                    if (yonghuOptions[i].id == ruleForm.yonghuId) {//下拉框value对比,如果一致就赋值汉字
                        yonghuSelect.options[i+1].selected = true;
                        $("#yonghuSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
        if (ruleForm.zhuyuanfeiyongContent != null && ruleForm.zhuyuanfeiyongContent != 'null' && ruleForm.zhuyuanfeiyongContent != '' && $("#zhuyuanfeiyongContentupload").length>0) {

            var zhuyuanfeiyongContentUeditor = UE.getEditor('zhuyuanfeiyongContentEditor');
            zhuyuanfeiyongContentUeditor.ready(function () {
                var mes = '' + ruleForm.zhuyuanfeiyongContent;
                zhuyuanfeiyongContentUeditor.setContent(mes);
            });
        }
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
        if($("#zhuyuanfeiyongContentupload").length>0) {
            var zhuyuanfeiyongContentEditor = UE.getEditor('zhuyuanfeiyongContentEditor');
            if (zhuyuanfeiyongContentEditor.hasContents()) {
                $('#zhuyuanfeiyongContent-input').attr('value', zhuyuanfeiyongContentEditor.getPlainTxt());
            }
        }
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function zhuyuanfeiyongMoneyChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addyizhu');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                yishengId: "required",
                bingrenId: "required",
                yonghuId: "required",
                yizhuTypes: "required",
                zhuyuanfeiyongContent: "required",
                zhuyuanfeiyongMoney: "required",
                insertTime: "required",
            },
            messages: {
                yishengId: "发布医生不能为空",
                bingrenId: "接收病人不能为空",
                yonghuId: "执行护士不能为空",
                yizhuTypes: "医嘱类型名称不能为空",
                zhuyuanfeiyongContent: "医嘱内容不能为空",
                zhuyuanfeiyongMoney: "消费金额不能为空",
                insertTime: "发布时间不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addyizhu = window.sessionStorage.getItem("addyizhu");
        if (addyizhu != null && addyizhu != "" && addyizhu != "null") {
            window.sessionStorage.removeItem('addyizhu');
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("yizhu/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
            laydate.render({
                elem: '#insertTime-input'
                ,type: 'datetime'
            });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        bingrenDataBind();
        yishengDataBind();
        yonghuDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#yishengId").val(ruleForm.yishengId);
        $("#bingrenId").val(ruleForm.bingrenId);
        $("#yonghuId").val(ruleForm.yonghuId);
        $("#zhuyuanfeiyongContent").val(ruleForm.zhuyuanfeiyongContent);
        $("#zhuyuanfeiyongMoney").val(ruleForm.zhuyuanfeiyongMoney);
        $("#insertTime-input").val(ruleForm.insertTime);

    }
    <!--  级联表的数据回显  -->
    function bingrenDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#bingrenId").val(ruleForm.id);

        $("#bingrenName").val(ruleForm.bingrenName);
        $("#sexValue").val(ruleForm.sexValue);
        $("#bingrenAge").val(ruleForm.bingrenAge);
        $("#bingrenPhone").val(ruleForm.bingrenPhone);
        yishengSelectOne(ruleForm.yishengId);
        $("#huanbingValue").val(ruleForm.huanbingValue);
        $("#bingrenContent").val(ruleForm.bingrenContent);
    }

    function yishengDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#yishengId").val(ruleForm.id);

        $("#yishengName").val(ruleForm.yishengName);
        $("#sexValue").val(ruleForm.sexValue);
        $("#yishengIdNumber").val(ruleForm.yishengIdNumber);
        $("#yishengPhone").val(ruleForm.yishengPhone);
    }

    function yonghuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#yonghuId").val(ruleForm.id);

        $("#yonghuName").val(ruleForm.yonghuName);
        $("#sexValue").val(ruleForm.sexValue);
        $("#yonghuIdNumber").val(ruleForm.yonghuIdNumber);
        $("#yonghuPhone").val(ruleForm.yonghuPhone);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        bingrenShowImg();
        yishengShowImg();
        yonghuShowImg();
    }


    <!--  级联表的图片  -->

    function bingrenShowImg() {
    }


    function yishengShowImg() {
        $("#yishengPhotoImg").attr("src",ruleForm.yishengPhoto);
    }


    function yonghuShowImg() {
        $("#yonghuPhotoImg").attr("src",ruleForm.yonghuPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        bingrenShowVideo();
        yishengShowVideo();
        yonghuShowVideo();
    }


    <!--  级联表的视频  -->

    function bingrenShowVideo() {
    }

    function yishengShowVideo() {
        $("#yishengPhotoV").attr("src",ruleForm.yishengPhoto);
    }

    function yonghuShowVideo() {
        $("#yonghuPhotoV").attr("src",ruleForm.yonghuPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            yizhuTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            bingrenSelect();
            yishengSelect();
            yonghuSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationYizhutypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationbingrenSelect();
            initializationyishengSelect();
            initializationyonghuSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
    });

    function readonly() {
        if (window.sessionStorage.getItem('updateId') == null) {
            $('#yonghuDiv1').attr('style', 'display:none;');
        }s
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>
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
                    <h3 class="block-title">编辑住院</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">住院管理</li>
                        <li class="breadcrumb-item active">编辑住院</li>
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
                        <h3 class="widget-title">住院信息</h3>
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
                                        <label>检查医生</label>
                                        <input id="yishengId" name="yishengId" class="form-control"
                                               placeholder="检查医生" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>患病类型</label>
                                        <input id="huanbingValue" name="huanbingValue" class="form-control"
                                               placeholder="患病类型" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>床位</label>
                                        <div>
                                            <select id="chuangweiSelect" name="chuangweiSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>床位编号</label>
                                        <input id="chuangweiName" name="chuangweiName" class="form-control"
                                               placeholder="床位编号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>床位状态</label>
                                        <input id="chuangweiValue" name="chuangweiValue" class="form-control"
                                               placeholder="床位状态" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="bingrenId" name="bingrenId" type="hidden">
                                <input id="chuangweiId" name="chuangweiId" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>花费总金额</label>
                                        <input id="zhuyuanMoney" name="zhuyuanMoney" value="0" readonly class="form-control"
                                               onchange="zhuyuanMoneyChickValue(this)"  placeholder="花费总金额">
                                        <input id="zhuyuanTypes" name="zhuyuanTypes" value="0" type="hidden">
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

    var tableName = "zhuyuan";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
        <!-- 级联表的下拉框数组 -->
    var bingrenOptions = [];
    var chuangweiOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#bingrenId") !=null){
               var bingrenId = $("#bingrenId").val();
               if(bingrenId == null || bingrenId =='' || bingrenId == 'null'){
                   alert("住院病人不能为空");
                   return;
               }
           }
           if($("#chuangweiId") !=null){
               var chuangweiId = $("#chuangweiId").val();
               if(chuangweiId == null || chuangweiId =='' || chuangweiId == 'null'){
                   alert("使用床位不能为空");
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
            httpJson("zhuyuan/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addzhuyuan');
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
        function chuangweiSelect() {
            //填充下拉框选项
            http("chuangwei/page?page=1&limit=100&chuangweiTypes=1&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    chuangweiOptions = res.data.list;
                }
            });
        }

        function chuangweiSelectOne(id) {
            http("chuangwei/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                chuangweiShowImg();
                chuangweiShowVideo();
                chuangweiDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->

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

        function initializationchuangweiSelect() {
            var chuangweiSelect = document.getElementById('chuangweiSelect');
            if(chuangweiSelect != null && chuangweiOptions != null  && chuangweiOptions.length > 0 ) {
                for (var i = 0; i < chuangweiOptions.length; i++) {
                        chuangweiSelect.add(new Option(chuangweiOptions[i].chuangweiName, chuangweiOptions[i].id));
                }

                $("#chuangweiSelect").change(function(e) {
                        chuangweiSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->
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
            var chuangweiSelect = document.getElementById("chuangweiSelect");
            if(chuangweiSelect != null && chuangweiOptions != null  && chuangweiOptions.length > 0 ) {
                for (var i = 0; i < chuangweiOptions.length; i++) {
                    if (chuangweiOptions[i].id == ruleForm.chuangweiId) {//下拉框value对比,如果一致就赋值汉字
                        chuangweiSelect.options[i+1].selected = true;
                        $("#chuangweiSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function zhuyuanMoneyChickValue(e){
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
        window.sessionStorage.removeItem('addzhuyuan');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                bingrenId: "required",
                insertTime: "required",
                chuangweiId: "required",
                zhuyuanMoney: "required",
            },
            messages: {
                bingrenId: "住院病人不能为空",
                insertTime: "住院时间不能为空",
                chuangweiId: "使用床位不能为空",
                zhuyuanMoney: "花费总金额不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addzhuyuan = window.sessionStorage.getItem("addzhuyuan");
        if (addzhuyuan != null && addzhuyuan != "" && addzhuyuan != "null") {
            window.sessionStorage.removeItem('addzhuyuan');
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
            http("zhuyuan/info/" + updateId, "GET", {}, (res) => {
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
        chuangweiDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#bingrenId").val(ruleForm.bingrenId);
        $("#insertTime-input").val(ruleForm.insertTime);
        $("#chuangweiId").val(ruleForm.chuangweiId);
        $("#zhuyuanMoney").val(ruleForm.zhuyuanMoney);

    }
    <!--  级联表的数据回显  -->
    function bingrenDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#bingrenId").val(ruleForm.id);

        $("#bingrenName").val(ruleForm.bingrenName);
        $("#sexValue").val(ruleForm.sexValue);
        $("#bingrenAge").val(ruleForm.bingrenAge);
        $("#bingrenPhone").val(ruleForm.bingrenPhone);
        $("#yishengId").val(ruleForm.yishengId);
        $("#huanbingValue").val(ruleForm.huanbingValue);
        $("#bingrenContent").val(ruleForm.bingrenContent);
    }

    function chuangweiDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#chuangweiId").val(ruleForm.id);

        $("#chuangweiName").val(ruleForm.chuangweiName);
        $("#chuangweiValue").val(ruleForm.chuangweiValue);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        bingrenShowImg();
        chuangweiShowImg();
    }


    <!--  级联表的图片  -->

    function bingrenShowImg() {
    }


    function chuangweiShowImg() {
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        bingrenShowVideo();
        chuangweiShowVideo();
    }


    <!--  级联表的视频  -->

    function bingrenShowVideo() {
    }

    function chuangweiShowVideo() {
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
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            bingrenSelect();
            chuangweiSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            <!--  初始化级联表的下拉框  -->
            initializationbingrenSelect();
            initializationchuangweiSelect();

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
        if (window.sessionStorage.getItem('role') != '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events: none;');
        }
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
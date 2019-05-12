<%--
  Created by IntelliJ IDEA.
  User: pxmwcwj
  Date: 2019/5/11
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>备件信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <style type="text/css">
        .table-bordered > tbody > tr > td, .table-bordered > tbody > tr > th, .table-bordered > tfoot > tr > td, .table-bordered > tfoot > tr > th, .table-bordered > thead > tr > td, .table-bordered > thead > tr > th {
            border: 1px solid #333;
        }
    </style>
    <style type="text/css">
        table {
            font-size: 12px;
        }

        td {
            padding-left: 10px;
        }

        caption {
            font-size: 24px;
            text-align: center;
        }

        #xx1 {
            position: relative;
            top: 5px;
        }

        #xx2 {
            position: absolute;
            left: 43%;
            margin-top: -16px;
        }

        .line-div {
            width: 100%;
            height: 100%;
            border-bottom: 1px solid #333;
            position: relative;
            margin-left: -9px;
            margin-top: 15px;
            -webkit-transform: rotate(7deg);
            -moz-transform: rotate(5deg);
            filter: progid:DXImageTransform.Microsoft.BasicImage(Rotation=0.45);

        }
    </style>
    <!--media=print 这个属性在打印时有效 有些不想打印出来的分页打印的都可以应用这类样式进行控制 在非打印时是无效的(可从打印预览中看到效果)-->
    <style media=print>
        /* 应用这个样式的在打印时隐藏 */
        .noPrint {
            display: none;
        }

        /* 应用这个样式的，从那个标签结束开始另算一页，之后在遇到再起一页，以此类推 */
        .page {
            page-break-after: always;
        }

        @page {
            size: auto;
            margin: 0mm;
        }
    </style>
    <script language="JavaScript">


        function printall() {
            //$("div[class=page]:last").removeClass("page");//最后一个分页不需要
            //window.print();
            var lastPage = $("div[class=page]:last");
            lastPage.removeClass("page");//最后一个打印分页不需要，浪费纸张
            window.print();
            lastPage.addClass("page");//批量打印后再恢复打印分页，防止重复打印分页失效
        }

        function displayTable(id) {

            if ($("#t" + id).prop("checked")) { //验证按钮是否点击
                $("#t" + id + "_table").css("display", "");//显示table
                $("#t" + id + "_print").addClass("page"); // 追加分页样式
            } else {
                $("#t" + id + "_table").css("display", "none");//隐藏table
                $("#t" + id + "_print").removeClass("page"); //移除分页样式
            }

        }


    </script>
</head>
<body>
<div class="page">
    ${info}
</div>
<div>
    <button type="button" class="btn btn-primary noPrint" style="position: absolute;left: 50%"
            onclick="printall()">
        打印
    </button>
</div>
<script type="text/javascript">
    if ($("input[name='isOriginal']").val() == "是") {
        console.log($("input[name='isOriginal']").val());
        $(".ywx").show();
        $("#sfywx1").attr("checked", "checked")
    } else {
        $(".ywx").hide();
        $("#sfywx2").attr("checked", "checked");
    }

    function shifou() {
        var isywx = $("input[name='isOriginal1']:checked").val();
        if (isywx == "是") {
            $(".ywx").show();
        } else {
            $(".ywx").hide();
        }
    }
</script>
</body>
</html>

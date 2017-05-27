<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="<%=request.getContextPath() %>/webMysel/image/png">

  <title>service_plan</title>

  <!--dynamic table-->
  <link href="<%=request.getContextPath() %>/webMysel/js/advanced-datatable/css/demo_page.css" rel="stylesheet" />
  <link href="<%=request.getContextPath() %>/webMysel/js/advanced-datatable/css/demo_table.css" rel="stylesheet" />
  <link rel="stylesheet" href="<%=request.getContextPath() %>/webMysel/js/data-tables/DT_bootstrap.css" />

  <link href="<%=request.getContextPath() %>/webMysel/css/style.css" rel="stylesheet">
  <link href="<%=request.getContextPath() %>/webMysel/css/style-responsive.css" rel="stylesheet">
  <link href="<%=request.getContextPath() %>/webMysel/css/myself.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">

        <!--logo and iconic logo start-->
        <div class="logo">
            <a href="<%=request.getContextPath() %>/webMysel/index.html"><img src="<%=request.getContextPath() %>/webMysel/images/logo.png" alt=""></a>
        </div>

        <div class="logo-icon text-center">
            <a href="<%=request.getContextPath() %>/webMysel/index.html"><img src="<%=request.getContextPath() %>/webMysel/images/logo_icon.png" alt=""></a>
        </div>
        <!--logo and iconic logo end-->

        <div class="left-side-inner">

            <!--sidebar nav start-->
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li><a href="<%=request.getContextPath() %>/webMysel/index.html"><i class="fa fa-home"></i> <span>首页</span></a></li>
                <li><a href="<%=request.getContextPath() %>/webMysel/parameter_settings.html"><i class="fa fa-th-list"></i> <span>参数设置</span></a></li>
                <li><a href="<%=request.getContextPath() %>/webMysel/working_parameter.html"><i class="fa fa-laptop"></i> <span>运行参数</span></a></li>
                <li><a href="<%=request.getContextPath() %>/webMysel/trouble_warning.html"><i class="fa fa-bullhorn"></i> <span>故障预报警</span></a></li>
                <li class="menu-list nav-active"><a href=""><i class="fa fa-cogs"></i> <span>故障维护</span></a>
                    <ul class="sub-menu-list">
                        <li class="active"><a href="<%=request.getContextPath() %>/equip!viewServicePlan.action"> 维护计划</a></li>
                        <li><a href="<%=request.getContextPath() %>/equip!viewServicePlan.action"> 维护结果</a></li>
                    </ul>
                </li>
                <li class="menu-list"><a href=""><i class="fa fa-book"></i> <span>库存管理</span></a>
                    <ul class="sub-menu-list">
                        <li><a href="<%=request.getContextPath() %>/webMysel/inventory.html"> 库存记录</a></li>
                        <li><a href="<%=request.getContextPath() %>/webMysel/import.html"> 入库记录</a></li>
                        <li><a href="<%=request.getContextPath() %>/webMysel/export.html">出库记录</a></li>
                    </ul>
                </li>
                <li><a href="<%=request.getContextPath() %>/webMysel/life_log.html"><i class="fa fa-file-text"></i> <span>生命日志</span></a></li>

            </ul>
            <!--sidebar nav end-->

        </div>
    </div>
    <!-- left side end-->
    
    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
        <div class="header-section">

            <!--toggle button start-->
            <a class="toggle-btn"><i class="fa fa-bars"></i></a>
            <!--toggle button end-->

            <!--search start-->
            <form class="searchform" action="index.html" method="post">
                <input type="text" class="form-control" name="keyword" placeholder="按设备编号搜索" />
            </form>
            <!--search end-->
            <button class="btn btn-primary add_new" id="addNew">新增</button>
        </div>
        <!-- header section end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            维护计划
                            <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <a href="javascript:;" class="fa fa-times"></a>
                            </span>
                        </header>
                        <div class="panel-body">
                            <div class="adv-table">
                                <table  class="display table table-bordered table-striped" id="dynamic-table">
                                    <thead>
                                        <tr>
                                            <th>设备编号</th>
                                            <th>预计维护时长（小时）</th>
                                            <th>所需备件</th>
                                            <th>维护人员</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${plan }" var="items">
                                    		<tr>
	                                            <td>${items.equipParameter.equipmentName }</td>
	                                            <td>${items.totalTime }</td>
	                                            <td>
													<c:forEach items="${items.equipAndMaintains }" var="equip">
														${equip.spare.spareName }
														${equip.needNumber }
														
													</c:forEach>
												</td>
	                                            <td>
	                                            	<c:forEach items="${items.maintainAndWorkers }" var="workers">
														${workers.worker.name }
														${workers.worker.no }
														,
													</c:forEach>
												</td>
	                                            <td><a href="<%=request.getContextPath() %>/webMysel/edit_servicePlan.html">详情编辑</a></td>
	                                        </tr>
                                    	</c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        
        </div>
        <!--body wrapper end-->


    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="<%=request.getContextPath() %>/webMysel/js/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath() %>/webMysel/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="<%=request.getContextPath() %>/webMysel/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=request.getContextPath() %>/webMysel/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/webMysel/js/modernizr.min.js"></script>
<script src="<%=request.getContextPath() %>/webMysel/js/jquery.nicescroll.js"></script>

<!--dynamic table-->
<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/webMysel/js/advanced-datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/webMysel/js/data-tables/DT_bootstrap.js"></script>
<!--dynamic table initialization -->
<script src="<%=request.getContextPath() %>/webMysel/js/dynamic_table_init.js"></script>

<!--common scripts for all pages-->
<script src="<%=request.getContextPath() %>/webMysel/js/scripts.js"></script>

<script type="text/javascript">
    $("#addNew").click(function(){
        window.location.href="<%=request.getContextPath() %>/webMysel/addNew_servicePlan.html";
    })
</script>
</body>
</html>

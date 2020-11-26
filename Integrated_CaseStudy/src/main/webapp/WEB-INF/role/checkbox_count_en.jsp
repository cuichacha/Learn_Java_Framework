<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
<HTML>
<HEAD>
    <TITLE> ZTREE DEMO - getChangeCheckedNodes / getCheckedNodes</TITLE>
    <link rel="stylesheet" href="/CaseStudy/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="/CaseStudy/ztree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="/CaseStudy/ztree/js/jquery.ztree.core-3.5.js"></script>
    <script type="text/javascript" src="/CaseStudy/ztree/js/jquery.ztree.excheck-3.5.js"></script>
    <!--
    <script type="text/javascript" src="../../../js/jquery.ztree.exedit-3.5.js"></script>
    -->
    <SCRIPT type="text/javascript">
        var setting = {

            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };

        setting.check.chkboxType = {"Y": "ps", "N": "ps"};
        var zNodes = ${roleModulesJson};

        // var zNodes = [
        //     { id:1, pId:0, name:"随意勾选 1", open:true},
        //     { id:11, pId:1, name:"随意勾选 1-1"},
        //     { id:12, pId:1, name:"随意勾选  1-2", open:true},
        //     { id:121, pId:12, name:"随意勾选 1-2-1", checked:true},
        //     { id:122, pId:12, name:"随意勾选 1-2-2"},
        //     { id:123, pId:12, name:"随意勾选 1-2-3"},
        //     { id:13, pId:1, name:"随意勾选 1-3"},
        //     { id:2, pId:0, name:"随意勾选 2", open:true},
        //     { id:21, pId:2, name:"随意勾选 2-1"},
        //     { id:22, pId:2, name:"随意勾选 2-2", open:true},
        //     { id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
        //     { id:222, pId:22, name:"随意勾选 2-2-2"},
        //     { id:223, pId:22, name:"随意勾选 2-2-3"},
        //     { id:23, pId:2, name:"随意勾选 2-3", checked:true}
        //
        // ];

        let ztree;
        $(function () {
            ztree = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            ztree.expandAll(true);
        });

        function getCheckedIds() {
            let checkedNodes = ztree.getCheckedNodes(true);
            $.each(checkedNodes,function (index,roleModule) {
                let moduleId = roleModule.id;
                $("#form").append("<input type=\"hidden\" name=\"moduleIds\" value=\""+moduleId+"\">");
            });
            $("#form").submit();
        }

    </SCRIPT>
</HEAD>

<BODY>
<ul id="treeDemo" class="ztree"></ul>
<form action="${ctx}/system/role?operation=updateRoleModules" method="post" id="form">
    <input type="hidden" name="roleId" value="${roleId}">
</form>
<input type="button" value="提交" onclick="getCheckedIds();">

</BODY>
</HTML>
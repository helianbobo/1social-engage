<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="brandtology_engage">
    <r:require modules="engage-posts, engage-case"/>
</head>

<body>
<%--
<content tag="moduleTitle">
  <g:message code="brandtology.module.title.socialEngage"/>
</content>
--%>
<div id="page">
    <div class="app-posts" tmpl="posts"></div>
</div>

<div class="modal fade hide app-case-modal">
    <div class="modal-inner">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">×</button>
        </div>

        <div class="modal-body">
            <div class="app-case container" tmpl="case"></div>
        </div>
    </div>
</div>

</body>
</html>
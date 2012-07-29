<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="brandtology_engage">
    <r:require modules="engage-overview"/>
</head>

<body>
<%--
<content tag="moduleTitle">
  <g:message code="brandtology.module.title.socialEngage"/>
</content>
--%>
    <div id="page">
      <div class="app-engage-overview" tmpl="engage-overview"></div>
    </div>
<r:script>
  requirejs(['engage/overview'], function() {})
</r:script>

</body>
</html>
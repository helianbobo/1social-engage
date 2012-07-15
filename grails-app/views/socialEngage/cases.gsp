<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="brandtology_engage">
    <r:require modules="engage-cases, engage-case"/>
</head>

  <body>
    <div id="page">
      <div class="app-cases" tmpl="cases"></div>
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
    <r:script>
      requirejs(['engage/cases'], function() {})
    </r:script>
  </body>
</html>
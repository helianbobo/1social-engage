<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="brandtology_engage">
    <r:require modules="engage-cases"/>
</head>

  <body>
    <div id="page">
      <div class="app-cases">
        <div class="app-cases-inner">
          <div class="toolbar" tmpl="cases-toolbar"></div>

          <div class="case-list-wrap">
            <ul class="case-list">
              <li>
                <div class="content">
                  <span class="user-name">{{articleVoiceName}}</span>
                  {{{articleContent}}}
                </div>

                <div class="pics">
                  <img src="http://placehold.it/50x50/ccc" alt="" width="50" height="50">
                  <img src="http://placehold.it/50x50/ccc" alt="" width="50" height="50">
                  <img data-original="{{articleVoicePicture}}" alt="{{articleVoiceName}}" width="50" height="50">
                </div>

                <div class="meta">
                  <div class="agent">{{assignTo}}</div>
                  <div class="status">{{caseStatus}}</div>
                  <div class="priority">
                    <ul class="prioritys">
                      <li><a href="javascript:;">1</a></li>
                      <li><a href="javascript:;">2</a></li>
                      <li><a href="javascript:;">3</a></li>
                      <li><a href="javascript:;">4</a></li>
                      <li><a href="javascript:;">5</a></li>
                    </ul>
                  </div>
                  <div class="datetime">{{timePosted}}<br/>{{datePosted}}</div>
                  <div class="datetime">{{timeCreated}}<br/>{{dateCreated}}</div>
                </div>
                <div class="actions"><button class="btn">Action</button></div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
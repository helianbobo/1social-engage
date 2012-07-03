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
          <div class="toolbar">
            <div class="refresh-actions pull-left">
              <a href="javascript:;" class="btn btn-refresh"><i class="icon-refresh"></i></a>
            </div>

            <div class="filter-actions pull-left">
              <span class="text">Filter by: </span>
              <ul class="nav">
                <li class="dropdown">
                  <a href="" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="dropdown-toggle-text">Post Type</span> <b class="caret"></b>
                  </a>
                  <ul class="dropdown-menu">
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="dropdown-toggle-text">Platform</span> <b class="caret"></b>
                  </a>
                  <ul class="dropdown-menu">
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="dropdown-toggle-text">Asset</span> <b class="caret"></b>
                  </a>
                  <ul class="dropdown-menu">
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="dropdown-toggle-text">Case</span> <b class="caret"></b>
                  </a>
                  <ul class="dropdown-menu">
                  </ul>
                </li>
              </ul>
            </div>

            <div class="sort-actions">
              <span class="text">Sort by: </span>
              <ul class="nav sort">
                <li>
                  <a href="#agent" title="Sort by Datetime Posted">
                    Agent
                    <b class="caret-reverse"></b><b class="caret"></b>
                  </a>
                </li>

                <li>
                  <a href="#status" title="Sort by Datetime Posted">
                    Status
                    <b class="caret-reverse"></b><b class="caret"></b>
                  </a>
                </li>

                <li>
                  <a href="#priority" title="Sort by Datetime Posted">
                    Priority
                    <b class="caret-reverse"></b><b class="caret"></b>
                  </a>
                </li>

                <li>
                  <a href="#datetimePosted" class="datetime" title="Sort by Datetime Posted">
                    Date/Time Posted
                    <b class="caret-reverse"></b><b class="caret"></b>
                  </a>
                </li>

                <li>
                  <a href="#datetimeCreated" class="datetime desc" title="Sort by Datetime Posted">
                    Date/Time Created
                    <b class="caret-reverse"></b><b class="caret"></b>
                  </a>
                </li>
              </ul>
            </div>

          </div>

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
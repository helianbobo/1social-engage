<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="brandtology_engage">
</head>

  <body>
<%--
<content tag="moduleTitle">
  <g:message code="brandtology.module.title.socialEngage"/>
</content>
--%>
    <div id="page">
      <div class="app-posts">
      
        <ul class="nav nav-tabs app-tabs">
          <li class="active"><a href="#facebook" data-toggle="tab"><i class="icon-facebook-s"></i> Facebook</a></li>
          <li><a href="#weibo" data-toggle="tab"><i class="icon-weibo-s"></i> Sina Weibo</a></li>
          <li><a href="#twitter" data-toggle="tab"><i class="icon-twitter-s"></i> Twitter</a></li>
          <li><a href="#forums" data-toggle="tab">Forums</a></li>
        </ul>
        
        <div class="tab-content">
          <div class="tab-pane active" id="facebook">
            <div class="toolbar" tmpl="post-toolbar"></div>

            <div class="post-list-wrap">
              <ul class="post-list">
                <li class="post-item">
                  <div class="content">
                    <a class="user-name" href="">{{voiceName}}</a>
                    {{content}}
                  </div>
                  <input type="checkbox" class="input-item-selector" >
                  <div class="type">
                    <span class="type-item-1-1"></span>
                    <span class="type-item-1-2"></span>
                    <span class="type-item-2-1"></span>
                    <span class="type-item-2-2"></span>
                  </div>
                  <span class="user-pic">
                    <img data-original="{{voicePic}}" width="50" height="50" alt="">
                  </span>

                  <div class="meta">
                    <div class="count">{{likeCount}}{{^likeCount}}-{{/likeCount}}</div>
                    <div class="count">{{commentCount}}{{^commentCount}}-{{/commentCount}}</div>
                    <div class="count">{{shareCount}}{{^shareCount}}-{{/shareCount}}</div>
                    <div class="datetime"><p>{{time}}</p><p>{{date}}</p></div>
                  </div>
                  <div class="actions">
                    <button class="show-case">Action</button>
                    <button>Mark as read</button>
                  </div>
                </li>
              </ul>
            </div>
          </div>

          <div class="tab-pane" id="weibo"></div>
          <div class="tab-pane" id="twitter"></div>
        </div>

      </div>
    </div>

    <div class="modal fade hide app-case-modal">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
      </div>
      <div class="modal-body">
        <div class="app-case container" tmpl="case"></div>
      </div>
    </div>

  </body>
</html>
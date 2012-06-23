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
      <div class="app-post">
      
        <ul class="nav nav-tabs app-tabs">
          <li class="active"><a href="#facebook"><i class="icon-facebook-s"></i> Facebook</a></li>
          <li><a href="#weibo"><i class="icon-weibo-s"></i> Sina Weibo</a></li>
          <li><a href="#twitter"><i class="icon-twitter-s"></i> Twitter</a></li>
          <li><a href="#forums">Forums</a></li>
        </ul>
        
        <div class="tab-body">
          <div class="tab-pane">

            <div class="toolbar">
              <div class="pull-left batch-actions">
                <input type="checkbox" class="input-all-selector">
                <button>Mark as read</button>
                <button>Mark as unread</button>
              </div>
              <div class="pull-left refresh-actions">
                <button>refresh</button>
              </div>
              <div class="pull-left filter-actions">
                <span>Filter by: </span>

                <ul class="nav">
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      Post Type <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                      <li><a href="#">All Posts</a></li>
                      <li><a href="#">Articles</a></li>
                      <li><a href="#">Comments</a></li>
                    </ul>
                  </li>

                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      Asserts <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                      <li><a href="#">All Asserts</a></li>
                      <li><a href="#">Page 1</a></li>
                      <li><a href="#">Page 2</a></li>
                    </ul>
                  </li>

                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      Read <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Everything</a></li>
                      <li><a href="#">Read Only</a></li>
                      <li><a href="#">Unread Only</a></li>
                    </ul>
                  </li>

                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      Case <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Everything</a></li>
                      <li><a href="#">Case Made</a></li>
                      <li><a href="#">No Case Made</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
              <div class="pull-right pagination-actions">
                <a href="#" title="prev" class="disabled">«</a>
                <span class="">1</span>
                <span>of</span>
                <span>50</span>
                <a href="#" title="next">»</a>
              </div>
              <div class="pull-right sort-actions">
                <span>Sort by: </span>
                <ul class="nav">
                  <li><a href="#"><i class="icon-like">like</i></a></li>
                  <li><a href="#"><i class="icon-comment">comment</i></a></li>
                  <li><a href="#"><i class="icon-share">share</i></a></li>
                  <li><a href="#" class="datetime">Date/Time Posted</a></li>
                </ul>
              </div>
            </div>

            <div class="post-list-wrap">
              <ul class="post-list">
                <li class="post-item">
                  <div class="content">
                    <a class="user-name" href="">Brandtology</a>
                    How The World Spends Its Time Online [INFOGRAPHIC] <a href="http://buff.ly/LATWXi" target="_blank">http://buff.ly/LATWXi</a>
                  </div>
                  <input type="checkbox" class="input-item-selector" >
                  <div class="type">
                    <span class="type-item-1-1"></span>
                    <span class="type-item-1-2"></span>
                    <span class="type-item-2-1"></span>
                    <span class="type-item-2-2"></span>
                  </div>
                  <span class="user-pic"><r:img dir="test-asset" file="user-pic.jpg" /></span>

                  <div class="meta">
                    <div class="count">15</div>
                    <div class="count">-</div>
                    <div class="count">-</div>
                    <div class="datetime"><p>13:56:55</p><p>20 June 2012</p></div>
                  </div>
                  <div class="actions">
                    <button>Action</button>
                    <button>Mark as read</button>
                  </div>
                </li>
              </ul>
            </div>

          </div>
        </div>

      </div>
    </div>

  </body>
</html>
<header>
	<div id="colLeft">
		<div id="colLeftWrap">
			<div id="row1">
    			<div id="mastHead"></div>
    			
				%{--<sec:ifLoggedIn>--}%
					<!--select client dialog box if isStaff-->
		            <!--section id="clientSelect"> 
			            <div id="clientSelectWrap">
				            <select name="active" id="active">
				                <option value="1">active</option>
				                <option value="0">inactive</option>
				            </select>
				
				            <select id="client_id">
				                <option></option>
				            </select>
						</div>
		            </section-->
				
		            <section id="userInfo">
		            	<div  id="username">
		                    <span>
		                        John Smith
		                    </span>
		
	                        <g:link uri="/logout">
		                    	<div class="btn" id="logout">
		                            <g:message code="brandtology.label.logout"/>
		                    	</div>
	                        </g:link>
	                    </div>

                        %{--<g:if test="${sec.loggedInUserInfo(field: 'details.profilePicture') != null && sec.loggedInUserInfo(field: 'details.profilePicture') != 'null'}">--}%
                            %{--<div id="userimg" style="background-image: url('${createLink(controller:'account', action:'displayPic',params:[email:sec.loggedInUserInfo(field: 'details.emailAddress'),profilePic:sec.loggedInUserInfo(field: 'details.profilePicture')])}')"></div>--}%
                        %{--</g:if>--}%
                       	%{--<g:else>--}%
                            <div id="userimg" style="background-image: url('${resource(dir: 'images', file: 'duser.png')}')"></div>
                       	%{--</g:else>--}%
		            </section>
		        %{--</sec:ifLoggedIn>--}%
			</div> <!-- #row1 end -->
			
			<div id="row2">
		        <div id="currentModule">
		            <g:message code="brandtology.module.title.${currentModule}"/>
		        </div>
		        
                <nav id="subModule">
	                <g:each in="${subModules}" var="subModule">
	                    <g:link controller="${currentModule}" action="${subModule}">
	                        <div
	                            <g:if test="${currentSubModule == subModule}">
	                                class="active"
	                            </g:if>
	                                id="${subModule}">
	                            <g:message code="brandtology.subModule.title.${subModule}"/>
	                        </div>
	                    </g:link>
	                </g:each>
	            </nav>
        	</div> <!-- #row2 end -->
		</div> <!-- #colLeftWrap end -->
	</div> <!-- #colLeft end -->
	
	<div id="colRight">
		<div id="colRightWrap">
			<nav id="mainModule">
	            <!--a href="${request.contextPath}/dashboard"><div id="dashboard"
	                <g:if test="${currentModule == 'dashboard'}">
	                    class="active"
	                </g:if>
	                	class="noaccess"></div></a-->
	                	
	            <a href="${request.contextPath}/socialAnalytics"><div id="analytics"
	                <g:if test="${currentModule == 'socialAnalytics'}">
	                    class="active"
	                </g:if>
	                	></div></a>
	                	
	            <a href="${request.contextPath}/socialInsights"><div id="insight"
	                <g:if test="${currentModule == 'socialInsights'}">
	                    class="active"
	                </g:if>
	                	></div></a>
	                	
	            <!--a href="${request.contextPath}/socialPulse"--><div id="pulse"
	                <g:if test="${currentModule == 'socialPulse'}">
	                    class="active"
	                </g:if>
	                	></div><!--/a-->
	                	
	            <!--a href="${request.contextPath}/socialInfluence"><div id="influence"
	                <g:if test="${currentModule == 'socialInfluence'}">
	                    class="active"
	                </g:if>
	                	class="noaccess"></div></a-->
	                	
	            <!--a href="${request.contextPath}/socialCampaign"><div id="campaign"
	                <g:if test="${currentModule == 'socialCampaign'}">
	                    class="active"
	                </g:if>
	                	class="noaccess"></div></a-->
	                	
		        <!--a href="${request.contextPath}/socialAlert"><div id="alert"
	                <g:if test="${currentModule == 'socialAlert'}">
	                    class="active"
	                </g:if>
	                	class="noaccess"></div></a-->
	                	
	            <a href="${request.contextPath}/socialAssets"><div id="assets"
	                <g:if test="${currentModule == 'socialAssets'}">
	                    class="active"
	                </g:if>
	                	></div></a>
	                	
	            <!--a href="${request.contextPath}/socialEngage"--><div id="engage"
	                <g:if test="${currentModule == 'socialEngage'}">
	                    class="active"
	                </g:if>
	                	></div><!--/a-->
	                	
	            <!--a href="${request.contextPath}/socialExplore"><div id="explore"
	                <g:if test="${currentModule == 'socialExplore'}">
	                    class="active"
	                </g:if>
	                	></div></a-->
	                	
	            <!--a href="${request.contextPath}/report/"><div id="report"
	                <g:if test="${currentModule == 'report'}">
	                    class="active"
	                </g:if>
	                	class="noaccess"></div></a-->
	                	
	            <a href="${request.contextPath}/account/"><div id="account"
	                <g:if test="${currentModule == 'account'}">
	                    class="active"
	                </g:if>
	                	></div></a>
	                	
	        	<!-- div></div> extra placeholder -->
			</nav>
		</div> <!-- #colRightWrap end -->
	</div> <!-- #colRight end -->
</header>
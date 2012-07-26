<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <g:render template="/share/title" model="[currentModule: 'socialAnalytics', currentSubModule: currentSubModule]"/>
    <g:render template="/share/head"/>

    <title><g:layoutTitle/></title>
    <r:require module="analytics"/>

    <g:layoutHead/>
    <r:layoutResources/>
    <g:render template="/share/session" model="[currentModule: 'socialAnalytics', currentSubModule: currentSubModule]"/>

</head>

<body>
<g:render template="/share/header"
          model="[subModules: ['overview', 'buzz', 'sentiment', 'growth', 'channels'], currentModule: 'socialAnalytics', currentSubModule: currentSubModule]"/>

<div id="page">
	<section id="chart">
		<div id="chartLeft">
			<div id="chartLeftWrap">
		        <div class="panels top" id="chartTop">
                    <div id="menuItem">
		                <select id="menuItemSelect">
		                    <g:applyLayout name="nochange">
		                        <g:pageProperty name="page.menuItems"/>
		                    </g:applyLayout>
		                </select>
					</div>
					
	                <div id="chartOption">
                        <div class="tab active" id="stacked">Stacked</div>
                        <div class="tab" id="percent">Percentage</div>
                        <div class="tab" id="bar">Bar</div>
                        <div class="tab" id="pie">Pie</div>
                    	%{--<div id="help"></div>--}%
	                </div>
		        </div>
		        
		        <div class="panels main" id="chartMain">
		        	<div id="chartContainer"></div>
                    <g:layoutBody/>
		        	%{--<div id="channelListTable"></div>--}%
		        	%{--<div id="chartDataGrid"></div>--}%
		        </div>
		        
		        <div class="panels foot" id="chartFoot"></div>
			</div> <!-- #chartLeftWrap end -->
		</div> <!-- #chartLeft end -->
		
		<div id="chartRight">
			<div id="chartRightWrap">
		        <div class="panels top" id="filterTop"></div>
		        <div class="panels main" id="filterMain"><g:render template="/share/searchOption"/></div>
		        <div class="panels foot" id="filterFoot"></div>
	        </div> <!-- #chartRightWrap end -->
		</div> <!-- #chartRight end -->
	</section>

    <section class="detailsTable" id="channelDetails">
		<g:render template="/share/channelDetail"/>
    </section>

    <section class="detailsTable" id="voiceDetails">
		<g:render template="/share/voiceDetail"/>
    </section>

    <section class="detailsTable" id="chartDetails">
        <g:render template="/share/postDetail"/>
    </section>
</div>
<r:layoutResources/>
</body>
</html>
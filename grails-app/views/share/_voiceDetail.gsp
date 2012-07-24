<r:script disposition="defer">
    $(document).ready(function () {

        var currentVoiceSearchOption = {};

        var totalVoice;
        var currentVoicePage = 1;
        var voicePageSize = 10;
        var voiceSort = 'voiceName';
        var voiceOrder = 'asc';

        var defaultChannelPaginationOptions = {
            max:voicePageSize,
            offset:(currentVoicePage-1)*voicePageSize,
            order:voiceOrder
        };

        var container = $('#voiceDetails');
        var mainWrap = $('#voiceDetails #main-wrap');
        var url = ""

        function renderVoiceDetails(options){
            url = '${request.contextPath}/socialAnalytics/getCumulativeVoice';
            if(options.type == "New Voices"){
                url = '${request.contextPath}/socialAnalytics/getNewVoice';
            }

            if(currentVoiceSearchOption.type != options.type){
                currentVoiceSearchOption.offset = 0;
                currentVoicePage = 1;
            }

            currentVoiceSearchOption = $.extend({}, defaultChannelPaginationOptions, options);

            $.getJSON(url,
                       currentVoiceSearchOption,
                       function (data) {
                           $('#voiceDetails #postSort .tab').each(function(){
                                $(this).removeClass('asc').removeClass('desc');

                                if ($(this).attr('id') == voiceSort){
                                    if (voiceOrder == 'asc'){
                                        $(this).addClass('asc');
                                    } else {
                                        $(this).addClass('desc');
                                    }
                                }
                            });

                           container.find('#detailsTitle').html('List of ' + options.selected_for_display + ' from ' + options.from_date + ' to ' + options.to_date + ' <div id="exportVoice" class="export">');

                           var voiceList = data;
                           if(data.data)
                               voiceList = data.data;
                           mainWrap.html($.render.voiceDetailsTmpl({data:voiceList}));
                           $(voiceList).each(function(index, item){
                               var channelContainer = $('.post .top#voice_' + item.voiceId)[0];
                               $.data(channelContainer, 'data', item);
                           });

                           totalVoice = data.total;
                            var pageNumberContainer = $('#voiceDetails #pagination #pageNumber');
                            var start = (currentVoicePage-1)*voicePageSize;
                            if (data.total<(start+voicePageSize))
                                pageNumberContainer.html('Showing ' + (start+1) + ' to ' + data.total + ' of ' + data.total);
                            else
                                pageNumberContainer.html('Showing ' + (start+1) + ' to ' + (start+voicePageSize) + ' of ' + data.total);
                       }
                );

        }

        $('#voiceDetails #pagination #prevPage').live('click', function(){
            if((currentVoicePage-1)>0){
                currentVoicePage--;
                currentVoiceSearchOption.offset = (currentVoicePage-1)*voicePageSize;
                renderVoiceDetails(currentVoiceSearchOption);
            }
        });

        $('#voiceDetails #pagination #nextPage').live('click', function(){
            if((currentVoicePage)*voicePageSize < totalVoice){
                currentVoicePage++;
                currentVoiceSearchOption.offset = (currentVoicePage-1)*voicePageSize;
                renderVoiceDetails(currentVoiceSearchOption);
            }
        });

        $('#voiceDetails #pagination #firstPage').live('click', function(){
            currentVoicePage = 1;
            currentVoiceSearchOption.offset = (currentVoicePage-1)*voicePageSize;
            renderVoiceDetails(currentVoiceSearchOption);
        });

        $('#voiceDetails #pagination #lastPage').live('click', function(){
            currentVoicePage = totalVoice/voicePageSize;
            currentVoiceSearchOption.offset = (currentVoicePage-1)*voicePageSize;
            renderVoiceDetails(currentVoiceSearchOption);
        });

        $('#voiceTable .top').live('click', function(){
        	$('.top').each(function(){
        		$(this).addClass('inactive');
        	});
        	
        	$(this).removeClass('inactive').addClass('active');
        });
        
        $('#voiceDetails #postSort .tab').live('click', function(){
            if(voiceSort != this.id){
                voiceSort = this.id;
            } else {
                currentVoiceSearchOption.order = switchOrder();
            }

            changeSortBy(voiceSort);
        });

        function switchOrder(){
            if(voiceOrder == 'desc')
                voiceOrder = 'asc';
            else
                voiceOrder = 'desc';

            return voiceOrder;
        }

        function changeSortBy(sort){
            currentVoicePage = 1;
            currentVoiceSearchOption.offset = 0;
            currentVoiceSearchOption.sort = sort;
            renderVoiceDetails(currentVoiceSearchOption);
        }

        container.find('.post .top').live('click', function(){
            var voice = $.data(this, 'data');
            var params = $.extend($.getSearchOptions(), {
                voice_id: voice.voiceId,
                voice_url:voice.voiceUrl
            });

            $(document).trigger('showPostDetails', [params])

        });

        $(document).live('renderChart', function(){
            container.slideUp('fast', function(){mainWrap.html('');});
        });

        $(document).live('showVoiceDetail', function (event, eventData) {
            container.slideDown('fast', function(){
                $(document).trigger('showPreloader', [{places:[mainWrap]}]);
                renderVoiceDetails(eventData);
            });

        });

        $.templates("voiceDetailsTmpl", "#voiceDetailsTemplate");
        $('#exportVoice').live('click', function () {
            var params = currentVoiceSearchOption;
            $.download(url + '.csv', params);
        });
    });
</r:script>

<script type="text/x-jsrender" id="voiceDetailsTemplate">
    %{--
        {
        "subjectName": "Bugis Junction",
        "subjectId": 27083,
        "channelId": 33412,
        "channelName": "Twitter ",
        "channelType": "MICROBLOG",
        "category": "GENERAL",
        "voiceName": "xoxokiat",
        "voiceId": 925981645,
        "voiceUrl": "http://twitter.com/xoxokiat",
        "authorInfluenceScore": 0,
        "commenterInfluenceScore": 47,
        "sentimentScore": 0,
        "authorCount": 0,
        "commenterCount": 2,
        "totalCount": 2
      }
    --}%

    {{for data}}
    <table class="post" id="voiceTable">
        <tr class="top" id="voice_{{:voiceId}}">
            <td id="sentiment"><div class="color" id="{{:~formatSentiment(sentimentScore)}}"></div></td>
            <td id="voiceDetails">
                <div class="name"><a href="{{:voiceUrl}}" target="_blank">{{:voiceName}}</a></div>

                <div class="channel"><a href="{{:channelUrl}}" target="_blank">{{:channelName}}</a></div>
            </td>
            <td class="voiceValue" id="authorInfluenceScore">
                <div class="count" title="Author Influence">{{:authorInfluenceScore}}</div>
            </td>
            <td class="voiceValue" id="commenterInfluenceScore">
                <div class="count" title="Commenter Influence">{{:commenterInfluenceScore}}</div>
            </td>
                
            <td class="voiceValue" id="authorCount">
                <div class="count" title="Author Post(s)">{{:authorCount}}</div>
            </td>

            <td class="voiceValue" id="commenterCount">
                <div class="count" title="Commenter Post(s)">{{:commenterCount}}</div>
            </td>

            <td class="voiceValue" id="totalCount">
                <div class="count" title="Total Post(s)">{{:totalCount}}</div>
            </td>
        </tr>
    </table>
    {{/for}}
</script>

<div class="panels" id="detailsTitle">
	List of (#) Voice(s) from (fromDate) to (toDate)
	<div id="exportVoice"></div>
</div> <!-- #detailsTitle end -->

<div class="panels" id="top-panel">
	<div id="left-panel">
	    <div id="left-wrap">
			<table id="postSort">
		        <tr class="top">
		            <td id="voiceDetails">
						<div class="tab" id="sortBy">SORT BY :</div>
		            	<div class="tab" id="sentimentScore">Net Sentiment</div>
				<div class="tab desc" id="voiceName">Voice</div>
		
				<div class="tab" id="channelName">Channel</div>
		            </td>
		            <td class="voiceValue" id="authorInfluenceScore">
                <div class="tab" id="authorInfluenceScore">Author Influence</div>
		            </td>
		            <td class="voiceValue" id="commenterInfluenceScore">
				<div class="tab" id="commenterInfluenceScore">Commenter Influence</div>
		            </td>
		                
		            <td class="voiceValue" id="authorCount">
				<div class="tab" id="authorCount">Author Post(s)</div>
		            </td>
		
		            <td class="voiceValue" id="commenterCount">
				<div class="tab" id="commenterCount">Commenter Post(s)</div>
		            </td>
		
		            <td class="voiceValue" id="totalCount">
				<div class="tab" id="totalCount">Total Post(s)</div>
		            </td>
		        </tr>
			</table>
			
			%{--
			<div id="postSort">
				<div class="tab" id="sortBy">SORT BY :</div>
				<div class="tab" id="sentimentScore">Net Sentiment</div>
				<div class="tab desc" id="voiceName">Voice</div>
				<div class="tab" id="channelName">Channel</div>
                <div class="tab" id="authorInfluenceScore">Author Influence</div>
				<div class="tab" id="commenterInfluenceScore">Commenter Influence</div>
				<div class="tab" id="authorCount">Author Post(s)</div>
				<div class="tab" id="commenterCount">Commenter Post(s)</div>
				<div class="tab" id="totalCount">Total Post(s)</div>
			</div>
			--}%
	    </div> <!-- #left-wrap end -->
	</div> <!-- #left-panel end -->
	
	<div id="right-panel">
	    <div id="right-wrap">
	    </div> <!-- #right-wrap end -->
	</div> <!-- #right-panel end -->

    %{--<div id="top-wrap">
        <div class="sort" id="channelSort">

        </div>
    </div> <!-- #top-wrap end -->--}%
</div>

<div class="panels" id="main-panel">
    <div id="main-wrap">
    </div>
</div>

<div class="panels" id="foot-panel">
    <div id="left-panel">
        <div id="left-wrap">
        </div> <!-- #left-wrap end -->
    </div> <!-- #left-panel end -->

    <div id="right-panel">
        <div id="right-wrap">
            <!--div></div-->

            <div id="pagination">
                <div id="pageNumber"><currentPage>- <totalPage>of <totalPage></div>
				<div class="btn" id="firstPage"><<</div>
				<div class="btn" id="prevPage"><</div>
				<div class="btn" id="nextPage">></div>
				<div class="btn" id="lastPage">>></div>
            </div>
        </div> <!-- #right-wrap end -->
    </div> <!-- #right-panel end -->
</div>
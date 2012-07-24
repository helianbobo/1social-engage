<r:script disposition="defer">
    $(document).ready(function () {

        var currentChannelSearchOption = {};

        var totalChannel;
        var currentChannelPage = 1;
        var channelPageSize = 10;
        var channelSort = 'countAll';
        var channelOrder = 'desc';

        var defaultChannelPaginationOptions = {
            max:channelPageSize,
            offset:(currentChannelPage-1)*channelPageSize,
            order:channelOrder
        };

        var container = $('#channelDetails');
        var mainWrap = $('#channelDetails #main-wrap');
        var url = "";

        function renderChannelDetails(options){
             url = '${request.contextPath}/socialAnalytics/getCumulativeChannel';
            if(options.type == "New Channels"){
                url = '${request.contextPath}/socialAnalytics/getNewChannel';
            }

            if(currentChannelSearchOption.type != options.type){
                currentChannelSearchOption.offset = 0;
                currentChannelPage = 1;
            }

            currentChannelSearchOption = $.extend({}, defaultChannelPaginationOptions, options);

            $.getJSON(url,
                       currentChannelSearchOption,
                       function (data) {

                           $('#channelDetails #postSort .tab').each(function(){
                                $(this).removeClass('asc').removeClass('desc');

                                if ($(this).attr('id') == channelSort){
                                    if (channelOrder == 'asc'){
                                        $(this).addClass('asc');
                                    } else {
                                        $(this).addClass('desc');
                                    }
                                }
                            });

                           container.find('#detailsTitle').html('List of ' + data.data.length + ' Channel(s) from ' + options.from_date + ' to ' + options.to_date + ' <div id="exportChannel" class="export">');
                           mainWrap.html($.render.channelDetailsTmpl(data));
                           $(data.data).each(function(index, item){
                               var channelContainer = $('.post .top#channel_' + item.channelId)[0];
                               $.data(channelContainer, 'data', item);
                           });

                            totalChannel = data.total;
                            var pageNumberContainer = $('#channelDetails #pagination #pageNumber');
                            var start = (currentChannelPage-1)*channelPageSize;
                            if (data.total<(start+channelPageSize))
                                pageNumberContainer.html('Showing ' + (start+1) + ' to ' + data.total + ' of ' + data.total);
                            else
                                pageNumberContainer.html('Showing ' + (start+1) + ' to ' + (start+channelPageSize) + ' of ' + data.total);

                       }
                );

        }

        $('#channelDetails #pagination #prevPage').live('click', function(){
            if((currentChannelPage-1)>0){
                currentChannelPage--;
                currentChannelSearchOption.offset = (currentChannelPage-1)*channelPageSize;
                renderChannelDetails(currentChannelSearchOption);
            }
        });

        $('#channelDetails #pagination #nextPage').live('click', function(){
            if((currentChannelPage)*channelPageSize < totalChannel){
                currentChannelPage++;
                currentChannelSearchOption.offset = (currentChannelPage-1)*channelPageSize;
                renderChannelDetails(currentChannelSearchOption);
            }
        });

        $('#channelDetails #pagination #firstPage').live('click', function(){
                currentChannelPage = 1;
                currentChannelSearchOption.offset = (currentChannelPage-1)*channelPageSize;
                renderChannelDetails(currentChannelSearchOption);
        });

        $('#channelDetails #pagination #lastPage').live('click', function(){
            currentChannelPage = totalChannel/channelPageSize;
            currentChannelSearchOption.offset = (currentChannelPage-1)*channelPageSize;
            renderChannelDetails(currentChannelSearchOption);
        });

        $('#channelTable .top').live('click', function(){
        	$('.top').each(function(){
        		$(this).addClass('inactive');
        	});
        	
        	$(this).removeClass('inactive').addClass('active');
        });

        $('#channelDetails #postSort .tab').live('click', function(){
            if(channelSort != this.id){
                channelSort = this.id;
            } else {
                currentChannelSearchOption.order = switchOrder();
            }

            changeSortBy(channelSort);
        });

        function switchOrder(){
            if(channelOrder == 'desc')
                channelOrder = 'asc';
            else
                channelOrder = 'desc';

            return channelOrder;
        }

        function changeSortBy(sort){
            currentChannelPage = 1;
            currentChannelSearchOption.offset = 0;
            currentChannelSearchOption.sort = sort;
            renderChannelDetails(currentChannelSearchOption);
        }

        container.find('.post .top').live('click', function(){
            var channel = $.data(this, 'data');
            var params = $.extend($.getSearchOptions(), {
                channel_id: channel.channelId
            });

            $(document).trigger('showPostDetails', [params])

        });

        $(document).live('renderChart', function(){
            container.slideUp('fast', function(){mainWrap.html('');});
        });

        $(document).live('showChannelDetail', function (event, eventData) {
            container.slideDown('fast', function(){
                $(document).trigger('showPreloader', [{places:[mainWrap]}]);
                renderChannelDetails(eventData);
            });
        });

        $.templates( "channelDetailsTmpl", "#channelDetailsTemplate" );
        $('#exportChannel').live('click', function () {
            var params = currentChannelSearchOption;
            $.download(url + '.csv', params);
        });
    });

</r:script>

<script type="text/x-jsrender" id="channelDetailsTemplate">
    {{for data}}
    <table class="post" id="channelTable">
        <tr class="top" id="channel_{{:channelId}}">
            <td id="sentiment"><div class="color" title="Average Sentiment: {{:~formatSentimentRange(sentimentScore)}}" id="{{:~formatSentiment(sentimentScore)}}"></div></td>
            <td class="color" title="Very Negative Buzz" id="countVeryNegative">{{:countVeryNegative}}</td>
            <td class="color" title="Negative Buzz" id="countNegative">{{:countNegative}}</td>
            <td class="color" title="Neutral Buzz" id="countNeutral">{{:countNeutral}}</td>
            <td class="color" title="Positive Buzz" id="countPositive">{{:countPositive}}</td>
            <td class="color" title="Very Positive Buzz" id="countVeryPositive">{{:countVeryPositive}}</td>
            <td class="color" title="Total Buzz" id="buzz">{{:countAll}}</td>
            <td id="name" title="Click here to go to the native channel"><a href="{{:channelUrl}}" target="_blank">{{:channelName}}</a></td>

            <td id="channelDetails">
                <div id="channelType"><span class="title">Channel Type&nbsp;:&nbsp;</span>{{:channelType}}</div>
                <div id="category"><span class="title">Category&nbsp;:&nbsp;</span>{{:category}}</div>
                <div id="language"><span class="title">Language&nbsp;:&nbsp;</span>{{:language}}</div>
            </td>
            
            <td id="country"><div id="{{:country}}"></div></td>
        </tr>
    </table>
    {{/for}}
</script>

<div class="panels" id="detailsTitle">
	List of (#) Channel(s) from (fromDate) to (toDate)
	<div id="exportChannel"></div>
</div> <!-- #detailsTitle end -->

<div class="panels" id="top-panel">
	<div id="left-panel">
	    <div id="left-wrap">
			<div id="postSort">
				<div class="tab" id="sortBy">SORT BY :</div>
				<div class="tab" id="sentimentScore">Net Sentiment</div>
				<div class="tab desc" id="countAll">Buzz</div>
                <div class="tab" id="channelName">Channel</div>
				<div class="tab" id="category">Category</div>
				<div class="tab" id="language">Language</div>
				<div class="tab" id="channelCountry">Country</div>
			</div>
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
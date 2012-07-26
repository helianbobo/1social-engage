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
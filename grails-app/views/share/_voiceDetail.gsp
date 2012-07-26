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
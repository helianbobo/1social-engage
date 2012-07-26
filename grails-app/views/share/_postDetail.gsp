<script type="text/x-jsrender" id="ticketsTableTemplate">
    %{--{
    "datetimePosted": "2012-02-26T12:20:21Z",
    "channelName": "Twitter - Singapore",
    "channelType": "MICROBLOG",
    "datetimeCreated": "2012-02-26T13:26:14Z",
    "datetimeStatus": "2012-02-26T13:39:40Z",
    "ticketStatus": "CLOSED",
    "isArticle": false,
    "url": "http://twitter.com/#!/Sapphirehole/statuses/173744207918407681",
    "influenceScore": 44,
    "articleId": 1100433582,
    "commentId": 1163999993,
    "content": "I'm at <span class='match'> 313@Somerset <\/span> (313 <span class='match'> Orchard <\/span> Rd, <span class='match'> Singapore <\/span> ) w/ 23 others http://t.co/j6yIJFUF \n",
"title": "I'm at 313@Somerset (313 Orchard Rd, Singapore) w/ 23 others http://t.co/j6yIJFUF",
"subjectName": "313@somerset",
"ticketId": 507962600,
"channelCountry": "SG",
"subjectId": 27080,
"priorityScore": 63,
"sentimentScore": 0,
"influencerName": "Sapphirehole",
"topicName": "General Mention"
},--}%

    {{for data}}
    <table class="post" id="ticket_{{:ticketId}}">

        <tr class="top1" >
            <td id="sentiment" rowspan="2"><div class="color" id="{{:~formatSentiment(sentimentScore)}}" title="Sentiment: {{:~formatSentimentRange(sentimentScore)}}"></div></td>
            <td id="influence" colspan="2" style="text-align:left;">
            	<div style="border:1px solid #555;color:#fff;padding:5px;background:#555;display:inline-block;">Influence</div>
            	<div style="border:1px solid #555;padding:5px;background:#fff;display:inline-block;">{{:influenceScore}}</div>
            </td>
            <td id="channelType" colspan="3"><a href="{{:channelUrl}}" target="_blank"><div class="channelName" id="{{:channelType}}" title="{{:channelName}} ({{:channelType}})">{{:channelName}}</div></a></td>
            <td id="heightCtrl" rowspan="4"><div class="icon"></div></td>
        </tr>
        <tr class="top2">
            <td id="articleComment">
            {{if (isArticle)}}
            	<div class="icon isArticle" title="Article"></div>
        	{{else}}
            	<div class="icon" title="Comment"></div>            	
        	{{/if}}
        		            
        	{{if (commentCount !=null)}}
				<div id="commentCount" title="No. of Comment(s)">{{:~formatNumber(commentCount)}}</div>
        	{{/if}}
            </td>
            <td id="title" colspan="2">
            	<a href="{{:url}}" target="_blank"><div class="title" title="Click here to go to the native post">{{:title}}</div></a>
            	<div id="postedBy"><span class="title">Posted By&nbsp;:&nbsp;</span>{{:voiceName}}</div>
            </td>
            <td id="country" title="{{:~formatCountry(channelCountry)}}"><div id="{{:channelCountry}}"></div></td>
            <td id="dateTime">{{:~formatDateTime(datetimePosted)}}</td>
        </tr>

		<tr class="mid">
			<td id="details" colspan="6">
				<div class="detailsCol">
					<div id="category"><span class="title">Category&nbsp;:&nbsp;</span>{{:topicName}}</div>
					<div id="subject"><span class="title">Subject&nbsp;:&nbsp;</span>{{:subjectName}}</div>
				</div>
				
				<div class="detailsCol">
					<div id="ticketID"><span class="title">Ticket ID&nbsp;:&nbsp;</span>{{:ticketId}}</div>
					<div id="status"><span class="title">Status&nbsp;:&nbsp;</span>{{:ticketStatus}}</div>
				</div>
				
				<div class="detailsCol">
					<div id="statusDate"><span class="title">Status Date&nbsp;:&nbsp;</span>{{:~formatDateTime(datetimeStatus)}}</div>
				</div>
			</td>
		</tr>
        
        <tr class="btm">
            <td id="content" colspan="6" title="click here to view its context">
                <input type="hidden" value="{{:commentId}}" name="commentId">
            	{{:~formatContent(content)}}
            </td>
       </tr>

    </table>
    {{/for}}
</script>

<script type="text/x-jsrender" id="postContextTemplate">
    %{--{
    "content": "I'm at Bugis Junction (200 Victoria St, Singapore) w/ 40 others http://t.co/tTFRmOpg",
    "id": 1081211480,
    "datetimePosted": "2012-01-21T13:01:42Z",
    "title": "I'm at Bugis Junction (200 Victoria St, Singapore) w/ 40 others http://t.co/tTFRmOpg",
    "postType": "COMMENT",
    "contextUrl": "http://twitter.com/#!/ClementAdam/statuses/160708647683489792",
    "commentId": 1081211480,
    "articleId": 1155028585,
    "influencerName": "ClementAdam"
    },--}%
    {{for data}}
    {{if isHighlight}}
    <table class="postContext active" id="context_{{:id}}">
    {{else}}
    <table class="postContext" id="context_{{:id}}">
    {{/if}}

        <tr class="top">
	        <td id="articleComment">
            {{if (commentId)>0}}
            	<div class="icon" title="Comment"></div>
        	{{else}}
            	<div class="icon isArticle" title="Article"></div>            	
        	{{/if}}
            </td>
            <td id="title" title="Click here to go to the native post"><a href="{{:contextUrl}}" target="_blank">{{:title}}</a></td>
			<td id="details">
				<div style="display: inline-block;">
					<div id="postedBy"><span class="title">Posted By&nbsp;:&nbsp;</span>{{:voiceName}}</div>
					<div id="dateTime">{{:~formatDateTime(datetimePosted)}}</div>
				</div>								
			</td>
		</tr>
        <tr class="btm">
            <td id="content" colspan="3">
            	{{:~formatContent(content)}}
            </td>
        </tr>

    </table>
    {{/for}}
</script>

<script type="text/javascript">

</script>

<script type="text/x-jsrender" id="postDetailTitleTemplate">
    List of {{:scope}} posts {{if date}}on {{:date}} {{else}}from {{:from_date}} to {{:to_date}} {{/if}} <div id="export" class="export"></div>
</script>

<div class="panels" id="detailsTitle">
</div> <!-- #detailsTitle end -->

<div class="panels" id="top-panel">
	<div id="left-panel">
	    <div id="left-wrap">
			<div id="postSort">
				<div class="tab" id="sortBy">SORT BY :</div>
				<div class="tab" id="sentimentScore">Sentiment</div>
				<div class="tab desc" id="datetimePostedMil">Date / Time</div>
				<div class="tab" id="influenceScore">Influence</div>
                <div class="tab" id="commentCount" style="display: none;">No. of Comment(s)</div>
                <div class="tab" id="title">Title</div>
				<div class="tab" id="channelCountry">Country</div>
				%{--<div class="tab" id="channelName">Channel Name</div>--}%
			</div>
	    </div> <!-- #left-wrap end -->
	</div> <!-- #left-panel end -->
	
	<div id="right-panel">
	    <div id="right-wrap">
	    </div> <!-- #right-wrap end -->
	</div> <!-- #right-panel end -->
</div> <!-- #top-panel end -->

<div class="panels" id="main-panel">
	<div id="left-panel">
	    <div id="left-wrap">
	    </div> <!-- #left-wrap end -->
	</div> <!-- #left-panel end -->
	
	<div id="right-panel">
	    <div id="right-wrap">
	    </div> <!-- #right-wrap end -->
	</div> <!-- #right-panel end -->
</div> <!-- #main-panel end -->

<div class="panels" id="foot-panel">
	<div id="left-panel">
	    <div id="left-wrap">
			<!--div></div-->
			
			<div id="pagination">
				<div id="pageNumber"></div>
				<div class="btn" id="firstPage"><<</div>
				<div class="btn" id="prevPage"><</div>
				<div class="btn" id="nextPage">></div>
				<div class="btn" id="lastPage">>></div>
			</div>
		</div> <!-- #left-wrap end -->
	</div> <!-- #left-panel end -->
	
	<div id="right-panel">
	    <div id="right-wrap">
			<!--div></div-->
			
			<div id="pagination">
				<div id="pageNumber"></div>
				<div class="btn" id="firstPage"><<</div>
				<div class="btn" id="prevPage"><</div>
				<div class="btn" id="nextPage">></div>
				<div class="btn" id="lastPage">>></div>
			</div>
	    </div> <!-- #right-wrap end -->
	</div> <!-- #right-panel end -->
</div> <!-- #foot-panel end -->
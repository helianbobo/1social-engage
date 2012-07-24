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
    $(document).ready(function(){

        var currentPostSearchOption = {};
        var currentContextSearchOption = {};

        var totalPost;
        var currentPostPage = 1;
        var postPageSize = 10;

        var postSort = 'datetimePostedMil';
        var postOrder = 'desc';

        var totalContext;
        var currentContextPage = 1;
        var contextPageSize = 5;

        var contextSort = 'datetimePosted';
        var contextOrder = 'asc';

        var defaultPostPaginationOptions = {
            max:postPageSize,
            offset:(currentPostPage-1)*postPageSize,
            order:postOrder
        };

        var defaultContextPaginationOptions = {
            max:contextPageSize,
            offset:(currentContextPage-1)*contextPageSize,
            order:contextOrder
        };

        $.templates( "ticketsTableTmpl", "#ticketsTableTemplate" );
        $.templates( "postContextTmpl", "#postContextTemplate" );
        $.templates( "postDetailTitleTmpl", "#postDetailTitleTemplate" );

        function renderTicketList(data){

            if(data.comment_count){
                $('#commentCount').show();
            }else{
                $('#commentCount').hide();
            }

            var totalFromChart = data.total;
            currentPostSearchOption = $.extend({}, defaultPostPaginationOptions, data);

            $('#chartDetails').slideDown('fast');

            renderTitle({
                from_date:data.from_date,
                to_date:data.to_date,
                date: data.date,
                scope:data.scope,
                grouping:data.grouping,
                keyword_selected: data.keyword_selected
            });
            $(document).trigger('showPreloader', [{places:[$("#chartDetails #main-panel #left-wrap")]}]);
            var callback = function (data) {
                totalPost = totalFromChart;
                if(data.total)
                    totalPost = data.total;

                var totalPage = Math.ceil(totalPost/postPageSize);
                
                var start = (currentPostPage-1)*postPageSize;
                if (totalPost<(start+postPageSize))
                	$('#chartDetails #left-panel #pageNumber').html('Showing ' + (start+1) + ' to ' + totalPost + ' of ' + totalPost);
                else
                	$('#chartDetails #left-panel #pageNumber').html('Showing ' + (start+1) + ' to ' + (start+postPageSize) + ' of ' + totalPost);
                        
                //$('#chartDetails #left-panel #pageNumber').html(currentPostPage + " of " + totalPage);

				$('#chartDetails #left-panel #postSort .tab').each(function(){
					$(this).removeClass('asc').removeClass('desc');
					
					if ($(this).attr('id') == postSort){
						if (postOrder == 'asc'){
							$(this).addClass('asc');
						} else {
							$(this).addClass('desc');
						}
					}
				});
				
                $("#chartDetails #main-panel #left-wrap").html(
                        $.render.ticketsTableTmpl( data )
                );

                $('#chartDetails #main-panel #right-wrap').html('');

            };
            $.ajax({
                url:  '${request.contextPath}/commonApi/getPosts',
                type: "POST",
                data: currentPostSearchOption,
                dataType: "json"
            }).done(callback);

        }

        $('#export').live('click', function () {
            var params = $.extend({}, currentPostSearchOption);
            delete params.max;
            $.download('${request.contextPath}/commonApi/getPosts' + '.csv', params);
        });

        function renderPostContext(data){
            var totalFromChart = data.total;

            $(document).trigger('showPreloader', [{places:[$("#main-panel #right-wrap")]}]);

            currentContextSearchOption = $.extend(defaultContextPaginationOptions, data);

            $.getJSON('${resource(dir: 'commonApi/getPostContext')}',
                    currentContextSearchOption,
                    function (data) {

                        totalContext = totalFromChart;
                        if(data.total)
                            totalContext = data.total;

                        var totalPage = Math.ceil(totalContext/contextPageSize);
                        if(data.page)
                            currentContextPage = data.page;

                        //$('#chartDetails #right-panel #pageNumber').html(currentContextPage + " of " + totalPage);

                        var start = (currentContextPage-1)*contextPageSize;
                        $('#chartDetails #right-panel #pageNumber').html('Showing ' + (start+1) + ' to ' + (start+data.data.length) + ' of ' + totalContext);

                        $('#chartDetails #right-panel #sortOrder').html('by ' + contextOrder + ' Order');

                        $("#chartDetails #main-panel #right-wrap").html(
                            $.render.postContextTmpl( data )
                        );
                    }
            );

        }

        $('#chartDetails #left-panel #prevPage').live('click', function(){
            if((currentPostPage-1)>0){
                currentPostPage--;
                currentPostSearchOption.offset = (currentPostPage-1)*postPageSize;
                renderTicketList(currentPostSearchOption);
            }
        });

        $('#left-panel #nextPage').live('click', function(){
            if((currentPostPage)*postPageSize < totalPost){
                currentPostPage++;
                currentPostSearchOption.offset = (currentPostPage-1)*postPageSize;
                renderTicketList(currentPostSearchOption);
            }
        });

        $('#chartDetails #left-panel #firstPage').live('click', function(){
            currentPostPage = 1;
            currentPostSearchOption.offset = (currentPostPage-1)*postPageSize;
            renderTicketList(currentPostSearchOption);
        });

        $('#chartDetails #left-panel #lastPage').live('click', function(){
            currentPostPage = totalPost/postPageSize;
            currentPostSearchOption.offset = (currentPostPage-1)*postPageSize;
            renderTicketList(currentPostSearchOption);
        });

        $('#chartDetails #right-panel #prevPage').live('click', function(){
            if((currentContextPage-1)>0){
                currentContextPage--;
                delete currentContextSearchOption.scrollTo;
                currentContextSearchOption.offset = (currentContextPage-1)*contextPageSize;
                renderPostContext(currentContextSearchOption);
            }
        });

        $('#chartDetails #right-panel #nextPage').live('click', function(){
            if((currentContextPage)*contextPageSize < totalContext){
                currentContextPage++;
                delete currentContextSearchOption.scrollTo;
                currentContextSearchOption.offset = (currentContextPage-1)*contextPageSize;
                renderPostContext(currentContextSearchOption);
            }
        });

        $('#chartDetails #right-panel #firstPage').live('click', function(){
            currentContextPage = 1;
            delete currentContextSearchOption.scrollTo;
            currentContextSearchOption.offset = (currentContextPage-1)*contextPageSize;
            renderPostContext(currentContextSearchOption);
        });

        $('#chartDetails #right-panel #lastPage').live('click', function(){
            currentContextPage = totalContext/contextPageSize;
            delete currentContextSearchOption.scrollTo;
            currentContextSearchOption.offset = (currentContextPage-1)*contextPageSize;
            renderPostContext(currentContextSearchOption);
        });

        function changeSortBy(sort){
            currentPostPage = 1;
            currentPostSearchOption.offset = 0;
            currentPostSearchOption.sort = sort;
            renderTicketList(currentPostSearchOption);
        }

        function switchOrder(){
            if(postOrder == 'desc')
                postOrder = 'asc';
            else
                postOrder = 'desc';

            return postOrder;
        }

        $('#chartDetails #postSort .tab').live('click', function(){
            if(postSort != this.id){
                postSort = this.id;
            } else {
                currentPostSearchOption.order = switchOrder();
            }
                
            changeSortBy(postSort);
        });

        $('#chartDetails .post').live('click', function(){
        	$('.post').each(function(){
        		$(this).addClass('inactive');
        	});
        	
        	$(this).removeClass('inactive').addClass('active');
        });

        $('#chartDetails .post #content').live('click', function(){
            var ticket_id = $(this).parent().parent().parent().attr('id').substring(7);
            var commentId = $(this).find('input[name="commentId"]').val();
            currentContextPage = 1;
            currentContextSearchOption = $.extend(
                    defaultContextPaginationOptions,
                    {
                        ticket_id:ticket_id,
                        scrollTo:commentId
                    });
	        renderPostContext(currentContextSearchOption);

        });

        $(document).live('showPostDetails', function(event, data){
            currentPostPage = 1;
            currentPostSearchOption.offset = 0;

            currentContextPage = 1;
            currentContextSearchOption.offset = 0;
            renderTicketList(data);
        });

        $(document).live('renderChart', function(event, data){
            cleanPostDetails()
        });

        $(document).live('searchOptionChanged', function(event, data){
            cleanPostDetails();
        });

        function cleanPostDetails() {
            postSort = 'datetimePostedMil';
            postOrder = 'desc';

            $('#chartDetails').slideUp('fast', function(){
                $('#main-panel #left-wrap').html('');
                $('#main-panel #right-wrap').html('');
            });
        }

        function renderTitle(data){
            if(data.keyword_selected){
                data.scope = data.keyword_selected;
            }else{
                if(data.grouping == 'topic'){
                    var topicList = [];
                    $(new String(data.scope).split(',')).each(function(index, topicId){
                        topicList.push($.brandtologyUserData.topicMap[topicId]);
                    });
                    data.scope = topicList.join(', ');
                }else{
                    var subjectList = [];
                    $(new String(data.scope).split(',')).each(function(index, subjectId){
                        subjectList.push($.brandtologyUserData.subjectMap[subjectId]);
                    });
                    data.scope = subjectList.join(', ');
                }
            }
            var postDetailTitleTmpl = $.render.postDetailTitleTmpl(data);
            $('#chartDetails #detailsTitle').html(postDetailTitleTmpl);
        }
        
        $('#content-expand').live('click', function(){
			$(this).parent().hide();
			$(this).parent().parent().children('#content-full').show();
		});
		
		$('#heightCtrl').live('click', function(){
			var tparentid = $(this).parent().parent().parent().attr('id');
			
			if ($(this).children('.icon').hasClass('collapse')){
				$('.post#' + tparentid + ' .mid').slideUp();
				$('.post#' + tparentid + ' .btm').slideUp();
				$(this).children('.icon').removeClass('collapse');
				
			} else {
				$('.post#' + tparentid + ' .mid').slideDown();
				$('.post#' + tparentid + ' .btm').slideDown();
				$(this).children('.icon').addClass('collapse');
			}			
		});

    });
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
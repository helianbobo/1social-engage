<r:script disposition="defer">
    $(document).ready(function () {


      runAccordion(1);
        var vars = {};

        $.views.tags({
            setvar: function(key, value) {
                vars[key] = value;
            }
        });

        $.views.helpers({
            getvar: function(key) {
                return vars[key];
            }
        });

        $.templates("topicSubjectTreeTmpl", "#topicSubjectTreeTemplate");
        $.templates("channelCountryTmpl", "#channelCountryTemplate");
        $.templates("channelTypeTmpl", "#channelTypeTemplate");
        $.templates("channelLanguageTmpl", "#channellanguageTemplate");



        function renderSelect(){
            $('#post_type').val($.brandtologyUserData.is_close);
        }

        function renderTree() {

                $("#category").html(
                     $.render.topicSubjectTreeTmpl($.brandtologyUserData.client_details)
                );


                checkboxHandlerObj.init();

                $("#category").treeview({
                    persist: "location",
                    collapsed: true,
                    unique: true
                });

        }

        function renderDatePicker(){
            var dates = $( "#from_date, #to_date" ).datepicker({
                dateFormat: 'yy-mm-dd',
                changeMonth: true,
                numberOfMonths: 1,
                showOn: "button",
                buttonImage: "${resource(dir: 'images', file: 'icon_calendar.gif')}",
                buttonImageOnly: true,
                onSelect: function( selectedDate ) {
                    var option = this.id == "from_date" ? "minDate" : "maxDate",
                    instance = $( this ).data( "datepicker" ),
                    date = $.datepicker.parseDate(
                        instance.settings.dateFormat ||
                        $.datepicker._defaults.dateFormat,
                        selectedDate, instance.settings );
                    //dates.not( this ).datepicker( "option", option, date );
                }
            });
        }

        function renderChannels(){
            $('#countryList').html($.render.channelCountryTmpl($.brandtologyUserData.client_details));
            $('#channelTypeList').html($.render.channelTypeTmpl($.brandtologyUserData.client_details));
             $('#languageList').html($.render.channelLanguageTmpl($.brandtologyUserData.client_details));

            if($.brandtologyUserData.channel_country)
                $('input[name="channel_country"]').val($.brandtologyUserData.channel_country.split(','));
            if($.brandtologyUserData.channel_site_type)
                $('input[name="channel_site_type"]').val($.brandtologyUserData.channel_site_type.split(','));
             if($.brandtologyUserData.channel_language)
              $('input[name="channel_language"]').val($.brandtologyUserData.channel_language.split(','));
        }

        function renderAll(){
            renderDatePicker();
            renderSelect();
            renderTree();
            renderChannels();
        }

        if($.brandtologyUserData)
            renderAll();
        else
            $(document).live('sessionReady', renderAll);
    });


    /* topic & subject checkboxes function*/
    var checkboxHandlerObj = {

        init: function()
        {
            $($.brandtologyUserData.scope.split(',')).each(function(index,value){
            	$('#category input:checkbox[value="'+$.brandtologyUserData.grouping.charAt(0)+'_'+value+'"]').attr('checked', true);

				if ($.brandtologyUserData.grouping.charAt(0) == 't'){
            		$('#category input:checkbox[class^="t_"]').show();
            		$('#category input:checkbox[class^="all-"]').hide();
            		$('#category input:checkbox[class^="parent-"]').attr('checked',false);
                    $('#category input:checkbox[class^="parent-"]').attr('disabled',true);
				}
            });

            $('#category input:checkbox[class^="t_"]').click(checkboxHandlerObj.topicClicked);
		    $('#category input:checkbox[class^="all-"]').click(checkboxHandlerObj.allClicked);
        },

        allClicked: function()
        {
            if ($(this).attr('checked'))
			{
			   	$('#category input:checkbox.t_'+$(this).attr('id')).hide();
			   	$('#category input:checkbox.t_'+$(this).attr('id')).attr('checked',false);

			   	$('#category input:checkbox[class^="parent-"]').attr('disabled', false);
			   	$('#category input:checkbox.parent-'+$(this).attr('id')).attr('checked', true);
            }
            else
            {
                $(this).hide();

                $('#category input:checkbox.t_'+$(this).attr('id')).show();
                $('#category input:checkbox.t_'+$(this).attr('id')).attr('checked',false);

                $('#category input:checkbox.parent-'+$(this).attr('id')).attr('checked',false);
            }
        },

		topicClicked: function()
        {
            if ($(this).attr('checked'))
			{
                $('#category input:checkbox.all-'+$(this).attr('id')).hide();
			   	$('#category input:checkbox.all-'+$(this).attr('id')).attr('checked',false);

                $('#category input:checkbox[class^="parent-"]').attr('checked',false);
                $('#category input:checkbox[class^="parent-"]').attr('disabled',true);

                $('#category input:checkbox[class^="all-"]:visible').each(function(){
                	$(this).hide();
                	$('#category input:checkbox.t_'+$(this).attr('id')).show();

                	if($(this).is(':checked')){
                		$('#category input:checkbox.t_'+$(this).attr('id')).attr('checked', true);
                		$(this).attr('checked', false);
                	}
                });
            }
            else
            {
               	$(this).hide();

                $('#category input:checkbox.all-'+$(this).attr('id')).show();
			   	$('#category input:checkbox.all-'+$(this).attr('id')).attr('checked',false);

                $('#category input:checkbox[class^="parent-"]').attr('checked',false);
                $('#category input:checkbox[class^="parent-"]').attr('disabled',false);

                $('#category input:checkbox[class^="t_"]:visible').each(function(){
                	$(this).hide();
                	$('#category input:checkbox.all-'+$(this).attr('id')).show();

                	if($(this).is(':checked')){
                		$('#category input:checkbox.all-'+$(this).attr('id')).attr('checked', true);
                		$('#category input:checkbox.parent-'+$(this).attr('id')).attr('checked', true);
                		$(this).attr('checked', false);
                	}
                });
            }
        }
    }

	<!-- select channel radio case switch-->
   $(function() {
		$( "#tabs" ).tabs();
	});


	   $('#yesbtn').click(function () {
	   		//$('#yesbtn').text('Loading...');

			var from_date = $("input#from_date").val();
            var to_date = $("input#to_date").val();
			var is_close = $("select#post_type").val();
			var grouping;
			var scope = [];

			var channel_site_type = [];
			$('input[name="channel_site_type"]:checked').each(function(index, item){
			    channel_site_type.push($(item).val());
			});
			var channel_country = [];
			$('input[name="channel_country"]:checked').each(function(index, item){
			    channel_country.push($(item).val());
			});
			var channel_language = [];
			$('input[name="channel_language"]:checked').each(function(index, item){
			    channel_language.push($(item).val());
			});

	       	$('#category :checked').each(function() {
	       		if($(this).val().indexOf('all')<0){
	       			if($(this).val().charAt(0)=='t'){grouping='topic';}
	       			else{grouping='subject';}

	       			scope.push($(this).attr('id'));
	       		}
	       	});

			$.ajax({
			    url:  '${request.contextPath}/commonApi/updateUserData',
			    type: "POST",
			    data: {
			        from_date:from_date,
			        to_date:to_date,
			        is_close:is_close,
			        grouping:grouping,
			        scope:scope.toString(),
			        channel_country: channel_country.toString(),
			        channel_language: channel_language.toString(),
			        channel_site_type:channel_site_type.toString()
			    },
			    dataType: "json"
			}).done(function(){
			    $.brandtologyUserData.from_date = from_date;
			    $.brandtologyUserData.to_date = to_date;
			    $.brandtologyUserData.is_close = is_close;
			    $.brandtologyUserData.grouping = grouping;
			    $.brandtologyUserData.scope = scope.toString();
			    $.brandtologyUserData.channel_country = channel_country.toString();
			    $.brandtologyUserData.channel_language = channel_language.toString();
			    $.brandtologyUserData.channel_site_type = channel_site_type.toString();

				$(document).trigger('searchOptionChanged');
			});



    });
     var ContentHeight = 0;
     var TimeToSlide = 200;
     var openAccordion = '';


     function runAccordion(index)
     {
       var nID = "Accordion" + index + "Content";
       if(openAccordion == nID)
         nID = '';

       ContentHeight = document.getElementById("Accordion" + index + "Content"+"_").offsetHeight;
       setTimeout("animate(" + new Date().getTime() + "," + TimeToSlide + ",'"
           + openAccordion + "','" + nID + "')", 33);

       openAccordion = nID;
     }

     function animate(lastTick, timeLeft, closingId, openingId)
     {
       var curTick = new Date().getTime();
       var elapsedTicks = curTick - lastTick;

       var opening = (openingId == '') ? null : document.getElementById(openingId);
       var closing = (closingId == '') ? null : document.getElementById(closingId);


       if(timeLeft <= elapsedTicks)
       {

         if(opening != null)
                 opening.style.height = 'auto';


         if(closing != null)
         {
           //closing.style.display = 'none';
           closing.style.height = '0px';
         }
         return;
       }

       timeLeft -= elapsedTicks;
       var newClosedHeight = Math.round((timeLeft/TimeToSlide) * ContentHeight);

       if(opening != null)
       {
         if(opening.style.display != 'block')
           opening.style.display = 'block';
         opening.style.height = (ContentHeight - newClosedHeight) + 'px';
       }

       if(closing != null)
         closing.style.height = newClosedHeight + 'px';

       setTimeout("animate(" + curTick + "," + timeLeft + ",'"
           + closingId + "','" + openingId + "')", 33);
     }


     $(function() {
     		var dates = $( "#from, #to" ).datepicker({
     			defaultDate: "+1w",
     			changeMonth: true,
     			numberOfMonths: 1,
     			onSelect: function( selectedDate ) {
     				var option = this.id == "from" ? "minDate" : "maxDate",
     					instance = $( this ).data( "datepicker" ),
     					date = $.datepicker.parseDate(
     						instance.settings.dateFormat ||
     						$.datepicker._defaults.dateFormat,
     						selectedDate, instance.settings );
     				dates.not( this ).datepicker( "option", option, date );
     			}
     		});
     	});


        /* adding this code to ensured that Popup datepicker moves relative to the content not the window size */
        	$(window).resize(function() {
                            var field = $(document.activeElement);
                            if (field.is('.hasDatepicker')) {
                                  field.datepicker('hide').datepicker('show');
                            }
                      });
</r:script>

<script id="topicSubjectTreeTemplate" type="text/x-jsrender">
    <ul>
        {{for topicSubjectDetails}}
        {{setvar "topicId" topicId/}}
        <li class="collapsable">
            <div class="hitarea collapsable-hitarea"></div>
            <input id="{{:topicId}}" class="all-{{:topicId}} topicSubject" type="checkbox" value="all-{{:topicId}}">
            <input id="{{:topicId}}" class="t_{{:topicId}} topicSubject" type="checkbox" style="display:none;"
                   value="t_{{:topicId}}">
            {{:topic}}

            <ul>
                {{for subjectDetails}}
                <li><input id="{{:id}}" class="parent-{{:~getvar('topicId')}} topicSubject" type="checkbox"
                           value="s_{{:id}}"> {{:name}}</li>
                %{--<li class="last"><input id="s16" class="parent-s1" type="checkbox">Subject 2</li>--}%
                {{/for}}
            </ul>
        </li>
        {{/for}}
    </ul>

</script>


<script type="text/x-jsrender" id="channelCountryTemplate">
    {{for countryList}}
      <tr>
                                               </tr>
    <tr>
        <td width="56%">{{:~formatCountry(#data)}}</td>
        <td width="10%">&nbsp;</td>
        <td width="34%"><input type="checkbox" name="channel_country" value="{{:#data}}">
        </td>
    </tr>
    {{/for}}
</script>
<script type="text/x-jsrender" id="channelTypeTemplate">
    {{for channelType}}
      <tr>
                                               </tr>
    <tr>
        <td width="56%">{{:#data}}</td>
        <td width="10%">&nbsp;</td>
        <td width="34%"><input type="checkbox" name="channel_site_type" value="{{:#data}}">
        </td>
    </tr>
    {{/for}}
</script>

<script type="text/x-jsrender" id="channellanguageTemplate">
    {{for languageList}}
      <tr>
                                               </tr>
    <tr>
        <td width="56%">{{:#data}}</td>
        <td width="10%">&nbsp;</td>
        <td width="34%"><input type="checkbox" name="channel_language" value="{{:#data}}">
        </td>
    </tr>
    {{/for}}
</script>



<div id="AccordionContainer" class="AccordionContainer">
    <div onclick="runAccordion(1);">
        <div class="AccordionTitle" onselectstart="return false;">
            Select Date
        </div>

    </div>
    <div id="Accordion1Content" class="AccordionContent">
        <div id="Accordion1Content_" class="AccordionContent_">

    <p>From <input type="text" id="from_date" name="from" value=""/><br><br> To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
        type="text" id="to_date" name="to" value=""/></p>
        </div>
    </div>
    <div onclick="runAccordion(2);">
        <div class="AccordionTitle" onselectstart="return false;">

           Select Posts
        </div>
    </div>
    <div id="Accordion2Content" class="AccordionContent">
        <div id="Accordion2Content_" class="AccordionContent_">
         <p>
                     <select name="post_type" id="post_type">
                         <option value="0">All Posts</option>
                         <option value="1">Verified Posts</option>
                         <option value="2">Verified Posts With Sentiment</option>
                     </select>
                 </p>
        </div>
    </div>
    <div onclick="runAccordion(3);">

        <div class="AccordionTitle" onselectstart="return false;">
           Select Category and Subjects
        </div>
    </div>
    <div id="Accordion3Content" class="AccordionContent">
        <div id="Accordion3Content_" class="AccordionContent4_">

    <p>

          <ul id="category" class="treeview">

              %{--<ul>
                  <li class="collapsable"><div class="hitarea collapsable-hitarea"></div><input id="s1" class="parent"
                                                                                                type="checkbox"
                                                                                                value="cat1"> <input
                          id="s1" class="all-s1" type="checkbox" style="display:none;" value="cat1"> Category 1
                      <ul>
                          <li><input id="s15" class="parent-s1" type="checkbox" checked=""> Subject 1</li>
                          <li class="last"><input id="s16" class="parent-s1" type="checkbox">Subject 2</li>
                      </ul>
                  </li>

                  <li class="collapsable lastCollapsable"><div
                          class="hitarea collapsable-hitarea lastCollapsable-hitarea"></div><input id="s2" class="parent"
                                                                                                   type="checkbox">   <input
                          id="s2" class="all-s2" type="checkbox" style="display:none;"> Category 2
                      <ul>
                          <li><input id="s15" class="parent-s2" type="checkbox"> Subject 1</li>
                          <li class="last"><input id="s16" class="parent-s2" type="checkbox">Subject 2</li>
                      </ul>
                  </li>--}%
          </ul>
         </p>
      </div>
    </div>

    <div onclick="runAccordion(4);">
        <div class="AccordionTitle" onselectstart="return false;">
            Select Channels</div>
    </div>
    <div id="Accordion4Content" class="AccordionContent">
        <div id="Accordion4Content_" class="AccordionContent4_">
             <div id="tabs" style="height:auto; width:auto;">
                      <ul>
                          <li><a href="#tabs-1">Country</a></li>
                          <li><a href="#tabs-2">Channel Type</a></li>
                            <li><a href="#tabs-3">Language</a></li>
                      </ul>

                      <div id="tabs-1">
                          <table width="100%" border="1" class="display">
                              <tr>
                                  <th>Country</th>
                              </tr>
                               <tr>
                                 </tr>
                              <tbody id="countryList">

                              </tbody>
                          </table>
                      </div>

                      <div id="tabs-2">
                          <table width="100%" border="1" class="display">
                              <tr>
                                  <th>Channel Type</th>
                              </tr>

                              <tbody id="channelTypeList">

                              </tbody>
                          </table>
                      </div>


                         <div id="tabs-3">
       <table width="100%" border="1" class="display">
           <tr>
               <th>Languages</th>
           </tr>

           <tbody id="languageList">

           </tbody>
       </table>
   </div>

                  </div>

          </div>

    </div>

          <p>

          <div class="yesbtn" id="yesbtn">Apply Selection</div></p>
</div>



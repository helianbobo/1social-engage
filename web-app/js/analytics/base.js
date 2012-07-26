define(
  [
    'lib/jquery-x'
  , 'jquery.views'
  , 'jquery.ui.datepicker'
  , 'jquery.ui.tabs'
  , 'jquery.treeview'
  , 'jquery.uniform'
  ]
, function() {
  // env setup
  $.contextPath = CONTEXT_PATH || ''

  $(document).ready(function() {
    var percentBtn = $('#chartOption #percent');
    var barBtn = $('#chartOption #bar');
    var stackedBtn = $('#chartOption #stacked');
    var pieBtn = $('#chartOption #pie');

    percentBtn.click(function() {
      percentBtn.addClass('active');
      stackedBtn.removeClass('active');
      barBtn.removeClass('active');
      pieBtn.removeClass('active');

      $(document).trigger('percent');
    });

    stackedBtn.click(function() {
      stackedBtn.addClass('active');
      percentBtn.removeClass('active');
      barBtn.removeClass('active');
      pieBtn.removeClass('active');

      $(document).trigger('stacked');
    });

    barBtn.click(function() {
      barBtn.addClass('active');
      percentBtn.removeClass('active');
      stackedBtn.removeClass('active');
      pieBtn.removeClass('active');

      $(document).trigger('bar');
    });

    pieBtn.click(function() {
      pieBtn.addClass('active');
      percentBtn.removeClass('active');
      stackedBtn.removeClass('active');
      barBtn.removeClass('active');

      $(document).trigger('pie');
    });

    $('#menuItem select').uniform({useID: true});
    $('#menuItem select').change(function () {
      $(document).trigger($(this).val());
    });
  });

  // channel detail
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
       url = _.absolutePath($.contextPath, '/socialAnalytics/getCumulativeChannel');
      if(options.type == "New Channels"){
        url = _.absolutePath($.contextPath, '/socialAnalytics/getNewChannel');
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

  // voice detail
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
      url = _.absolutePath($.contextPath, '/socialAnalytics/getCumulativeVoice');
      if(options.type == "New Voices"){
        url = _.absolutePath($.contextPath, '/socialAnalytics/getNewVoice');
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

  // post detail
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
        url:  _.absolutePath($.contextPath, '/commonApi/getPosts'),
        type: "POST",
        data: currentPostSearchOption,
        dataType: "json"
      }).done(callback);

    }

    $('#export').live('click', function () {
      var params = $.extend({}, currentPostSearchOption);
      delete params.max;
      $.download(_.absolutePath($.contextPath, '/commonApi/getPosts' + '.csv'), params);
    });

    function renderPostContext(data){
      var totalFromChart = data.total;

      $(document).trigger('showPreloader', [{places:[$("#main-panel #right-wrap")]}]);

      currentContextSearchOption = $.extend(defaultContextPaginationOptions, data);

      $.getJSON(_.absolutePath($.contextPath, 'commonApi/getPostContext'),
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

  // search options
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
        buttonImage: _.absolutePath($.contextPath, '/images/icon_calendar.gif'),
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
  $(function() { $( "#tabs" ).tabs() });


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
      url:  _.absolutePath($.contextPath, '/commonApi/updateUserData'),
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


  function runAccordion(index) {
    var nID = "Accordion" + index + "Content";
    if(openAccordion == nID)
    nID = '';

    ContentHeight = document.getElementById("Accordion" + index + "Content"+"_").offsetHeight;
    setTimeout("animate(" + new Date().getTime() + "," + TimeToSlide + ",'"
      + openAccordion + "','" + nID + "')", 33);

    openAccordion = nID;
  }

  function animate(lastTick, timeLeft, closingId, openingId) {
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

  window.runAccordion = runAccordion

    /* adding this code to ensured that Popup datepicker moves relative to the content not the window size */
    $(window).resize(function() {
      var field = $(document.activeElement);
      if (field.is('.hasDatepicker')) {
          field.datepicker('hide').datepicker('show');
      }
    });

})
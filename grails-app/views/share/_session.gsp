<%@ page contentType="text/html;charset=UTF-8" %>
%{--<sec:ifLoggedIn>--}%
<r:script disposition="defer">

    $(document).ready(function(){
        $.getJSON("${request.contextPath}/commonApi/getCurrentUserData", function (data) {
            $.brandtologyUserData = data;
            $.brandtologyUserData.topicMap = {};
            $.brandtologyUserData.subjectMap = {};
            $(data.client_details.topicSubjectDetails).each(function(index, topic){
                $.brandtologyUserData.topicMap[topic.topicId] = topic.topic;
                $(topic.subjectDetails).each(function(index, subject){
                    $.brandtologyUserData.subjectMap[subject.id] = subject.name;
                });
            });
            $(document).trigger('sessionReady');
        });
    });

    $.getSearchOptions = function(){

        var options = {
                client_id:$.brandtologyUserData.client_id,
                user_id:$.brandtologyUserData.user_id,
                from_date:$.brandtologyUserData.from_date,
                to_date:$.brandtologyUserData.to_date,
                grouping:$.brandtologyUserData.grouping,
                scope:$.brandtologyUserData.scope,
                is_close:$.brandtologyUserData.is_close,
                is_close_index: $.brandtologyUserData.is_close_index,
                date_range: $.brandtologyUserData.date_range,
                topic_list: $.brandtologyUserData.topic_list,
                subject_list:$.brandtologyUserData.subject_list
            };
        if($.brandtologyUserData.channel_country)
            options.channel_country = $.brandtologyUserData.channel_country;
        if($.brandtologyUserData.channel_site_type)
            options.channel_site_type = $.brandtologyUserData.channel_site_type;
        if($.brandtologyUserData.channel_language)
            options.channel_language = $.brandtologyUserData.channel_language;

        return options;
    };


</r:script>
%{--</sec:ifLoggedIn>--}%
<script type="text/javascript">
    $.contextPath = '${request.contextPath}';
    $.currentModule = '${currentModule}';
    $.currentSubModule = '${currentSubModule}';
</script>
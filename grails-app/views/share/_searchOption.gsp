<r:script disposition="defer">
    
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



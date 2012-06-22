define([
//    'jQuery',
    'Underscore',
    'Backbone',
    'text!templates/weiboReplyList.html'
], function($, _, Backbone, weiboReplyListTemplate){
    var weiboReplyList = Backbone.View.extend({
        render: function(){
            var data = {};
            $.templates('weiboReplyListTmpl', weiboReplyListTemplate);

            var compiledTemplate = $.render.weiboReplyListTmpl(data);
            this.el.html( compiledTemplate );
        }
    });
    return new weiboReplyList;
});
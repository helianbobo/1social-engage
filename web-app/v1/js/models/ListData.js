define([
    'Underscore',
    'Backbone'
], function(_, Backbone){
    var listDataModel = Backbone.Model.extend({
        defaults: {
            total: 0,
            data: []
        },
        params:{
            offset:0,
            max:10

        },
        fetch: function(params){
            this.params = $.extend(this.params, params);
            $.ajax({
                url:  this.url,
                type: "POST",
                data: this.params,
                dataType: "json"
            }).done(function(json){
                this.set(json);
            });
        },
        nextPage:function(){

        }
    });
    return listDataModel;
});
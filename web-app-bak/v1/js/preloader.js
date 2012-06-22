$.preloader = {
    renderPreloaderHtml:function (id) {
        //TODO: Keith will implement the real preloader
        return "<div class='preloader' id='preloader_" + id + "'></div>"
    },
    showDefaultPreloader:function(){
        $('body').append(this.renderPreloaderHtml('default'));
    },
    showPreloader:function(container){
        if(typeof container == 'string')
            $('#' + container).html($.preloader.renderPreloaderHtml(container));
        else
            container.html($.preloader.renderPreloaderHtml(container.attr('id')));

    },
    hideAllPreloader:function(){
        $('[id^=preloader_]').remove();
    },
    hidePreloader:function(id){
        $('#preloader_' + id).remove();
    }

}

$(document).live('showPreloader', function (event, eventData) {
    if (eventData) {
        $(eventData.places).each(function (index, container) {
            $.preloader.showPreloader(container);
        });
    }
    else {
        $.preloader.showDefaultPreloader();
    }
});

$(document).live('hidePreloader', function (event, eventData) {
    if (eventData) {
        $(eventData.places).each(function (index, container) {
            $.preloader.hidePreloader(container);
        });
    } else {
        $.preloader.hideAllPreloader();
    }
});
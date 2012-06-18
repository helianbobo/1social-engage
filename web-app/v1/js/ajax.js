$.ajaxSetup({
    complete:function(data, textStatus, jqXHR){
        if(data.status == '200'){
            var responseJSON = $.parseJSON(data.responseText);
            if(responseJSON.code == '408'){
                alert('Your request has timed out.');
            }
        }

        if(this.url.indexOf('getCurrentUserData') < 0 && this.url.indexOf('updateUserData') < 0)
            setTimeout("$(document).trigger('hidePreloader');", 100);

    },
    beforeSend:function(){
//        $(document).trigger('showPreloader');
    },
    success:function(data){
        if(data.code == '408'){
				console.log(data.message);
//            	alert(data.message);
        }
    },
    error:function(data, textStatus, jqXHR){
        if(data.status == '401'){
            window.location.href = "";
        }
        else if(data.status != '0')
            alert('Your request has timed out.');
    }
});


jQuery.download = function(url, data, method){
    //url and data options required
    if( url && data ){
        //data can be string of parameters or array/object
        data = typeof data == 'string' ? data : jQuery.param(data);
        //split params into form inputs
        var inputs = '';
        jQuery.each(data.split('&'), function(){
            var pair = this.split('=');
            inputs+='<input type="hidden" name="'+ pair[0] +'" value="'+ pair[1] +'" />';
        });
        //send request
        jQuery('<form action="'+ url +'" method="'+ (method||'post') +'">'+inputs+'</form>')
            .appendTo('body').submit().remove();
    };
};
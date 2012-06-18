$('document').ready(function () {

    var contextPath = $('#contextPath').val();

    var spinner = $('#spinner');

    function authAjax() {

		$('#login > #yes').text('Authenticating...');

        $.ajax({
            url:$('#url').val(),
            type:'POST',
            dataType:'JSON',
            data:{
                ajax:true,
                j_username:$('#email').val(),
                j_password:$('#pw').val()
            }
        }).success(
            function (data) {

                if (data.success) {
                    if (data.is_client == 0) {
                        //loginMessage.hide();
                        $('#login').hide();
                        var active = 1;
                        showClientSelection(active);
                    } else {
                        window.location.href = contextPath;
                    }

                }
                else if (data.error) {
                    $('#message > #dataerror').text(data.error).show();
                }
                else {
                    //loginMessage.html(responseText);

                }
            }).error(function (data) {
                $('#message > #invalidacct').show();
            });
    }

    function showClientSelection(active) {
        spinner.show();
        $.getJSON(contextPath + '/commonApi/getClientList', function (data) {
            var client_id = $('#client_id');
            var clientOptionsHtml = '';
            var list;
            if (active == 1)
                list = data.activeList;
            else if (active == 0)
                list = data.inactiveList;
            $.each(list, function (index, item) {
                clientOptionsHtml += '<option value="' + item.id + '">' + item.name + '</option>'
            });
            client_id.html(clientOptionsHtml);

            spinner.hide();

        });
        $('#clientselect').show();
    }

    function getDefaultDetails(client_id) {
        spinner.show();

        $.getJSON(contextPath + '/commonApi/getDefaultDetails', {client_id:client_id}, function (data, textStatus, jqxhr) {
            var from_date = data.dateStart;
            var to_date = data.dateEnd;

            $.ajax({
                url:contextPath + '/commonApi/updateUserData',
                type:"POST",
                data:{clientDetails:jqxhr.responseText},
                dataType:"json"
            }).done(function () {
                    window.location.href = contextPath + '?client_id=' + client_id + '&from_date=' + from_date + '&to_date=' + to_date;
                });


        });
    }

    $('#active').live('change', function () {
        showClientSelection($(this).val());
    });


    $("input").focus(function () {
        $(this).css('color', '#555');
    });

    $("input").blur(function () {
        $(this).css('color', '#B3B3B3');
    });

    $("#email").focus(function () {
        if ($(this).val() == "Email address") {
            $(this).val('');
        }
    });

    $("#email").blur(function () {
        if ($(this).val() == "") {
            $(this).val('Email address');
        }
    });

    $("#pwblur").focus(function () {
        $('#pw').show();
        $('#pwblur').hide();
        $('#pw').focus();
    });

    $("#pw").blur(function () {
        if ($(this).val() == "") {
            $('#pwblur').show();
            $('#pw').hide();
            $('#pwblur').blur();
        }
    });

    $('#login #yes').click(function () {
    	if ($('#login #email').val()=='') {
             $('#message > #blankemail').show();
    	} else if ($('#login #email').val().indexOf('@') < 0) {
             $('#message > #invalidemail').show();
    	} else if ($('#login #pw').val()=='') {
             $('#message > #blankpw').show();
    	} else {
        	authAjax();
    	}    
    });

    $('#login #no').click(function () {
        $('#login').hide();
        $('#forgotpw').show();
    });

    $('#forgotpw #yes').click(function () {
        //$('#forgotpw').hide();
        //$('#clientselect').show();
    });

    $('#forgotpw #no').click(function () {
        $('#forgotpw').hide();
        $('#login').show();
    });

    $('#clientselect #yes').click(function () {
        var client_id = $('#client_id').val();
        if (client_id) {
            getDefaultDetails(client_id);
        }
    });
});
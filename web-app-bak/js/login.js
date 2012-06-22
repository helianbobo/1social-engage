$('document').ready(function () {

    var contextPath = $('#contextPath').val();

    var spinner = $('#spinner');

    function authAjax() {

        var loginMessage = $('#loginMessage');
        loginMessage.html('Sending request ...');
        loginMessage.show();


        $.ajax({
            url:$('#url').val(),
            type:'POST',
            dataType:'JSON',
            data:{
                ajax:true,
                j_username:$('#j_username').val(),
                j_password:$('#j_password').val()
            }
        }).success(
            function (data) {

                if (data.success) {
                    if (data.is_client == 0) {
                        loginMessage.hide();
                        $('#login').hide();
                        var active = 1;
                        showClientSelection(active);
                    } else {
                        window.location.href = contextPath;
                    }

                }
                else if (data.error) {
                    loginMessage.html("<span class='errorMessage'>" +
                        data.error + '</error>');
                }
                else {
                    loginMessage.html(responseText);

                }
            }).error(function (data) {
                loginMessage.html("<span class='errorMessage'>" + 'Failed to Login.' + '</error>');
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

    function getDefaultDetails(client_id){
        spinner.show();

        $.getJSON(contextPath + '/commonApi/getDefaultDetails', {client_id: client_id}, function (data, textStatus, jqxhr) {
            var from_date = data.dateStart;
            var to_date = data.dateEnd;

            $.ajax({
                  url: contextPath + '/commonApi/updateUserData',
                  type: "POST",
                  data: {clientDetails : jqxhr.responseText},
                  dataType: "json"
                }).done(function(){
                    window.location.href = contextPath + '?client_id=' + client_id + '&from_date=' + from_date + '&to_date=' + to_date;
                });


        });
    }


    $('input[name=active]').live('click', function () {
        if (this.checked)
            showClientSelection($(this).val());

    });

    $('#clientselect #yes').click(function () {
        var client_id = $('#client_id').val();
        if(client_id){
            getDefaultDetails(client_id);
        }
    });

    $('#j_username').focus(function () {
        if ($('#j_username').val() == 'Email address')
            $('#j_username').val('');
    });
    $('#j_password').focus(function () {
        if ($('#j_password').val() == 'Password')
            $('#j_password').val('');
    });

    $('#login #yes').click(function () {
        authAjax();
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

});
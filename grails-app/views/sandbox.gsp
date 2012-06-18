<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<!-- Use the .htaccess and remove these lines to avoid edge case issues.
    	       More info: h5bp.com/b/378 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!-- Mobile viewport optimized: j.mp/bplateviewport -->
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>1-Social v2</title>

<!--link rel="shortcut icon" href="../images/favicon/favicon.ico" type="image/x-icon">
    	<link rel="icon"  href="../images/favicon/favicon.ico" type="image/x-icon"-->

%{--<link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'css', file: 'layout.css')}"/>--}%
<link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'css', file: 'reset.css')}"/>
<link rel="stylesheet" type="text/css" media="screen" href="${resource(dir: 'css', file: 'fontface.css')}"/>
<!--link rel="stylesheet" type="text/css" media="screen" href="../css/layout.css" /-->

<script type="text/javascript" src="${resource(dir: 'js', file: 'jquery-1.7.2.min.js')}"></script>
<script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.dataTables.min.js')}"></script>
<!--script type="text/javascript" src="../js/analytics.js"></script-->

<!--[if IE]>
    		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->


<style media="screen" type="text/css">
body {
    font-family: 'BreuerTextRegular';
    font-size: 1.2em;
}

#container {
    clear: both;
    float: left;
    width: 100%; /* width of whole page */
    overflow: hidden; /* This chops off any overhanging divs */
}

header {
    width: 100%;
    text-align: center;
}

nav {
    width: 200px;
    float: left;
}

nav > ul > li {
    cursor: pointer;
}

#contents {
    /*position: relative;
   overflow-y: scroll;
   overflow-x: hidden;
   -ms-overflow-y: scroll;
   -ms-overflow-x: hidden;*/
}

#description {
    background: blue;
    color: white;
}

.panels {
    text-align: center;
}

.btn {
    cursor: pointer;
}

#helpbtn {
    float: right;
}
</style>

<script type="text/javascript">
    var dashboard = ['dashboard', 'this is a description for dashboard', 'dashboard no submodule', 'dashboard charts'];
    var analytics = ['social analytics', 'this is a description for social analytics', 'social analytics submodule #1', 'social analytics menuitem #1 charts', 'social analytics menuitem'];
    var insight = ['social insight', 'this is a description for social insight', 'social insight submodule #1', 'social insight menuitem #1 charts', 'social insight menuitem'];
    var assets = ['social assets', 'this is a description for social assets', 'social assets no submodule', 'social assets charts'];
    var account = ['acccount', 'this is a description for account', 'account submodule #1', 'account menuitem #1 charts', 'social account menuitem'];

    $(document).ready(function () {
        $('#description').hide();
        $('#divider').hide();
        $('#menuitems').hide();

        $('nav > ul > li').click(function () {
            switch ($(this).attr('id')) {
                case 'dashboard':
                    pseudojson(dashboard);
                    break;
                case 'analytics':
                    pseudojson(analytics);
                    break;
                case 'insight':
                    pseudojson(insight);
                    break;
                case 'assets':
                    pseudojson(assets);
                    break;
                case 'account':
                    pseudojson(account);
                    break;
            }
        });

        $('#menuitems').change(function () {
            $('.panels').text($(this).val() + " charts");
        });

        $("#helpbtn").click(function () {
            if ($('#description').is(':visible')) {
                $('#description').slideUp(500);
            } else {
                $('#description').slideDown(500);
            }
        });
    });

    function pseudojson(n) {
        $('header').text(n[0]);
        $('#desciption').text(n[1]);
        $('#submodule').text(n[2]);
        $('.panels').text(n[3]);
        if (n[4]) {
            $('#menuitems option').remove();
            $('#menuitems').append(new Option(n[4] + " #1", n[4] + " #1", true));
            $('#menuitems').append(new Option(n[4] + " #2", n[4] + " #2", true));
            $('#divider').show();
            $('#menuitems').show();
        } else {
            $('#divider').hide();
            $('#menuitems').hide();
        }
    }
</script>




<!-- Highslide code -->
<script src="${resource(dir: 'js', file: 'highcharts.src.js')}"></script>
<!-- End Highslide code -->

<script type="text/javascript">

    var userid = 2243010574;

    function renderTable() {
        var chart;
        $.getJSON('${resource(dir:'table/index')}', {userid:userid, type:'weibo'}, function (data) {

            $('#table').html('<table cellpadding="0" cellspacing="0" border="0" class="display" id="weibotable"></table>');

            $('#weibotable').dataTable(data);

        });
        //chart.redraw();
    }

    function renderLineChart() {
        var chart;
        $.getJSON('${resource(dir:'chart/line')}',{userid:userid, type:'weibo'}, function (data) {

            chart = new Highcharts.Chart({
                chart:{
                    renderTo:'content',
                    height: 500,
                    defaultSeriesType:'line'
                },
                subtitle:{
                    text:'Source: Fitness',
                    x:-20
                },
                xAxis:{
                    categories:data.xAxis
                },
                yAxis:{
                    title:{
                        text:'-weight -Pounds '
                    },
                    plotLines:[
                        {
                            value:0,
                            width:1,
                            color:'#808080'
                        }
                    ]
                },
                tooltip:{
                    formatter:function () {
                        return '<b>' + this.series.name + '</b><br/>' +
                                this.x + ': ' + this.y + ' -Pounds';
                    }
                },
                legend:{
                    borderWidth:0
                },
                series:data.series
            });


        });
        //chart.redraw();
    }

    function renderPieChart() {
        var chart;
        $.getJSON('${resource(dir:'chart/pie')}',{userid:userid, type:'weibo'}, function (data) {

            chart = new Highcharts.Chart({

                chart:{

                    renderTo:'content',

                    plotBackgroundColor:null,

                    plotBorderWidth:null,

                    plSothadow:false,

                    width:500,

                    height:400

                },

                title:{

                    text:'Location'



                },

                tooltip:{

                    formatter:function () {

                        return '<b>' + this.point.name + '</b>: ' + this.y + '( ' + Highcharts.numberFormat((this.percentage)) + '%) ';

                    }

                },

                plotOptions:{

                    pie:{

                        allowPointSelect:true,

                        cursor:'pointer',

                        dataLabels:{

                            enabled:false

                        },

                        showInLegend:true

                    }

                },

                series:data.series

            });

        });
    }

    $(document).ready(function () {
        renderLineChart();

        renderTable();
    });
</script>

</head>

<body>

<div id="wrapper">
    <div id="container">
        <header>module title</header>

        <nav>
            <ul>
                <li id="dashboard">dashboard</li>
                <li id="analytics">social analytics</li>
                <li id="insight">social insight</li>
                <li id="pulse">social pulse</li>
                <li id="influence">social influence</li>
                <li id="campaign">social campaign</li>
                <li id="assets">social assets</li>
                <li id="engage">social engage</li>
                <li id="explore">social explore</li>
                <li id="report">social report</li>
                <li id="account">account</li>
            </ul>
        </nav>

        <div id="contents">
            <div id="breadcrumbs">
                <span id="submodule"></span>
                <span>></span>

                <select id="menuitems">
                    <option></option>
                </select>

                <span class="btn" id="helpbtn">?</span>

                <div id="description"></div>
            </div> <!-- #breadcrumbs end -->

            <div class="panels">
                <div id="content" style="width:92%; margin-left:25px; text-align:center"></div>

                <div id="table" style="width:92%; margin-left:25px; text-align:center"></div>
            </div> <!-- .panels end -->
        </div> <!-- #contents end -->
    </div> <!-- #container end -->
</div> <!-- #wrapper end -->

</body>
</html>




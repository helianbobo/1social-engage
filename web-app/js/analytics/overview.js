define('analytics/overview', ['jquery'], function() {
  var chartData;
  var currentChart = 'stacked';

  var chart;

  $(document).ready(function(){
    $("#menuItem").hide();
    var spinner = $('#spinner');
    $('.tab#pie').hide();
    $('.tab#bar').css('margin-right','0');

    function renderStackedChart(data){
      $(document).trigger('renderChart');
      
      chart = new Highcharts.Chart({
        brandtologyData:{chartName:'stacked'},
        chart: {
          renderTo: 'chartContainer',
          defaultSeriesType: 'bar',
          zoomType: 'x'
        },
        title: {
          text: '',
          x: -20 //center
        },
        xAxis:{
          categories:data.xAxis
        },
        yAxis: {
          allowDecimals:false,
          title: {
            text: 'Buzz'
          },
          plotLines: [{
            value: 0,
            width: 1,
            color: '#808080'
          }]
        },
        tooltip: {
          formatter: function() {
      return '<b>'+this.x+'</b><br/><b>'+this.y+'</b>'+this.series.name.toLowerCase()+' buzz out of<b>'+this.total+'</b>';
          }
        },
        plotOptions: {
          series: {
            stacking: 'normal',

            /* trigger dialog event*/
            enableMouseTracking: true,
            point: {
              enableMouseTracking: true,
              events: {
                click: function (event) {
                  var data = $.extend($.getSearchOptions(), {
                     client_id:$.brandtologyUserData.client_id,
                     user_id:$.brandtologyUserData.user_id,
                     from_date:$.brandtologyUserData.from_date,
                     to_date:$.brandtologyUserData.to_date,
                     grouping:$.brandtologyUserData.grouping,
                     scope:chartData.xAxisInfo[this.x],
                     is_close:$.brandtologyUserData.is_close,
                     post_selection_sentiment_str: this.series.name
                  });
                  
                  $(document).trigger('showPostDetails', [data]);
                }
              }
            }

          }
        },
        legend: {
          reversed: true,
          borderWidth: 0
        },
        series:data.series
      });
    }

    function renderPercentChart(data){
      $(document).trigger('renderChart');
      
      new Highcharts.Chart({
        brandtologyData:{chartName:'percent'},
        chart: {
          renderTo: 'chartContainer',
          defaultSeriesType: 'bar',
        zoomType: 'x'
        },
        title: {
          text: '',
          x: -20 //center
        },
        xAxis: {
          categories:data.xAxis
        },
        yAxis: {
          title: {
            text: '%'
          },
          plotLines: [{
            value: 0,
            width: 1,
            color: '#808080'
          }]
        },
        tooltip: {
          formatter: function() {
            return '<b>'+this.x+'</b><br/><b>'+Highcharts.numberFormat(this.percentage)+'%</b>'+this.series.name.toLowerCase()+' buzz';

          }
        },
        plotOptions: {
          series: {
            stacking: 'percent',

          /* trigger dialog event*/
          enableMouseTracking: true,
          point: {
          enableMouseTracking: true,
          events: {
            click: function () {
              var data = $.extend($.getSearchOptions(), {
                 client_id:$.brandtologyUserData.client_id,
                 user_id:$.brandtologyUserData.user_id,
                 from_date:$.brandtologyUserData.from_date,
                 to_date:$.brandtologyUserData.to_date,
                 grouping:$.brandtologyUserData.grouping,
                 scope:chartData.xAxisInfo[this.x],
                 is_close:$.brandtologyUserData.is_close,
                 post_selection_sentiment_str: this.series.name
              });
              
              $(document).trigger('showPostDetails', [data]);
            }
          }
          }
          }
        },
        legend: {
          reversed: true,
          borderWidth: 0
        },
        series:data.series
      });
    }

    function renderBarChart(data){
      $(document).trigger('renderChart');
      
      new Highcharts.Chart({
        brandtologyData:{chartName:'bar'},
        chart: {
          renderTo: 'chartContainer',
          defaultSeriesType: 'bar',
        zoomType: 'x'
        },
        colors: $.NON_SENTIMENT_COLOR,
        title: {
          text: ' ',
          x: -20 //center
        },
        xAxis: {
           categories:data.xAxis
        },
        yAxis: {
          allowDecimals:false,
          title: {
            text: 'Total buzz'
          },
          plotLines: [{
            value: 0,
            width: 1,
            color: '#808080'
          }]
        },
        tooltip: {
          formatter: function() {
            return '<b>'+ this.x +'</b><br/><b>'+ this.y +'</b>total buzz';
          }
        },
        /*open dialog*/
          plotOptions: {
          series: {
            enableMouseTracking: true,
            enableMouseTracking: true,
            point: {
            enableMouseTracking: true,
            events: {
            click: function () {
               var data = $.extend($.getSearchOptions(),{
                 client_id:$.brandtologyUserData.client_id,
                 user_id:$.brandtologyUserData.user_id,
                 from_date:$.brandtologyUserData.from_date,
                 to_date:$.brandtologyUserData.to_date,
                 grouping:$.brandtologyUserData.grouping,
                 scope:chartData.xAxisInfo[this.x],
                 is_close:$.brandtologyUserData.is_close,
                 post_selection_sentiment_str: this.series.name
              });
              $(document).trigger('showPostDetails', [data]);
            }
          }
          }

        }
        },
        legend: {
          reversed: true,
          borderWidth: 0,
          labelFormatter: function() {
          if (this.name=='Buzz')return 'Total Buzz';
        }
        },
        series:data.seriesCountAll
      });
    }

     function renderChart() {
       $(document).trigger('showPreloader', [{places:['chartContainer']}]);
       var params = $.getSearchOptions();

       $.getJSON('${resource(dir: 'socialAnalytics/overviewData')}',
        params,
        function (data) {
          chartData = data;
          $(document).trigger(currentChart);
          spinner.hide();
        }
      );
    }

    $(document).live('percent', function(){
      currentChart = 'percent';
      renderPercentChart(chartData);
    });

    $(document).live('bar', function(){
      currentChart = 'bar';
      renderBarChart(chartData);
    });

    $(document).live('stacked', function(){
      currentChart = 'stacked';
      renderStackedChart(chartData);
    });

    $(document).live('searchOptionChanged', function(){
    renderChart();
    });

    if($.brandtologyUserData){
      renderChart();
    }else{
      $(document).live('sessionReady', renderChart);
    }
  });
})
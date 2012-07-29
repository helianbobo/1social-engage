define(['highcharts-exporting', 'highcharts-theme'], function() {

Highcharts.setOptions({
    xAxis: {
        labels: {
            overflow: 'justify'
        }
    },
    credits: {
        enabled: false,
        text: 'Highcharts.com',
        href: 'http://www.highcharts.com',
        position: {
            align: 'right',
            x: -10,
            verticalAlign: 'bottom',
            y: -5
        },
        style: {
            cursor: 'pointer',
            color: '#909090',
            fontSize: '10px'
        }
    },
	 legend: {
        reversed: false,
        borderWidth: 0
    },
    lang:{
        pptsize1:'Power Point: Full Screen',
        pptsize2:'Power Point: Half Screen(Horizontal)',
        pptsize3:'Power Point: Half Screen(Vertical)',
        pptButtonTitle: 'Export the chart to Power Point'
    },

    plotOptions:{
        bar: {
            shadow: false
        },
        column:{
            shadow: false
        }
    },

    exporting:{
        width:null,
        buttons:{

            pptButton:{
//                enabled: true,
                symbol: 'circle',
                x:-62,
                symbolFill:'#779ABF',
                hoverSymbolFill:'#FF8C00',
                _id: 'pptButton',
                _titleKey:'pptButtonTitle',

                menuItems:[
                    {
                        textKey:'pptsize1',
                        onclick:function () {
                            this.exportPPT(1);

                        }
                    },
                    {
                        textKey:'pptsize2',
                        onclick:function () {
                            this.exportPPT(2);
                        }
                    },
                    {
                        textKey:'pptsize3',
                        onclick:function () {
                            this.exportPPT(3);
                        }
                    }
                ]

            },

            exportButton: {
                //enabled: true,
                symbol: 'exportIcon',
                x: -36,
                symbolFill: '#A8BF77',
                hoverSymbolFill: '#768F3E',
                _id: 'exportButton',
                _titleKey: 'exportButtonTitle',
                menuItems: [{
                    textKey: 'downloadPNG',
                    onclick: function () {
                        this.exportChart();
                    }
                }, {
                    textKey: 'downloadJPEG',
                    onclick: function () {
                        this.exportChart({
                            type: 'image/jpeg'
                        });
                    }
                }, {
                    textKey: 'downloadPDF',
                    onclick: function () {
                        this.exportChart({
                            type: 'application/pdf'
                        });
                    }
                }, {
                    textKey: 'downloadSVG',
                    onclick: function () {
                        this.exportChart({
                            type: 'image/svg+xml'
                        });
                    }
                }
                    // Enable this block to add "View SVG" to the dropdown menu
                    /*
                     ,{

                     text: 'View SVG',
                     onclick: function () {
                     var svg = this.getSVG()
                     .replace(/</g, '\n&lt;')
                     .replace(/>/g, '&gt;');

                     doc.body.innerHTML = '<pre>' + svg + '</pre>';
                     }
                     } // */
                ]

            },
            printButton: {
                //enabled: true,
                symbol: 'printIcon',
                x: -10,
                symbolFill: '#B5C9DF',
                hoverSymbolFill: '#779ABF',
                _id: 'printButton',
                _titleKey: 'printButtonTitle',
                onclick: function () {
                    this.print();
                }
            }
        }
    }
});

Highcharts.extend(Highcharts.Chart.prototype, {

    sortData:function(sort, order){
        if(!order) order = 'desc';

        var data = [];
        var names = [];
        var options = this.options;

        $(this.options.xAxis.categories).each(function(index, item){
            data.push({
                name: item,
                data: [],
                total: 0
            });
        });

        $(this.options.series).each(function(index, item){
            names.push(item.name);
            $(item.data).each(function(i, dataItem){
                data[i].data.push(dataItem);
                data[i].total += dataItem;
            });
        });

        var sortByTotalFunction = function(a,b){
            var modifier = 1;
            if(order == 'desc')
                modifier = -1;

            return modifier*(a.total - b.total);
        };

        var sortByNameFunction = function(a,b){
            var modifier = 1;
            if(order == 'desc')
                modifier = -1;

            return modifier*(a.name.localeCompare(b.name));
        };

        if(sort == 'total')
            data.sort(sortByTotalFunction);
        else if(sort == 'category')
            data.sort(sortByNameFunction);

        var xAxis = [];
        var series = [];

        $(names).each(function(i, name){
            series.push({name:name, data:[]});
        });

        $(data).each(function(index, item){
            xAxis.push(item.name);
            $(names).each(function(i, name){
                series[i].data.push(item.data[i]);
            });
        });

        options.xAxis.categories = xAxis;
        options.series = [];

        $(series).each(function(index, item){
            options.series.push(item);
        });

        this.destroy();

        return new Highcharts.Chart(options);
    },

    exportPPT: function(option) {
        var params = {
        	user_id:$.brandtologyUserData.user_id,
            module_name:$.currentModule,
            sub_module_name:$.currentSubModule,
//            chart: this.options.brandtologyData.chartName,
            chart_xaxis: JSON.stringify(this.options.xAxis),
            chart_yaxis:JSON.stringify(this.options.yAxis),
            chart_plot_options:JSON.stringify(this.options.plotOptions),
            chart_legend_reversed:JSON.stringify(this.options.legend.reversed),
            chart_legend_borderWidth:JSON.stringify(this.options.legend.borderWidth),
            chart_colors:JSON.stringify(this.options.colors),
            chart_series:JSON.stringify(this.options.series),
            chart_defaultSeriesType:JSON.stringify(this.options.chart.defaultSeriesType),
            chart_option:option
        };
        
        $.ajax({
            url:  $.contextPath  + '/commonApi/exportChartPpt',
            type: "POST",
            data: params,
            dataType: "json"
        }).done(function(data){
            $('<iframe id="secretDownloadIFrame" src="" style="display:none; visibility:hidden;"></iframe>').appendTo($('body'));
            $('#secretDownloadIFrame').attr("src",data.filePath);
        });
    },

//Overwrite original highcharts exporting function to allow multiple export button with menus
    addButton: function (options) {
        var chart = this,
            renderer = chart.renderer,
            btnOptions = Highcharts.merge(chart.options.navigation.buttonOptions, options),
            onclick = btnOptions.onclick,
            menuItems = btnOptions.menuItems,
            buttonWidth = btnOptions.width,
            buttonHeight = btnOptions.height,
            box,
            symbol,
            button,
            borderWidth = btnOptions.borderWidth,
            boxAttr = {
                stroke: btnOptions.borderColor

            },
            symbolAttr = {
                stroke: btnOptions.symbolStroke,
                fill: btnOptions.symbolFill
            },
            symbolSize = btnOptions.symbolSize || 12;

        // Keeps references to the button elements
        if (!chart.exportDivElements) {
            chart.exportDivElements = [];
            chart.exportSVGElements = [];
        }

        if (btnOptions.enabled === false) {
            return;
        }

        // element to capture the click
        function revert() {
            symbol.attr(symbolAttr);
            box.attr(boxAttr);
        }

        // the box border
        box = renderer.rect(
            0,
            0,
            buttonWidth,
            buttonHeight,
            btnOptions.borderRadius,
            borderWidth
        )
            //.translate(buttonLeft, buttonTop) // to allow gradients
            .align(btnOptions, true)
            .attr(Highcharts.extend({
            fill: btnOptions.backgroundColor,
            'stroke-width': borderWidth,
            zIndex: 19
        }, boxAttr)).add();

        // the invisible element to track the clicks
        button = renderer.rect(
            0,
            0,
            buttonWidth,
            buttonHeight,
            0
        )
            .align(btnOptions)
            .attr({
                id: btnOptions._id,
                fill: 'rgba(255, 255, 255, 0.001)',
                title: chart.options.lang[btnOptions._titleKey],
                zIndex: 21
            }).css({
                cursor: 'pointer'
            })
            .on('mouseover', function () {
                symbol.attr({
                    stroke: btnOptions.hoverSymbolStroke,
                    fill: btnOptions.hoverSymbolFill
                });
                box.attr({
                    stroke: btnOptions.hoverBorderColor
                });
            })
            .on('mouseout', revert)
            .on('click', revert)
            .add();

        // add the click event
        if (menuItems) {
            onclick = function () {
                revert();
                var bBox = button.getBBox();
                //Changed by Liu Chao
                chart.contextMenu('export-menu' + btnOptions._id, menuItems, bBox.x, bBox.y, buttonWidth, buttonHeight);
            };
        }
        /*addEvent(button.element, 'click', function() {
         onclick.apply(chart, arguments);
         });*/
        button.on('click', function () {
            onclick.apply(chart, arguments);
        });

        // the icon
        symbol = renderer.symbol(
            btnOptions.symbol,
            btnOptions.symbolX - (symbolSize / 2),
            btnOptions.symbolY - (symbolSize / 2),
            symbolSize,
            symbolSize
        )
            .align(btnOptions, true)
            .attr(Highcharts.extend(symbolAttr, {
            'stroke-width': btnOptions.symbolStrokeWidth || 1,
            zIndex: 20
        })).add();

        // Keep references to the renderer element so to be able to destroy them later.
        chart.exportSVGElements.push(box, button, symbol);
    }

});

function crisp(arr) {
    var i = arr.length;
    while (i--) {
        if (typeof arr[i] === 'number') {
            arr[i] = Math.round(arr[i]) - 0.5;
        }
    }
    return arr;
}

Highcharts.Renderer.prototype.symbols.pptIcon = function (x, y, width, height) {
    return crisp([
        'M', // the disk
        x, y + width,
        'L',
        x + width, y + height,
        x + width, y + height * 0.8,
        x, y + height * 0.8,
        'Z',
        'M', // the arrow
        x + width * 0.5, y + height * 0.8,
        'L',
        x + width * 0.8, y + height * 0.4,
        x + width * 0.4, y + height * 0.4,
        x + width * 0.4, y,
        x + width * 0.6, y,
        x + width * 0.6, y + height * 0.4,
        x + width * 0.2, y + height * 0.4,
        'Z'
    ]);
};

})

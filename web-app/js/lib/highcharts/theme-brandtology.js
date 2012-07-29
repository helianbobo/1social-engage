/**
 * Gray theme for Highcharts JS
 * @author Torstein Hønsi
 */


$.NON_SENTIMENT_COLOR =  ['#7798BF','#7F00AD','#BEAF87','#FFDF20','#7CA70E','#C86B84','#04145E','#AFBE87','#177163','#D9C62D','#5E0414','#A4DFFF', '#C86B5D', '#335C8F', '#FFA4DF', '#A2B816', '#FFDFA4', '#7F00AD','#465096','#90BB94','#FF5BA4','#C6992D','#87AFBE','#909404','#A70E7C','#634C17','#33511E','#BEAF0F','#9094BB','#51338F','#B8A2AE','#A09650','#631771','#00ADAD','#BE87AF','#48D92D','#A05050','#C6D920','#A2B8AE','#637117','#FF5BA4','#5E144A','#007F7F','#DFFFA4','#A77C2B','#A05096','#007FAD','#846BC8','#50A096','#BF5133','#8F5133','#20DFFF'];
  $.NET_SENTIMENT_COLOR = ['#14813C','#E4210D','#7798BF']
Highcharts.theme = {
	/*colors: ["#DDDF0D", "#7798BF", "#55BF3B", "#DF5353", "#aaeeee", "#ff0066", "#eeaaee", 
		"#55BF3B", "#DF5353", "#7798BF", "#aaeeee", '#8A0CCF','#550055','#000040','#0000CC','#CD0D74','#754DEB','#990000','#DDDDDD','#999999','#333333','#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4'],*/


    colors: ['#28CD91','#14813C','#666666','#F8A322','#E4210D','#7798BF','#7F00AD','#BEAF87','#FFDF20','#7CA70E','#C86B84','#04145E','#AFBE87','#177163','#D9C62D','#5E0414','#A4DFFF', '#C86B5D', '#335C8F', '#FFA4DF', '#A2B816', '#FFDFA4', '#7F00AD','#465096','#90BB94','#FF5BA4','#C6992D','#87AFBE','#909404','#A70E7C','#634C17','#33511E','#BEAF0F','#9094BB','#51338F','#B8A2AE','#A09650','#631771','#00ADAD','#BE87AF','#48D92D','#A05050','#C6D920','#A2B8AE','#637117','#FF5BA4','#5E144A','#007F7F','#DFFFA4','#A77C2B','#A05096','#007FAD','#846BC8','#50A096','#BF5133','#8F5133','#20DFFF'],


	title: {
		style: { 
			color: '#000',
			font: 'bold 16px "Trebuchet MS", Verdana, sans-serif'
		}
	},
	subtitle: {
		style: { 
			color: '#666666',
			font: 'bold 12px "Trebuchet MS", Verdana, sans-serif'
		}
	},
	xAxis: {
		gridLineColor: '#333333',
		gridLineWidth:0,
		lineColor: '#000',
		tickColor: '#000',
		labels: {
			style: {
				color: '#000',
				font: '11px Verdana'
			}
		},
		title: {
			style: {
				color: '#333',
				fontWeight: 'bold',
				fontSize: '12px',
				fontFamily: 'Verdana'

			}				
		}
	},

	yAxis: {
		gridLineColor: '#333333',
		gridLineWidth:0,
		/*minorTickInterval: 'auto',*/   <!--grid line for background-->
		lineColor: '#000',
		lineWidth: 1,
		tickWidth: 1,
		tickColor: '#000',
		labels: {
			style: {
				color: '#000',
				font: '11px Verdana'
			}
		},
		title: {
			style: {
				color: '#333',
				fontWeight: 'bold',
				fontSize: '12px',
				fontFamily: 'Verdana'
			}				
		}
	},
	legend: {
		itemStyle: {			
			font: '8pt verdana',
			color: 'black'

		},
		itemHoverStyle: {
			color: '#039'
		},
		itemHiddenStyle: {
			color: 'gray'
		}
	},
	labels: {
		style: {
			color: '#99b'
		}
	}
};

// Apply the theme
var highchartsOptions = Highcharts.setOptions(Highcharts.theme);

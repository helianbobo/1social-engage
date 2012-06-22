/**
 * Gray theme for Highcharts JS
 * @author Torstein Hønsi
 */

Highcharts.theme = {
	/*colors: ["#DDDF0D", "#7798BF", "#55BF3B", "#DF5353", "#aaeeee", "#ff0066", "#eeaaee", 
		"#55BF3B", "#DF5353", "#7798BF", "#aaeeee", '#8A0CCF','#550055','#000040','#0000CC','#CD0D74','#754DEB','#990000','#DDDDDD','#999999','#333333','#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4'],*/



    colors: ['#DDDF0D', '#7798BF', '#55BF3B', '#DF5353','#FF0099','#8A0CCF','#550055','#000040','#0000CC','#CD0D74','#754DEB','#990000','#DDDDDD','#999999','#333333','#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4','#143FC2','#DE0071','#98F100','#FFAE00','#35467A','#8B3460','#749738',' #A0803C','#02195D','#6A0036 ','#487300','#795300','#3B63DA','#EA2D8D',' #ADF62F',' #FFBE31','#597ADA',' #EA519F','#BBF655','#FFCA58','#097DBB','#A803BF','#DAFA00','#FF8B00','#682F78','#A06F3C ','#2E6274','#959E3B'],




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
				font: '11px Trebuchet MS, Verdana, sans-serif'
			}
		},
		title: {
			style: {
				color: '#333',
				fontWeight: 'bold',
				fontSize: '12px',
				fontFamily: 'Trebuchet MS, Verdana, sans-serif'

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
				font: '11px Trebuchet MS, Verdana, sans-serif'
			}
		},
		title: {
			style: {
				color: '#333',
				fontWeight: 'bold',
				fontSize: '12px',
				fontFamily: 'Trebuchet MS, Verdana, sans-serif'
			}				
		}
	},
	legend: {
		itemStyle: {			
			font: '9pt Trebuchet MS, Verdana, sans-serif',
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

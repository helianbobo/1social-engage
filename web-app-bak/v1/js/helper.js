
$.brandtologyUtils = {
    addColorToSeries : function(series){
        $(series).each(function(index, s){
            var result = [];
            $(s.data).each(function(index, item){
                var colorIndex = Math.min(index, $.NON_SENTIMENT_COLOR.length);
                var color = $.NON_SENTIMENT_COLOR[colorIndex];
                result.push({
                    y:item,
                    color: color
                });

            });
            s.data = result;
        });

        return series;
    },
    formatCountry:function (i) {
        switch (i) {
            case "AE":
                return "United Arab Emirates";
            case "AF":
                return "Afghanistan";
            case "AM":
                return "Armenia";
            case "AN":
                return "Netherlands Antilles";
            case "AO":
                return "Angola";
            case "AR":
                return "Argentina";
            case "ASIA":
                return "Asia";
            case "AT":
                return "Austria";
            case "AU":
                return "Australia";
            case "AX":
                return "Aland Islands";
            case "AZ":
                return "Azerbaijan";
            case "BA":
                return "Bosnia and Herzegovina";
            case "BD":
                return "Bangladesh";
            case "BE":
                return "Belgium";
            case "BG":
                return "Bulgaria";
            case "BH":
                return "Bahrain";
            case "BN":
                return "Brunei";
            case "BR":
                return "Brazil";
            case "BT":
                return "Bhutan";
            case "BY":
                return "Belarus";
            case "BZ":
                return "Belize";
            case "CA":
                return "Canada";
            case "CH":
                return "Switzerland";
            case "CL":
                return "Chile";
            case "CN":
                return "China";
            case "CO":
                return "Colombia";
            case "CR":
                return "Costa Rica";
            case "CS":
                return "Serbia";
            case "CU":
                return "Cuba";
            case "CV":
                return "Cape Verde";
            case "CY":
                return "Cyprus";
            case "CZ":
                return "Czech Republic";
            case "DE":
                return "Germany";
            case "DK":
                return "Denmark";
            case "DO":
                return "Dominican Republic";
            case "DZ":
                return "Algeria";
            case "EC":
                return "Ecuador";
            case "EE":
                return "Estonia";
            case "EG":
                return "Egypt";
            case "ER":
                return "Eritrea";
            case "ES":
                return "Spain";
            case "FI":
                return "Finland";
            case "FJ":
                return "Fiji";
            case "FR":
                return "France";
            case "GB":
                return "United Kingdom";
            case "GE":
                return "Georgia";
            case "GH":
                return "Ghana";
            case "GI":
                return "Gibraltar";
            case "GR":
                return "Greece";
            case "GT":
                return "Guatemala";
            case "HK":
                return "Hong Kong";
            case "HN":
                return "Honduras";
            case "HR":
                return "Croatia";
            case "HU":
                return "Hungary";
            case "ID":
                return "Indonesia";
            case "IE":
                return "Ireland";
            case "IL":
                return "Israel";
            case "IN":
                return "India";
            case "INTL":
                return "International";
            case "IQ":
                return "Iraq";
            case "IR":
                return "Iran";
            case "IS":
                return "Iceland";
            case "IT":
                return "Italy";
            case "JM":
                return "Jamaica";
            case "JO":
                return "Jordan";
            case "JP":
                return "Japan";
            case "KE":
                return "Kenya";
            case "KG":
                return "Kyrgyzstan";
            case "KH":
                return "Cambodia";
            case "KR":
                return "South Korea";
            case "KW":
                return "Kuwait";
            case "KY":
                return "Cayman Islands";
            case "KZ":
                return "Kazakhstan";
            case "LB":
                return "Lebanon";
            case "LI":
                return "Liechtenstein";
            case "LK":
                return "Sri Lanka";
            case "LT":
                return "Lithuania";
            case "LU":
                return "Luxembourg ";
            case "LV":
                return "Latvia";
            case "LY":
                return "Libya";
            case "MA":
                return "Morocco";
            case "MD":
                return "Moldova";
            case "MK":
                return "Macedonia";
            case "MN":
                return "Mongolia";
            case "MS":
                return "Montserrat";
            case "MX":
                return "Mexico";
            case "MY":
                return "Malaysia";
            case "MZ":
                return "Mozambique";
            case "NC":
                return "New Caledonia";
            case "NI":
                return "Nicaragua";
            case "NL":
                return "Netherlands";
            case "NO":
                return "Norway";
            case "NP":
                return "Nepal";
            case "NZ":
                return "New Zealand";
            case "OM":
                return "Oman";
            case "PE":
                return "Peru";
            case "PH":
                return "Philippines";
            case "PK":
                return "Pakistan";
            case "PL":
                return "Poland";
            case "PS":
                return "Occupied Palestinian Territory";
            case "PT":
                return "Portugal";
            case "PY":
                return "Paraguay";
            case "QA":
                return "Qatar";
            case "RO":
                return "Romania";
            case "RU":
                return "Russia";
            case "SA":
                return "Saudi Arabia";
            case "SE":
                return "Sweden";
            case "SG":
                return "Singapore";
            case "SI":
                return "Slovenia";
            case "SK":
                return "Slovakia";
            case "SY":
                return "Syria";
            case "TC":
                return "Turks and Caicos Islands";
            case "TH":
                return "Thailand";
            case "TL":
                return "East Timor";
            case "TN":
                return "Tunisia";
            case "TR":
                return "Turkey";
            case "TW":
                return "Taiwan";
            case "UA":
                return "Ukraine";
            case "US":
                return "United States";
            case "UY":
                return "Uruguay";
            case "UZ":
                return "Uzbekistan";
            case "VE":
                return "Venezuela";
            case "VN":
                return "Vietnam";
            case "ZA":
                return "South Africa";
            default:
                return i;
        }
    }
};

$(document).ready(function () {
    $.views.helpers({
        formatStatus:function (status) {

            switch (status) {
                case 0:
                    return "Closed";
                    break;
                case 1:
                    return "Open";
                    break;

            }
            return "unknown";
        },
        formatGender:function (gender) {
            switch (gender) {
                case 'm':
                    return "Male";
                    break;
                case 'f':
                    return "Female";
                    break;
            }
            return 'N.A.';
        },
        formatPriority:function (priority) {
            switch (priority) {
                case 1:
                    return "High";
                    break;
                case 2:
                    return "Medium";
                    break;
                case 3:
                    return "Low";
                    break;
            }
            return 'unknown';
        },
        formatSentiment:function (sentiment) {
            if (sentiment == 0) {
                return 'Neu';
            }
            else if (sentiment > 50) {
                return 'veryPos';
            }
            else if (sentiment > 0) {
                return 'Pos';
            }
            else if (sentiment < -50) {
                return 'veryNeg';
            }
            else {
                return 'Neg';
            }
        },
        formatSentimentRange:function (sentiment) {
            if (sentiment == 0) {
                return 'Sentiment: Neutral';
            }
            else if (sentiment > 50) {
                return 'Sentiment: Very Positive';
            }
            else if (sentiment > 0) {
                return 'Sentiment: Positive';
            }
            else if (sentiment < -50) {
                return 'Sentiment: Very Negative';
            }
            else {
                return 'Sentiment: Negative';
            }
        },
        formatDateTime:function (dt) {
            dt = dt.replace('T', ' ').replace('Z', '') + ' GMT';
            return Date.parse(dt).toString("MMMM dd yyyy dddd, h:mm:ss tt");
        },
        formatNumber:function (x) {
            if (x)
                return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            else
                return "0";
        },
        formatAccountProfile: function (x,y) {
            if (x>-1)
                if (y>-1)
                	if(y>0)
	                    if (x%1 != 0)
	                        return x.toFixed(2) + "&nbsp;&nbsp;<b>(" + (x/y*100).toFixed(2) + "%)</b>";
	                    else
	                        return x + "&nbsp;&nbsp;<b>(" + (x/y*100).toFixed(2) + "%)</b>";
                    else
	                    if (x%1 != 0)
	                        return x.toFixed(2) + "&nbsp;&nbsp;<b>(0.00%)</b>";
	                    else
	                        return x + "&nbsp;&nbsp;<b>(0.00%)</b>";
                else
                     if (x%1 != 0)
                         return x.toFixed(2);
                     else
                         return x;
            else
                return "N.A.";
        },
        formatContent:function (t) {
            var t1 = strip(t);

            if (t1.length > 360) {
                return '<div id="content-short">' + t1.substring(0, 360) + '<br /><div id="content-expand"">Read More</div></div><div id="content-full" style="display:none;">' + t + '</div>';
            } else {
                return t;
            }
        },
        formatPostContent:function (t) {
            var t1 = strip(t);

            if (t1.length > 300) {
                return t1.substring(0, 300);
            } else {
                return t;
            }
        },
        formatCountry:function (i) {
            return $.brandtologyUtils.formatCountry(i);
        }
    });
});

function strip(t) {
    var tmp = document.createElement("DIV");
    tmp.innerHTML = t;
    return tmp.textContent || tmp.innerText;
}

function genderPercent(male, female, container) {
    var maleCell = Math.round(parseInt(male) / 10);
    $(container + ' tr.human td div').removeClass('male');

    for (j = 0; j <= maleCell; j++) {
        $(container + ' tr.human td:nth-child(' + j + ') div').addClass('male');
    }

    $(container + ' tr.stats #male .count').text(Math.round(male * 100) / 100 + '%');
    $(container + ' tr.stats #female .count').text(Math.round(female * 100) / 100 + '%');
}

/*	GENDERPERCENT 100x100
 function genderPercent(male, container){
 var maleRow = parseInt(parseInt(male)/10);
 var maleCell = parseInt(male)%10;

 var str = '<table>';
 for (i=0;i<10;i++){
 str += '<tr>';
 for (j=0;j<10;j++){
 if (i<maleRow){str += '<td class="male"></td>';}
 else if (i==maleRow){
 if (j<maleCell){str += '<td class="male"></td>';}
 else {str += '<td></td>';}
 }
 else {str += '<td></td>';}
 }
 str +='</tr>';
 }
 str += '</table>';

 $(container).html(str);
 }*/
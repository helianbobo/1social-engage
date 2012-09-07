package one_social_ui

class SocialReportController {

    def index() { }

    def weeklyReport() {
    	render '''{
  "buzzChart": {
    "dayCount": 3,
    "series": 
    [
      {
        "name": "Cards",
        "id": 878,
        "data": 
        [
          21,
          36,
          75,
          23
        ],
        "pointStart": 1343174400000,
        "pointInterval": 86400000
      }
    ]
  },
  "conversationGrowthChart": {
    "dayCount": 3,
    "series": 
    [
      {
        "name": "Cumulative Conversations",
        "data": 
        [
          14,
          34,
          52,
          62
        ],
        "pointStart": 1343174400000,
        "pointInterval": 86400000
      },
      {
        "name": "New Conversations",
        "data": 
        [
          14,
          20,
          18,
          10
        ],
        "pointStart": 1343174400000,
        "pointInterval": 86400000
      }
    ]
  },
  "topicShareOfVoiceChart": {
    "series": 
    [
      {
        "type": "pie",
        "data": 
        [
          [
            "Bank Insurance",
            10
          ],
          [
            "Cards",
            155
          ],
          [
            "Internet Banking",
            14
          ],
          [
            "Investments",
            35
          ],
          [
            "Loans",
            54
          ],
          [
            "Deposits",
            23
          ],
          [
            "Crisis Management",
            2
          ],
          [
            "General Mentions",
            366
          ],
          [
            "Securities",
            106
          ],
          [
            "Archived",
            0
          ],
          [
            "Twitter - INTL",
            90
          ],
          [
            "Twitter-SG",
            193
          ]
        ]
      }
    ]
  },
  "subjectShareOfVoiceChart": {
    "series": 
    [
      {
        "type": "pie",
        "data": 
        [
          [
            "DBS - Cards",
            40
          ],
          [
            "OCBC - Cards",
            6
          ],
          [
            "UOB - Cards",
            27
          ],
          [
            "Standard Chartered - Cards",
            12
          ],
          [
            "Citibank - Cards",
            29
          ],
          [
            "POSB - Cards",
            21
          ],
          [
            "HSBC - Cards",
            20
          ]
        ]
      }
    ]
  },
  "buzzByChannelTypeChart": {
    "xAxis": 
    [
      "FORUM",
      "BLOG",
      "SOCIAL_NETWORKING_SITE",
      "NEWS"
    ],
    "series": 
    [
      {
        "name": "Buzz",
        "data": 
        [
          103,
          34,
          15,
          3
        ]
      }
    ]
  },
  "topXChannelBuzzChart": {
    "xAxis": 
    [
      "Hardwarezone Forum - Eat-Drink-Man-Woman",
      "Hardwarezone Forum - Credit Cards & Line of Credit facilities",
      "MyCarForum Forum - Lite & EZ",
      "Facebook - DBS Cards - Wall",
      "Singapore Jobs Market Forum",
      "Lioney - Buying Selling Portal Online - Singapore ",
      "ChannelNewsAsia Forum - MarketTalk",
      "Hardwarezone Forum - Cars & Cars",
      "Asiaone News - Business",
      "More More Cash",
      "Others"
    ],
    "series": 
    [
      {
        "name": "Buzz",
        "data": 
        [
          36,
          29,
          29,
          13,
          10,
          4,
          4,
          3,
          2,
          2,
          23
        ]
      }
    ]
  }

}'''
    }
}

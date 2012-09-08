package one_social_ui

class SocialAssetsController {
    def getAllAssets() {
      if (params.type == "facebook") {
        /*
        clientAccountId=733&
        type=facebook
         */
        render '''{
  "data":
  [
    {
      "accountId": "28011986676",
      "pageData":
      [
        {
          "name": "SingTel",
          "id": "28011986676",
          "likes": 137619,
          "type": "facebook",
          "url": "http://www.facebook.com/singtel",
          "pending": 0,
          "imageURL": "https://graph.facebook.com/28011986676/picture",
          "tokenExpiry": 58
        }
      ]
    },
    {
      "accountId": "633714023",
      "pageData":
      [
        {
          "name": "Brandtology",
          "imageURL": "https://graph.facebook.com/104681096700/picture",
          "type": "facebook",
          "pending": 1,
          "id": "104681096700",
          "tokenExpiry": 59
        },
        {
          "friendsOfFans": 0,
          "name": "WJ Bank",
          "id": "322058887863626",
          "likes": 5,
          "type": "facebook",
          "url": "http://www.facebook.com/pages/WJ-Bank/322058887863626",
          "pending": 0,
          "imageURL": "https://graph.facebook.com/322058887863626/picture",
          "tokenExpiry": 59
        }
      ]
    }
  ]
}
'''
      } else if (params.type == "twitter") {
        render '''{
  "data": 
  [
    {
      "name": "mrbrown",
      "id": "574253",
      "followingCount": "7427",
      "followerCount": "67242",
      "statusCount": 19882,
      "type": "twitter",
      "url": "https://twitter.com/mrbrown",
      "imageURL": "http://a0.twimg.com/profile_images/1705668255/mrbrown_bio_pic61_normal.jpg",
      "pending": 0
    },
    {
      "name": "mayhemstudios",
      "id": "14652452",
      "followingCount": "82930",
      "followerCount": "77446",
      "statusCount": 172904,
      "type": "twitter",
      "url": "https://twitter.com/mayhemstudios",
      "imageURL": "http://a0.twimg.com/profile_images/292130090/calvinlee_normal.jpg",
      "pending": 0
    }
  ]
}'''
      }
    }

    def getTwitterFollowerTrends() {
      render '''{
  "startDate": 1343721600000,
  "dayCount": 11,
  "followerCount": [],
  "followerAdded": []
}'''
    }

    def getTwitterPostBreakdown() {
      render '''{
  "repostArr": 
  [
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    18,
    18,
    10
  ],
  "replyArr": 
  [
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    14,
    36,
    19
  ],
  "postArr": 
  [
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    32,
    62,
    36
  ],
  "startDate": 1343721600000,
  "dayCount": 15,
  "totalRepostCount": 46,
  "totalPostCount": 130,
  "totalReplyCount": 69
}'''
    }

    def getTwitterDetailsAtSpecificPost() {
      render '''{
        "total": 98,
        "data": [
          {
            "avatarPic": "http://a0.twimg.com/profile_images/292130090/calvinlee_normal.jpg",
            "cCount": 0,
            "class": "com.brandtology.mongo.TwitterPost",
            "comUpdDate": "2012-08-16T12:10:52Z",
            "content": "Even though their homes are gone, we are rebuilding community after the tsunami. http://t.co/NdSP361h #DT @operationSAFE",
            "date": 16,
            "datetimeCrawled": "2012-08-16T12:16:02Z",
            "datetimePost": "2012-08-16T12:10:52Z",
            "datetimeUpdated": "2012-08-16T12:16:02Z",
            "day": 4,
            "gender": "unknown",
            "hour": 20,
            "id": {
              "class": "org.bson.types.ObjectId",
              "inc": 1408756626,
              "machine": -458214107,
              "new": false,
              "time": 1345119362000,
              "timeSecond": 1345119362
            },
            "language": "en",
            "latit": 0,
            "location": "US",
            "longti": 0,
            "postId": "236072533076611073",
            "rCount": 3,
            "repUpdDate": "2012-08-16T21:46:00Z",
            "source": "JustCoz",
            "tweetType": "Link",
            "url": "http://twitter.com/mayhemstudios/statuses/236072533076611073",
            "userid": "14652452",
            "username": "mayhemstudios",
            "version": 0
          }
        ]
        }'''
    }

    def getTwitterPostAtSpecificDate() {
      render '''{
  "total": 98,
  "data": 
  [
    {
      "avatarPic": "http://a0.twimg.com/profile_images/292130090/calvinlee_normal.jpg",
      "cCount": 0,
      "class": "com.brandtology.mongo.TwitterPost",
      "comUpdDate": "2012-08-16T12:10:52Z",
      "content": "Even though their homes are gone, we are rebuilding community after the tsunami. http://t.co/NdSP361h #DT @operationSAFE",
      "date": 16,
      "datetimeCrawled": "2012-08-16T12:16:02Z",
      "datetimePost": "2012-08-16T12:10:52Z",
      "datetimeUpdated": "2012-08-16T12:16:02Z",
      "day": 4,
      "gender": "unknown",
      "hour": 20,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1408756626,
        "machine": -458214107,
        "new": false,
        "time": 1345119362000,
        "timeSecond": 1345119362
      },
      "language": "en",
      "latit": 0,
      "location": "US",
      "longti": 0,
      "postId": "236072533076611073",
      "rCount": 3,
      "repUpdDate": "2012-08-16T21:46:00Z",
      "source": "JustCoz",
      "tweetType": "Link",
      "url": "http://twitter.com/mayhemstudios/statuses/236072533076611073",
      "userid": "14652452",
      "username": "mayhemstudios",
      "version": 0
    },
    {
      "avatarPic": "http://a0.twimg.com/profile_images/292130090/calvinlee_normal.jpg",
      "cCount": 1,
      "class": "com.brandtology.mongo.TwitterPost",
      "comUpdDate": "2012-08-16T18:32:14Z",
      "content": "RT @ladyxtel Dear Brands: Be Meaningful to Win, by @ladyxtel on @HuffPostBiz  http://t.co/R5M6gBsJ",
      "date": 16,
      "datetimeCrawled": "2012-08-16T12:08:01Z",
      "datetimePost": "2012-08-16T12:02:24Z",
      "datetimeUpdated": "2012-08-16T12:08:01Z",
      "day": 4,
      "gender": "unknown",
      "hour": 20,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 2051668319,
        "machine": -458193774,
        "new": false,
        "time": 1345118881000,
        "timeSecond": 1345118881
      },
      "language": "en",
      "latit": 0,
      "location": "US",
      "longti": 0,
      "postId": "236070403200675840",
      "rCount": 0,
      "repUpdDate": "2012-08-16T12:02:24Z",
      "source": "Twittelator",
      "tweetType": "Link",
      "url": "http://twitter.com/mayhemstudios/statuses/236070403200675840",
      "userid": "14652452",
      "username": "mayhemstudios",
      "version": 0
    },
    {
      "avatarPic": "http://a0.twimg.com/profile_images/292130090/calvinlee_normal.jpg",
      "cCount": 0,
      "class": "com.brandtology.mongo.TwitterPost",
      "comUpdDate": "2012-08-16T12:02:03Z",
      "content": "RT @AskAaronLee When is the best time to post on #instagram http://t.co/qhkmsmzh",
      "date": 16,
      "datetimeCrawled": "2012-08-16T12:08:01Z",
      "datetimePost": "2012-08-16T12:02:03Z",
      "datetimeUpdated": "2012-08-16T12:08:01Z",
      "day": 4,
      "gender": "unknown",
      "hour": 20,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 2051668318,
        "machine": -458193774,
        "new": false,
        "time": 1345118881000,
        "timeSecond": 1345118881
      },
      "language": "en",
      "latit": 0,
      "location": "US",
      "longti": 0,
      "postId": "236070315623604226",
      "rCount": 0,
      "repUpdDate": "2012-08-16T12:02:03Z",
      "source": "Twittelator",
      "tweetType": "Link",
      "url": "http://twitter.com/mayhemstudios/statuses/236070315623604226",
      "userid": "14652452",
      "username": "mayhemstudios",
      "version": 0
    },
    {
      "avatarPic": "http://a0.twimg.com/profile_images/292130090/calvinlee_normal.jpg",
      "cCount": 0,
      "class": "com.brandtology.mongo.TwitterPost",
      "comUpdDate": "2012-08-16T11:13:51Z",
      "content": "@DianeBrogan I will be back for more #NYC. I plan on visiting with many of my followers too :)",
      "date": 16,
      "datetimeCrawled": "2012-08-16T11:16:02Z",
      "datetimePost": "2012-08-16T11:13:51Z",
      "datetimeUpdated": "2012-08-16T11:16:02Z",
      "day": 4,
      "gender": "unknown",
      "hour": 19,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 526332826,
        "machine": -458223938,
        "new": false,
        "time": 1345115762000,
        "timeSecond": 1345115762
      },
      "language": "en",
      "latit": 0,
      "location": "US",
      "longti": 0,
      "postId": "236058183825760256",
      "rCount": 0,
      "repUpdDate": "2012-08-16T11:13:51Z",
      "source": "web",
      "tweetType": "",
      "url": "http://twitter.com/mayhemstudios/statuses/236058183825760256",
      "userid": "14652452",
      "username": "mayhemstudios",
      "version": 0
    }]
}'''
    }

    def getTwitterAnalysisAtSpecificPost() {
      render '''{
  "categories": 
  [
  ],
  "data": 
  [
  ]
}'''
    }

    def getTwitterPostAnalysisAtSpecificDate() {
      render '''{
  "categories": 
  [
    "unknown",
    "male",
    "female"
  ],
  "data": 
  [
    83,
    5,
    3
  ]
}'''
    }

    def getDensityChartData() {
      render '''{
  "data": 
  [
    {
      "x": 15,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 11
    },
    {
      "x": 13,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 3
    },
    {
      "x": 10,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 5
    },
    {
      "x": 11,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 9
    },
    {
      "x": 19,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 2
    },
    {
      "x": 10,
      "y": 5,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 19
    },
    {
      "x": 11,
      "y": 5,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 23,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 9,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 9
    },
    {
      "x": 8,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 8
    },
    {
      "x": 9,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 11
    },
    {
      "x": 17,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 7,
      "y": 5,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 2
    },
    {
      "x": 20,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 3
    },
    {
      "x": 9,
      "y": 5,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 10
    },
    {
      "x": 2,
      "y": 5,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 3
    },
    {
      "x": 14,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 2
    },
    {
      "x": 7,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 15,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 5
    },
    {
      "x": 16,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 4
    },
    {
      "x": 5,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 2,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 10,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 7
    },
    {
      "x": 3,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 11,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 6
    },
    {
      "x": 12,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 6
    },
    {
      "x": 20,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 1,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 3,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 14,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 4,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 4
    },
    {
      "x": 2,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 2
    },
    {
      "x": 17,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 2
    },
    {
      "x": 18,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 4
    },
    {
      "x": 8,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 5
    },
    {
      "x": 5,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 6
    },
    {
      "x": 16,
      "y": 4,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 2
    },
    {
      "x": 6,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 4
    }
  ]
}'''
    }

    def getTwitterEngagementMatrix() {
      render '''{
  "data": 
  [
    {
      "userid": "35657867",
      "username": "penelopephoto",
      "klout": 70,
      "followerCount": 10463,
      "repostCount": 2,
      "replyCount": 1,
      "avatarPic": "http://a0.twimg.com/profile_images/1290070220/Penelope_avatar_normal.jpg",
      "userURL": "http://www.twitter.com/penelopephoto"
    },
    {
      "userid": "94414042",
      "username": "JoanPelzerNYC",
      "klout": 35,
      "followerCount": 583,
      "repostCount": 0,
      "replyCount": 1,
      "avatarPic": "http://a0.twimg.com/profile_images/1265056214/1182612947_joan_062_normal.jpg",
      "userURL": "http://www.twitter.com/JoanPelzerNYC"
    },
    {
      "userid": "16723344",
      "username": "rsmithing",
      "klout": 44,
      "followerCount": 533,
      "repostCount": 1,
      "replyCount": 0,
      "avatarPic": "http://a0.twimg.com/profile_images/1844985790/rsmithing-sq_normal.jpg",
      "userURL": "http://www.twitter.com/rsmithing"
    },
    {
      "userid": "11503282",
      "username": "ladyxtel",
      "klout": 69,
      "followerCount": 13469,
      "repostCount": 0,
      "replyCount": 1,
      "avatarPic": "http://a0.twimg.com/profile_images/1806839285/59431622-7987-4C16-922A-BF45768A5BA4_normal",
      "userURL": "http://www.twitter.com/ladyxtel"
    }]}'''
    }

    def getAdminActivity() {
      render '''{
  "startDate": 1346284800000,
  "dayCount": 7,
  "categories": 
  [
    "2012-08-30",
    "2012-08-31",
    "2012-09-01",
    "2012-09-02",
    "2012-09-03",
    "2012-09-04",
    "2012-09-05",
    "2012-09-06"
  ],
  "postSum": 
  [
    0,
    10,
    26,
    34,
    14,
    12,
    8,
    0
  ],
  "likeSum": 
  [
    0,
    10,
    10,
    20,
    30,
    20,
    10,
    0
  ],
  "commentSum": 
  [
    0,
    9,
    11,
    7,
    4,
    2,
    1,
    0
  ]
}'''
    }

    def getAllFacebookPost() {
      render '''{
  "data": 
  [
    {
      "username": "WJ Bank",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=382662921803222&id=322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "profileURL": "http://www.facebook.com/322058887863626",
      "content": "\\"Please do not put nonsense on...\\" on Alvin Chan\'s post on WJ Bank\'s wall.",
      "id": "322058887863626_382662921803222",
      "likesCount": 0,
      "commentCount": 0,
      "datetimePost": "2012-09-04T08:37:59Z",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "comLastDate": "2012-09-04T08:37:59Z"
    },
    {
      "username": "Alvin Chan",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=379773918758789&id=322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "profileURL": "http://www.facebook.com/567870958",
      "content": "sentia sentia... double sentia...",
      "id": "322058887863626_379773918758789",
      "likesCount": 0,
      "commentCount": 1,
      "datetimePost": "2012-08-27T08:47:23Z",
      "userPic": "https://graph.facebook.com/567870958/picture",
      "comLastDate": "2012-09-04T08:37:59Z"
    }
  ]
}'''
    }
}

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
      "accountId": "100004080564130",
      "pageData": 
      [
        {
          "friendsOfFans": 0,
          "name": "Cassandra Centre of Nurturing",
          "id": "498933693465875",
          "likes": 12,
          "type": "facebook",
          "url": "http://www.facebook.com/498933693465875",
          "pending": 0,
          "imageURL": "https://graph.facebook.com/498933693465875/picture&access_token=AAADQLJxeGEMBAKRaZBvlosO8WA9LzKc3SamtZBLfDJkvKkoeVhjPLpBNZB4DHfSvx6ffuRltrXxZCS3oPNVJkLGb2DdOw6nZAlyHYmQkfZBd7JIQ6dM16O",
          "tokenExpiry": 23,
          "dateAdded": "2012-09-26T22:00:03Z",
          "isCompetitor": 1
        },
        {
          "friendsOfFans": 17437,
          "name": "WJ Bank",
          "id": "322058887863626",
          "likes": 49,
          "type": "facebook",
          "url": "http://www.facebook.com/322058887863626",
          "pending": 0,
          "imageURL": "https://graph.facebook.com/322058887863626/picture&access_token=AAADQLJxeGEMBANLxZA2hUXUGPk4jZA1CSVDkbJD2ZAxYtNJJlEDLZAnsdlx0As9yA7r9ZA3hp8UJHAjrpxuLlQC91TCzHOHLLv8x6FeIbzZBbUprqTdrJ4",
          "dateAdded": "2012-09-26T22:00:03Z",
          "isCompetitor": 0
        }
      ]
    },
    {
      "accountId": "227700026",
      "pageData": 
      [
        {
          "friendsOfFans": 585731,
          "name": "Fake Steve Jobs",
          "id": "6291744229",
          "likes": 1013,
          "type": "facebook",
          "url": "http://www.facebook.com/6291744229",
          "pending": 0,
          "imageURL": "https://graph.facebook.com/6291744229/picture&access_token=AAADQLJxeGEMBACw7iVpeYHfEC6HPfgiiqnW07XNXczkYCM3R4eHEdq0LZC1eN5ZAH3pKzgnKwBsjHjHyn2b5JhCb6kgApJe4LvdDVzAAZDZD",
          "tokenExpiry": 39,
          "dateAdded": "2012-10-18T04:00:07Z",
          "isCompetitor": 0
        },
        {
          "friendsOfFans": 0,
          "name": "Social Media",
          "id": "112122928813234",
          "likes": 7,
          "type": "facebook",
          "url": "http://www.facebook.com/112122928813234",
          "pending": 0,
          "imageURL": "https://graph.facebook.com/112122928813234/picture&access_token=AAADQLJxeGEMBAAqFyKKPGfUkd0gQzdrkRRYFdmulaOU8OPBVTzTfi5Rsy7HAOhzroSPTpDOku8fWjveeMZBuA7WDkV6FQd9FgtjCLTQZDZD",
          "dateAdded": "2012-10-18T05:00:04Z",
          "isCompetitor": 0
        }
      ]
    }
  ]
}'''
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
      "pending": 0,
      "dateAdded": "2012-09-26T09:37:07Z"
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
      "pending": 1,
      "dateAdded": "2012-09-26T09:37:07Z"
    }
  ]
}'''
      } else if (params.type == "weibo") {
        render '''{
  "data": 
  [
    {
      "name": "香港海港城",
      "id": "1686192095",
      "followingCount": "1097",
      "followerCount": "460411",
      "statusCount": 7274,
      "type": "weibo",
      "url": "http://weibo.com/u/1686192095",
      "imageURL": "http://tp4.sinaimg.cn/1686192095/50/5624671947/0",
      "pending": 0,
      "dateAdded": "2012-08-02T02:41:47Z"
    },
    {
      "name": "香奈儿CHANEL",
      "id": "1892475055",
      "followingCount": "14",
      "followerCount": "268294",
      "statusCount": 215,
      "type": "weibo",
      "url": "http://weibo.com/u/1892475055",
      "imageURL": "http://tp4.sinaimg.cn/1892475055/50/22821763469/0",
      "pending": 0,
      "dateAdded": "2012-09-12T13:48:39Z"
    },
    {
      "name": "wjtest",
      "id": "2517138064",
      "followingCount": "9",
      "followerCount": "6",
      "statusCount": 19,
      "type": "weibo",
      "url": "http://weibo.com/u/2517138064",
      "imageURL": "http://tp1.sinaimg.cn/2517138064/50/0/1",
      "pending": 1,
      "dateAdded": null
    }
  ]
}'''
      }
    }

    def deleteAssets() {
      if (params.clientAccountId == '969') {      
        render '''{
    "data": "ok"
  }'''
      } else {
        render '''{
  "data": "error"
}'''
      }
    }

    def getTwitterFollowerTrends() {
      render '''{
  "startDate": 1353427200000,
  "dayCount": 6,
  "followerTotal": 521713,
  "followerAddedTotal": 566,
  "followerCount": 
  [
    74242,
    74387,
    74487,
    74560,
    74612,
    74685,
    74740
  ],
  "followerAdded": 
  [
    68,
    145,
    100,
    73,
    52,
    73,
    55
  ],
  "dateArray": 
  [
    "2012-11-20T16:00:00Z",
    "2012-11-21T16:00:00Z",
    "2012-11-22T16:00:00Z",
    "2012-11-23T16:00:00Z",
    "2012-11-24T16:00:00Z",
    "2012-11-25T16:00:00Z",
    "2012-11-26T16:00:00Z"
  ]
}'''
    }

    def getTwitterPostBreakdown() {
      render '''{
  "repostArr": 
  [
    16,
    11,
    23,
    25,
    22,
    31,
    11
  ],
  "replyArr": 
  [
    12,
    28,
    32,
    21,
    23,
    11,
    21
  ],
  "postArr": 
  [
    22,
    46,
    53,
    35,
    47,
    36,
    33
  ],
  "startDate": 1351612800000,
  "dayCount": 6,
  "totalRepostCount": 139,
  "totalPostCount": 272,
  "totalReplyCount": 148,
  "dateArray": 
  [
    "2012-10-30T16:00:00Z",
    "2012-10-31T16:00:00Z",
    "2012-11-01T16:00:00Z",
    "2012-11-02T16:00:00Z",
    "2012-11-03T16:00:00Z",
    "2012-11-04T16:00:00Z",
    "2012-11-05T16:00:00Z"
  ]
}'''
    }

    def getTwitterDetailsAtSpecificPost() {
      render '''{
  "data": 
  [
    {
      "articleId": "235386767648374784",
      "assetId": "574253",
      "avatarPic": "http://a0.twimg.com/profile_images/2408935446/image_normal.jpg",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mrbrown: R.I.P. the late LCP Muhammad Fahrurrazi Salim, missing #NSF whose body was found in a Brunei river : http://t.co/oiMwiMZA",
      "date": 15,
      "datetimeCrawled": "2012-08-15T15:48:01Z",
      "datetimePost": "2012-08-15T15:43:15Z",
      "day": 3,
      "followerCount": 312,
      "gender": "unknown",
      "hour": 23,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 12264863,
        "machine": -458205229,
        "new": false,
        "time": 1345045681000,
        "timeSecond": 1345045681
      },
      "klout": 38,
      "language": "en",
      "latit": 0,
      "location": "INTL",
      "longti": 0,
      "postId": "235763593231089665",
      "rURL": "http://twitter.com/Joeson_Koh/statuses/235763593231089665",
      "source": "<a href=\\"http://twitter.com/download/iphone\\" rel=\\"nofollow\\">Twitter for iPhone</a>",
      "tweetType": null,
      "userid": "383701403",
      "username": "Joeson_Koh",
      "verified": "true",
      "version": 0
    },
    {
      "articleId": "235386767648374784",
      "assetId": "574253",
      "avatarPic": "http://a0.twimg.com/profile_images/2488841831/image_normal.jpg",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mrbrown: R.I.P. the late LCP Muhammad Fahrurrazi Salim, missing #NSF whose body was found in a Brunei river : http://t.co/oiMwiMZA",
      "date": 15,
      "datetimeCrawled": "2012-08-15T11:48:01Z",
      "datetimePost": "2012-08-15T11:41:37Z",
      "day": 3,
      "followerCount": 103,
      "gender": "unknown",
      "hour": 19,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": -1396638554,
        "machine": -458221305,
        "new": false,
        "time": 1345031281000,
        "timeSecond": 1345031281
      },
      "klout": 36,
      "language": "en",
      "latit": 0,
      "location": "INTL",
      "longti": 0,
      "postId": "235702785495150592",
      "rURL": "http://twitter.com/lwj_/statuses/235702785495150592",
      "source": "<a href=\\"http://tweetli.st/\\" rel=\\"nofollow\\">TweetList!</a>",
      "tweetType": null,
      "userid": "626689567",
      "username": "lwj_",
      "verified": null,
      "version": 0
    },
    {
      "articleId": "235386767648374784",
      "assetId": "574253",
      "avatarPic": "http://a0.twimg.com/profile_images/2488098386/d14exmblcaml9b88p2bn_normal.jpeg",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mrbrown: R.I.P. the late LCP Muhammad Fahrurrazi Salim, missing #NSF whose body was found in a Brunei river : http://t.co/oiMwiMZA",
      "date": 15,
      "datetimeCrawled": "2012-08-15T09:24:01Z",
      "datetimePost": "2012-08-15T09:19:54Z",
      "day": 3,
      "followerCount": 242,
      "gender": "unknown",
      "hour": 17,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": -718177576,
        "machine": -458219718,
        "new": false,
        "time": 1345022641000,
        "timeSecond": 1345022641
      },
      "klout": 36,
      "language": "en",
      "latit": 0,
      "location": "INTL",
      "longti": 0,
      "postId": "235667119059120128",
      "rURL": "http://twitter.com/Chendanaa/statuses/235667119059120128",
      "source": "<a href=\\"http://itunes.apple.com/us/app/twitter/id409789998?mt=12\\" rel=\\"nofollow\\">Twitter for Mac</a>",
      "tweetType": null,
      "userid": "99057183",
      "username": "Chendanaa",
      "verified": null,
      "version": 0
    },
    {
      "articleId": "235386767648374784",
      "assetId": "574253",
      "avatarPic": "http://a0.twimg.com/profile_images/291344829/n715952564_4905_normal.jpg",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mrbrown: R.I.P. the late LCP Muhammad Fahrurrazi Salim, missing #NSF whose body was found in a Brunei river : http://t.co/oiMwiMZA",
      "date": 15,
      "datetimeCrawled": "2012-08-15T00:16:01Z",
      "datetimePost": "2012-08-15T00:13:19Z",
      "day": 3,
      "followerCount": 110,
      "gender": "unknown",
      "hour": 8,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": -631574761,
        "machine": -458224796,
        "new": false,
        "time": 1344989761000,
        "timeSecond": 1344989761
      },
      "klout": 26,
      "language": "en",
      "latit": 0,
      "location": "SG",
      "longti": 0,
      "postId": "235529566586826752",
      "rURL": "http://twitter.com/cq2727/statuses/235529566586826752",
      "source": "<a href=\\"http://twitter.com/download/android\\" rel=\\"nofollow\\">Twitter for Android</a>",
      "tweetType": null,
      "userid": "52559515",
      "username": "cq2727",
      "verified": null,
      "version": 0
    },
    {
      "articleId": "235386767648374784",
      "assetId": "574253",
      "avatarPic": "http://a0.twimg.com/profile_images/2454728693/xf1Wd7K9_normal",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mrbrown: R.I.P. the late LCP Muhammad Fahrurrazi Salim, missing #NSF whose body was found in a Brunei river : http://t.co/oiMwiMZA",
      "date": 15,
      "datetimeCrawled": "2012-08-14T22:08:02Z",
      "datetimePost": "2012-08-14T21:54:59Z",
      "day": 3,
      "followerCount": 70,
      "gender": "unknown",
      "hour": 5,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": -334168886,
        "machine": -458226951,
        "new": false,
        "time": 1344982082000,
        "timeSecond": 1344982082
      },
      "klout": 42,
      "language": null,
      "latit": 0,
      "location": "INTL",
      "longti": 0,
      "postId": "235494754660544512",
      "rURL": "http://twitter.com/seyongbaragi/statuses/235494754660544512",
      "source": "<a href=\\"http://www.echofon.com/\\" rel=\\"nofollow\\">Echofon</a>",
      "tweetType": null,
      "userid": "518436850",
      "username": "seyongbaragi",
      "verified": null,
      "version": 0
    },
    {
      "articleId": "235386767648374784",
      "assetId": "574253",
      "avatarPic": "http://a0.twimg.com/profile_images/2452177440/c5swk2hhjrdphirh55rj_normal.jpeg",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mrbrown: R.I.P. the late LCP Muhammad Fahrurrazi Salim, missing #NSF whose body was found in a Brunei river : http://t.co/oiMwiMZA",
      "date": 15,
      "datetimeCrawled": "2012-08-14T17:28:01Z",
      "datetimePost": "2012-08-14T17:23:50Z",
      "day": 3,
      "followerCount": 575,
      "gender": "unknown",
      "hour": 1,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 939161362,
        "machine": -458189859,
        "new": false,
        "time": 1344965281000,
        "timeSecond": 1344965281
      },
      "klout": 29,
      "language": "en",
      "latit": 0,
      "location": "INTL",
      "longti": 0,
      "postId": "235426516736032768",
      "rURL": "http://twitter.com/NurdiyanaYanYan/statuses/235426516736032768",
      "source": "<a href=\\"http://ubersocial.com\\" rel=\\"nofollow\\">UberSocial for Android</a>",
      "tweetType": null,
      "userid": "44095384",
      "username": "NurdiyanaYanYan",
      "verified": null,
      "version": 0
    },
    {
      "articleId": "235386767648374784",
      "assetId": "574253",
      "avatarPic": "http://a0.twimg.com/profile_images/2453929462/image_normal.jpg",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mrbrown: R.I.P. the late LCP Muhammad Fahrurrazi Salim, missing #NSF whose body was found in a Brunei river : http://t.co/oiMwiMZA",
      "date": 15,
      "datetimeCrawled": "2012-08-14T17:16:01Z",
      "datetimePost": "2012-08-14T17:14:38Z",
      "day": 3,
      "followerCount": 101,
      "gender": "unknown",
      "hour": 1,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 899591705,
        "machine": -458180739,
        "new": false,
        "time": 1344964561000,
        "timeSecond": 1344964561
      },
      "klout": 15,
      "language": "en",
      "latit": 0,
      "location": "INTL",
      "longti": 0,
      "postId": "235424202340065280",
      "rURL": "http://twitter.com/huienen/statuses/235424202340065280",
      "source": "<a href=\\"http://twitter.com/download/iphone\\" rel=\\"nofollow\\">Twitter for iPhone</a>",
      "tweetType": null,
      "userid": "287692078",
      "username": "huienen",
      "verified": null,
      "version": 0
    },
    {
      "articleId": "235386767648374784",
      "assetId": "574253",
      "avatarPic": "http://a0.twimg.com/profile_images/2201818345/myk8m6L9_normal",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mrbrown: R.I.P. the late LCP Muhammad Fahrurrazi Salim, missing #NSF whose body was found in a Brunei river : http://t.co/oiMwiMZA",
      "date": 15,
      "datetimeCrawled": "2012-08-14T17:08:01Z",
      "datetimePost": "2012-08-14T17:04:02Z",
      "day": 3,
      "followerCount": 220,
      "gender": "unknown",
      "hour": 1,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 2092892444,
        "machine": -458175911,
        "new": false,
        "time": 1344964081000,
        "timeSecond": 1344964081
      },
      "klout": 34,
      "language": "en",
      "latit": 0,
      "location": "INTL",
      "longti": 0,
      "postId": "235421535194730496",
      "rURL": "http://twitter.com/irfanlolok/statuses/235421535194730496",
      "source": "web",
      "tweetType": null,
      "userid": "238959523",
      "username": "irfanlolok",
      "verified": null,
      "version": 0
    },
    {
      "articleId": "235386767648374784",
      "assetId": "574253",
      "avatarPic": "http://a0.twimg.com/profile_images/2286790270/nmsr3eshf72j88uhifnt_normal.jpeg",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mrbrown: R.I.P. the late LCP Muhammad Fahrurrazi Salim, missing #NSF whose body was found in a Brunei river : http://t.co/oiMwiMZA",
      "date": 15,
      "datetimeCrawled": "2012-08-14T16:48:01Z",
      "datetimePost": "2012-08-14T16:42:15Z",
      "day": 3,
      "followerCount": 189,
      "gender": "unknown",
      "hour": 0,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 34051587,
        "machine": -458204372,
        "new": false,
        "time": 1344962881000,
        "timeSecond": 1344962881
      },
      "klout": 32,
      "language": "en",
      "latit": 0,
      "location": "INTL",
      "longti": 0,
      "postId": "235416054258597889",
      "rURL": "http://twitter.com/shaojiey/statuses/235416054258597889",
      "source": "<a href=\\"http://blackberry.com/twitter\\" rel=\\"nofollow\\">Twitter for BlackBerry®</a>",
      "tweetType": null,
      "userid": "254611798",
      "username": "shaojiey",
      "verified": null,
      "version": 0
    },
    {
      "articleId": "235386767648374784",
      "assetId": "574253",
      "avatarPic": "http://a0.twimg.com/profile_images/1397111304/Free-Clipart-of-Light-Bulb_normal.jpg",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mrbrown: R.I.P. the late LCP Muhammad Fahrurrazi Salim, missing #NSF whose body was found in a Brunei river : http://t.co/oiMwiMZA",
      "date": 15,
      "datetimeCrawled": "2012-08-14T16:16:02Z",
      "datetimePost": "2012-08-14T16:12:45Z",
      "day": 3,
      "followerCount": 3,
      "gender": "unknown",
      "hour": 0,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 490719858,
        "machine": -458222796,
        "new": false,
        "time": 1344960962000,
        "timeSecond": 1344960962
      },
      "klout": 10,
      "language": "en",
      "latit": 0,
      "location": "SG",
      "longti": 0,
      "postId": "235408628377587712",
      "rURL": "http://twitter.com/ilackcre8TVT/statuses/235408628377587712",
      "source": "web",
      "tweetType": null,
      "userid": "317792076",
      "username": "ilackcre8TVT",
      "verified": null,
      "version": 0
    }
  ],
  "total": 70
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
      "rCount": 3000000,
      "repUpdDate": "2012-08-16T21:46:00Z",
      "source": "JustCoz",
      "tweetType": "Link",
      "url": "http://twitter.com/mayhemstudios/statuses/236072533076611073",
      "userid": "14652452",
      "username": "mayhemstudios",
      "version": 0,
      "verified": "true"
    },
    {
      "avatarPic": "http://a0.twimg.com/profile_images/292130090/calvinlee_normal.jpg",
      "cCount": 1000000,
      "class": "com.brandtology.mongo.TwitterPost",
      "comUpdDate": "2012-08-16T18:32:14Z",
      "content": "RT @ladyxtel Dear Brands: Be Meaningful to Win, by @ladyxtel on @HuffPostBiz  http://t.co/R5M6gBsJ",
      "date": 16,
      "datetimeCrawled": "2012-08-16T12:08:01Z",
      "datetimePost": "2012-08-16T12:02:24Z",
      "datetimeUpdated": "2012-08-16T12:08:01Z",
      "day": 4,
      "gender": "male",
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
      "location": "BZ",
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
      "gender": "female",
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
      "location": "ASIA",
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
      if (params.analysis == "gender") {
        render '''{
  "categories": 
  [
    "unknown",
    "male",
    "female"
  ],
  "data": 
  [
    68,
    2,
    90
  ]
}'''
} else if (params.analysis == "location") {
  render '''{
  "categories": 
  [
    "INTL",
    "SG",
    "FR"
  ],
  "data": 
  [
    42,
    27,
    1
  ]
}'''
} else {
  render '''{
  "categories": 
  [
    "Twitter for iPhone",
    "web",
    "Twitter for Android",
    "Echofon",
    "Tweetbot for iOS",
    "Twitter for BlackBerry®",
    "TweetDeck",
    "Twitter for Mac",
    "UberSocial for BlackBerry",
    "Seesmic"
  ],
  "data": 
  [
    18,
    18,
    14,
    5,
    4,
    3,
    2,
    1,
    1,
    1
  ]
}'''
}
    }

    def getTwitterPostAnalysisAtSpecificDate() {
      if (params.analysis == 'location') {
        render '''{
  "categories": 
  [
    "SG",
    "INTL",
    "AU",
    "TW",
    "TH",
    "JP",
    "US",
    "MY",
    "GB",
    "PK"
  ],
  "data": 
  [
    174,
    169,
    8,
    4,
    4,
    4,
    3,
    2,
    1,
    1
  ]
}'''
      } else {
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
    }

    def getDensityChartData() {
      render '''{
  "total": 119,
  "data": 
  [
    {
      "x": 16,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 14,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 10,
      "y": 0,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 15,
      "y": 3,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 4
    },
    {
      "x": 13,
      "y": 3,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 6
    },
    {
      "x": 14,
      "y": 5,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 10,
      "y": 6,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 4
    },
    {
      "x": 14,
      "y": 0,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 13,
      "y": 0,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 10,
      "y": 5,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 6
    },
    {
      "x": 11,
      "y": 5,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 20,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 21,
      "y": 2,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 7
    },
    {
      "x": 4,
      "y": 6,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 2,
      "y": 6,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 0,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 3,
      "y": 6,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 0,
      "y": 6,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 3,
      "y": 0,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 5
    },
    {
      "x": 1,
      "y": 6,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 7,
      "y": 0,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 20,
      "y": 1,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 9
    },
    {
      "x": 6,
      "y": 0,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 21,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 7,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 8,
      "y": 5,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 9,
      "y": 0,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
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
      "id": 1
    },
    {
      "x": 23,
      "y": 0,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 4
    },
    {
      "x": 23,
      "y": 6,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 4
    },
    {
      "x": 4,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 6,
      "y": 6,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 4,
      "y": 4,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 5
    },
    {
      "x": 1,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 9,
      "y": 6,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 0,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 8,
      "y": 6,
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
      "id": 1
    },
    {
      "x": 11,
      "y": 2,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 4
    },
    {
      "x": 4,
      "y": 5,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 5
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
      "x": 12,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
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
      "x": 14,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 1,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 8,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 23,
      "y": 5,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 15,
      "y": 0,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    }
  ]
}'''
    }

    def twitterUserInfluenceData() {
      render '''{
  "total": 98,
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
      "userURL": "http://www.twitter.com/penelopephoto",
      "verified": "true"
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

    def getTotalActivity() {
      render '''{
  "startDate": 1348531200000,
  "dayCount": 8,
  "commentData": 
  [
    0,
    0,
    36,
    49,
    51,
    60,
    93,
    47,
    76
  ],
  "commentTotal": 412,
  "articleData": 
  [
    0,
    0,
    23,
    18,
    28,
    17,
    29,
    20,
    26
  ],
  "articleTotal": 161
}'''
    }

    def getAdminActivity() {
      render '''{
  "startDate": 1348531200000,
  "dayCount": 8,
  "commentData": 
  [
    0,
    0,
    2,
    9,
    1,
    1,
    19,
    1,
    7
  ],
  "commentTotal": 40,
  "articleData": 
  [
    0,
    0,
    2,
    3,
    4,
    4,
    5,
    4,
    5
  ],
  "articleTotal": 27
}'''
    }

    def getNonAdminActivity() {
      render '''{
  "startDate": 1348531200000,
  "dayCount": 8,
  "commentData": 
  [
    0,
    0,
    34,
    40,
    50,
    59,
    74,
    46,
    69
  ],
  "commentTotal": 372,
  "articleData": 
  [
    0,
    0,
    21,
    15,
    24,
    13,
    24,
    16,
    21
  ],
  "articleTotal": 134
}'''
    }

    def getAllFacebookPost() {
      if (params.type == 'All') {
        render '''{
          "total": 55,
  "data": 
  [
    {
      "username": "Ho Wei Siong",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104774371185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/745531823",
      "content": "iPhone5 White 64GB Tampines Mall has stock? http://www.dslreports.com/shownews/iPhone-5-Bug-Results-in-Huge-Bandwidth-Bills-121475?nocomment=1 http://www.dslreports.com/shownews/iPhone-5-Bug-Results-in-Huge-Bandwidth-Bills-121475?nocomment=1",
      "id": "39419741184_10151104774371185",
      "imageURL": "http://sphotos-f.ak.fbcdn.net/hphotos-ak-snc7/s480x480/399090_10151215068442621_1398182145_n.jpg",
      "likesCount": 1,
      "commentCount": 1,
      "shareCount": 0,
      "datetimePost": "2012-10-01T15:21:08Z",
      "userPic": "https://graph.facebook.com/745531823/picture",
      "comLastDate": "2012-10-01T15:21:08Z",
      "uniqueVoiceCount": 2
    },
    {
      "username": "Arthur Hoe",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104678531185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/640663353",
      "content": "m1 wassup with your m1shop website, its so confusing, tried to contract new line for samsung s3 lte but cant find value surf price plan. And when i tried contracting, the phone is apparently $598? thats not right http://www.mobile88.com.sg/news/read.asp?file=%2F2012%2F10%2F4%2Fsg%2F20121004091725&phone=iPhone-5-vs-One-X-compare",
      "id": "39419741184_10151104678531185",
      "likesCount": 0,
      "commentCount": 1,
      "shareCount": 0,
      "datetimePost": "2012-10-01T13:41:42Z",
      "userPic": "https://graph.facebook.com/640663353/picture",
      "comLastDate": "2012-10-01T13:41:42Z",
      "uniqueVoiceCount": 1
    },
    {
      "username": "Jason Ong Chee Hsun",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104613056185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/777262374",
      "content": "15 years with this telco and there is no serious loyalty voucher given, as it is just status quo till now...I am opting for a number port to Singtel wef 01 Jan 2013!",
      "id": "39419741184_10151104613056185",
      "likesCount": 15,
      "commentCount": 7,
      "shareCount": 0,
      "datetimePost": "2012-10-01T12:19:52Z",
      "userPic": "https://graph.facebook.com/777262374/picture",
      "comLastDate": "2012-10-01T12:19:52Z",
      "uniqueVoiceCount": 20
    },
    {
      "username": "Eric Tan",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104592421185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/621696224",
      "content": "How come M1 is reducing the corporate discount for their plans under iPhone 5?? Data capacity is grossly reduced by >50% yet price increases?? Seriously, is this what customer service is about??",
      "id": "39419741184_10151104592421185",
      "likesCount": 1,
      "commentCount": 0,
      "shareCount": 0,
      "datetimePost": "2012-10-01T11:53:52Z",
      "userPic": "https://graph.facebook.com/621696224/picture",
      "comLastDate": "2012-10-01T11:53:52Z",
      "uniqueVoiceCount": 1
    },
    {
      "username": "M1",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104565936185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/39419741184",
      "content": "Please note that M1 Shop Paragon has closed its iPhone 5 queue for the night. The 32GB models are likely to be sold out soon at IMM, Bugis Junction and West Mall.",
      "id": "39419741184_10151104565936185",
      "likesCount": 82,
      "commentCount": 16,
      "shareCount": 1,
      "datetimePost": "2012-10-01T11:09:40Z",
      "userPic": "https://graph.facebook.com/39419741184/picture",
      "comLastDate": "2012-10-01T11:09:40Z",
      "uniqueVoiceCount": 94
    },
    {
      "username": "Eugene Wong",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104556051185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/529868170",
      "content": "I\'ve queued for 1 hours at M1 Paragon for a number, waited another 2 for processing just to be told to come back at 9pm to collect my phone!! What the hell??? Your CSO could at least have the courtesy to inform the customer that they will need to come back a a later time to collect the phone before hand and before all the stupid queuing!! I\'m just lost for word at the service level M1 is showing to its loyal customer!!!!!!",
      "id": "39419741184_10151104556051185",
      "likesCount": 1,
      "commentCount": 0,
      "shareCount": 0,
      "datetimePost": "2012-10-01T10:54:34Z",
      "userPic": "https://graph.facebook.com/529868170/picture",
      "comLastDate": "2012-10-01T10:54:34Z",
      "uniqueVoiceCount": 1
    },
    {
      "username": "Eugene Wong",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104556051185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/529868170",
      "content": "http://www.dslreports.com/shownews/iPhone-5-Bug-Results-in-Huge-Bandwidth-Bills-121475?nocomment=1 http://www.dslreports.com/shownews/iPhone-5-Bug-Results-in-Huge-Bandwidth-Bills-121475?nocomment=1",
      "id": "39419741184_10151104556051186",
      "likesCount": 1,
      "commentCount": 0,
      "shareCount": 0,
      "datetimePost": "2012-10-01T10:54:34Z",
      "userPic": "https://graph.facebook.com/529868170/picture",
      "comLastDate": "2012-10-01T10:54:34Z",
      "uniqueVoiceCount": 1
    },
    {
      "username": "Eugene Wong",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104556051185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/529868170",
      "content": "----- Forwarded Message -----\\nFrom: Nareshkumar Mehta <mehta.nareshkumar@yahoo.com.sg>\\nTo: \\"istana_general_office@istana.gov.sg\\" <istana_general_office@istana.gov.sg>; \\"parl@parl.gov.sg\\" <parl@parl.gov.sg> \\nCc: \\"inderjit@singnet.com.sg\\" <inderjit@singnet.com.sg>; \\"indranee.rajah@drewnapier.com\\" <indranee.rajah@drewnapier.com>; \\"fscom@hcisingapore.org\\" <fscom@hcisingapore.org>; \\"fscons@hcisingapore.org\\" <fscons@hcisingapore.org>; \\"fatimah.abd.lateef@sgh.com.sg\\" <fatimah.abd.lateef@sgh.com.sg>; \\"wongkanseng@gmail.com\\" <wongkanseng@gmail.com>; \\"wendy.soh@citicorp.com\\" <wendy.soh@citicorp.com>; \\"wendy.soh@citigroup.com\\" <wendy.soh@citigroup.com>; \\"wecare@lifeisgreat.com.sg\\" <wecare@lifeisgreat.com.sg>; \\"Wecare-SG@greateasternlife.com\\" <Wecare-SG@greateasternlife.com> \\nSent: Thursday, 11 October 2012, 23:18\\nSubject: Fw: MLaw-12-001844 : Insolvency & Public Trustee's Office - Individual Insolvency [Submitted]\\n\\n\\n\\n--- On Thu, 11/10/12, minlaw_agent_runner/govsg@notesapp2.internet.gov.sg <minlaw_agent_runner/govsg@notesapp2.internet.gov.sg> wrote:\\n\\n\\nFrom: minlaw_agent_runner/govsg@notesapp2.internet.gov.sg <minlaw_agent_runner/govsg@notesapp2.internet.gov.sg>\\nSubject: MLaw-12-003008 : Insolvency & Public Trustee's Office - Individual Insolvency [Submitted]\\nTo: s2622389z@yahoo.com.sg\\nDate: Thursday, 11 October, 2012, 12:34 PM\\n\\n\\nDear Mr NARESHKUMAR MEHTA\\n\\nName of Customer: NARESHKUMAR MEHTA\\nSubmitted Date & Time:11-Oct-2012 12:34:48\\n\\nDetails:\\nSubject : Renting\\n\\nCategory : Direct from HDB\\n\\nTitle : CHECK ALL GOVT AGENCIES/STAT BOARDS/MINISTRIES FOR NRIC/S2622389Z\\n\\nYour Feedback :\\n\\nSEE THE FOOTAGE OF US PRESIDENT AND DEEPAK PAREKH/HDFC/SINGTEL BOARD OF DIRECTORS\\nHTTP://WWW.SINGTEL.COM \\nAND \\nHTTP://WWW.HDFC.COM \\nON \\nHTTP://WWW.MEDIACORP.COM.SG \\nSIGNING A DEAL AND TREATY ALONG WITH KELLY.KHOO@D1.COM.SG MALAYSIAN CHINESE AND HER ACTIVITES IN KASHMIR HOTEL AND MUMBANI HOTELFOOTAGE-\\n------------------------------------\\nSubject : Renting\\n\\nCategory : Direct from HDB\\n\\nTitle : CHECK FROM ANGIE_WONG@ICA.GOV.SG/CLARENCE_YEO@ICA.GOV.SG FOR DETAILS\\n\\nYour Feedback :\\n\\nSubject : Renting\\n\\nCategory : Direct fromHDB\\n\\nTitle : CHECK ALL THE EMAIL BOXES/COMPUTERS AND GET THE FACTS CLEAR\\n\\nYour Feedback :\\n\\nUSERID/EMAIL BOX\\nmehta.nareshkumar@yahoo.com.sg\\nPASSWORDhassalkantas2622389z\\nURLhttp://www.yahoo.com.sg\\n-----------------------------------------------------------------------------------------\\n-USERID/EMAIL BOX\\n",
      "id": "39419741184_56051186",
      "likesCount": 1,
      "commentCount": 0,
      "shareCount": 0,
      "datetimePost": "2012-10-01T10:54:34Z",
      "userPic": "https://graph.facebook.com/529868170/picture",
      "comLastDate": "2012-10-01T10:54:34Z",
      "uniqueVoiceCount": 1
    }
  ]
}'''
      } else if (params.type == "Admin") {
        render '''{
          "total": 99,
  "data": 
  [
    {
      "username": "M1",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104565936185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/39419741184",
      "content": "Please note that M1 Shop Paragon has closed its iPhone 5 queue for the night. The 32GB models are likely to be sold out soon at IMM, Bugis Junction and West Mall.",
      "id": "39419741184_10151104565936185",
      "imageURL": "http://sphotos-f.ak.fbcdn.net/hphotos-ak-snc7/s480x480/399090_10151215068442621_1398182145_n.jpg",
      "likesCount": 8200,
      "commentCount": 16,
      "shareCount": 1,
      "datetimePost": "2012-10-01T11:09:40Z",
      "userPic": "https://graph.facebook.com/39419741184/picture",
      "comLastDate": "2012-10-01T11:09:40Z",
      "uniqueVoiceCount": 94
    },
    {
      "username": "M1",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104516616185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/39419741184",
      "content": "M1 Shop West Mall has also run out of the 32GB black version of iPhone 5.",
      "id": "39419741184_10151104516616185",
      "likesCount": 55,
      "commentCount": 5000,
      "shareCount": 1,
      "datetimePost": "2012-10-01T09:46:21Z",
      "userPic": "https://graph.facebook.com/39419741184/picture",
      "comLastDate": "2012-10-01T09:46:21Z",
      "uniqueVoiceCount": 60
    },
    {
      "username": "M1",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104484646185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/39419741184",
      "content": "Please note that the iPhone 5 32GB black model is out of stock at M1 Shop Tampines Mall.",
      "id": "39419741184_10151104484646185",
      "likesCount": 119,
      "commentCount": 9,
      "shareCount": 0,
      "datetimePost": "2012-10-01T08:44:17Z",
      "userPic": "https://graph.facebook.com/39419741184/picture",
      "comLastDate": "2012-10-01T08:44:17Z",
      "uniqueVoiceCount": 128
    },
    {
      "username": "M1",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104280271185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/39419741184",
      "content": "Heartiest birthday greetings to those of you celebrating your special day in October! \\r\\n\\r\\nHere\'s an exclusive treat for M1 customers: One dines free with every three paying adults for High Tea and Dinner Buffets at Singapore Marriott Hotel.\\r\\n\\r\\nFind out more about this and other birthday treats at www.m1.com.sg/birthdaytreats",
      "id": "39419741184_10151104280271185",
      "likesCount": 188,
      "commentCount": 4,
      "shareCount": 1000,
      "datetimePost": "2012-10-01T03:27:22Z",
      "userPic": "https://graph.facebook.com/39419741184/picture",
      "comLastDate": "2012-10-01T03:27:22Z",
      "uniqueVoiceCount": 191,
      "imageURL": "http://photos-g.ak.fbcdn.net/hphotos-ak-ash4/199577_10151104280251185_1353318939_s.jpg"
    },
    {
      "username": "M1",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104232021185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/39419741184",
      "content": "Good morning.\\n\\nAll models of iPhone 5 are currently available at M1 Shops. Do note, however, that both black and white versions of the 32GB model are limited in stock and may run out by day\'s end. \\n\\nThis update applies only to M1 Shop outlets, and not those of our exclusive dealers. For a list of M1 Shop locations and opening hours, please visit www.m1shop.com.sg.\\n\\nFor information on our iPhone 5 prices and subscription plans, please visit www.m1.com.sg/iPhone.",
      "id": "39419741184_10151104232021185",
      "likesCount": 128,
      "commentCount": 25,
      "shareCount": 0,
      "datetimePost": "2012-10-01T02:36:27Z",
      "userPic": "https://graph.facebook.com/39419741184/picture",
      "comLastDate": "2012-10-01T02:36:27Z",
      "uniqueVoiceCount": 1460
    }
  ]
}'''
      } else {
        render '''{
          "total": 100,
  "data": 
  [
    {
      "username": "Ho Wei Siong",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104774371185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/745531823",
      "content": "iPhone5 White 64GB Tampines Mall has stock?",
      "id": "39419741184_10151104774371185",
      "imageURL": "http://sphotos-f.ak.fbcdn.net/hphotos-ak-snc7/s480x480/399090_10151215068442621_1398182145_n.jpg",
      "likesCount": 1,
      "commentCount": 1,
      "shareCount": 0,
      "datetimePost": "2012-10-01T15:21:08Z",
      "userPic": "https://graph.facebook.com/745531823/picture",
      "comLastDate": "2012-10-01T15:21:08Z",
      "uniqueVoiceCount": 2
    },
    {
      "username": "Arthur Hoe",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104678531185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/640663353",
      "content": "m1 wassup with your m1shop website, its so confusing, tried to contract new line for samsung s3 lte but cant find value surf price plan. And when i tried contracting, the phone is apparently $598? thats not right",
      "id": "39419741184_10151104678531185",
      "likesCount": 0,
      "commentCount": 1,
      "shareCount": 0,
      "datetimePost": "2012-10-01T13:41:42Z",
      "userPic": "https://graph.facebook.com/640663353/picture",
      "comLastDate": "2012-10-01T13:41:42Z",
      "uniqueVoiceCount": 1
    },
    {
      "username": "Jason Ong Chee Hsun",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104613056185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/777262374",
      "content": "15 years with this telco and there is no serious loyalty voucher given, as it is just status quo till now...I am opting for a number port to Singtel wef 01 Jan 2013!",
      "id": "39419741184_10151104613056185",
      "likesCount": 15,
      "commentCount": 7,
      "shareCount": 0,
      "datetimePost": "2012-10-01T12:19:52Z",
      "userPic": "https://graph.facebook.com/777262374/picture",
      "comLastDate": "2012-10-01T12:19:52Z",
      "uniqueVoiceCount": 20
    },
    {
      "username": "Eric Tan",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104592421185&id=39419741184",
      "assetsURL": "http://www.facebook.com/39419741184",
      "assetsPic": "http://graph.facebook.com/39419741184/picture",
      "profileURL": "http://www.facebook.com/621696224",
      "content": "How come M1 is reducing the corporate discount for their plans under iPhone 5?? Data capacity is grossly reduced by >50% yet price increases?? Seriously, is this what customer service is about??",
      "id": "39419741184_10151104592421185",
      "likesCount": 1,
      "commentCount": 0,
      "shareCount": 0,
      "datetimePost": "2012-10-01T11:53:52Z",
      "userPic": "https://graph.facebook.com/621696224/picture",
      "comLastDate": "2012-10-01T11:53:52Z",
      "uniqueVoiceCount": 1
    }
  ]
}'''
      }
    }

    def getFacebookFansCumulativeGrowth() {
      render '''{
  "maleData": 
  [
    60442,
    60444,
    60461,
    60473
  ],
  "femaleData": 
  [
    211514,
    211533,
    211536,
    211628
  ],
  "fansData": 
  [
    272671,
    272691,
    272710,
    272815
  ],
  "dayCount": 3,
  "startDate": 1343779200000
}'''
    }

    def getAllPostLikes() {
      render '''{
  "data": 
  [
    {
      "username": "Shevv Haryadin",
      "gender": null,
      "userPic": "https://graph.facebook.com/1182981815/picture",
      "profileURL": "http://www.facebook.com/1182981815"
    }
  ]
}'''
    }

    def getAllPostComments() {
      render '''{
  "data": 
  [
    {
      "username": "Ho Wei Siong",
      "gender": null,
      "userPic": "https://graph.facebook.com/745531823/picture",
      "content": "I got mine iPhone5 White 64GB at Buggis instead! I got mine iPhone5 White 64GB at Buggis instead! http://abcasdfa.comad.sadfadsf.sadfadsf I got mine iPhone5 White 64GB at Buggis instead! I got mine iPhone5 White 64GB at Buggis instead!",
      "postId": "39419741184_10151104774371185_23975967",
      "likesCount": 0,
      "profileURL": "http://www.facebook.com/745531823",
      "datetimePost": "2012-10-04T03:48:20Z",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151104774371185&id=39419741184"
    }
  ],
  "total": 1890
}'''
    }

    def getAllPostUniqueVoice() {
      render '''{
  "data": 
  [
    {
      "userId": "745531823",
      "profileURL": "http://www.facebook.com/745531823",
      "userPic": "http://graph.facebook.com/745531823/picture",
      "username": "Ho Wei Siong",
      "commentCount": 1,
      "likesCount": 0
    },
    {
      "userId": "1182981815",
      "profileURL": "http://www.facebook.com/1182981815",
      "userPic": "http://graph.facebook.com/1182981815/picture",
      "username": "Shevv Haryadin",
      "commentCount": 0,
      "likesCount": 1
    }
  ]
}'''
    }

    def getFacebookTotalDensityChartData() {
      render '''{
  "data": 
  [
    {
      "x": 17,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 16,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 16,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 17,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 19,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 18,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 12,
      "y": 3,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 4
    },
    {
      "x": 10,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 11,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 23,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 20,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 19,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 18,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
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
      "x": 9,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 20,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 7,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 21,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 23,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 21,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 7,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 9,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 3,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 2,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 13,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 14,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 1,
      "y": 2,
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
      "id": 1
    },
    {
      "x": 20,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 15,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 13,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 12,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 11,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 10,
      "y": 1,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 7
    },
    {
      "x": 8,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 19,
      "y": 3,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 5
    },
    {
      "x": 18,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    }
  ],
  "total": 75
}'''
    }

    def getFacebookAdminDensityChartData() {
      render '''{
  "data": 
  [
    {
      "x": 16,
      "y": 3,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 17,
      "y": 1,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 17,
      "y": 3,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 16,
      "y": 1,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 9,
      "y": 2,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 19,
      "y": 1,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 11,
      "y": 3,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 14,
      "y": 2,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 11,
      "y": 1,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 19,
      "y": 2,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 10,
      "y": 1,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 18,
      "y": 2,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 1
    },
    {
      "x": 19,
      "y": 3,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 2
    }
  ],
  "total": 14
}'''
    }

    def getFacebookNonAdminDensityChartData() {
      render '''{
  "data": 
  [
    {
      "x": 17,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 16,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 16,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 17,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 19,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 18,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 12,
      "y": 3,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 4
    },
    {
      "x": 10,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 11,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 23,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 20,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 19,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 18,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
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
      "x": 9,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 20,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 7,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 21,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 23,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 21,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 7,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 9,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 3,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 2,
      "y": 2,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 13,
      "y": 2,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 1,
      "y": 2,
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
      "id": 1
    },
    {
      "x": 20,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 15,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 13,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 12,
      "y": 1,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 2
    },
    {
      "x": 11,
      "y": 1,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 10,
      "y": 1,
      "marker": {
        "fillColor": "#7798BF",
        "radius": 13
      },
      "id": 6
    },
    {
      "x": 8,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    },
    {
      "x": 19,
      "y": 3,
      "marker": {
        "fillColor": "#BEAF87",
        "radius": 9
      },
      "id": 3
    },
    {
      "x": 18,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 1
    }
  ],
  "total": 61
}'''
    }

    def getFacebookTotalPostType() {
      render '''{
  "categories": 
  [
    "status",
    "photo"
  ],
  "postData": 
  [
    41,
    10
  ],
  "likeData": 
  [
    18,
    17
  ],
  "commentData": 
  [
    97,
    29
  ],
  "shareData": 
  [
    97,
    29
  ]
}'''
    }

    def getFacebookAdminPostType() {
      render '''{
  "categories": 
  [
    "status",
    "photo"
  ],
  "postData": 
  [
    41,
    10
  ],
  "likeData": 
  [
    18,
    17
  ],
  "commentData": 
  [
    97,
    29
  ],
  "shareData": 
  [
    97,
    29
  ]
}'''
    }

    def getFacebookFanPostType() {
      render '''{
  "categories": 
  [
    "status",
    "photo"
  ],
  "postData": 
  [
    41,
    10
  ],
  "likeData": 
  [
    18,
    17
  ],
  "commentData": 
  [
    97,
    29
  ],
  "shareData": 
  [
    97,
    29
  ]
}'''
    }

    def getFacebookReplyTimeDetails() {
      render '''{
  "total": 1,
  "maxTime": 61,
  "xAxisData": 
  [
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    1
  ]
}'''
    }

    def getFacebookFansGrowth() {
      render '''{
  "dayCount": 11,
  "startDate": 1346284800000,
  "likesData": 
  [
    122,
    75,
    124,
    104,
    83,
    84,
    79,
    100,
    71,
    110,
    93,
    0
  ],
  "dislikeData": 
  [
    61,
    48,
    93,
    70,
    54,
    56,
    70,
    61,
    67,
    65,
    64,
    0
  ]
}'''
    }

    def getFacebookFansSource() {
      render '''{
  "data": 
  [
    [
      "hovercard",
      6
    ],
    [
      "photo_snowlift",
      2
    ],
    [
      "page_browser",
      152
    ],
    [
      "video_flyout",
      3
    ],
    [
      "timeline",
      177
    ],
    [
      "favorites",
      1
    ],
    [
      "like_story",
      4
    ],
    [
      "recommended_pages",
      87
    ],
    [
      "search",
      2
    ],
    [
      "external_connect",
      11
    ],
    [
      "page_profile",
      115
    ],
    [
      "api",
      17
    ],
    [
      "mobile",
      100
    ]
  ]
}'''
    }

    def getFacebookGenderAnalysis() {
      render '''{
  "series": 
  [
    {
      "name": "Gender",
      "data": 
      [
        22.23136105,
        77.51133659,
        0.25730236
      ]
    }
  ],
  "categories": 
  [
    "Male",
    "Female",
    "Unknown"
  ]
}'''
    }

    def getFacebookGenderCumulative() {
      render '''{
  "categories": 
  [
    "13-17",
    "18-24",
    "25-34",
    "35-44",
    "45-54",
    "55-64",
    "65+"
  ],
  "data": 
  [
    19365,
    24486,
    10767,
    3762,
    1425,
    439,
    732
  ],
  "total": 60976
}'''
    }

    def getFacebookCountryAnalysis() {
      render '''{
      "name": "Country",
      "data": 
      [
        75.53698676,
        8.68495564,
        8.27334464,
        1.54272238,
        1.3571153,
        0.72241187,
        0.27622701,
        0.18415134,
        0.17032179
      ],
  "categories": 
  [
    "NZ",
    "FJ",
    "AU",
    "GB",
    "US",
    "IE",
    "IN",
    "CA",
    "WS"
  ]
}'''
    }

    def getFacebookCityAnalysis() {
      render '''{
      "name": "City",
      "data": 
      [
        23.71003079,
        6.95225895,
        4.98118454,
        4.62671141,
        4.22347093,
        2.19562258,
        2.13739291,
        2.10245511,
        1.65663418
      ],
  "categories": 
  [
    "Auckland, New Zealand",
    "Christchurch, Canterbury, New Zealand",
    "Wellington, New Zealand",
    "Suva, Central, Fiji",
    "Hamilton, Waikato, New Zealand",
    "Palmerston North, Manawatu-Wanganui, New Zealand",
    "Dunedin, Otago, New Zealand",
    "Tauranga, Bay of Plenty, New Zealand",
    "Brisbane, QLD, Australia"
  ]
}'''
    }

    def getFacebookLanguageAnalysis() {
      render '''{
      "name": "Language",
      "data": 
      [
        75.26803846,
        23.80392614,
        0.12774134,
        0.10590522,
        0.09535109,
        0.07023954,
        0.06296083,
        0.03857716,
        0.03639355
      ],
  "categories": 
  [
    "English (United States)",
    "English (United Kingdom)",
    "Spanish (Laos)",
    "French (France)",
    "German (Germany)",
    "English (PI)",
    "Indonesian (Indonesia)",
    "Japanese (Japan)",
    "Arabic (Argentina)"
  ]
}'''
    }

    def getPageViews() {
      render '''{
  "pageview": 
  [
    1220,
    502,
    799,
    383,
    355,
    460,
    641,
    393
  ],
  "uniqueview": 
  [
    677,
    244,
    420,
    191,
    168,
    265,
    346,
    209
  ],
  "startDate": 1346338800000,
  "dayCount": 7
}'''
    }

    def getTotalTabViews() {
      render '''{
  "categories": 
  [
    "timeline",
    "photos",
    "videos",
    "events",
    "photos_stream",
    "info",
    "photos_albums",
    "likes",
    "wall",
    "app_53267368995"
  ],
  "data": 
  [
    32434,
    4427,
    1985,
    1473,
    690,
    339,
    249,
    77,
    42,
    11
  ]
}'''
    }

    def getExternalReference() {
      render '''{
  "categories": 
  [
    "tvnz.co.nz",
    "google.co.nz",
    "google.com",
    "vb.google.com",
    "oop.google.com",
    "tv.google.com",
    "search.babylon.com",
    "google.fr",
    "proxyinfo.srv.volvo.com",
    "app_53267368995"
  ],
  "data": 
  [
    32434,
    4427,
    1985,
    1473,
    690,
    339,
    249,
    77,
    42,
    11
  ]
}'''
    }

    def getFacebookVisitFrequency() {
      render '''{
  "data": 
  [
    295526,
    
    85459,
    76356,
    53166,
    47014,
    19693,
    4126
  ],
  "categories": 
  [
    "1",
    
    "6-10",
    "3",
    "4",
    "5",
    "11-20",
    "21+"
  ],
  "total": 706012
}'''
    }

    def getTwitterReplyTimeDetails() {
      render '''{
  "maxTime": 11,
  "xAxisData": 
  [
    8,
    1,
    1,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    1
  ]
}'''
    }

    def getTwitterRepostTimeDetails() {
      render '''{
  "maxTime": 37,
  "xAxisData": 
  [
    29,
    4,
    0,
    1,
    0,
    0,
    0,
    0,
    0,
    1,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1
  ]
}'''
    }

    def fbVerifyPassword() {
      render '''{"data":[
        {
          "accessToken": "asdfasdfsa",
          "id": "1",
          "name": "Joe King"
        },
        {
          "accessToken": "asdfasdfsa",
          "id": "2",
          "name": "Mehache mogo"
        },
        {
          "accessToken": "asdfasdfsa",
          "id": "3",
          "name": "Delie lyen"
        },
        {
          "accessToken": "asdfasdfsa",
          "id": "4",
          "name": "Groy metony"
        }
      ]}'''
    }

    def selectFbPage() {
      render '''{"data":{}}'''
    }

    def verifyUserPasswordAuth() {
      render '''{"data": "success"}'''
    }

    def getFacebookTotalEngageActivity() {
      render '''{
  "audienceArr": 
  [
    82,
    382,
    209,
    117,
    172,
    198,
    95
  ],
  "engageArr": 
  [
    46,
    94,
    51,
    51,
    40,
    35,
    7
  ],
  "postArr": 
  [
    24,
    39,
    9,
    25,
    12,
    17,
    2
  ],
  "startDate": 1348012800000,
  "dayCount": 6
}'''
    }

    def getFacebookAdminEngageActivity() {
      getFacebookTotalEngageActivity()
    }

    def getFacebookNonAdminEngageActivity() {
      getFacebookTotalEngageActivity()
    }

    def getAllFacebookEngage() {
      render '''{
        "data": [
          {
      "username": "Taniwha Tu",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151215317824808&id=163327684807",
      "assetsURL": "http://www.facebook.com/163327684807",
      "assetsPic": "http://graph.facebook.com/163327684807/picture",
      "profileURL": "http://www.facebook.com/100001169512110",
      "content": "LOL ENCOURAGING EVERTHING IN THIS SHOW.. ALL TODO WITH N.Z SOCIETY AND HAPPENINGS THAT ARE OUT THERE.. DANIEL WINS $1MIL WOTS GONA HAPPEN TO IT? HE CAN PISS OF NOW DONT NEED TO WRK AS A MAINTAINENCE NOW.... GET OF THE SHOW! ",
      "postId": "163327684807_10151215317824808",
      "likesCount": 1000,
      "audienceCount": 2000,
      "engageCount": 5600,
      "engageRate": 20,
      "imageURL": "http://sphotos-f.ak.fbcdn.net/hphotos-ak-snc7/s480x480/399090_10151215068442621_1398182145_n.jpg",
      "datetimePost": "2012-09-06T12:01:49Z",
      "userPic": "https://graph.facebook.com/100001169512110/picture",
      "comLastDate": "2012-09-06T12:01:49Z"
    }, {
      "username": "Taniwha Tu",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151215317824808&id=163327684807",
      "assetsURL": "http://www.facebook.com/163327684807",
      "assetsPic": "http://graph.facebook.com/163327684807/picture",
      "profileURL": "http://www.facebook.com/100001169512110",
      "content": "LOL ENCOURAGING EVERTHING IN THIS SHOW.. ALL TODO WITH N.Z SOCIETY AND HAPPENINGS THAT ARE OUT THERE.. DANIEL WINS $1MIL WOTS GONA HAPPEN TO IT? HE CAN PISS OF NOW DONT NEED TO WRK AS A MAINTAINENCE NOW.... GET OF THE SHOW! ",
      "postId": "163327684807_10151215317824808",
      "likesCount": 80,
      "audienceCount": 790,
      "engageCount": 1230,
      "engageRate": 10,
      "imageURL": "http://sphotos-f.ak.fbcdn.net/hphotos-ak-snc7/s480x480/399090_10151215068442621_1398182145_n.jpg",
      "datetimePost": "2012-09-06T12:01:49Z",
      "userPic": "https://graph.facebook.com/100001169512110/picture",
      "comLastDate": "2012-09-06T12:01:49Z"
    }, {
      "username": "Taniwha Tu",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151215317824808&id=163327684807",
      "assetsURL": "http://www.facebook.com/163327684807",
      "assetsPic": "http://graph.facebook.com/163327684807/picture",
      "profileURL": "http://www.facebook.com/100001169512110",
      "content": "LOL ENCOURAGING EVERTHING IN THIS SHOW.. ALL TODO WITH N.Z SOCIETY AND HAPPENINGS THAT ARE OUT THERE.. DANIEL WINS $1MIL WOTS GONA HAPPEN TO IT? HE CAN PISS OF NOW DONT NEED TO WRK AS A MAINTAINENCE NOW.... GET OF THE SHOW! ",
      "postId": "163327684807_10151215317824808",
      "likesCount": 34230,
      "audienceCount": 2340,
      "engageCount": 7860,
      "engageRate": 90,
      "imageURL": "http://sphotos-f.ak.fbcdn.net/hphotos-ak-snc7/s480x480/399090_10151215068442621_1398182145_n.jpg",
      "datetimePost": "2012-09-06T12:01:49Z",
      "userPic": "https://graph.facebook.com/100001169512110/picture",
      "comLastDate": "2012-09-06T12:01:49Z"
    }
        ],
        "total": 28
        }'''
    }

    def getTotalCommentActivity() {
      render '''{
  "startDate": 1349222400000,
  "dayCount": 6,
  "commentData": 
  [
    82,
    382,
    209,
    117,
    172,
    198,
    95
  ],
  "uniqueComm": 
  [
    8,
    82,
    29,
    17,
    72,
    98,
    9
  ],
  "commentTotal": 54,
  "uniqueCommentTotal": 23
}'''
    }

    def getAdminCommentActivity() {
      getTotalCommentActivity()
    }

    def getNonAdminCommentActivity() {
      getTotalCommentActivity()
    }

    def getAllFacebookComment() {
      render '''{
        "data": [
          {
      "username": "WJ Bank",
      "gender": null,
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "content": "Dear Mr. Seah.  We are very happy to assist with your transaction and aid in becoming as rich as Miss Luah. http://abc.google.com/asdf/sdfad/asdfd/asdf?asdf=324%sd adfawe wer werwer werwer  Loerm Dory",
      "postId": "322058887863626_364095136993334",
      "likesCount": 10,
      "profileURL": "http://www.facebook.com/322058887863626",
      "datetimePost": "2012-07-12T10:10:18Z"
    },{
      "username": "WJ Bank",
      "gender": null,
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "content": "Dear Mr. Seah.  We are very happy to assist with your transaction and aid in becoming as rich as Miss Luah.",
      "postId": "322058887863626_36409513699",
      "likesCount": 100,
      "profileURL": "http://www.facebook.com/322058887863626",
      "datetimePost": "2012-07-12T10:10:18Z"
    },{
      "username": "WJ Bank",
      "gender": null,
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "content": "Dear Mr. Seah.  We are very happy to assist with your transaction and aid in becoming as rich as Miss Luah.",
      "postId": "322058887863626",
      "likesCount": 1000,
      "profileURL": "http://www.facebook.com/322058887863626",
      "datetimePost": "2012-07-12T10:10:18Z"
    }
        ],
        "total": 1780
        }'''
    }

    def getAllFacebookUniqueCommenter() {
      render '''{
  "data": 
  [
    {
      "voiceId": "745531823",
      "profileURL": "http://www.facebook.com/745531823",
      "userPic": "http://graph.facebook.com/745531823/picture",
      "username": "Ho Wei Siong",
      "commentCount": 10
    }
  , {
      "voiceId": "745531823",
      "profileURL": "http://www.facebook.com/745531823",
      "userPic": "http://graph.facebook.com/745531823/picture",
      "username": "Ho Wei Siong",
      "commentCount": 100
    }
  , {
      "voiceId": "745531823",
      "profileURL": "http://www.facebook.com/745531823",
      "userPic": "http://graph.facebook.com/745531823/picture",
      "username": "Ho Wei Siong",
      "commentCount": 1000
    }
  , {
      "voiceId": "745531823",
      "profileURL": "http://www.facebook.com/745531823",
      "userPic": "http://graph.facebook.com/745531823/picture",
      "username": "Ho Wei Siong",
      "commentCount": 10000
    }
  ],
  "total": 99
}'''
    }

    def getFacebookTotalCommentDensityChart() {
      getDensityChartData()
    }

    def getFacebookAdminCommentDensityChart() {
      getFacebookTotalCommentDensityChart()
    }

    def getFacebookNonAdminCommentDensityChart() {
      getFacebookTotalCommentDensityChart()
    }

    def getFacebookNonAdminUniqueCommenterDensityChart() {
      getFacebookTotalCommentDensityChart()
    }

    def getFacebookUserInfluence() {
      render '''{
        "data": [{
      "userId": "100000614994747",
      "profileURL": "http://www.facebook.com/100000614994747",
      "userPic": "http://graph.facebook.com/100000614994747/picture",
      "username": "Eddy Sotplug Lim",
      "commentCount": 0,
      "postCount": 1,
      "postLikeCount": 0,
      "postCommentCount": 0,
      "postShareCount": 0,
      "commentLikeCount": 0
    },
    {
      "userId": "548208008",
      "profileURL": "http://www.facebook.com/548208008",
      "userPic": "http://graph.facebook.com/548208008/picture",
      "username": "Amber Zara Garcia",
      "commentCount": 2,
      "postCount": 1,
      "postLikeCount": 1,
      "postCommentCount": 5,
      "postShareCount": 0,
      "commentLikeCount": 0
    }, {
      "userId": "1294509943",
      "profileURL": "http://www.facebook.com/1294509943",
      "userPic": "http://graph.facebook.com/1294509943/picture",
      "username": "Lau Wei Cheng",
      "commentCount": 100,
      "postCount": 108
    }, {
      "userId": "1294509942",
      "profileURL": "http://www.facebook.com/1294509943",
      "userPic": "http://graph.facebook.com/1294509943/picture",
      "username": "Lau Wei Cheng",
      "commentCount": 0,
      "postCount": 199
    }, {
      "userId": "129409943",
      "profileURL": "http://www.facebook.com/1294509943",
      "userPic": "http://graph.facebook.com/1294509943/picture",
      "username": "Lau Wei Cheng",
      "commentCount": 0,
      "postCount": 100
    }, {
      "userId": "129450943",
      "profileURL": "http://www.facebook.com/1294509943",
      "userPic": "http://graph.facebook.com/1294509943/picture",
      "username": "Lau Wei Cheng",
      "commentCount": 0,
      "postCount": 1
    }, {
      "userId": "294509943",
      "profileURL": "http://www.facebook.com/1294509943",
      "userPic": "http://graph.facebook.com/1294509943/picture",
      "username": "Lau Wei Cheng",
      "commentCount": 1090,
      "postCount": 90
    },{
      "userId": "94509943",
      "profileURL": "http://www.facebook.com/1294509943",
      "userPic": "http://graph.facebook.com/1294509943/picture",
      "username": "Lau Wei Cheng",
      "commentCount": 80,
      "postCount": 21
    }],
    "total": 98
        }'''
    }

    def getWeiboPostBreakdown() {
      render '''{"repostArr": 
  [
    495,
    1428,
    990,
    198,
    469,
    295
  ],
  "replyArr": 
  [
    290,
    516,
    400,
    111,
    175,
    95
  ],
  "postArr": 
  [
    13,
    74,
    25,
    5,
    13,
    1
  ],
  "startDate": 1349827200000,
  "dayCount": 5,
  "totalRepostCount": 3875,
  "totalPostCount": 131,
  "totalReplyCount": 1587,
  "dateArray": 
  [
    "2012-10-09T16:00:00Z",
    "2012-10-10T16:00:00Z",
    "2012-10-11T16:00:00Z",
    "2012-10-12T16:00:00Z",
    "2012-10-13T16:00:00Z",
    "2012-10-14T16:00:00Z"
  ]
}'''
    }

    def getWeiboPostAtSpecificDate() {
      if (params.type == "Post") {
      render '''{
  "data": 
  [
    {
      "avatarPic": "http://tp3.sinaimg.cn/1900093822/50/5640584682/1",
      "cCount": 43,
      "city": "北京",
      "class": "com.brandtology.mongo.WeiboPost",
      "content": "真是够荒唐！",
      "country": "中国",
      "datetimePost": "2012-10-14T15:57:10Z",
      "day": 0,
      "gender": "m",
      "hour": 23,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1845032493,
        "machine": 1066394133,
        "new": false,
        "time": 1350276087000,
        "timeSecond": 1350276087
      },
      "pictureURL": "",
      "postId": "3501181701257222",
      "rCount": 177,
      "source": "iPhone客户端",
      "state": "北京",
      "url": "http://weibo.com/1900093822/zuJY5h3M",
      "userid": "1900093822",
      "username": "张醒生",
      "verified": "true",
      "version": 0
    },
    {
      "avatarPic": "http://tp3.sinaimg.cn/1900093822/50/5640584682/1",
      "cCount": 30,
      "city": "北京",
      "class": "com.brandtology.mongo.WeiboPost",
      "content": "这是中国社会变态！我说过几次，还要重复一遍：今天拼命挤进去的，大部分明天还会被甩出来！[衰]",
      "country": "中国",
      "datetimePost": "2012-10-14T15:55:04Z",
      "day": 0,
      "gender": "m",
      "hour": 23,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1845032584,
        "machine": 1066394133,
        "new": false,
        "time": 1350276108000,
        "timeSecond": 1350276108
      },
      "pictureURL": "",
      "postId": "3501181177303087",
      "rCount": 60,
      "source": "iPhone客户端",
      "state": "北京",
      "url": "http://weibo.com/1900093822/zuJ7uDRJ",
      "userid": "1900093822",
      "username": "张醒生",
      "verified": "true",
      "version": 0
    },
    {
      "avatarPic": "http://tp3.sinaimg.cn/1900093822/50/5640584682/1",
      "cCount": 30,
      "city": "北京",
      "class": "com.brandtology.mongo.WeiboPost",
      "content": "这是中国社会变态！我说过几次，还要重复一遍：今天拼命挤进去的，大部分明天还会被甩出来！[衰]",
      "country": "中国",
      "datetimePost": "2012-10-14T15:55:04Z",
      "day": 0,
      "gender": "m",
      "hour": 23,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1845032584,
        "machine": 1066394133,
        "new": false,
        "time": 1350276108000,
        "timeSecond": 1350276108
      },
      "pictureURL": "",
      "postId": "350118117730308999",
      "rCount": 60,
      "source": "iPhone客户端",
      "state": "北京",
      "url": "http://weibo.com/1900093822/zuJ7uDRJ",
      "userid": "1900093822",
      "username": "",
      "verified": "true",
      "version": 0
    }
 ],
 "total": 88
}'''
      } else {
        render '''{
  "data": 
  [
    {
      "articleId": "3499876358616815",
      "assetId": "1900093822",
      "avatarPic": "http://tp2.sinaimg.cn/1278307193/50/40004253237/0",
      "city": "重庆",
      "class": "com.brandtology.mongo.Weibo_Comment",
      "content": "握笔的手不因恐惧而颤抖，不因表达而获罪。",
      "country": "中国",
      "datetimePost": "2012-10-11T02:08:00Z",
      "day": 4,
      "followerCount": 246,
      "gender": "f",
      "hour": 10,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1845036593,
        "machine": 1066394133,
        "new": false,
        "time": 1350277158000,
        "timeSecond": 1350277158
      },
      "postId": "3499885875870563",
      "source": "iPhone客户端",
      "state": "重庆",
      "userid": "1278307193",
      "username": "Drunk-Mandy",
      "verified": "false",
      "version": 0
    },
    {
      "articleId": "3499876358616815",
      "assetId": "1900093822",
      "avatarPic": "http://tp2.sinaimg.cn/1624917041/50/5626495033/1",
      "city": "济南",
      "class": "com.brandtology.mongo.Weibo_Comment",
      "content": "为重庆模式摇旗呐喊的不要视而不见",
      "country": "中国",
      "datetimePost": "2012-10-11T02:07:44Z",
      "day": 4,
      "followerCount": 263,
      "gender": "m",
      "hour": 10,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1845036594,
        "machine": 1066394133,
        "new": false,
        "time": 1350277158000,
        "timeSecond": 1350277158
      },
      "postId": "3499885816616475",
      "source": "新浪微博",
      "state": "山东",
      "userid": "1624917041",
      "username": "张昌涛",
      "verified": "false",
      "version": 0
    }
 ],
 "total": 99
}'''
      }
    }

    def getWeiboDetailsAtSpecificPost() {
      render '''{
  "data": 
  [
    {
      "articleId": "3501181701257222",
      "assetId": "1900093822",
      "avatarPic": "http://tp2.sinaimg.cn/1691940253/50/0/0",
      "city": "荆州",
      "class": "com.brandtology.mongo.Weibo_Comment",
      "content": " @Kate爹的微博",
      "country": "中国",
      "datetimePost": "2012-10-15T02:22:52Z",
      "day": 1,
      "followerCount": 21,
      "gender": "f",
      "hour": 10,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1845032273,
        "machine": 1066394133,
        "new": false,
        "time": 1350276053000,
        "timeSecond": 1350276053
      },
      "postId": "3501339168782542",
      "source": "iPhone客户端",
      "state": "湖北",
      "userid": "1691940253",
      "username": "pingping008的世界",
      "verified": "false",
      "version": 0
    },
    {
      "articleId": "3501181701257222",
      "assetId": "1900093822",
      "avatarPic": "http://tp4.sinaimg.cn/2342482075/50/5630120088/1",
      "city": "北京",
      "class": "com.brandtology.mongo.Weibo_Comment",
      "content": "没有感同身受，哪来真知灼见？",
      "country": "中国",
      "datetimePost": "2012-10-15T02:06:56Z",
      "day": 1,
      "followerCount": 66,
      "gender": "m",
      "hour": 10,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1845032274,
        "machine": 1066394133,
        "new": false,
        "time": 1350276054000,
        "timeSecond": 1350276054
      },
      "postId": "3501335154140230",
      "source": "WeicoPro",
      "state": "北京",
      "userid": "2342482075",
      "username": "奋章兴",
      "verified": "false",
      "version": 0
    }
 ],
 "total": 88
}'''
    }

    def getWeiboAnalysisAtSpecificPost() {
      getTwitterAnalysisAtSpecificPost()
    }

    def getWeiboRepostTimeDetails() {
      getTwitterRepostTimeDetails()
    }

    def getWeiboReplyTimeDetails() {
      getTwitterReplyTimeDetails()
    }

    def getWeiboRepostInfluencerDetails() {
      render '''{
  "data": 
  [
    {
      "username": "张醒生",
      "count": "163"
    }
  , {
      "username": "张醒生",
      "count": "163"
    }
  , {
      "username": "张醒生",
      "count": "163"
    }
  , {
      "username": "张醒生",
      "count": "163"
    }
  , {
      "username": "张醒生",
      "count": "163"
    }
  , {
      "username": "张醒生",
      "count": "163"
    }
  , {
      "username": "张醒生",
      "count": "163"
    }
  , {
      "username": "张醒生",
      "count": "163"
    }
  , {
      "username": "张醒生",
      "count": "163"
    }
  , {
      "username": "张醒生",
      "count": "163"
    }
  ],
  "total": 99
}'''
    }

    def getWeiboDensityChartData() {
      render '''{
  "total": 131,
  "data": 
  [
    {
      "x": 16,
      "y": 5,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 2
    },
    {
      "x": 15,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 6
    },
    {
      "x": 13,
      "y": 3,
      "marker": {
        "fillColor": "#7F00AD",
        "radius": 5
      },
      "id": 2
    }
 ]
}'''
    }

    def getWeiboPostAnalysisAtSpecificDate() {
      if (params.analysis == 'location') {
        render '''{
  "total": 1211,
  "categories": 
  [
    "北京",
    "广东",
    "上海",
    "其他",
    "浙江",
    "江苏",
    "山东",
    "湖北",
    "福建",
    "四川"
  ],
  "data": 
  [
    380,
    244,
    155,
    97,
    75,
    65,
    56,
    55,
    42,
    42
  ]
}'''
      } else if (params.analysis == "gender") {
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
      } else {
        render '''{
  "total": 1350,
  "categories": 
  [
    "新浪微博",
    "iPhone客户端",
    "Android客户端",
    "iPad客户端",
    "360安全浏览器",
    "新浪微博手机版",
    "微博桌面",
    "专业版微博",
    "S60客户端",
    "小米手机"
  ],
  "data": 
  [
    613,
    324,
    182,
    53,
    51,
    31,
    28,
    26,
    23,
    19
  ]
}'''
      }
    }

    def getWeiboEngagementMatrix() {
      render '''{
  "data": 
  [
    {
      "userid": "1231145622",
      "username": "独渚千帆",
      "verified": "false",
      "followerCount": 676,
      "repostCount": 1,
      "replyCount": 0,
      "avatarPic": "http://tp3.sinaimg.cn/1231145622/50/5628501472/1",
      "userURL": "http://www.weibo.com/u/1231145622"
    }
  , {
      "userid": "2029750905",
      "username": "孟孟来了",
      "verified": "false",
      "followerCount": 116,
      "repostCount": 1,
      "replyCount": 1,
      "avatarPic": "http://tp2.sinaimg.cn/2029750905/50/5615638024/0",
      "userURL": "http://www.weibo.com/u/2029750905"
    }
  , {
      "userid": "20297509056",
      "username": "孟孟来了2",
      "verified": "false",
      "followerCount": 116,
      "repostCount": 0,
      "replyCount": 100000,
      "avatarPic": "http://tp2.sinaimg.cn/2029750905/50/5615638024/0",
      "userURL": "http://www.weibo.com/u/2029750905"
    }
 ], "total": 99
}'''
    }

    def getWeiboFollowerTrends() {
      render '''{
  "startDate": 1349827200000,
  "dayCount": 5,
  "followerTotal": 1358194,
  "followerAddedTotal": 1358194,
  "followerCount": 
  [
    0,
    0,
    0,
    0,
    0,
    1358194
  ],
  "followerAdded": 
  [
    0,
    0,
    0,
    0,
    0,
    1358194
  ],
  "dateArray": 
  [
    "2012-10-09T16:00:00Z",
    "2012-10-10T16:00:00Z",
    "2012-10-11T16:00:00Z",
    "2012-10-12T16:00:00Z",
    "2012-10-13T16:00:00Z",
    "2012-10-14T16:00:00Z"
  ]
}'''
    }

    def getAllProfiles() {
      render '''{
  "data": 
  [
    {
      "location": "其他",
      "gender": "f",
      "name": "小朵2240426123",
      "followerCount": 29,
      "url": "http://www.weibo.com/u/2240426123",
      "profilePic": "http://tp4.sinaimg.cn/2240426123/50/5637823413/0"
    },
    {
      "location": "广东",
      "gender": "f",
      "name": "Yasmin練婉婉",
      "followerCount": 734,
      "url": "http://www.weibo.com/u/1724135153",
      "profilePic": "http://tp2.sinaimg.cn/1724135153/50/40003708039/0"
    }
 ],"total": 98
}'''
    }

    def getWeiboFollowingProfileGenderChart() {
      render '''{
  "xAxis": 
  [
    "Male",
    "Female"
  ],
  "series": 
  [
    {
      "name": "Percentage",
      "data": 
      [
        68.33910035,
        31.66089965
      ]
    }
  ]
}'''
    }

    def getWeiboFollowingProfileLocationChart() {
      render '''{
  "series": 
  [
    {
      "name": "Location",
      "data": 
      [
        71.79930796,
        5.70934256,
        5.53633218,
        3.46020761,
        2.76816609,
        1.55709343,
        1.03806228,
        0.69204152,
        0.69204152,
        0.51903114
      ]
    }
  ],
  "categories": 
  [
    "北京",
    "广东",
    "上海",
    "其他",
    "香港",
    "台湾",
    "山东",
    "云南",
    "福建",
    "湖南"
  ]
}'''
    }

    def getWeiboTweetsByVoice() {
      if (params.type == "Repost") {
        render '''{
  "data": 
  [
    {
      "articleId": "3501837808550568",
      "assetId": "1686192095",
      "avatarPic": "http://tp2.sinaimg.cn/1686194565/50/5607412110/1",
      "city": "香港",
      "class": "com.brandtology.mongo.Weibo_Repost",
      "content": "刚好相机坏了",
      "country": "香港",
      "datetimePost": "2012-10-17T16:01:18Z",
      "day": 4,
      "followerCount": 2771,
      "gender": "m",
      "hour": 0,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1734368396,
        "machine": -458204572,
        "new": false,
        "time": 1350491411000,
        "timeSecond": 1350491411
      },
      "layer": 1,
      "postId": "3502269914243923",
      "rURL": "http://weibo.com/1686194565/z0X39hO2n",
      "source": "iPad客户端",
      "state": "香港",
      "userid": "1686194565",
      "username": "少爷啤",
      "verified": "true",
      "version": 0
    }
 ], "total": 88
}'''
      } else if (params.type == "Reply") {
        render '''{
  "data": 
  [
    {
      "articleId": "3501837808550568",
      "assetId": "1686192095",
      "avatarPic": "http://tp2.sinaimg.cn/1686194565/50/5607412110/1",
      "city": "香港",
      "class": "com.brandtology.mongo.Weibo_Comment",
      "content": "刚好相机坏了",
      "country": "香港",
      "datetimePost": "2012-10-17T16:01:18Z",
      "day": 4,
      "followerCount": 2771,
      "gender": "m",
      "hour": 0,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1734368395,
        "machine": -458204572,
        "new": false,
        "time": 1350491411000,
        "timeSecond": 1350491411
      },
      "postId": "3502269913929789",
      "rURL": "http://weibo.com/1686192095/z0LOczSoo",
      "source": "iPad客户端",
      "state": "香港",
      "userid": "1686194565",
      "username": "少爷啤",
      "verified": "true",
      "version": 0
    }
 ], "total": 88
}'''
      }
    }

    def getTwitterTweetsByVoice() {
      if (params.type == "Repost") {
        render '''{
  "data": 
  [
    {
      "articleId": "260799147353976832",
      "assetId": "14652452",
      "avatarPic": "http://a0.twimg.com/profile_images/2715678395/424359bc43afc0e810e3078fd6588669_normal.png",
      "class": "com.brandtology.mongo.Twitter_Repost",
      "content": "RT @mayhemstudios: Wearing my psdtuts @envatopsd tee today! Thanks @grantfriedman. Great hanging out. #MayhemNYC http://t.co/tBavFxIk",
      "date": 24,
      "datetimeCrawled": "2012-10-23T17:52:14Z",
      "datetimePost": "2012-10-23T17:46:52Z",
      "day": 3,
      "followerCount": 46,
      "gender": "unknown",
      "hour": 1,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 47066285,
        "machine": -458221792,
        "new": false,
        "time": 1351014734000,
        "timeSecond": 1351014734
      },
      "klout": 10,
      "language": "en",
      "latit": 0,
      "location": "INTL",
      "longti": 0,
      "postId": "260799464883769344",
      "rURL": "http://twitter.com/RocketingMedia/statuses/260799464883769344",
      "source": "RoundTeam",
      "tweetType": null,
      "userid": "837072367",
      "username": "RocketingMedia",
      "verified": "false",
      "version": 0
    }
 ], "total": 88
}'''
      } else if (params.type == "Reply") {
        render '''{
  "data": 
  [
    {
      "articleId": "258805415108829184",
      "assetId": "14652452",
      "avatarPic": "http://a0.twimg.com/profile_images/1041447167/Screen_shot_2010-06-30_at_11.48.31_PM_normal.png",
      "class": "com.brandtology.mongo.Twitter_Comment",
      "content": "@mayhemstudios lol I was just there a couple of weeks ago",
      "date": 18,
      "datetimeCrawled": "2012-10-18T06:28:02Z",
      "datetimePost": "2012-10-18T06:20:39Z",
      "day": 4,
      "followerCount": 5735,
      "gender": "unknown",
      "hour": 14,
      "id": {
        "class": "org.bson.types.ObjectId",
        "inc": 1869486545,
        "machine": -458217628,
        "new": false,
        "time": 1350541682000,
        "timeSecond": 1350541682
      },
      "klout": 62,
      "language": "en",
      "latit": 34.07248706,
      "location": "US",
      "longti": -118.14662824,
      "postId": "258814832361476096",
      "rURL": "http://twitter.com/kiasuchick/statuses/258814832361476096",
      "source": "Twitter for iPhone",
      "tweetType": null,
      "userid": "13460112",
      "username": "kiasuchick",
      "verified": "false",
      "version": 0
    }
 ], "total": 88
}'''
      }
    }

    def getFacebookLikesTrends() {
      render '''{
  "startDate": 1357142400000,
  "dayCount": 1,
  "followerTotal": 66869,
  "followerAddedTotal": 66869,
  "followerCount": 
  [
    0,
    6660,
    7770,
    8880,
    9990,
    66869
  ],
  "followerAdded": 
  [
    0,
    1110,
    1110,
    1110,
    1110,
    66869
  ],
  "dateArray": 
  [
    "2012-12-29T16:00:00Z",
    "2012-12-30T16:00:00Z",
    "2012-12-31T16:00:00Z",
    "2013-01-01T16:00:00Z",
    "2013-01-02T16:00:00Z",
    "2013-01-03T16:00:00Z"
  ]
}'''
    }

    def getFacebookTalkingAboutThisTrends() {
      render '''{
  "startDate": 1357142400000,
  "dayCount": 1,
  "followerTotal": 418,
  "followerAddedTotal": 418,
  "followerCount": 
  [
    0,
    418
  ],
  "followerAdded": 
  [
    0,
    418
  ],
  "dateArray": 
  [
    "2013-01-02T16:00:00Z",
    "2013-01-03T16:00:00Z"
  ]
}'''
    }
}

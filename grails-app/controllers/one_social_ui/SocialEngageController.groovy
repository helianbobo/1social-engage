package one_social_ui

import javax.servlet.AsyncContext
import grails.converters.JSON

class SocialEngageController {


    def index() {redirect(action: 'posts')}


    def getPostDetails() {

        render '''{
  "data": {
    "username": "Brandtology",
    "permalink": "http://www.facebook.com/permalink.php?story_fbid=10150862533251701&id=104681096700",
    "profileURL": "http://www.facebook.com/104681096700",
    "imageURL": "http://photos-d.ak.fbcdn.net/hphotos-ak-ash3/533419_10150862533191701_1214425481_s.jpg",
    "content": "How The World Spends Its Time Online [INFOGRAPHIC] <a href=\\"http://buff.ly/LATWXi\\" target=\\"_blank\\">http://buff.ly/LATWXi<\\/a>",
    "id": "104681096700_10150862533251701",
    "likesCount": 4,
    "caseData": {
    },
    "commentCount": 0,
    "datetimePost": "2012-06-13T00:56:31Z",
    "userPic": "https://graph.facebook.com/104681096700/picture",
    "comment":
    [
    ]
  }
}
'''

    }


    def getAllPosts() {

        response.contentType = 'application/json'
        render '''{
  "data":
  [
    {
      "content": "Short buzz cuts for men¡¯s hair are back in style?!\\n http://redirect.pepperconn.net/eq",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-25T06:24:30Z",
      "fbId": "98685085344_10150933171645345",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 0,
      "likeCount": 9,
      "caseCreated": true,
      "readStatus": true,
      "readBy": "weijian",
      "comment":
      [
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture"
    },
    {
      "content": "Watch these kids as they come together to honor every living thing and help save Mother Earth. öá?Ê×Ê×ÊŠ?îÜ?ÔÛ?åýùŒî÷?ÙéÝïßæÙ€Õô£¬?ñõÏ­ò¢Ï¹íÂõóÒœÕô£¡\\n http://www.facebook.com/MediaCorpSavingGaia",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-25T01:30:59Z",
      "fbId": "98685085344_319577704796315",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 2,
      "likeCount": 48,
      "caseCreated": false,
      "readStatus": true,
      "readBy": "weijian",
      "comment":
      [
        {
          "content": "í»ðôá³QQüåñËñýý­£¬ðÎßÓÜšÔðÌÚé»æ¶ûÕÖõ ><~~ ÍÅÕçû¿Îù£¬ÌœïÒõÌÐÎöŠ\\nÕÎìýâ¢Ó€äÑ ^^",
          "voiceName": "Presath Wedagedara",
          "datetimePosted": "2012-06-25T04:06:14Z",
          "likeCount": 1,
          "relatedCase":
          [
            "9691337237017561"
          ]
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture"
    },
    {
      "content": "Food for thought for Marketers.",
      "voiceName": "Brandtology",
      "datetimePosted": "2012-06-25T03:44:58Z",
      "fbId": "104681096700_10150886023251701",
      "voicePic": "https://graph.facebook.com/104681096700/picture",
      "commentCount": 0,
      "likeCount": 5,
      "caseCreated": false,
      "readStatus": true,
      "readBy": "weijian",
      "comment":
      [
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture"
    },
    {
      "content": "Watch these kids as they come together to honor every living thing and help save Mother Earth. öá?Ê×Ê×ÊŠ?îÜ?ÔÛ?åýùŒî÷?ÙéÝïßæÙ€Õô£¬?ñõÏ­ò¢Ï¹íÂõóÒœÕô£¡\\n http://www.facebook.com/MediaCorpSavingGaia",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-25T01:30:59Z",
      "fbId": "98685085344_319577704796315",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 2,
      "likeCount": 48,
      "caseCreated": false,
      "readStatus": true,
      "readBy": "weijian",
      "comment":
      [
        {
          "content": "But I tried very hard to understand the singing words",
          "voiceName": "Chee Yong",
          "datetimePosted": "2012-06-25T03:29:15Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ]
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture"
    },
    {
      "content": "Watch these kids as they come together to honor every living thing and help save Mother Earth. öá?Ê×Ê×ÊŠ?îÜ?ÔÛ?åýùŒî÷?ÙéÝïßæÙ€Õô£¬?ñõÏ­ò¢Ï¹íÂõóÒœÕô£¡\\n http://www.facebook.com/MediaCorpSavingGaia",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-25T01:30:59Z",
      "fbId": "98685085344_319577704796315",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 2,
      "likeCount": 48,
      "caseCreated": false,
      "readStatus": true,
      "readBy": "weijian",
      "comment":
      [
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture"
    },
    {
      "content": "I find priority seat auntie look very much like choo mimi . how abt asking her to play the role of tat auntie and hopefully tis auntie be embarrassed..",
      "voiceName": "Alvin Fua",
      "datetimePosted": "2012-06-24T23:56:41Z",
      "fbId": "98685085344_10150932677890345",
      "voicePic": "https://graph.facebook.com/1073794765/picture",
      "commentCount": 0,
      "likeCount": 0,
      "caseCreated": false,
      "readStatus": true,
      "readBy": "weijian",
      "comment":
      [
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture"
    },
    {
      "content": "Sorry For Not Posting For Awhile, Bcos I Was Busy Fulfilling My Dream:) Even Though School Is Reopening Tmr Is Also Important For Students To Study Hard For Yr Exam, But Do Remember To Watch Joys of Life ü£?ìÑ? At 9pm On Channel 8! Here Is A Video To Make U Hv A Great Start For Tmr!! 2 MORE DAYS! =D\\n\\nhttp://www.youtube.com/watch?v=6PKc6OnqNg8&feature=plcp \\n\\n-RR.\\n Joys of Life ü£?ìÑ? - Behind The Scene Ø­ýšü£ßü 6: Opening sequence (HD 1080p)",
      "voiceName": "Rui En",
      "datetimePosted": "2012-06-24T15:45:21Z",
      "fbId": "98685085344_10150931839135345",
      "voicePic": "https://graph.facebook.com/149424541737219/picture",
      "commentCount": 0,
      "likeCount": 0,
      "caseCreated": false,
      "readStatus": true,
      "readBy": "weijian",
      "comment":
      [
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture"
    },
    {
      "content": "I like channel 8 because I lovely love",
      "voiceName": "Meili Mei Li Low",
      "datetimePosted": "2012-06-24T15:41:38Z",
      "fbId": "98685085344_10150931833590345",
      "voicePic": "https://graph.facebook.com/100003973665702/picture",
      "commentCount": 0,
      "likeCount": 0,
      "caseCreated": false,
      "readStatus": true,
      "readBy": "weijian",
      "comment":
      [
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture"
    },
    {
      "content": "??Ñá×ìÊŠì€Ê×ÓðÐÑôž8?Ô³îÜãæ?ñì÷ë??£¿é©î€?ó×ßŸîÜ¡£",
      "voiceName": "Luisa Mok Lu Yock",
      "datetimePosted": "2012-06-24T15:24:50Z",
      "fbId": "98685085344_10150931804300345",
      "voicePic": "https://graph.facebook.com/1647235259/picture",
      "commentCount": 0,
      "likeCount": 0,
      "caseCreated": false,
      "readStatus": true,
      "readBy": "weijian",
      "comment":
      [
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture"
    },
    {
      "content": "How The World Spends Its Time Online [INFOGRAPHIC] http://buff.ly/LATWXi",
      "voiceName": "Brandtology",
      "datetimePosted": "2012-06-13T00:56:31Z",
      "fbId": "104681096700_10150862533251701",
      "voicePic": "https://graph.facebook.com/104681096700/picture",
      "commentCount": 0,
      "likeCount": 4,
      "caseCreated": false,
      "readStatus": true,
      "readBy": "weijian",
      "comment":
      [
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture"
    }
  ]
}
'''

    }

    def getAllCase() {

    }

    def createCase() {

    }

    def getCaseHistory() {

    }

    def closeCase() {

    }

    def post() {

    }

    def cases() {
        def currentSubModule = 'cases'

        [currentSubModule: currentSubModule]
    }

    def posts() {
        def currentSubModule = 'posts'

        [currentSubModule: currentSubModule]
    }


}

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
        /*
        clientAccountId=969&
        type=facebook&
        sort=dateCreated&
        order=asc&
        max=20&
        offset=0&
         */

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

    def showConversation(){

        /*
        articleId=98685085344_196710807123445&
        voiceId=719707536&
        type=facebook&
        commentId=98685085344_196710807123445_518623
         */

        render '''{
  "url": "http://www.facebook.com/permalink.php?story_fbid=196710807123445&id=98685085344",
  "username": "Channel 8",
  "content": "ü£?ìÑ? debuts tomorrow!! Here's a look at the meet & greet we had at Eastpoint Mall last weekend!\\n Joys of Life ü£?ìÑ? - äÄâ¢?Øü? Meet & Greet at Eastpoint Mall!",
  "fbId": "98685085344_196710807123445",
  "likesCount": 109,
  "voiceId": "98685085344",
  "comments":
  [
    {
      "content": "yes finally can watch it",
      "isOriginal": 1,
      "isUser": 1,
      "dateTimePosted": "2012-06-25T10:19:40Z",
      "fbid": "98685085344_196710807123445_518623",
      "username": "Xavienne Chew Lah Sia",
      "userpic": "https://graph.facebook.com/719707536/picture",
      "likesCount": 0,
      "voiceId": "719707536"
    },
    {
      "content": "episode 1 last part the somebody cutting Rui En hairs i think",
      "isUser": 1,
      "dateTimePosted": "2012-06-25T10:20:13Z",
      "fbid": "98685085344_196710807123445_518624",
      "username": "Xavienne Chew Lah Sia",
      "userpic": "https://graph.facebook.com/719707536/picture",
      "likesCount": 0,
      "voiceId": "719707536"
    },
    {
      "content": "26hrs 35mins more to #joysoflife",
      "dateTimePosted": "2012-06-25T10:24:23Z",
      "fbid": "98685085344_196710807123445_518630",
      "username": "Swee Heng Tan",
      "userpic": "https://graph.facebook.com/100002676015109/picture",
      "likesCount": 1,
      "voiceId": "100002676015109"
    },
    {
      "content": "Let's trend #joysoflife tmr at 9pm on twitter! :)",
      "dateTimePosted": "2012-06-25T10:42:35Z",
      "fbid": "98685085344_196710807123445_518683",
      "username": "Joys of Life ü£?ìÑ?",
      "userpic": "https://graph.facebook.com/345262218830470/picture",
      "likesCount": 3,
      "voiceId": "345262218830470"
    },
    {
      "content": "Xiao gui acting skills is real good. 2 thumps up for him..",
      "dateTimePosted": "2012-06-25T10:55:48Z",
      "fbid": "98685085344_196710807123445_518704",
      "username": "Kitty Catty",
      "userpic": "https://graph.facebook.com/624748319/picture",
      "likesCount": 2,
      "voiceId": "624748319"
    },
    {
      "content": "I love XiaoGui ^^ ",
      "dateTimePosted": "2012-06-25T11:00:48Z",
      "fbid": "98685085344_196710807123445_518714",
      "username": "Jesslyn Tu",
      "userpic": "https://graph.facebook.com/100000140890216/picture",
      "likesCount": 0,
      "voiceId": "100000140890216"
    },
    {
      "content": "Where is Xiao Gui now ? Singapore or Taiwan ?",
      "dateTimePosted": "2012-06-25T12:01:14Z",
      "fbid": "98685085344_196710807123445_518888",
      "username": "Xian Ning",
      "userpic": "https://graph.facebook.com/100000066130303/picture",
      "likesCount": 0,
      "voiceId": "100000066130303"
    },
    {
      "content": "I Love Rui En,:)\\nepisode 1 last part the somebody cutting Rui En hairs i think:)",
      "dateTimePosted": "2012-06-25T14:00:46Z",
      "fbid": "98685085344_196710807123445_519311",
      "username": "Heng XinYing",
      "userpic": "https://graph.facebook.com/100001907864504/picture",
      "likesCount": 0,
      "voiceId": "100001907864504"
    },
    {
      "content": "^^ One more day!",
      "dateTimePosted": "2012-06-25T10:17:52Z",
      "fbid": "98685085344_196710807123445_518620",
      "username": "Joys of Life ü£?ìÑ?",
      "userpic": "https://graph.facebook.com/345262218830470/picture",
      "likesCount": 4,
      "voiceId": "345262218830470"
    }
  ]
}'''
    }

    def markStatus(){
        /*
        commentId=0&
        articleId=98685085344_10150933571490345&
        status=true&
        userId=661&
        type=facebook
         */

        render '''{"response":"ok"}'''
    }

    def getAllCase() {
        /*
        sort=dateCreated&
        order=asc&
        max=20&
        offset=0&
        platform=everything&
        assetId=everything

        Case SortBy:
            Params                                 UI

            assignee                              Agent
            caseStatus                          Status
            priority                                 Priority
            datetimePosted               Datetime Posted
            dateCreated                      Datetime Created
         */

        render '''{
  "data":
  [
    {
      "caseId": "9691340801189916",
      "title": "hello",
      "priority": 3,
      "dateCreated": "2012-06-27T12:46:29Z",
      "articleId": "98685085344_10150933571490345",
      "commentId": "0",
      "caseStatus": 1,
      "assignTo": "Tan Weijian - SG",
      "createdBy": "Tan Weijian - SG",
      "type": "facebook",
      "articleContent": "we're on episode 3 of Share Something ä²?Íë? on Channel 8 from 15:28 to 19:10 :) catch it on xinmsn!\\n Episode 3",
      "articleVoiceName": "Manicurious",
      "articleVoicePicture": "https://graph.facebook.com/180911745311892/picture",
      "articleDateTimePost": "2012-06-25T12:16:59Z",
      "articleVoiceId": "180911745311892",
      "assetId": "98685085344",
      "assetPic": "http://graph.facebook.com/98685085344/picture",
      "comment":
      [
      ]
    },
    {
      "caseId": "9691340812250263",
      "title": "hello",
      "priority": 3,
      "dateCreated": "2012-06-27T15:50:50Z",
      "articleId": "98685085344_196710807123445",
      "commentId": "0",
      "caseStatus": 1,
      "assignTo": "Tan Weijian - SG",
      "createdBy": "Tan Weijian - SG",
      "type": "facebook",
      "articleContent": "ü£?ìÑ? debuts tomorrow!! Here's a look at the meet & greet we had at Eastpoint Mall last weekend!\\n Joys of Life ü£?ìÑ? - äÄâ¢?Øü? Meet & Greet at Eastpoint Mall!",
      "articleVoiceName": "Channel 8",
      "articleVoicePicture": "https://graph.facebook.com/98685085344/picture",
      "articleDateTimePost": "2012-06-25T10:16:33Z",
      "articleVoiceId": "98685085344",
      "assetId": "98685085344",
      "assetPic": "http://graph.facebook.com/98685085344/picture",
      "comment":
      [
      ]
    }
  ]
}'''

    }

    def createCase() {
        /*
        articleId=98685085344_196710807123445&
        type=facebook&
        commentId=98685085344_196710807123445_518623&
        name=hello&
        priority=3&
        assignTo=661&
         */

        render '''{
  "data": {"caseId":"9691340720753581"}
}'''
    }

    def addMemo(){
        /*
        caseId=9691340714194928&
        type=facebook&
        memo=hello3&
         */

        render '''{"response":"ok"}'''
    }

    def updateCase(){
        /*
        caseId=9691340714194928&
        type=facebook&
        name=newTitle&
         */
        render '''{"response":"ok"}'''
    }

    def responseCase(){
        /*
        caseId=9691340714194928&
        type=facebook&
        response=responding&
         */
        render '''{"response":"ok"}'''
    }


    def getCaseHistory() {
        /*
        caseId=9691340720753581
         */

        def caseHistoryDataJson = '''{
  "data":
  [
    {
      "createdBy": "Tan Weijian - SG",
      "createDate": "2012-06-27T12:46:29Z",
      "indicator": 3,
      "params": {
        "caseId": "9691340801189916",
        "caseState": 1
      }
    },
    {
      "createdBy": "Tan Weijian - SG",
      "createDate": "2012-06-27T12:46:29Z",
      "indicator": 4,
      "params":{
          "caseId": "9691340801189916",
          "assignee": "Tan Weijian - SG"
       }

    },
    {
      "createdBy": "Tan Weijian - SG",
      "createDate": "2012-06-27T12:46:29Z",
      "indicator": 5,
      "params": {
        "caseId": "9691340801189916",
        "priority": 3
      }
    },
    {
      "createdBy": "Tan Weijian - SG",
      "createDate": "2012-06-27T12:46:29Z",
      "indicator": 1,
      "params": {
        "caseId": "9691340801189916",
        "caseName": "hello"
      }
    }
  ]
}'''
        def result = [:]
        def caseHistoryData = JSON.parse(caseHistoryDataJson)
        result.data = caseHistoryData.data.collect {caseHistoryEntry->

            def args = [caseHistoryEntry.createDate, caseHistoryEntry.createdBy]
            args.addAll(caseHistoryEntry.params.values() as List)

            g.message(
                    code: "brandtology.engage.case.history.CH${caseHistoryEntry.indicator}",
                    args: args)
        }

        render result as JSON

    }

    def closeCase() {
        /*
        caseId=9691340714194928&
        type=facebook&
         */

        render '''{"response":"ok"}'''
    }

    def updateVoiceDetails(){
        /*
        voiceId=9691340801140613.1340801141467&
        name=hello&
        identifier=iden&
        email=a&
        phone=12345&
         */

        render '''{"response":"ok"}'''

    }

    def updateSocialProfile(){
        /*
        voiceId=9691340801140613.1340801141467&
        name=hi&
        url=www.twitter.com/bye&
        type=twitter&
         */
    }

    def getVoiceProfile(){
        /*
        voiceId=9691340801140613.1340801141467
         */
        render '''{
  "data": {
    "class": "com.brandtology.mongo.Voice",
    "clientAccountId": 969,
    "email": "a",
    "fbId": "180911745311892",
    "fbName": "Manicurious",
    "fbUrl": "http://www.facebook.com/180911745311892",
    "id": {
      "class": "org.bson.types.ObjectId",
      "inc": 877359895,
      "machine": -1351019594,
      "new": false,
      "time": 1340801141000,
      "timeSecond": 1340801141
    },
    "identifier": "iden",
    "name": "bye",
    "phone": "12345",
    "twitterId": null,
    "twitterSN": "hi",
    "twitterURL": "www.twitter.com/bye",
    "version": 0,
    "voiceId": "9691340801140613.1340801141467",
    "weiboId": null,
    "weiboSN": null,
    "weiboURL": null
  }
}'''
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

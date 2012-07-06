package one_social_ui

import javax.servlet.AsyncContext
import grails.converters.JSON

class SocialEngageController {


    def index() {redirect(action: 'posts')}

    def getCaseById(){
        /*
        caseId=9691340959298765
         */

        render '''{
  "caseId": "''' + params.caseId + '''",
  "title": "case1",
  "priority": 2,
  "caseStatus": 1,
  "assetPic": "http://graph.facebook.com/28011986676/picture",
  "assetURL": "http://www.facebook.com/28011986676",
  "articleId": "28011986676_10151726285826677",
  "commentId": "0",
  "type": "facebook",
  "content": "Cant believe you all wrote/said to ST and said that 2G was available when the network outage occurred this morning. Its was a complete loss of both network mind you! the fact that ST tried to downplay the whole affair reflects on how much ST cant face up to the issue while playing taichi and asking the consumers to keep switching on and off their phone or worse trying to call into the nonexistent helplines and telling us to head to exeter to make a sim change. All this while the issue is on your end of the stick! Yes i am pissed. pissed with how you guys insult the users and trying to twist facts! ",
  "voicePic": "https://graph.facebook.com/665336665/picture",
  "voiceName": "Perry Teo",
  "voiceURL": "http://www.facebook.com/665336665"
}'''
    }


    def getPostDetails() {

        render '''{
  "data": {
    "userName": "Brandtology",
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
        type=facebook&
        sort=datetimeSort|lCount(likes Count)|cCount(comment count)
        order=asc&
        max=20&
        offset=0&
        postType=Article|Comment
        assetsId=everything
        readStatus=read|unread
        caseCreated=true|false

         */

        render '''{ "data": [ { "content": "Review interest rate, Contact us for more info", "voiceName": "WJ Bank", "datetimePosted": "2012-07-03T03:46:08Z", "fbId": "322058887863626_360570517345796", "voicePic": "https://graph.facebook.com/322058887863626/picture", "commentCount": 0, "likeCount": 0, "voiceId": "322058887863626", "caseId": "9691341297556920", "caseCreated": true, "readStatus": "unread", "comment": [ ], "assetsPic": "https://graph.facebook.com/322058887863626/picture", "assetsId": "322058887863626" }, { "content": "Singtel Network Down.!!! I cant make any calls out or receive any calls!! SINTEL What is appening to you guys!! Why is this always happening!!!!!!!", "voiceName": "Lawrence Chia", "datetimePosted": "2012-07-01T02:36:34Z", "fbId": "28011986676_10151725883386677", "voicePic": "https://graph.facebook.com/1024767404/picture", "commentCount": 7, "likeCount": 1, "voiceId": "1024767404", "caseId": "9691341302369330", "caseCreated": true, "readStatus": "unread", "comment": [ { "content": "Hi Lawrence, earlier this morning around 10.30am, some of our customers in Paya Lebar, Kallang, East Coast and Marine Parade area may have had difficulties using their 3G services. Recovery started from 1130am, and all services were fully restored by 1145am. The root cause is under investigation. During the issue, 2G services were available. Once again, please accept our apologies for the inconvenience caused. - Caroline", "voiceName": "SingTel", "datetimePosted": "2012-07-01T08:54:15Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151725883386677_22343077" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "Cant believe you all wrote/said to ST and said that 2G was available when the network outage occurred this morning. Its was a complete loss of both network mind you! the fact that ST tried to downplay the whole affair reflects on how much ST cant face up to the issue while playing taichi and asking the consumers to keep switching on and off their phone or worse trying to call into the nonexistent helplines and telling us to head to exeter to make a sim change. All this while the issue is on your end of the stick! Yes i am pissed. pissed with how you guys insult the users and trying to twist facts! ", "voiceName": "Perry Teo", "datetimePosted": "2012-07-01T08:51:10Z", "fbId": "28011986676_10151726285826677", "voicePic": "https://graph.facebook.com/665336665/picture", "commentCount": 0, "likeCount": 0, "voiceId": "665336665", "caseId": "9691341301184247", "caseCreated": true, "readStatus": "unread", "comment": [ ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "I experience bad voice and data connection for the last 14 days around Macperson area and Eunos area....you are performing upgrading work?", "voiceName": "Denis Beh", "datetimePosted": "2012-07-01T06:17:45Z", "fbId": "28011986676_10151726136881677", "voicePic": "https://graph.facebook.com/824347312/picture", "commentCount": 1, "likeCount": 0, "voiceId": "824347312", "caseId": "9691340959298765", "caseCreated": true, "readStatus": "unread", "comment": [ { "content": "Hi Denis, please provide us your details via the form below so that we can investigate on the network performance in both areas. Thanks - Caroline\\n\\nhttp://on.fb.me/ContactSingTel", "voiceName": "SingTel", "datetimePosted": "2012-07-01T07:48:08Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151726136881677_22342829" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "Singtel Network Down.!!! I cant make any calls out or receive any calls!! SINTEL What is appening to you guys!! Why is this always happening!!!!!!!", "voiceName": "Lawrence Chia", "datetimePosted": "2012-07-01T02:36:34Z", "fbId": "28011986676_10151725883386677", "voicePic": "https://graph.facebook.com/1024767404/picture", "commentCount": 7, "likeCount": 1, "voiceId": "1024767404", "caseId": "9691341396224413", "caseCreated": true, "readStatus": "unread", "comment": [ { "content": "Caroline, Service is up now. But that does not explain why it was down for for about 1 and a half hours. This is not the explanation i am expecting. I missed my teleconference because of the your downed Network!!", "voiceName": "Lawrence Chia", "datetimePosted": "2012-07-01T07:40:56Z", "likeCount": 0, "relatedCase": null, "voiceId": "1024767404", "voicePic": "https://graph.facebook.com/1024767404/picture", "fbId": "28011986676_10151725883386677_22342791" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "When will singtel be rolling out the blackberry 7.1 upgrade for the curve 9360 ? Its out for 9900 but not for the curve. WHY ?", "voiceName": "Vish Upadhya", "datetimePosted": "2012-07-01T07:19:50Z", "fbId": "28011986676_10151726186846677", "voicePic": "https://graph.facebook.com/700223890/picture", "commentCount": 0, "likeCount": 0, "voiceId": "700223890", "caseId": "9691341396023367", "caseCreated": true, "readStatus": "unread", "comment": [ ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "Singtel Network Down.!!! I cant make any calls out or receive any calls!! SINTEL What is appening to you guys!! Why is this always happening!!!!!!!", "voiceName": "Lawrence Chia", "datetimePosted": "2012-07-01T02:36:34Z", "fbId": "28011986676_10151725883386677", "voicePic": "https://graph.facebook.com/1024767404/picture", "commentCount": 7, "likeCount": 1, "voiceId": "1024767404", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "You mean they have online staff replying your FB postings?? Damn !! I should stop calling the hotline from now on! Lol", "voiceName": "Alwyn Sim", "datetimePosted": "2012-07-01T06:59:25Z", "likeCount": 0, "relatedCase": null, "voiceId": "1109161257", "voicePic": "https://graph.facebook.com/1109161257/picture", "fbId": "28011986676_10151725883386677_22342622" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "Was there a connection problem with Singtel mobile earlier?? My mobile phone had no mobile reception for about an hour or so. ", "voiceName": "Mitesh Desai", "datetimePosted": "2012-07-01T03:44:08Z", "fbId": "28011986676_10151725984296677", "voicePic": "https://graph.facebook.com/525740717/picture", "commentCount": 3, "likeCount": 0, "voiceId": "525740717", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Hi Mitesh, thanks for sharing the update. Have a good weekend. - Caroline", "voiceName": "SingTel", "datetimePosted": "2012-07-01T06:54:25Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151725984296677_22342607" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "Kindly do something about the network!! Its TERRIBLE!!", "voiceName": "Sharon Lyra Norahs", "datetimePosted": "2012-07-01T03:39:57Z", "fbId": "28011986676_10151725980561677", "voicePic": "https://graph.facebook.com/542187018/picture", "commentCount": 5, "likeCount": 0, "voiceId": "542187018", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Hi Sharon, are you still facing the issue now? If yes, please let us know the exact location or postal code. Thanks - Caroline", "voiceName": "SingTel", "datetimePosted": "2012-07-01T06:52:24Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151725980561677_22342603" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "How come Singtel took no apparent efforts to inform its subscribers of the disruption in 3G services? Perhaps IDA should take a closer look at its mitigation process. ", "voiceName": "JC Ho", "datetimePosted": "2012-07-01T06:48:54Z", "fbId": "28011986676_10151726160131677", "voicePic": "https://graph.facebook.com/100002090110307/picture", "commentCount": 0, "likeCount": 0, "voiceId": "100002090110307", "caseCreated": false, "readStatus": "unread", "comment": [ ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "Network down again this morning at East Coast???", "voiceName": "Victor Tan", "datetimePosted": "2012-07-01T03:51:58Z", "fbId": "28011986676_10151725992586677", "voicePic": "https://graph.facebook.com/100000518330877/picture", "commentCount": 6, "likeCount": 0, "voiceId": "100000518330877", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Hi Perry Teo & Victor Tan, we are sorry about your experience this morning. The network has been restored. Do alert us if you are still facing any issue. Thanks - Caroline", "voiceName": "SingTel", "datetimePosted": "2012-07-01T06:48:41Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151725992586677_22342589" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "I experience bad voice and data connection for the last 14 days around Macperson area and Eunos area....you are performing upgrading work?", "voiceName": "Denis Beh", "datetimePosted": "2012-07-01T06:17:45Z", "fbId": "28011986676_10151726136881677", "voicePic": "https://graph.facebook.com/824347312/picture", "commentCount": 1, "likeCount": 0, "voiceId": "824347312", "caseCreated": false, "readStatus": "unread", "comment": [ ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "My contract is ending with Singtel, and I am most probably going to switch my mobile service provider. So disappointing! ", "voiceName": "Mitesh Desai", "datetimePosted": "2012-07-01T06:10:50Z", "fbId": "28011986676_10151726131241677", "voicePic": "https://graph.facebook.com/525740717/picture", "commentCount": 0, "likeCount": 0, "voiceId": "525740717", "caseCreated": false, "readStatus": "unread", "comment": [ ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "Was there a connection problem with Singtel mobile earlier?? My mobile phone had no mobile reception for about an hour or so. ", "voiceName": "Mitesh Desai", "datetimePosted": "2012-07-01T03:44:08Z", "fbId": "28011986676_10151725984296677", "voicePic": "https://graph.facebook.com/525740717/picture", "commentCount": 3, "likeCount": 0, "voiceId": "525740717", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "It's fine now . ", "voiceName": "Mitesh Desai", "datetimePosted": "2012-07-01T06:07:51Z", "likeCount": 0, "relatedCase": null, "voiceId": "525740717", "voicePic": "https://graph.facebook.com/525740717/picture", "fbId": "28011986676_10151725984296677_22342425" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "....", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:56:34Z", "fbId": "28011986676_10151726120501677", "voicePic": "https://graph.facebook.com/646605485/picture", "commentCount": 3, "likeCount": 0, "voiceId": "646605485", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Hi Alvin Ncs\\n\\nWe did not hide your posting. It is still on the Facebook wall. Do let us know if you are still encountering any issue so that we can investigate. Thanks. - Darryl", "voiceName": "SingTel", "datetimePosted": "2012-07-01T06:06:37Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151726120501677_22342420" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "....", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:56:34Z", "fbId": "28011986676_10151726120501677", "voicePic": "https://graph.facebook.com/646605485/picture", "commentCount": 3, "likeCount": 0, "voiceId": "646605485", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "I cant post a single shit when you hide my post. I cant even comment. ", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:57:18Z", "likeCount": 0, "relatedCase": null, "voiceId": "646605485", "voicePic": "https://graph.facebook.com/646605485/picture", "fbId": "28011986676_10151726120501677_22342380" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "....", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:56:34Z", "fbId": "28011986676_10151726120501677", "voicePic": "https://graph.facebook.com/646605485/picture", "commentCount": 3, "likeCount": 0, "voiceId": "646605485", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Stop hiding my post. ", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:56:47Z", "likeCount": 0, "relatedCase": null, "voiceId": "646605485", "voicePic": "https://graph.facebook.com/646605485/picture", "fbId": "28011986676_10151726120501677_22342376" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "....", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:56:34Z", "fbId": "28011986676_10151726120501677", "voicePic": "https://graph.facebook.com/646605485/picture", "commentCount": 3, "likeCount": 0, "voiceId": "646605485", "caseCreated": false, "readStatus": "unread", "comment": [ ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "Singtel's 3G network has been very erratic of late. Just this morning, the Singtel mobile network was suddenly not available where I was in the eastern part of Singapore at around 11am. At other times, 3G data transfer can be slow to the point of being non existent, despite reasonable phone reception.\\n\\nThis is not a complaint but I hope you guys don't let service standards fall as I know you're capable of doing a great job as I have a fantastic experience with Singtel, till now.", "voiceName": "Gerald Lim", "datetimePosted": "2012-07-01T05:17:58Z", "fbId": "28011986676_10151726088091677", "voicePic": "https://graph.facebook.com/665603361/picture", "commentCount": 1, "likeCount": 0, "voiceId": "665603361", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Hi Gerald\\n\\nSorry to hear about that. Are you still experiencing any problems? Do let us know your exact location so that we can look into this. Thanks. - Darryl", "voiceName": "SingTel", "datetimePosted": "2012-07-01T05:37:21Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151726088091677_22342294" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" }, { "content": "Connection down with 3g, 2g restarted phone and connection but still the same I have been facing this issue for lots of times. Currently at joo chiat, old airport road and toa payoh. Whats wrong with singtel. Now it shows no service. Isnt that cool?", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:20:57Z", "fbId": "28011986676_10151726091496677", "voicePic": "https://graph.facebook.com/646605485/picture", "commentCount": 2, "likeCount": 0, "voiceId": "646605485", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "lol Alvin chill", "voiceName": "Yang YaoTian", "datetimePosted": "2012-07-01T05:34:28Z", "likeCount": 0, "relatedCase": null, "voiceId": "819178641", "voicePic": "https://graph.facebook.com/819178641/picture", "fbId": "28011986676_10151726091496677_22342285" } ], "assetsPic": "https://graph.facebook.com/28011986676/picture", "assetsId": "28011986676" } ], "total": 117 }'''

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
        commentId=98685085344_252834011497416_920663&
        articleId=98685085344_252834011497416&
        status=read|unread
        userId=661
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

        render '''{ "total": 9, "data": [ { "caseId": "9691341565324557", "title": "Strange", "priority": 3, "dateCreated": "2012-07-06T09:02:05Z", "articleId": "28011986676_10151726186846677", "commentId": "0", "caseStatus": 1, "assignTo": "Tan Weijian - SG", "createdBy": "Tan Weijian - SG", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "When will singtel be rolling out the blackberry 7.1 upgrade for the curve 9360 ? Its out for 9900 but not for the curve. WHY ?", "articleVoiceName": "Vish Upadhya", "articleVoicePicture": "https://graph.facebook.com/700223890/picture", "articleDateTimePost": "2012-07-01T07:19:50Z", "articleVoiceId": "700223890", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ ] }, { "caseId": "9691341482695378", "title": "ddd", "priority": 3, "dateCreated": "2012-07-05T10:04:55Z", "articleId": "104681096700_10150904152071701", "commentId": "0", "caseStatus": 1, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Food for thought for Marketers.", "articleVoiceName": "Brandtology", "articleVoicePicture": "https://graph.facebook.com/104681096700/picture", "articleDateTimePost": "2012-07-04T05:25:38Z", "articleVoiceId": "104681096700", "assetId": "104681096700", "assetPic": "http://graph.facebook.com/104681096700/picture", "comment": [ ] }, { "caseId": "9691341396224413", "title": "case1", "priority": 3, "dateCreated": "2012-07-04T10:03:44Z", "articleId": "28011986676_10151725883386677", "commentId": "28011986676_10151725883386677_22342791", "caseStatus": 1, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Singtel Network Down.!!! I cant make any calls out or receive any calls!! SINTEL What is appening to you guys!! Why is this always happening!!!!!!!", "articleVoiceName": "Lawrence Chia", "articleVoicePicture": "https://graph.facebook.com/1024767404/picture", "articleDateTimePost": "2012-07-01T02:36:34Z", "articleVoiceId": "1024767404", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ { "content": "Caroline, Service is up now. But that does not explain why it was down for for about 1 and a half hours. This is not the explanation i am expecting. I missed my teleconference because of the your downed Network!!", "voiceId": "1024767404", "voiceName": "Lawrence Chia", "datetimePost": "2012-07-01T07:40:56Z", "voicePicture": "https://graph.facebook.com/1024767404/picture" } ] }, { "caseId": "9691341396023367", "title": "newTitle", "priority": 4, "dateCreated": "2012-07-04T10:00:23Z", "articleId": "28011986676_10151726186846677", "commentId": "0", "caseStatus": 1, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "When will singtel be rolling out the blackberry 7.1 upgrade for the curve 9360 ? Its out for 9900 but not for the curve. WHY ?", "articleVoiceName": "Vish Upadhya", "articleVoicePicture": "https://graph.facebook.com/700223890/picture", "articleDateTimePost": "2012-07-01T07:19:50Z", "articleVoiceId": "700223890", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ ] }, { "caseId": "9691341302369330", "title": "case22345", "priority": 4, "dateCreated": "2012-07-03T07:59:29Z", "articleId": "28011986676_10151725883386677", "commentId": "28011986676_10151725883386677_22343077", "caseStatus": 1, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Singtel Network Down.!!! I cant make any calls out or receive any calls!! SINTEL What is appening to you guys!! Why is this always happening!!!!!!!", "articleVoiceName": "Lawrence Chia", "articleVoicePicture": "https://graph.facebook.com/1024767404/picture", "articleDateTimePost": "2012-07-01T02:36:34Z", "articleVoiceId": "1024767404", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ { "content": "Hi Lawrence, earlier this morning around 10.30am, some of our customers in Paya Lebar, Kallang, East Coast and Marine Parade area may have had difficulties using their 3G services. Recovery started from 1130am, and all services were fully restored by 1145am. The root cause is under investigation. During the issue, 2G services were available. Once again, please accept our apologies for the inconvenience caused. - Caroline", "voiceId": "28011986676", "voiceName": "SingTel", "datetimePost": "2012-07-01T08:54:15Z", "voicePicture": "https://graph.facebook.com/28011986676/picture" } ] }, { "caseId": "9691341301184247", "title": "case1", "priority": 2, "dateCreated": "2012-07-03T07:39:44Z", "articleId": "28011986676_10151726285826677", "commentId": "0", "caseStatus": 1, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Cant believe you all wrote/said to ST and said that 2G was available when the network outage occurred this morning. Its was a complete loss of both network mind you! the fact that ST tried to downplay the whole affair reflects on how much ST cant face up to the issue while playing taichi and asking the consumers to keep switching on and off their phone or worse trying to call into the nonexistent helplines and telling us to head to exeter to make a sim change. All this while the issue is on your end of the stick! Yes i am pissed. pissed with how you guys insult the users and trying to twist facts! ", "articleVoiceName": "Perry Teo", "articleVoicePicture": "https://graph.facebook.com/665336665/picture", "articleDateTimePost": "2012-07-01T08:51:10Z", "articleVoiceId": "665336665", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ ] }, { "caseId": "9691341297556920", "title": "qqq", "priority": 5, "dateCreated": "2012-07-03T06:39:16Z", "articleId": "322058887863626_360570517345796", "commentId": "0", "caseStatus": 2, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Review interest rate, Contact us for more info", "articleVoiceName": "WJ Bank", "articleVoicePicture": "https://graph.facebook.com/322058887863626/picture", "articleDateTimePost": "2012-07-03T03:46:08Z", "articleVoiceId": "322058887863626", "assetId": "322058887863626", "assetPic": "http://graph.facebook.com/322058887863626/picture", "comment": [ ] }, { "caseId": "9691341291444028", "title": "Location", "priority": 3, "dateCreated": "2012-07-03T04:57:24Z", "articleId": "322058887863626_338046902931491", "commentId": "0", "caseStatus": 2, "assignTo": "Tan Weijian - SG", "createdBy": "Tan Weijian - SG", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Hi how can I apply for credit card from WJ bank?", "articleVoiceName": "Zhou Shuo", "articleVoicePicture": "https://graph.facebook.com/1647738938/picture", "articleDateTimePost": "2012-05-23T03:38:24Z", "articleVoiceId": "1647738938", "assetId": "322058887863626", "assetPic": "http://graph.facebook.com/322058887863626/picture", "comment": [ ] }, { "caseId": "9691340959298765", "title": "hello", "priority": 3, "dateCreated": "2012-06-29T08:41:38Z", "articleId": "28011986676_10151726136881677", "commentId": "28011986676_10151726136881677_22342829", "caseStatus": 0, "assignTo": "Tan Weijian - SG", "createdBy": "Tan Weijian - SG", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "I experience bad voice and data connection for the last 14 days around Macperson area and Eunos area....you are performing upgrading work?", "articleVoiceName": "Denis Beh", "articleVoicePicture": "https://graph.facebook.com/824347312/picture", "articleDateTimePost": "2012-07-01T06:17:45Z", "articleVoiceId": "824347312", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ { "content": "Hi Denis, please provide us your details via the form below so that we can investigate on the network performance in both areas. Thanks - Caroline\\n\\nhttp://on.fb.me/ContactSingTel", "voiceId": "28011986676", "voiceName": "SingTel", "datetimePost": "2012-07-01T07:48:08Z", "voicePicture": "https://graph.facebook.com/28011986676/picture" } ] } ] }'''

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
  "data": {
    "caseId":"9691340720753581"
  }
}'''
    }

    def addNotes(){
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

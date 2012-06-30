package one_social_ui

import javax.servlet.AsyncContext
import grails.converters.JSON

class SocialEngageController {


    def index() {redirect(action: 'posts')}


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

        render '''{
  "offset": 0,
  "total": 10,
  "data":
  [
    {
      "content": "??ÊŠì€î€YOUTUBEÊ×Óðü£?ìÑ??£¿öáUPLOAD?£¡£¡Ê§Ê§£¡£¡???£¡:)",
      "voiceName": "Diane Timothea Ng",
      "datetimePosted": "2012-06-28T09:33:38Z",
      "fbId": "98685085344_10150940547215345",
      "voicePic": "https://graph.facebook.com/100001293120297/picture",
      "commentCount": 0,
      "likeCount": 0,
      "voiceId": "100001293120297",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Behind-the-scenes shots of the artistes going 'all out' for the battle and having fun! ^_^",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:22:15Z",
      "fbId": "98685085344_10150940394490345",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 18,
      "likeCount": 1098,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "Jurong East Swimming Complex",
          "voiceName": "Ming Wang",
          "datetimePosted": "2012-06-28T09:25:15Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "1671482364",
          "voicePic": "https://graph.facebook.com/1671482364/picture",
          "fbId": "98685085344_10150940394490345_23215075"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "Wads the title?",
          "voiceName": "Sharon Gwee",
          "datetimePosted": "2012-06-28T09:23:53Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "100000076498318",
          "voicePic": "https://graph.facebook.com/100000076498318/picture",
          "fbId": "98685085344_252834011497416_920476"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "They filmed somewhere at Raffles Place right?",
          "voiceName": "Sharon Gwee",
          "datetimePosted": "2012-06-28T09:23:36Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "100000076498318",
          "voicePic": "https://graph.facebook.com/100000076498318/picture",
          "fbId": "98685085344_252834011497416_920475"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Behind-the-scenes shots of the artistes going 'all out' for the battle and having fun! ^_^",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:22:15Z",
      "fbId": "98685085344_10150940394490345",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 18,
      "likeCount": 1098,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "XIAO DAI!! <3<3",
          "voiceName": "Michelle Yelloww Leong",
          "datetimePosted": "2012-06-28T09:20:57Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "522180897",
          "voicePic": "https://graph.facebook.com/522180897/picture",
          "fbId": "98685085344_10150940394490345_23215053"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "Beyond!",
          "voiceName": "Angelz CoolYin",
          "datetimePosted": "2012-06-28T09:12:17Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "100000488094577",
          "voicePic": "https://graph.facebook.com/100000488094577/picture",
          "fbId": "98685085344_252834011497416_920450"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Is there a new children show coming up on 1st July?",
      "voiceName": "Samme Hong Chan",
      "datetimePosted": "2012-06-27T15:28:52Z",
      "fbId": "98685085344_10150938598530345",
      "voicePic": "https://graph.facebook.com/100001064408289/picture",
      "commentCount": 2,
      "likeCount": 0,
      "voiceId": "100001064408289",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "What show?",
          "voiceName": "Foo XiaoTong",
          "datetimePosted": "2012-06-28T09:09:58Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "100000542382136",
          "voicePic": "https://graph.facebook.com/100000542382136/picture",
          "fbId": "98685085344_10150938598530345_23214983"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "?ýÀû¿ø÷ÕÕ?£¡~XD",
          "voiceName": "Jason Lee",
          "datetimePosted": "2012-06-28T09:06:32Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "100000593746444",
          "voicePic": "https://graph.facebook.com/100000593746444/picture",
          "fbId": "98685085344_252834011497416_920430"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "X êªáÈ!!! :)",
          "voiceName": "Joanna Kwang",
          "datetimePosted": "2012-06-28T09:05:58Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "824609473",
          "voicePic": "https://graph.facebook.com/824609473/picture",
          "fbId": "98685085344_252834011497416_920426"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Behind-the-scenes shots of the artistes going 'all out' for the battle and having fun! ^_^",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:22:15Z",
      "fbId": "98685085344_10150940394490345",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 18,
      "likeCount": 1098,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "When is Tiz Episode gng 2 Aired??",
          "voiceName": "Kll Ling",
          "datetimePosted": "2012-06-28T09:05:14Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "100001089684329",
          "voicePic": "https://graph.facebook.com/100001089684329/picture",
          "fbId": "98685085344_10150940394490345_23214967"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "Jeanette looks cool in her new style . :D",
          "voiceName": "Shimin Katherine",
          "datetimePosted": "2012-06-28T08:54:29Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "100001402174059",
          "voicePic": "https://graph.facebook.com/100001402174059/picture",
          "fbId": "98685085344_252834011497416_920395"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "so beautiful :P",
          "voiceName": "Alfred Hoo",
          "datetimePosted": "2012-06-28T08:52:48Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "679349222",
          "voicePic": "https://graph.facebook.com/679349222/picture",
          "fbId": "98685085344_252834011497416_920393"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "?ÒöêªáÈ",
          "voiceName": "Tay Hwee Mei",
          "datetimePosted": "2012-06-28T08:46:05Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "1455368026",
          "voicePic": "https://graph.facebook.com/1455368026/picture",
          "fbId": "98685085344_252834011497416_920386"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "Ms Introvert?",
          "voiceName": "Dave Chen",
          "datetimePosted": "2012-06-28T08:39:36Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "1245241502",
          "voicePic": "https://graph.facebook.com/1245241502/picture",
          "fbId": "98685085344_252834011497416_920372"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "Saw them filming this show",
          "voiceName": "Shao Ming YourBuddy",
          "datetimePosted": "2012-06-28T08:39:27Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "100000219819341",
          "voicePic": "https://graph.facebook.com/100000219819341/picture",
          "fbId": "98685085344_252834011497416_920371"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "She's so pretty",
          "voiceName": "Sihui Ahhai",
          "datetimePosted": "2012-06-28T08:37:52Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "1546635179",
          "voicePic": "https://graph.facebook.com/1546635179/picture",
          "fbId": "98685085344_252834011497416_920363"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "Ah Lian and Aminah sequel to Abang and Ah Beng",
          "voiceName": "Hamid Ahmad",
          "datetimePosted": "2012-06-28T08:37:05Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "1250892263",
          "voicePic": "https://graph.facebook.com/1250892263/picture",
          "fbId": "98685085344_252834011497416_920362"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "ãÀîÜ! #joysoflife îÜñ«?ÍØ<òÒà­> ãÀëŠ?Õôûý?æÑóÝîÜ! ýñØÐî¢??îð?!",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-27T13:01:25Z",
      "fbId": "98685085344_10150938306215345",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 2,
      "likeCount": 79,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "u acting as a student",
          "voiceName": "Yeoh Teng Khean",
          "datetimePosted": "2012-06-28T08:34:54Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "1035922695",
          "voicePic": "https://graph.facebook.com/1035922695/picture",
          "fbId": "98685085344_10150938306215345_23214802"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Behind-the-scenes shots of the artistes going 'all out' for the battle and having fun! ^_^",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:22:15Z",
      "fbId": "98685085344_10150940394490345",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 18,
      "likeCount": 1098,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "Óã?ôž! <3",
          "voiceName": "Øº??",
          "datetimePosted": "2012-06-28T08:32:16Z",
          "likeCount": 1,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "100003629082496",
          "voicePic": "https://graph.facebook.com/100003629082496/picture",
          "fbId": "98685085344_10150940394490345_23214788"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    },
    {
      "content": "Jeanette Aw in character for our year-end blockbuster <3 Can anyone guess what show is it? ;)\\n good morning!! :)",
      "voiceName": "Channel 8",
      "datetimePosted": "2012-06-28T07:07:24Z",
      "fbId": "98685085344_252834011497416",
      "voicePic": "https://graph.facebook.com/98685085344/picture",
      "commentCount": 44,
      "likeCount": 946,
      "voiceId": "98685085344",
      "caseCreated": false,
      "readStatus": "unread",
      "comment":
      [
        {
          "content": "Cute",
          "voiceName": "Yeong Wen Qi",
          "datetimePosted": "2012-06-28T08:17:35Z",
          "likeCount": 0,
          "relatedCase":
          [
            "9691337237017561"
          ],
          "voiceId": "100000182118812",
          "voicePic": "https://graph.facebook.com/100000182118812/picture",
          "fbId": "98685085344_252834011497416_920300"
        }
      ],
      "assetsPic": "https://graph.facebook.com/98685085344/picture",
      "assetsId": "98685085344"
    }
  ]
}'''

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

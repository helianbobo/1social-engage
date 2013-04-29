package one_social_ui

import javax.servlet.AsyncContext
import grails.converters.JSON

class SocialEngageController {


    def index() {redirect(action: 'overview')}

    def getCase(params, body) {
        // the case model
        def obj = [
                caseId: "969134095929876${Math.round(Math.random()*1000)}",
                title: 'case 2',
                priority: 2,
                assignTo: 79,
                caseStatus: 1,
                assetPic: "http://graph.facebook.com/28011986676/picture",
                assetURL: "http://www.facebook.com/28011986676",
                articleId: "28011986676_10151726285826677",
                commentId: "0",
                type: "facebook",
                content: "Cant believe you all wrote/said to ST and said that 2G was available when the network outage occurred this morning. Its was a complete loss of both network mind you! the fact that ST tried to downplay the whole affair reflects on how much ST cant face up to the issue while playing taichi and asking the consumers to keep switching on and off their phone or worse trying to call into the nonexistent helplines and telling us to head to exeter to make a sim change. All this while the issue is on your end of the stick! Yes i am pissed. pissed with how you guys insult the users and trying to twist facts! ",
                notes: "just another note",
                voicePic: "https://graph.facebook.com/665336665/picture",
                voiceName: "Perry Teo",
                voiceId: "9691341482695378.1341482695531",
                voiceURL: "http://www.facebook.com/665336665"
        ]

        if (params) obj.each { k, v -> if (params.containsKey(k)) obj[k] = params[k] }
        if (body) obj.each { k, v -> if (body.containsKey(k)) obj[k] = body[k] }
        return obj
    }

    def getAllFacebookPost() {
      //if (1+1 == 2) return render('''{"data":[],"total": 0}''')
      def str = params.scrollTo ? ', "page": 2' : ', "page":null'

      render """{
        "total": 31
        ${str}
  , "data": 
  [
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "assignName": "Cass Goh - Brandtology R&D",
      "assignNotes": "Take Note of this Carefully",
      "assignTo": "590",
      "url": "http://www.facebook.com/permalink.php?story_fbid=407608369308677&id=322058887863626",
      "content": "\\"Test\\" on Wei Jian\'s post on WJ Bank\'s wall.",
      "datetimePost": "2012-11-09T10:17:38Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "userURL": "http://www.facebook.com/322058887863626",
      "lCount": 0,
      "cCount": 0,
      "sCount": 0,
      "nCount": 1,
      "isArticle": 1,
      "fbid": "322058887863626_407608369308677",
      "readStatus": "unread",
      "caseCreated": "true",
      "caseId": "9691341302369330"
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "lCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "fbid": "322058887863626_412497998819714_3559603",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "fbid": "322058887863626_412497998819714",
        "lCount": 100,
        "sCount": 99,
        "cCount": 98
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "lCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "fbid": "322058887863626_412497998819714_1",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626"
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "lCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "fbid": "322058887863626_412497998819714_2",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "fbid": "322058887863626_412497998819714"
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "lCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "fbid": "322058887863626_412497998819714_3",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "fbid": "322058887863626_412497998819714"
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "lCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "fbid": "322058887863626_412497998819714_4",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "fbid": "322058887863626_412497998819714"
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "lCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "fbid": "322058887863626_412497998819714_5",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "fbid": "322058887863626_412497998819714"
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "lCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "fbid": "322058887863626_412497998819714_6",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "fbid": "322058887863626_412497998819714"
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "lCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "fbid": "322058887863626_412497998819714_355960309",
      "readStatus": "read",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "fbid": "322058887863626_412497998819714"
      }
    }
  ]
}"""
    }

    def getAllTwitterPost() {
      //if (1+1 == 2) return render('''{"data":[],"total":0}''')
      def str = params.scrollTo ? ', "page": 2' : ', "page":null'

      render """{
        "total": 31
        ${str}
  , "data": 
  [
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "assignName": "Cass Goh - Brandtology R&D",
      "assignNotes": "Take Note of this Carefully",
      "assignTo": "590",
      "url": "http://www.facebook.com/permalink.php?story_fbid=407608369308677&id=322058887863626",
      "content": "\\"Test\\" on Wei Jian\'s post on WJ Bank\'s wall.",
      "datetimePost": "2012-11-09T10:17:38Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "userURL": "http://www.facebook.com/322058887863626",
      "rCount": 100,
      "cCount": 27,
      "sCount": 0,
      "nCount": 1,
      "isArticle": 1,
      "postId": "322058887863626_407608369308677",
      "readStatus": "unread",
      "caseCreated": "true",
      "caseId": "9691341302369330"
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "rCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "postId": "322058887863626_412497998819714_3559603",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "postId": "322058887863626_412497998819714",
        "rCount": 100,
        "sCount": 99,
        "cCount": 98
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "rCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "postId": "322058887863626_412497998819714_1",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626"
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "rCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "postId": "322058887863626_412497998819714_2",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "postId": "322058887863626_412497998819714"
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "rCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "postId": "322058887863626_412497998819714_3",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "postId": "322058887863626_412497998819714"
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "rCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "postId": "322058887863626_412497998819714_4",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "postId": "322058887863626_412497998819714"
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "rCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "postId": "322058887863626_412497998819714_5",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "postId": "322058887863626_412497998819714"
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "rCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "postId": "322058887863626_412497998819714_6",
      "readStatus": "unread",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "postId": "322058887863626_412497998819714"
      }
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "y senorita goh, por favor deja de gritar. podemos oír perfectamente bien. gracias.",
      "datetimePost": "2012-11-26T18:43:09Z",
      "userId": "322058887863626",
      "username": "WJ Bank",
      "userPic": "https://graph.facebook.com/322058887863626/picture",
      "rCount": 0,
      "userURL": "http://www.facebook.com/322058887863626",
      "isArticle": 0,
      "postId": "322058887863626_412497998819714_355960309",
      "readStatus": "read",
      "caseCreated": "false",
      "url": "http://www.facebook.com/permalink.php?story_fbid=412497998819714&id=322058887863626",
      "article": {
        "content": "WHEN ARE YOU OPENING A BRANCH IN ESPANA? ",
        "userId": "517557078",
        "username": "Cassandra Goh",
        "userPic": "https://graph.facebook.com/517557078/picture",
        "userURL": "http://www.facebook.com/517557078",
        "postId": "322058887863626_412497998819714"
      }
    }
  ]
}"""
    }

    def getAllFacebookDM() {
      // if (1+1 == 2) return render('''{"data":[],"total": 0}''')
      render '''{
  "data": 
  [
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "好 Yup, its time to find out what happen in this morning you can say everything you want",
      "datetimePost": "2012-12-04T06:05:11Z",
      "userId": "689247620",
      "username": "Liu Qiang",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "322058887863626",
      "fromName": "WJ Bank",
      "fromURL": "http://graph.facebook.com/322058887863626",
      "fromPic": "http://graph.facebook.com/322058887863626/picture",
      "toId": "689247620",
      "toName": "Wei Jian",
      "toURL": "http://graph.facebook.com/689247620",
      "toPic": "http://graph.facebook.com/689247620/picture",
      "readStatus": "unread",
      "caseCreated": "false",
      "cCount": 10
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "hello",
      "datetimePost": "2012-12-04T03:08:36Z",
      "userId": "689247620",
      "username": "Wei Jian2",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "689247620",
      "fromName": "Wei Jian",
      "fromURL": "http://graph.facebook.com/689247620",
      "fromPic": "http://graph.facebook.com/689247620/picture",
      "toId": "322058887863626",
      "toName": "WJ Bank",
      "toURL": "http://graph.facebook.com/322058887863626",
      "toPic": "http://graph.facebook.com/322058887863626/picture",
      "readStatus": "read",
      "caseCreated": "false"
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "test",
      "datetimePost": "2012-12-04T02:52:52Z",
      "userId": "689247620",
      "username": "Wei Jian3",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "689247620-1",
      "fromName": "Wei Jian",
      "fromURL": "http://graph.facebook.com/689247620",
      "fromPic": "http://graph.facebook.com/689247620/picture",
      "toId": "322058887863626",
      "toName": "WJ Bank",
      "toURL": "http://graph.facebook.com/322058887863626",
      "toPic": "http://graph.facebook.com/322058887863626/picture",
      "readStatus": "unread",
      "caseCreated": "false"
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": ":P",
      "datetimePost": "2012-12-03T09:44:45Z",
      "userId": "689247620",
      "username": "Wei Jian",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "689247620-2",
      "fromName": "Wei Jian",
      "fromURL": "http://graph.facebook.com/689247620",
      "fromPic": "http://graph.facebook.com/689247620/picture",
      "toId": "322058887863626",
      "toName": "WJ Bank",
      "toURL": "http://graph.facebook.com/322058887863626",
      "toPic": "http://graph.facebook.com/322058887863626/picture",
      "readStatus": "unread",
      "caseCreated": "false",
      "nCount": 1
    }
  ]
}'''
    }

    def getAllTwitterDM() {
      render '''{
  "data": 
  [
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "好 Yup, its time to find out what happen in this morning you can say everything you want",
      "datetimePost": "2012-12-04T06:05:11Z",
      "userId": "689247620",
      "username": "Liu Qiang",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "322058887863626",
      "fromName": "WJ Bank",
      "fromURL": "http://graph.facebook.com/322058887863626",
      "fromPic": "http://graph.facebook.com/322058887863626/picture",
      "toId": "689247620",
      "toName": "Wei Jian",
      "toURL": "http://graph.facebook.com/689247620",
      "toPic": "http://graph.facebook.com/689247620/picture",
      "readStatus": "unread",
      "caseCreated": "false",
      "cCount": 10
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "hello",
      "datetimePost": "2012-12-04T03:08:36Z",
      "userId": "689247620",
      "username": "Wei Jian2",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "689247620",
      "fromName": "Wei Jian",
      "fromURL": "http://graph.facebook.com/689247620",
      "fromPic": "http://graph.facebook.com/689247620/picture",
      "toId": "322058887863626",
      "toName": "WJ Bank",
      "toURL": "http://graph.facebook.com/322058887863626",
      "toPic": "http://graph.facebook.com/322058887863626/picture",
      "readStatus": "read",
      "caseCreated": "false"
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "test",
      "datetimePost": "2012-12-04T02:52:52Z",
      "userId": "689247620",
      "username": "Wei Jian3",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "689247620-1",
      "fromName": "Wei Jian",
      "fromURL": "http://graph.facebook.com/689247620",
      "fromPic": "http://graph.facebook.com/689247620/picture",
      "toId": "322058887863626",
      "toName": "WJ Bank",
      "toURL": "http://graph.facebook.com/322058887863626",
      "toPic": "http://graph.facebook.com/322058887863626/picture",
      "readStatus": "unread",
      "caseCreated": "false"
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": ":P",
      "datetimePost": "2012-12-03T09:44:45Z",
      "userId": "689247620",
      "username": "Wei Jian",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "689247620-2",
      "fromName": "Wei Jian",
      "fromURL": "http://graph.facebook.com/689247620",
      "fromPic": "http://graph.facebook.com/689247620/picture",
      "toId": "322058887863626",
      "toName": "WJ Bank",
      "toURL": "http://graph.facebook.com/322058887863626",
      "toPic": "http://graph.facebook.com/322058887863626/picture",
      "readStatus": "unread",
      "caseCreated": "false",
      "nCount": 1
    }
  ]
}'''
    }

    def getAllFacebookVoices() {
      render '''{
  "data": 
  [
    {
      "userId": "322058887863626",
      "profileURL": "http://www.facebook.com/322058887863626",
      "userPic": "http://graph.facebook.com/322058887863626/picture",
      "username": "WJ Bank",
      "commentCount": 19,
      "postCount": 8,
      "caseCount": 6,
      "dmCount": 3
    },
    {
      "userId": "506417801",
      "profileURL": "http://www.facebook.com/506417801",
      "userPic": "http://graph.facebook.com/506417801/picture",
      "username": "Callum Feasby",
      "commentCount": 0,
      "postCount": 1,
      "dmCount": 0
    },
    {
      "userId": "517557078",
      "profileURL": "http://www.facebook.com/517557078",
      "userPic": "http://graph.facebook.com/517557078/picture",
      "username": "Cassandra Goh",
      "commentCount": 1,
      "postCount": 2,
      "dmCount": 0
    },
    {
      "userId": "526890270",
      "profileURL": "http://www.facebook.com/526890270",
      "userPic": "http://graph.facebook.com/526890270/picture",
      "username": "Yuan Shan Lee",
      "commentCount": 0,
      "postCount": 1,
      "dmCount": 0
    },
    {
      "userId": "672895093",
      "profileURL": "http://www.facebook.com/672895093",
      "userPic": "http://graph.facebook.com/672895093/picture",
      "username": "Jonathan See",
      "commentCount": 1,
      "postCount": 1,
      "dmCount": 0
    },
    {
      "userId": "639105596",
      "profileURL": "http://www.facebook.com/639105596",
      "userPic": "http://graph.facebook.com/639105596/picture",
      "username": "Chern Chieh",
      "commentCount": 0,
      "postCount": 1,
      "dmCount": 0
    },
    {
      "userId": "501293712",
      "profileURL": "http://www.facebook.com/501293712",
      "userPic": "http://graph.facebook.com/501293712/picture",
      "username": "Danial Smurthwaite",
      "commentCount": 1,
      "postCount": 1,
      "dmCount": 0
    },
    {
      "userId": "705262535",
      "profileURL": "http://www.facebook.com/705262535",
      "userPic": "http://graph.facebook.com/705262535/picture",
      "username": "Jon Ngin",
      "commentCount": 1,
      "postCount": 0,
      "dmCount": 0
    },
    {
      "userId": "604892779",
      "profileURL": "http://www.facebook.com/604892779",
      "userPic": "http://graph.facebook.com/604892779/picture",
      "username": "Hani Bani",
      "commentCount": 1,
      "postCount": 0,
      "dmCount": 0
    },
    {
      "userId": "609490972",
      "profileURL": "http://www.facebook.com/609490972",
      "userPic": "http://graph.facebook.com/609490972/picture",
      "username": "Jonathan James",
      "commentCount": 1,
      "postCount": 0,
      "dmCount": 0
    },
    {
      "userId": "689247620",
      "profileURL": "http://www.facebook.com/689247620",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "username": "Wei Jian",
      "commentCount": 0,
      "postCount": 0,
      "dmCount": 10
    }
  ],
  "total": 36
}'''
    }

    def getAllTwitterVoices() {
      render '''{
  "data": 
  [
    {
      "userId": "322058887863626",
      "profileURL": "http://www.facebook.com/322058887863626",
      "userPic": "http://graph.facebook.com/322058887863626/picture",
      "username": "WJ Bank",
      "commentCount": 19,
      "postCount": 8,
      "caseCount": 6,
      "dmCount": 3
    },
    {
      "userId": "506417801",
      "profileURL": "http://www.facebook.com/506417801",
      "userPic": "http://graph.facebook.com/506417801/picture",
      "username": "Callum Feasby",
      "commentCount": 0,
      "postCount": 1,
      "dmCount": 0
    },
    {
      "userId": "517557078",
      "profileURL": "http://www.facebook.com/517557078",
      "userPic": "http://graph.facebook.com/517557078/picture",
      "username": "Cassandra Goh",
      "commentCount": 1,
      "postCount": 2,
      "dmCount": 0
    },
    {
      "userId": "526890270",
      "profileURL": "http://www.facebook.com/526890270",
      "userPic": "http://graph.facebook.com/526890270/picture",
      "username": "Yuan Shan Lee",
      "commentCount": 0,
      "postCount": 1,
      "dmCount": 0
    },
    {
      "userId": "672895093",
      "profileURL": "http://www.facebook.com/672895093",
      "userPic": "http://graph.facebook.com/672895093/picture",
      "username": "Jonathan See",
      "commentCount": 1,
      "postCount": 1,
      "dmCount": 0
    },
    {
      "userId": "639105596",
      "profileURL": "http://www.facebook.com/639105596",
      "userPic": "http://graph.facebook.com/639105596/picture",
      "username": "Chern Chieh",
      "commentCount": 0,
      "postCount": 1,
      "dmCount": 0
    },
    {
      "userId": "501293712",
      "profileURL": "http://www.facebook.com/501293712",
      "userPic": "http://graph.facebook.com/501293712/picture",
      "username": "Danial Smurthwaite",
      "commentCount": 1,
      "postCount": 1,
      "dmCount": 0
    },
    {
      "userId": "705262535",
      "profileURL": "http://www.facebook.com/705262535",
      "userPic": "http://graph.facebook.com/705262535/picture",
      "username": "Jon Ngin",
      "commentCount": 1,
      "postCount": 0,
      "dmCount": 0
    },
    {
      "userId": "604892779",
      "profileURL": "http://www.facebook.com/604892779",
      "userPic": "http://graph.facebook.com/604892779/picture",
      "username": "Hani Bani",
      "commentCount": 1,
      "postCount": 0,
      "dmCount": 0
    },
    {
      "userId": "609490972",
      "profileURL": "http://www.facebook.com/609490972",
      "userPic": "http://graph.facebook.com/609490972/picture",
      "username": "Jonathan James",
      "commentCount": 1,
      "postCount": 0,
      "dmCount": 0
    },
    {
      "userId": "689247620",
      "profileURL": "http://www.facebook.com/689247620",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "username": "Wei Jian",
      "commentCount": 0,
      "postCount": 0,
      "dmCount": 10
    }
  ],
  "total": 36
}'''
    }

    def getAllFacebookCase() {
      //if (1+1==2) return render('''{"data":[], "total":0,"page":null}''')
      if (params.streamType == "stream") {
        render '''{
          "data":[
          {"assignNotes":null,"assignTo":"478","assetsURL":"http://www.facebook.com/322058887863626","userPic":"https://graph.facebook.com/322058887863626/picture","assetsId":"322058887863626","caseStatus":1,"url":"http://www.facebook.com/permalink.php?story_fbid=476953039040876&id=322058887863626","content":"好","username":"WJ Bank","nCount":1,"article":{"assetsURL":"http://www.facebook.com/322058887863626","userPic":"https://graph.facebook.com/689247620/picture","assetsId":"322058887863626","content":"why like that?","username":"Wei Jian","lCount":0,"sCount":0,"userId":"689247620","fbid":"322058887863626_476953039040876","assetsPic":"http://graph.facebook.com/322058887863626/picture","userURL":"http://www.facebook.com/689247620","cCount":7,"datetimePost":"2013-03-27T07:15:14Z"},"sCount":0,"lCount":0,"caseId":"9691366622732312","userId":"322058887863626","assignName":"Joshua Troy - R&D","redisId":"FacebookPost|322058887863626_476953039040876_3984613","fbid":"322058887863626_476953039040876_3984613","assetsPic":"http://graph.facebook.com/322058887863626/picture","userURL":"http://www.facebook.com/322058887863626","cCount":0,"datetimePost":"2013-03-27T08:11:25Z"}
        , {"assignNotes":null,"assignTo":"478","assetsURL":"http://www.facebook.com/322058887863626","userPic":"https://graph.facebook.com/322058887863626/picture","assetsId":"322058887863626","caseStatus":1,"url":"http://www.facebook.com/permalink.php?story_fbid=476953039040876&id=322058887863626","content":"好","username":"WJ Bank","nCount":0,"article":{"assetsURL":"http://www.facebook.com/322058887863626","userPic":"https://graph.facebook.com/689247620/picture","assetsId":"322058887863626","content":"why like that?","username":"Wei Jian","lCount":0,"sCount":0,"userId":"689247620","fbid":"322058887863626_476953039040876vv","assetsPic":"http://graph.facebook.com/322058887863626/picture","userURL":"http://www.facebook.com/689247620","cCount":7,"datetimePost":"2013-03-27T07:15:14Z"},"sCount":0,"lCount":0,"caseId":"9691366622732312-333","userId":"322058887863626","assignName":"Joshua Troy - R&D","redisId":"FacebookPost|322058887863626_476953039040876_3984613","fbid":"322058887863626_476953039040876_3984613","assetsPic":"http://graph.facebook.com/322058887863626/picture","userURL":"http://www.facebook.com/322058887863626","cCount":0,"datetimePost":"2013-03-27T08:11:25Z"}
        , {"assignNotes":null,"assignTo":"478","assetsURL":"http://www.facebook.com/322058887863626","userPic":"https://graph.facebook.com/322058887863626/picture","assetsId":"322058887863626","caseStatus":1,"url":"http://www.facebook.com/permalink.php?story_fbid=476953039040876&id=322058887863626","content":"好","username":"WJ Bank","nCount":0,"article":{"assetsURL":"http://www.facebook.com/322058887863626","userPic":"https://graph.facebook.com/689247620/picture","assetsId":"322058887863626","content":"why like that?","username":"Wei Jian","lCount":0,"sCount":0,"userId":"689247620","fbid":"322058887863626_476953039040876vv","assetsPic":"http://graph.facebook.com/322058887863626/picture","userURL":"http://www.facebook.com/689247620","cCount":7,"datetimePost":"2013-03-27T07:15:14Z"},"sCount":0,"lCount":0,"caseId":"9691366622732312-344","userId":"322058887863626","assignName":"Joshua Troy - R&D","redisId":"FacebookPost|322058887863626_476953039040876_3984613","fbid":"322058887863626_476953039040876_3984613","assetsPic":"http://graph.facebook.com/322058887863626/picture","userURL":"http://www.facebook.com/322058887863626","cCount":0,"datetimePost":"2013-03-27T08:11:25Z"}
          ],
          "total": "1",
          "page": null,
          "selectAllIds": ["null"]
        }'''
      } else if (params.streamType == "message") {
        render '''{
  "data": 
  [
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "好 Yup, its time to find out what happen in this morning you can say everything you want",
      "datetimePost": "2012-12-04T06:05:11Z",
      "userId": "689247620",
      "username": "Liu Qiang",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "322058887863626",
      "fromName": "WJ Bank",
      "fromURL": "http://graph.facebook.com/322058887863626",
      "fromPic": "http://graph.facebook.com/322058887863626/picture",
      "toId": "689247620",
      "toName": "Wei Jian",
      "toURL": "http://graph.facebook.com/689247620",
      "toPic": "http://graph.facebook.com/689247620/picture",
      "caseStatus": "1",
      "caseCreated": "false",
      "cCount": 10
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "hello",
      "datetimePost": "2012-12-04T03:08:36Z",
      "userId": "689247620",
      "username": "Wei Jian2",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "689247620",
      "fromName": "Wei Jian",
      "fromURL": "http://graph.facebook.com/689247620",
      "fromPic": "http://graph.facebook.com/689247620/picture",
      "toId": "322058887863626",
      "toName": "WJ Bank",
      "toURL": "http://graph.facebook.com/322058887863626",
      "toPic": "http://graph.facebook.com/322058887863626/picture",
      "caseStatus": "0",
      "caseCreated": "false"
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": "test",
      "datetimePost": "2012-12-04T02:52:52Z",
      "userId": "689247620",
      "username": "Wei Jian3",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "689247620-1",
      "fromName": "Wei Jian",
      "fromURL": "http://graph.facebook.com/689247620",
      "fromPic": "http://graph.facebook.com/689247620/picture",
      "toId": "322058887863626",
      "toName": "WJ Bank",
      "toURL": "http://graph.facebook.com/322058887863626",
      "toPic": "http://graph.facebook.com/322058887863626/picture",
      "caseStatus": "1",
      "caseCreated": "false"
    },
    {
      "assetsId": "322058887863626",
      "assetsURL": "http://www.facebook.com/322058887863626",
      "assetsPic": "http://graph.facebook.com/322058887863626/picture",
      "content": ":P",
      "datetimePost": "2012-12-03T09:44:45Z",
      "userId": "689247620",
      "username": "Wei Jian",
      "userPic": "http://graph.facebook.com/689247620/picture",
      "responseId": "689247620-2",
      "fromName": "Wei Jian",
      "fromURL": "http://graph.facebook.com/689247620",
      "fromPic": "http://graph.facebook.com/689247620/picture",
      "toId": "322058887863626",
      "toName": "WJ Bank",
      "toURL": "http://graph.facebook.com/322058887863626",
      "toPic": "http://graph.facebook.com/322058887863626/picture",
      "caseStatus": "1",
      "caseCreated": "false",
      "nCount": 1
    }
  ]
}'''
      } else {
        render '''{
          "data":[
          {"assignTo":"Liu Chao - Test","notesUpdateDate":null,"caseStatus":1,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=476953039040876&id=322058887863626","datetimeUpdated":"2013-04-10T08:21:54Z","articleDateTimePost":"2013-03-27T07:15:14Z","type":"facebook","commentId":"322058887863626_476953039040876_3984613","articleId":"322058887863626_476953039040876","readStatus":"unread","title":"9691365582113850","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"why like that?","createdBy":"Alvin Chan - SG","caseId":"9691365582113850","dateCreated":"2013-04-10T08:21:53Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"好","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-27T08:11:25Z"}],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"Joshua Troy - R&D","notesUpdateDate":null,"caseStatus":1,"articleURL":null,"datetimeUpdated":"2013-03-25T01:53:28Z","articleDateTimePost":null,"type":"facebook","commentId":"0","articleId":null,"readStatus":"unread","title":"9691364176407805","assetId":"322058887863626","priority":3,"articleVoicePicture":null,"articleVoiceName":null,"notesUpdateBy":"","voiceId":"9691346316520721.1346316520767","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":null,"assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":null,"createdBy":"Tan Wei Jian - SG","caseId":"9691364176407805","dateCreated":"2013-03-25T01:53:27Z","comment":[],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/null"},{"assignTo":"Liu Qiang - SG","notesUpdateDate":null,"caseStatus":1,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=468167326586114&id=322058887863626","datetimeUpdated":"2013-03-21T08:38:14Z","articleDateTimePost":"2013-03-13T06:57:36Z","type":"facebook","commentId":"322058887863626_468167326586114_3944707","articleId":"322058887863626_468167326586114","readStatus":"unread","title":"9691363855093685","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"woohooo","createdBy":"Tan Wei Jian - SG","caseId":"9691363855093685","dateCreated":"2013-03-21T08:38:13Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"hello","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-15T02:46:42Z"}],"updateCount":0,"notes":"vbbbbb","articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"Liu Qiang - SG","notesUpdateDate":null,"caseStatus":1,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=468167326586114&id=322058887863626","datetimeUpdated":"2013-03-21T07:22:33Z","articleDateTimePost":"2013-03-13T06:57:36Z","type":"facebook","commentId":"322058887863626_468167326586114_3944602","articleId":"322058887863626_468167326586114","readStatus":"unread","title":"9691363850553616","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"woohooo","createdBy":"Tan Wei Jian - SG","caseId":"9691363850553616","dateCreated":"2013-03-21T07:22:33Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"good","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-15T02:09:07Z"}],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"Liu Qiang - SG","notesUpdateDate":null,"caseStatus":1,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=471763846226462&id=322058887863626","datetimeUpdated":"2013-03-21T01:50:07Z","articleDateTimePost":"2013-03-19T06:37:09Z","type":"facebook","commentId":"322058887863626_471763846226462_3961518","articleId":"322058887863626_471763846226462","readStatus":"unread","title":"9691363830607228","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"Enquiringly about the bank interest","createdBy":"Tan Wei Jian - SG","caseId":"9691363830607228","dateCreated":"2013-03-21T01:50:07Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"Can i get a response from you?","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-20T10:08:05Z"}],"updateCount":0,"notes":"notes test","articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"Tan Wei Jian - SG","notesUpdateDate":null,"caseStatus":2,"articleURL":null,"datetimeUpdated":"2013-03-20T10:07:48Z","articleDateTimePost":null,"type":"facebook","commentId":"0","articleId":null,"readStatus":"unread","title":"9691363774064936","assetId":"322058887863626","priority":3,"articleVoicePicture":null,"articleVoiceName":null,"notesUpdateBy":"","voiceId":"9691346316520721.1346316520767","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":null,"assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":null,"createdBy":"Tan Wei Jian - SG","caseId":"9691363774064936","dateCreated":"2013-03-20T10:07:44Z","comment":[],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/null"},{"assignTo":"Joshua Troy - R&D","notesUpdateDate":null,"caseStatus":2,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=471763846226462&id=322058887863626","datetimeUpdated":"2013-03-20T10:08:06Z","articleDateTimePost":"2013-03-19T06:37:09Z","type":"facebook","commentId":"322058887863626_471763846226462_3961423","articleId":"322058887863626_471763846226462","readStatus":"unread","title":"9691363772375290","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"Enquiringly about the bank interest","createdBy":"Tan Wei Jian - SG","caseId":"9691363772375290","dateCreated":"2013-03-20T09:39:35Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"Any updates?","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-20T09:37:18Z"}],"updateCount":0,"notes":"dddd","articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"Tan Wei Jian - SG","notesUpdateDate":null,"caseStatus":2,"articleURL":null,"datetimeUpdated":"2013-03-20T09:36:51Z","articleDateTimePost":null,"type":"facebook","commentId":"0","articleId":null,"readStatus":"unread","title":"9691363772206742","assetId":"322058887863626","priority":3,"articleVoicePicture":null,"articleVoiceName":null,"notesUpdateBy":"","voiceId":"9691346316520721.1346316520767","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":null,"assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":null,"createdBy":"Tan Wei Jian - SG","caseId":"9691363772206742","dateCreated":"2013-03-20T09:36:46Z","comment":[],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/null"},{"assignTo":"Tan Wei Jian - SG","notesUpdateDate":null,"caseStatus":1,"articleURL":null,"datetimeUpdated":"2013-03-20T07:30:06Z","articleDateTimePost":null,"type":"facebook","commentId":"0","articleId":null,"readStatus":"unread","title":"9691363764606359","assetId":"322058887863626","priority":3,"articleVoicePicture":null,"articleVoiceName":null,"notesUpdateBy":"","voiceId":"9691363748865322.1363748865557","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":null,"assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":null,"createdBy":"Tan Wei Jian - SG","caseId":"9691363764606359","dateCreated":"2013-03-20T07:30:06Z","comment":[],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/null"},{"assignTo":"Tan Wei Jian - SG","notesUpdateDate":null,"caseStatus":2,"articleURL":null,"datetimeUpdated":"2013-03-20T07:28:23Z","articleDateTimePost":null,"type":"facebook","commentId":"0","articleId":null,"readStatus":"unread","title":"9691363764501083","assetId":"322058887863626","priority":3,"articleVoicePicture":null,"articleVoiceName":null,"notesUpdateBy":"","voiceId":"9691363748865322.1363748865557","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":null,"assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":null,"createdBy":"Tan Wei Jian - SG","caseId":"9691363764501083","dateCreated":"2013-03-20T07:28:21Z","comment":[],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/null"},{"assignTo":"Randy Globot SG-3","notesUpdateDate":null,"caseStatus":2,"articleURL":null,"datetimeUpdated":"2013-03-20T07:27:50Z","articleDateTimePost":null,"type":"facebook","commentId":"0","articleId":null,"readStatus":"unread","title":"9691363748865322","assetId":"322058887863626","priority":3,"articleVoicePicture":null,"articleVoiceName":null,"notesUpdateBy":"","voiceId":"9691363748865322.1363748865557","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":null,"assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":null,"createdBy":"Lee Gowing","caseId":"9691363748865322","dateCreated":"2013-03-20T03:07:45Z","comment":[],"updateCount":0,"notes":"note","articleVoiceURL":"http://www.facebook.com/null"},{"assignTo":"Liu Qiang - SG","notesUpdateDate":null,"caseStatus":2,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=471763846226462&id=322058887863626","datetimeUpdated":"2013-03-20T09:37:29Z","articleDateTimePost":"2013-03-19T06:37:09Z","type":"facebook","commentId":"322058887863626_471763846226462_3957816","articleId":"322058887863626_471763846226462","readStatus":"unread","title":"9691363683055868","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"Enquiringly about the bank interest","createdBy":"Tan Wei Jian - SG","caseId":"9691363683055868","dateCreated":"2013-03-19T08:50:55Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"Which kind of interest are you talking about?","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-19T07:15:22Z"}],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"Tan Wei Jian - SG","notesUpdateDate":null,"caseStatus":2,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=471763846226462&id=322058887863626","datetimeUpdated":"2013-03-19T07:14:25Z","articleDateTimePost":"2013-03-19T06:37:09Z","type":"facebook","commentId":"0","articleId":"322058887863626_471763846226462","readStatus":"unread","title":"9691363677254419","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691346316520721.1346316520767","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"Enquiringly about the bank interest","createdBy":"Tan Wei Jian - SG","caseId":"9691363677254419","dateCreated":"2013-03-19T07:14:14Z","comment":[],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"Joshua Troy - R&D","notesUpdateDate":null,"caseStatus":2,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=468167326586114&id=322058887863626","datetimeUpdated":"2013-03-15T02:45:53Z","articleDateTimePost":"2013-03-13T06:57:36Z","type":"facebook","commentId":"322058887863626_468167326586114_3944605","articleId":"322058887863626_468167326586114","readStatus":"unread","title":"9691363315304027","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"woohooo","createdBy":"Tan Wei Jian - SG","caseId":"9691363315304027","dateCreated":"2013-03-15T02:41:44Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"ok","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-15T02:09:28Z"}],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"James Neal","notesUpdateDate":null,"caseStatus":2,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=468167326586114&id=322058887863626","datetimeUpdated":"2013-03-15T02:09:28Z","articleDateTimePost":"2013-03-13T06:57:36Z","type":"facebook","commentId":"322058887863626_468167326586114_3942133","articleId":"322058887863626_468167326586114","readStatus":"unread","title":"9691363313237956","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"woohooo","createdBy":"Tan Wei Jian - SG","caseId":"9691363313237956","dateCreated":"2013-03-15T02:07:18Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"whats up","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-14T10:41:10Z"}],"updateCount":0,"notes":"Take Care","articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"Tan Wei Jian - SG","notesUpdateDate":null,"caseStatus":2,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=468167326586114&id=322058887863626","datetimeUpdated":"2013-03-14T10:41:10Z","articleDateTimePost":"2013-03-13T06:57:36Z","type":"facebook","commentId":"322058887863626_468167326586114_3938526","articleId":"322058887863626_468167326586114","readStatus":"unread","title":"9691363257668153","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"woohooo","createdBy":"Tan Wei Jian - SG","caseId":"9691363257668153","dateCreated":"2013-03-14T10:41:08Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"yes?","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-13T07:38:43Z"}],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"James Neal","notesUpdateDate":null,"caseStatus":2,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=468167326586114&id=322058887863626","datetimeUpdated":"2013-03-13T07:37:57Z","articleDateTimePost":"2013-03-13T06:57:36Z","type":"facebook","commentId":"0","articleId":"322058887863626_468167326586114","readStatus":"unread","title":"9691363159946000","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/689247620/picture","articleVoiceName":"Wei Jian","notesUpdateBy":"","voiceId":"9691346316520721.1346316520767","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"689247620","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"woohooo","createdBy":"Tan Wei Jian - SG","caseId":"9691363159946000","dateCreated":"2013-03-13T07:32:26Z","comment":[],"updateCount":0,"notes":"Take Note of this Carefully","articleVoiceURL":"http://www.facebook.com/689247620"},{"assignTo":"Randy Globot SG-1","notesUpdateDate":null,"caseStatus":1,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=467623973307116&id=322058887863626","datetimeUpdated":"2013-03-13T07:08:11Z","articleDateTimePost":"2013-03-12T07:08:13Z","type":"facebook","commentId":"322058887863626_467623973307116_3938468","articleId":"322058887863626_467623973307116","readStatus":"unread","title":"9691363158490757","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/322058887863626/picture","articleVoiceName":"WJ Bank","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"322058887863626","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"good day","createdBy":"Tan Wei Jian - SG","caseId":"9691363158490757","dateCreated":"2013-03-13T07:08:10Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"good","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-13T06:30:16Z"}],"updateCount":0,"notes":"Take Note of this Carefully","articleVoiceURL":"http://www.facebook.com/322058887863626"},{"assignTo":"James Neal","notesUpdateDate":null,"caseStatus":2,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=467623973307116&id=322058887863626","datetimeUpdated":"2013-03-13T06:29:33Z","articleDateTimePost":"2013-03-12T07:08:13Z","type":"facebook","commentId":"322058887863626_467623973307116_3935768","articleId":"322058887863626_467623973307116","readStatus":"unread","title":"9691363138963667","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/322058887863626/picture","articleVoiceName":"WJ Bank","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"322058887863626","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"good day","createdBy":"Tan Wei Jian - SG","caseId":"9691363138963667","dateCreated":"2013-03-13T01:42:43Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"ok good","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-12T12:01:41Z"}],"updateCount":0,"notes":"kkkk","articleVoiceURL":"http://www.facebook.com/322058887863626"},{"assignTo":"Tan Wei Jian - SG","notesUpdateDate":null,"caseStatus":2,"articleURL":"http://www.facebook.com/permalink.php?story_fbid=467623973307116&id=322058887863626","datetimeUpdated":"2013-03-12T12:00:56Z","articleDateTimePost":"2013-03-12T07:08:13Z","type":"facebook","commentId":"322058887863626_467623973307116_3935728","articleId":"322058887863626_467623973307116","readStatus":"unread","title":"9691363089654714","assetId":"322058887863626","priority":3,"articleVoicePicture":"https://graph.facebook.com/322058887863626/picture","articleVoiceName":"WJ Bank","notesUpdateBy":"","voiceId":"9691344409339213.1344409339233","assetURL":"http://www.facebook.com/322058887863626","articleVoiceId":"322058887863626","assetPic":"http://graph.facebook.com/322058887863626/picture","articleContent":"good day","createdBy":"Tan Wei Jian - SG","caseId":"9691363089654714","dateCreated":"2013-03-12T12:00:54Z","comment":[{"voiceURL":"http://www.facebook.com/322058887863626","content":"rrrrr","voiceName":"WJ Bank","voiceId":"322058887863626","voicePicture":"https://graph.facebook.com/322058887863626/picture","datetimePost":"2013-03-12T11:46:50Z"}],"updateCount":0,"notes":null,"articleVoiceURL":"http://www.facebook.com/322058887863626"}
          ],
          "total": "23",
          "page": null,
          "selectAllIds": ["2013-04-10T08:21:53Z","2013-03-25T01:53:27Z","2013-03-21T08:38:13Z","2013-03-21T07:22:33Z","2013-03-21T01:50:07Z","2013-03-20T10:07:44Z","2013-03-20T09:39:35Z","2013-03-20T09:36:46Z","2013-03-20T07:30:06Z","2013-03-20T07:28:21Z","2013-03-20T03:07:45Z","2013-03-19T08:50:55Z","2013-03-19T07:14:14Z","2013-03-15T02:41:44Z","2013-03-15T02:07:18Z","2013-03-14T10:41:08Z","2013-03-13T07:32:26Z","2013-03-13T07:08:10Z","2013-03-13T01:42:43Z","2013-03-12T12:00:54Z","2013-03-12T11:46:02Z","2013-03-12T08:37:29Z","2013-03-11T03:50:22Z"]
        }'''
      }
    }
    def getAllTwitterCase() {
      render '''{
  "data": 
  [
    {
      "caseId": "4261353458587692",
      "title": "",
      "priority": 3,
      "dateCreated": "2012-11-21T00:43:07Z",
      "articleId": "28011986676_10151949726736677",
      "commentId": "0",
      "caseStatus": 0,
      "assignTo": "Buvaneswaran Gunasegran\\n",
      "createdBy": "Buvaneswaran Gunasegran\\n",
      "type": "facebook",
      "updateCount": 0,
      "readStatus": "read",
      "voiceId": "4261353458587692.1353458587771",
      "notes": null,
      "notesUpdateDate": null,
      "notesUpdateBy": "",
      "datetimeUpdated": "2012-11-21T00:52:33Z",
      "articleContent": "I have a complaint about 3G Reception around Dover road. I seem to get 3-5 bars on both my phone and friends yet the 3G is terrible when sending iMessages,surfing the internet etc. This started to happen a few months ago while it was good before. Please sort this out.",
      "articleVoiceName": "Patrick Combe",
      "articleVoicePicture": "https://graph.facebook.com/1015175280/picture",
      "articleDateTimePost": "2012-11-20T13:08:02Z",
      "articleVoiceId": "1015175280",
      "assetId": "28011986676",
      "assetPic": "http://graph.facebook.com/28011986676/picture",
      "assetURL": "http://www.facebook.com/28011986676",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151949726736677&id=28011986676",
      "articleVoiceURL": "http://www.facebook.com/1015175280",
      "comment": 
      [
      ]
    },
    {
      "caseId": "4261353458587693",
      "title": "",
      "priority": 3,
      "dateCreated": "2012-11-21T00:43:07Z",
      "articleId": "28011986676_10151949726736677",
      "commentId": "0",
      "caseStatus": 0,
      "assignTo": "Buvaneswaran Gunasegran\\n",
      "createdBy": "Buvaneswaran Gunasegran\\n",
      "type": "facebook",
      "updateCount": 0,
      "readStatus": "read",
      "voiceId": "4261353458587692.1353458587771",
      "notes": null,
      "notesUpdateDate": null,
      "notesUpdateBy": "",
      "datetimeUpdated": "2012-11-21T00:52:33Z",
      "articleContent": "I have a complaint about 3G Reception around Dover road. I seem to get 3-5 bars on both my phone and friends yet the 3G is terrible when sending iMessages,surfing the internet etc. This started to happen a few months ago while it was good before. Please sort this out.",
      "articleVoiceName": "Patrick Combe",
      "articleVoicePicture": "https://graph.facebook.com/1015175280/picture",
      "articleDateTimePost": "2012-11-20T13:08:02Z",
      "articleVoiceId": "1015175280",
      "assetId": "28011986676",
      "assetPic": "http://graph.facebook.com/28011986676/picture",
      "assetURL": "http://www.facebook.com/28011986676",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151949726736677&id=28011986676",
      "articleVoiceURL": "http://www.facebook.com/1015175280",
      "comment": 
      [
      ]
    },
    {
      "caseId": "4261353458587694",
      "title": "",
      "priority": 3,
      "dateCreated": "2012-11-21T00:43:07Z",
      "articleId": "28011986676_10151949726736677",
      "commentId": "0",
      "caseStatus": 0,
      "assignTo": "Buvaneswaran Gunasegran\\n",
      "createdBy": "Buvaneswaran Gunasegran\\n",
      "type": "facebook",
      "updateCount": 0,
      "readStatus": "read",
      "voiceId": "4261353458587692.1353458587771",
      "notes": null,
      "notesUpdateDate": null,
      "notesUpdateBy": "",
      "datetimeUpdated": "2012-11-21T00:52:33Z",
      "articleContent": "I have a complaint about 3G Reception around Dover road. I seem to get 3-5 bars on both my phone and friends yet the 3G is terrible when sending iMessages,surfing the internet etc. This started to happen a few months ago while it was good before. Please sort this out.",
      "articleVoiceName": "Patrick Combe",
      "articleVoicePicture": "https://graph.facebook.com/1015175280/picture",
      "articleDateTimePost": "2012-11-20T13:08:02Z",
      "articleVoiceId": "1015175280",
      "assetId": "28011986676",
      "assetPic": "http://graph.facebook.com/28011986676/picture",
      "assetURL": "http://www.facebook.com/28011986676",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151949726736677&id=28011986676",
      "articleVoiceURL": "http://www.facebook.com/1015175280",
      "comment": 
      [
      ]
    },
    {
      "caseId": "4261353458587695",
      "title": "",
      "priority": 3,
      "dateCreated": "2012-11-21T00:43:07Z",
      "articleId": "28011986676_10151949726736677",
      "commentId": "0",
      "caseStatus": 0,
      "assignTo": "Buvaneswaran Gunasegran\\n",
      "createdBy": "Buvaneswaran Gunasegran\\n",
      "type": "facebook",
      "updateCount": 0,
      "readStatus": "read",
      "voiceId": "4261353458587692.1353458587771",
      "notes": null,
      "notesUpdateDate": null,
      "notesUpdateBy": "",
      "datetimeUpdated": "2012-11-21T00:52:33Z",
      "articleContent": "I have a complaint about 3G Reception around Dover road. I seem to get 3-5 bars on both my phone and friends yet the 3G is terrible when sending iMessages,surfing the internet etc. This started to happen a few months ago while it was good before. Please sort this out.",
      "articleVoiceName": "Patrick Combe",
      "articleVoicePicture": "https://graph.facebook.com/1015175280/picture",
      "articleDateTimePost": "2012-11-20T13:08:02Z",
      "articleVoiceId": "1015175280",
      "assetId": "28011986676",
      "assetPic": "http://graph.facebook.com/28011986676/picture",
      "assetURL": "http://www.facebook.com/28011986676",
      "articleURL": "http://www.facebook.com/permalink.php?story_fbid=10151949726736677&id=28011986676",
      "articleVoiceURL": "http://www.facebook.com/1015175280",
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
        print params
        params.remove('caseId')
        render getCase(params, request.JSON) as JSON
    }

    def closeCase() {
        /*
       caseId=9691340714194928&
       type=facebook&
        */
        render getCase(params, [caseStatus: 0]) as JSON
    }

    def getCaseById() {
        /*
       caseId=9691340959298765
        */
        render getCase(params, null) as JSON
    }

    def updateCase() {
        /*
       caseId=9691340714194928&
       type=facebook&
       name=newTitle&
        */
        render getCase(params, request.JSON) as JSON
    }

    def reOpenCase() {
        /**
         * caseId = 9691340714194928
         * createBy = 456
         */
        render getCase(params, [caseStatus: 1]) as JSON
    }

    def emailCase() {
        /**
         * caseId = 123
         */
        render '''{
  "name": "Mr Tan",
  "phone": "91234567",
  "identifier": "0123456789",
  "email": "mr.tan@wjbank.com",
  "notes": "VIP customer",
  "title": "Rewards",
  "articleURL": "http://www.facebook.com/permalink.php?story_fbid=388362207899960&id=322058887863626",
  "history": 
  [
    {
      "content": "what is upcoming for WJBank?",
      "datetimePosted": "2012-09-20T06:13:25Z",
      "voiceName": "Wei Jian",
      "voiceURL": "http://www.facebook.com/689247620",
      "voiceId": "689247620",
      "voicePic": "https://graph.facebook.com/689247620/picture"
    },
    {
      "content": "Thanks All",
      "agentName": "Joshua Troy - Brandtology R&D",
      "datetimePosted": "2012-09-20T06:22:52Z",
      "voiceId": "322058887863626",
      "voicePic": "https://graph.facebook.com/322058887863626/picture",
      "voiceURL": "http://www.facebook.com/322058887863626",
      "voiceName": "WJ Bank"
    }
  ]
}'''
    }



    def createCaseReal() {
        params.remoteAction = 'createCase'
        forward(action: 'passThrough')
    }

    def closeCaseReal() {
        params.remoteAction = 'closeCase'
        forward(action: 'passThrough')
    }

    def getCaseByIdReal() {
        params.remoteAction = 'getCaseById'
        forward(action: 'passThrough')
    }

    def updateCaseReal() {
        params.remoteAction = 'updateCase'
        forward(action: 'passThrough')
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
        assetId=everything
        readStatus=read|unread
        caseCreated=true|false

         */

        render '''{ "data": 
        [
            {
                "content": "Review interest rate, Contact us for more info"
              , "imageURL": "http://a2.sphotos.ak.fbcdn.net/hphotos-ak-ash4/s480x480/482021_10151279023744017_1947373084_n.jpg"
              , "voiceName": "WJ Bank", "datetimePosted": "2012-07-03T03:46:08Z", "fbId": "322058887863626_360570517345796", "voicePic": "https://graph.facebook.com/322058887863626/picture", "commentCount": 0, "likeCount": 0, "voiceId": "322058887863626", "caseId": "9691341297556920", "caseCreated": true, "readStatus": "unread", "comment": [ ], "assetPic": "https://graph.facebook.com/322058887863626/picture", "assetId": "322058887863626" }, { "content": "Singtel Network Down.!!! I cant make any calls out or receive any calls!! SINTEL What is appening to you guys!! Why is this always happening!!!!!!!", "voiceName": "Lawrence Chia", "datetimePosted": "2012-07-01T02:36:34Z", "fbId": "28011986676_10151725883386677", "voicePic": "https://graph.facebook.com/1024767404/picture", "commentCount": 7, "likeCount": 1, "voiceId": "1024767404", "caseId": "9691341302369330", "caseCreated": true, "readStatus": "unread", "comment": [ { "content": "Hi Lawrence, earlier this morning around 10.30am, some of our customers in Paya Lebar, Kallang, East Coast and Marine Parade area may have had difficulties using their 3G services. Recovery started from 1130am, and all services were fully restored by 1145am. The root cause is under investigation. During the issue, 2G services were available. Once again, please accept our apologies for the inconvenience caused. - Caroline", "voiceName": "SingTel", "datetimePosted": "2012-07-01T08:54:15Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151725883386677_22343077" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "Cant believe you all wrote/said to ST and said that 2G was available when the network outage occurred this morning. Its was a complete loss of both network mind you! the fact that ST tried to downplay the whole affair reflects on how much ST cant face up to the issue while playing taichi and asking the consumers to keep switching on and off their phone or worse trying to call into the nonexistent helplines and telling us to head to exeter to make a sim change. All this while the issue is on your end of the stick! Yes i am pissed. pissed with how you guys insult the users and trying to twist facts! ", "voiceName": "Perry Teo", "datetimePosted": "2012-07-01T08:51:10Z", "fbId": "28011986676_10151726285826677", "voicePic": "https://graph.facebook.com/665336665/picture", "commentCount": 0, "likeCount": 0, "voiceId": "665336665", "caseId": "9691341301184247", "caseCreated": true, "readStatus": "unread", "comment": [ ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "I experience bad voice and data connection for the last 14 days around Macperson area and Eunos area....you are performing upgrading work?", "voiceName": "Denis Beh", "datetimePosted": "2012-07-01T06:17:45Z", "fbId": "28011986676_10151726136881677", "voicePic": "https://graph.facebook.com/824347312/picture", "commentCount": 1, "likeCount": 0, "voiceId": "824347312", "caseId": "9691340959298765", "caseCreated": true, "readStatus": "unread", "comment": [ { "content": "Hi Denis, please provide us your details via the form below so that we can investigate on the network performance in both areas. Thanks - Caroline\\n\\nhttp://on.fb.me/ContactSingTel", "voiceName": "SingTel", "datetimePosted": "2012-07-01T07:48:08Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151726136881677_22342829" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "Singtel Network Down.!!! I cant make any calls out or receive any calls!! SINTEL What is appening to you guys!! Why is this always happening!!!!!!!", "voiceName": "Lawrence Chia", "datetimePosted": "2012-07-01T02:36:34Z", "fbId": "28011986676_10151725883386677", "voicePic": "https://graph.facebook.com/1024767404/picture", "commentCount": 7, "likeCount": 1, "voiceId": "1024767404", "caseId": "9691341396224413", "caseCreated": true, "readStatus": "unread", "comment": [ { "content": "Caroline, Service is up now. But that does not explain why it was down for for about 1 and a half hours. This is not the explanation i am expecting. I missed my teleconference because of the your downed Network!!", "voiceName": "Lawrence Chia", "datetimePosted": "2012-07-01T07:40:56Z", "likeCount": 0, "relatedCase": null, "voiceId": "1024767404", "voicePic": "https://graph.facebook.com/1024767404/picture", "fbId": "28011986676_10151725883386677_22342791" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "When will singtel be rolling out the blackberry 7.1 upgrade for the curve 9360 ? Its out for 9900 but not for the curve. WHY ?", "voiceName": "Vish Upadhya", "datetimePosted": "2012-07-01T07:19:50Z", "fbId": "28011986676_10151726186846677", "voicePic": "https://graph.facebook.com/700223890/picture", "commentCount": 0, "likeCount": 0, "voiceId": "700223890", "caseId": "9691341396023367", "caseCreated": true, "readStatus": "unread", "comment": [ ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "Singtel Network Down.!!! I cant make any calls out or receive any calls!! SINTEL What is appening to you guys!! Why is this always happening!!!!!!!", "voiceName": "Lawrence Chia", "datetimePosted": "2012-07-01T02:36:34Z", "fbId": "28011986676_10151725883386677", "voicePic": "https://graph.facebook.com/1024767404/picture", "commentCount": 7, "likeCount": 1, "voiceId": "1024767404", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "You mean they have online staff replying your FB postings?? Damn !! I should stop calling the hotline from now on! Lol", "voiceName": "Alwyn Sim", "datetimePosted": "2012-07-01T06:59:25Z", "likeCount": 0, "relatedCase": null, "voiceId": "1109161257", "voicePic": "https://graph.facebook.com/1109161257/picture", "fbId": "28011986676_10151725883386677_22342622" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "Was there a connection problem with Singtel mobile earlier?? My mobile phone had no mobile reception for about an hour or so. ", "voiceName": "Mitesh Desai", "datetimePosted": "2012-07-01T03:44:08Z", "fbId": "28011986676_10151725984296677", "voicePic": "https://graph.facebook.com/525740717/picture", "commentCount": 3, "likeCount": 0, "voiceId": "525740717", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Hi Mitesh, thanks for sharing the update. Have a good weekend. - Caroline", "voiceName": "SingTel", "datetimePosted": "2012-07-01T06:54:25Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151725984296677_22342607" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "Kindly do something about the network!! Its TERRIBLE!!", "voiceName": "Sharon Lyra Norahs", "datetimePosted": "2012-07-01T03:39:57Z", "fbId": "28011986676_10151725980561677", "voicePic": "https://graph.facebook.com/542187018/picture", "commentCount": 5, "likeCount": 0, "voiceId": "542187018", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Hi Sharon, are you still facing the issue now? If yes, please let us know the exact location or postal code. Thanks - Caroline", "voiceName": "SingTel", "datetimePosted": "2012-07-01T06:52:24Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151725980561677_22342603" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "How come Singtel took no apparent efforts to inform its subscribers of the disruption in 3G services? Perhaps IDA should take a closer look at its mitigation process. ", "voiceName": "JC Ho", "datetimePosted": "2012-07-01T06:48:54Z", "fbId": "28011986676_10151726160131677", "voicePic": "https://graph.facebook.com/100002090110307/picture", "commentCount": 0, "likeCount": 0, "voiceId": "100002090110307", "caseCreated": false, "readStatus": "unread", "comment": [ ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "Network down again this morning at East Coast???", "voiceName": "Victor Tan", "datetimePosted": "2012-07-01T03:51:58Z", "fbId": "28011986676_10151725992586677", "voicePic": "https://graph.facebook.com/100000518330877/picture", "commentCount": 6, "likeCount": 0, "voiceId": "100000518330877", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Hi Perry Teo & Victor Tan, we are sorry about your experience this morning. The network has been restored. Do alert us if you are still facing any issue. Thanks - Caroline", "voiceName": "SingTel", "datetimePosted": "2012-07-01T06:48:41Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151725992586677_22342589" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "I experience bad voice and data connection for the last 14 days around Macperson area and Eunos area....you are performing upgrading work?", "voiceName": "Denis Beh", "datetimePosted": "2012-07-01T06:17:45Z", "fbId": "28011986676_10151726136881677", "voicePic": "https://graph.facebook.com/824347312/picture", "commentCount": 1, "likeCount": 0, "voiceId": "824347312", "caseCreated": false, "readStatus": "unread", "comment": [ ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "My contract is ending with Singtel, and I am most probably going to switch my mobile service provider. So disappointing! ", "voiceName": "Mitesh Desai", "datetimePosted": "2012-07-01T06:10:50Z", "fbId": "28011986676_10151726131241677", "voicePic": "https://graph.facebook.com/525740717/picture", "commentCount": 0, "likeCount": 0, "voiceId": "525740717", "caseCreated": false, "readStatus": "unread", "comment": [ ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "Was there a connection problem with Singtel mobile earlier?? My mobile phone had no mobile reception for about an hour or so. ", "voiceName": "Mitesh Desai", "datetimePosted": "2012-07-01T03:44:08Z", "fbId": "28011986676_10151725984296677", "voicePic": "https://graph.facebook.com/525740717/picture", "commentCount": 3, "likeCount": 0, "voiceId": "525740717", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "It's fine now . ", "voiceName": "Mitesh Desai", "datetimePosted": "2012-07-01T06:07:51Z", "likeCount": 0, "relatedCase": null, "voiceId": "525740717", "voicePic": "https://graph.facebook.com/525740717/picture", "fbId": "28011986676_10151725984296677_22342425" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "...."
              , "imageURL": "http://a2.sphotos.ak.fbcdn.net/hphotos-ak-ash4/s480x480/482021_10151279023744017_1947373084_n.jpg"
              , "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:56:34Z", "fbId": "28011986676_10151726120501677", "voicePic": "https://graph.facebook.com/646605485/picture", "commentCount": 3, "likeCount": 0, "voiceId": "646605485", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Hi Alvin Ncs\\n\\nWe did not hide your posting. It is still on the Facebook wall. Do let us know if you are still encountering any issue so that we can investigate. Thanks. - Darryl", "voiceName": "SingTel", "datetimePosted": "2012-07-01T06:06:37Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151726120501677_22342420" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "....", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:56:34Z", "fbId": "28011986676_10151726120501677", "voicePic": "https://graph.facebook.com/646605485/picture", "commentCount": 3, "likeCount": 0, "voiceId": "646605485", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "I cant post a single shit when you hide my post. I cant even comment. ", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:57:18Z", "likeCount": 0, "relatedCase": null, "voiceId": "646605485", "voicePic": "https://graph.facebook.com/646605485/picture", "fbId": "28011986676_10151726120501677_22342380" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "....", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:56:34Z", "fbId": "28011986676_10151726120501677", "voicePic": "https://graph.facebook.com/646605485/picture", "commentCount": 3, "likeCount": 0, "voiceId": "646605485", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Stop hiding my post. ", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:56:47Z", "likeCount": 0, "relatedCase": null, "voiceId": "646605485", "voicePic": "https://graph.facebook.com/646605485/picture", "fbId": "28011986676_10151726120501677_22342376" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "....", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:56:34Z", "fbId": "28011986676_10151726120501677", "voicePic": "https://graph.facebook.com/646605485/picture", "commentCount": 3, "likeCount": 0, "voiceId": "646605485", "caseCreated": false, "readStatus": "unread", "comment": [ ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "Singtel's 3G network has been very erratic of late. Just this morning, the Singtel mobile network was suddenly not available where I was in the eastern part of Singapore at around 11am. At other times, 3G data transfer can be slow to the point of being non existent, despite reasonable phone reception.\\n\\nThis is not a complaint but I hope you guys don't let service standards fall as I know you're capable of doing a great job as I have a fantastic experience with Singtel, till now.", "voiceName": "Gerald Lim", "datetimePosted": "2012-07-01T05:17:58Z", "fbId": "28011986676_10151726088091677", "voicePic": "https://graph.facebook.com/665603361/picture", "commentCount": 1, "likeCount": 0, "voiceId": "665603361", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "Hi Gerald\\n\\nSorry to hear about that. Are you still experiencing any problems? Do let us know your exact location so that we can look into this. Thanks. - Darryl", "voiceName": "SingTel", "datetimePosted": "2012-07-01T05:37:21Z", "likeCount": 0, "relatedCase": null, "voiceId": "28011986676", "voicePic": "https://graph.facebook.com/28011986676/picture", "fbId": "28011986676_10151726088091677_22342294" } ], "assetPic": "https://graph.facebook.com/28011986676/picture", "assetId": "28011986676" }, { "content": "Connection down with 3g, 2g restarted phone and connection but still the same I have been facing this issue for lots of times. Currently at joo chiat, old airport road and toa payoh. Whats wrong with singtel. Now it shows no service. Isnt that cool?", "voiceName": "Alvin Ncs", "datetimePosted": "2012-07-01T05:20:57Z", "fbId": "28011986676_10151726091496677", "voicePic": "https://graph.facebook.com/646605485/picture", "commentCount": 2, "likeCount": 0, "voiceId": "646605485", "caseCreated": false, "readStatus": "unread", "comment": [ { "content": "lol Alvin chill", "voiceName": "Yang YaoTian", "datetimePosted": "2012-07-01T05:34:28Z", "likeCount": 0, "relatedCase": null, "voiceId": "819178641", "voicePic": "https://graph.facebook.com/819178641/picture", "fbId": "28011986676_10151726091496677_22342285" } ], "assetPic": "https://graph.facebook.com/28011986676/picture"
              , "imageURL": "http://a2.sphotos.ak.fbcdn.net/hphotos-ak-ash4/s480x480/482021_10151279023744017_1947373084_n.jpg"
              , "assetId": "28011986676" } ], "total": 117 }'''

    }

    def showConversationForTwitter() {
      showConversation()
    }

    def showConversation() {

        /*
        articleId=98685085344_196710807123445&
        voiceId=719707536&
        type=facebook&
        commentId=98685085344_196710807123445_518623
         */

        render '''{
  "url": "http://www.facebook.com/permalink.php?story_fbid=196710807123445&id=98685085344",
  "userName": "Channel 8",
  "dateTimePosted": "2012-06-23T11:21:13Z",
  "content": "ü£?ìÑ? debuts tomorrow!! Here's a look at the meet & greet we had at Eastpoint Mall last weekend!\\n Joys of Life ü£?ìÑ? - äÄâ¢?Øü? Meet & Greet at Eastpoint Mall!",
  "fbId": "98685085344_196710807123445",
  "likesCount": 109,
  "commentCount": 0,
  "voiceId": "98685085344",
  "imageURL": "https://graph.facebook.com/719707536/picture",
  "comments":
  [
    {
      "content": "yes finally can watch it",
      "isOriginal": 1,
      "isUser": 1,
      "dateTimePosted": "2012-06-25T10:19:40Z",
      "fbid": "98685085344_196710807123445_518623",
      "messageId": "98685085344_196710807123445_518623",
      "userName": "Xavienne Chew Lah Sia",
      "userpic": "https://graph.facebook.com/719707536/picture",
      "likesCount": 0,
      "caseStatus": 1,
      "voiceId": "719707536"
    },
    {
      "content": "episode 1 last part the somebody cutting Rui En hairs i think",
      "isUser": 1,
      "dateTimePosted": "2012-06-25T10:20:13Z",
      "fbid": "98685085344_196710807123445_518624",
      "messageId": "98685085344_196710807123445_518624",
      "userName": "Xavienne Chew Lah Sia",
      "userpic": "https://graph.facebook.com/719707536/picture",
      "likesCount": 0,
      "caseStatus": 1,
      "voiceId": "719707536"
    },
    {
      "content": "26hrs 35mins more to #joysoflife",
      "dateTimePosted": "2012-06-25T10:24:23Z",
      "fbid": "98685085344_196710807123445_518630",
      "messageId": "98685085344_196710807123445_518630",
      "userName": "Swee Heng Tan",
      "userpic": "https://graph.facebook.com/100002676015109/picture",
      "likesCount": 1,
      "caseStatus": 1,
      "voiceId": "100002676015109"
    },
    {
      "content": "Let's trend #joysoflife tmr at 9pm on twitter! :)",
      "dateTimePosted": "2012-06-25T10:42:35Z",
      "fbid": "98685085344_196710807123445_518683",
      "messageId": "98685085344_196710807123445_518683",
      "userName": "Joys of Life ü£?ìÑ?",
      "userpic": "https://graph.facebook.com/345262218830470/picture",
      "likesCount": 3,
      "voiceId": "345262218830470"
    },
    {
      "content": "Xiao gui acting skills is real good. 2 thumps up for him..",
      "dateTimePosted": "2012-06-25T10:55:48Z",
      "fbid": "98685085344_196710807123445_518704",
      "messageId": "98685085344_196710807123445_518704",
      "userName": "Kitty Catty",
      "userpic": "https://graph.facebook.com/624748319/picture",
      "likesCount": 2,
      "voiceId": "624748319"
    },
    {
      "content": "I love XiaoGui ^^ ",
      "dateTimePosted": "2012-06-25T11:00:48Z",
      "fbid": "98685085344_196710807123445_518714",
      "messageId": "98685085344_196710807123445_518714",
      "userName": "Jesslyn Tu",
      "userpic": "https://graph.facebook.com/100000140890216/picture",
      "likesCount": 0,
      "voiceId": "100000140890216"
    },
    {
      "content": "Where is Xiao Gui now ? Singapore or Taiwan ?",
      "dateTimePosted": "2012-06-25T12:01:14Z",
      "fbid": "98685085344_196710807123445_518888",
      "messageId": "98685085344_196710807123445_518888",
      "userName": "Xian Ning",
      "userpic": "https://graph.facebook.com/100000066130303/picture",
      "likesCount": 0,
      "voiceId": "100000066130303"
    },
    {
      "content": "I Love Rui En,:)\\nepisode 1 last part the somebody cutting Rui En hairs i think:)",
      "dateTimePosted": "2012-06-25T14:00:46Z",
      "fbid": "98685085344_196710807123445_519311",
      "messageId": "98685085344_196710807123445_519311",
      "userName": "Heng XinYing",
      "userpic": "https://graph.facebook.com/100001907864504/picture",
      "likesCount": 0,
      "voiceId": "100001907864504"
    },
    {
      "content": "^^ One more day!",
      "dateTimePosted": "2012-06-25T10:17:52Z",
      "fbid": "98685085344_196710807123445_518620",
      "messageId": "98685085344_196710807123445_518620",
      "userName": "Joys of Life ü£?ìÑ?",
      "userpic": "https://graph.facebook.com/345262218830470/picture",
      "likesCount": 4,
      "nCount": 1,
      "voiceId": "345262218830470",
      "assignNotes": "just a note",
      "caseId": "12312312341234-12341234"
    }
  ],
  "retweets":
  [
    {
      "content": "yes finally can watch it",
      "isOriginal": 1,
      "isUser": 1,
      "dateTimePosted": "2012-06-25T10:19:40Z",
      "fbid": "98685085344_196710807123445_518623",
      "messageId": "98685085344_196710807123445_518623",
      "userName": "Xavienne Chew Lah Sia",
      "userpic": "https://graph.facebook.com/719707536/picture",
      "likesCount": 0,
      "voiceId": "719707536"
    },
    {
      "content": "episode 1 last part the somebody cutting Rui En hairs i think",
      "isUser": 1,
      "dateTimePosted": "2012-06-25T10:20:13Z",
      "fbid": "98685085344_196710807123445_518624",
      "messageId": "98685085344_196710807123445_518624",
      "userName": "Xavienne Chew Lah Sia",
      "userpic": "https://graph.facebook.com/719707536/picture",
      "likesCount": 0,
      "voiceId": "719707536"
    },
    {
      "content": "26hrs 35mins more to #joysoflife",
      "dateTimePosted": "2012-06-25T10:24:23Z",
      "fbid": "98685085344_196710807123445_518630",
      "messageId": "98685085344_196710807123445_518630",
      "userName": "Swee Heng Tan",
      "userpic": "https://graph.facebook.com/100002676015109/picture",
      "likesCount": 1,
      "voiceId": "100002676015109"
    },
    {
      "content": "Let's trend #joysoflife tmr at 9pm on twitter! :)",
      "dateTimePosted": "2012-06-25T10:42:35Z",
      "fbid": "98685085344_196710807123445_518683",
      "messageId": "98685085344_196710807123445_518683",
      "userName": "Joys of Life ü£?ìÑ?",
      "userpic": "https://graph.facebook.com/345262218830470/picture",
      "likesCount": 3,
      "voiceId": "345262218830470"
    },
    {
      "content": "Xiao gui acting skills is real good. 2 thumps up for him..",
      "dateTimePosted": "2012-06-25T10:55:48Z",
      "fbid": "98685085344_196710807123445_518704",
      "messageId": "98685085344_196710807123445_518704",
      "userName": "Kitty Catty",
      "userpic": "https://graph.facebook.com/624748319/picture",
      "likesCount": 2,
      "voiceId": "624748319"
    },
    {
      "content": "I love XiaoGui ^^ ",
      "dateTimePosted": "2012-06-25T11:00:48Z",
      "fbid": "98685085344_196710807123445_518714",
      "messageId": "98685085344_196710807123445_518714",
      "userName": "Jesslyn Tu",
      "userpic": "https://graph.facebook.com/100000140890216/picture",
      "likesCount": 0,
      "voiceId": "100000140890216"
    },
    {
      "content": "Where is Xiao Gui now ? Singapore or Taiwan ?",
      "dateTimePosted": "2012-06-25T12:01:14Z",
      "fbid": "98685085344_196710807123445_518888",
      "messageId": "98685085344_196710807123445_518888",
      "userName": "Xian Ning",
      "userpic": "https://graph.facebook.com/100000066130303/picture",
      "likesCount": 0,
      "voiceId": "100000066130303"
    },
    {
      "content": "I Love Rui En,:)\\nepisode 1 last part the somebody cutting Rui En hairs i think:)",
      "dateTimePosted": "2012-06-25T14:00:46Z",
      "fbid": "98685085344_196710807123445_519311",
      "messageId": "98685085344_196710807123445_519311",
      "userName": "Heng XinYing",
      "userpic": "https://graph.facebook.com/100001907864504/picture",
      "likesCount": 0,
      "voiceId": "100001907864504"
    }
  ]
}'''
    }

    def markStatus() {
        /*
        commentId=98685085344_252834011497416_920663&
        articleId=98685085344_252834011497416&
        status=read|unread
        userId=661
        type=facebook
         */

        render """{
  "data": {
    "content": "Dear Admin,\\nI have been a customer of WJ Bank for 15 years and am unhappy with the customer service. Recently I was asked to leave your branch because I was good looking. When I told them that I was not good looking,they ignored me and forcefully removed me from the bank. Please help.",
    "voiceName": "Erwin Iriawan Seah",
    "datetimePosted": "2012-07-12T04:21:17Z",
    "fbId": "322058887863626_364033690332812",
    "voicePic": "https://graph.facebook.com/580607408/picture",
    "commentCount": 2,
    "likeCount": 0,
    "voiceId": "580607408",
    "articleURL": "http://www.facebook.com/permalink.php?story_fbid=364033690332812&id=322058887863626",
    "voiceURL": "http://www.facebook.com/580607408",
    "caseId": "9691342079864534",
    "caseCreated": true,
    "readStatus": "${params.status}",
    "readBy": "Chao Liu",
    "comment":
    [
      {
        "content": "Yeah.. http://www.youtube.com/watch?v=MyGJXLxtVEo",
        "voiceName": "Erwin Iriawan Seah",
        "datetimePosted": "2012-07-12T04:36:16Z",
        "likeCount": 0,
        "relatedCase": null,
        "voiceId": "580607408",
        "voicePic": "https://graph.facebook.com/580607408/picture",
        "voiceURL": "http://www.facebook.com/580607408",
        "fbId": "322058887863626_364033690332812_3056431"
      }
    ],
    "assetPic": "https://graph.facebook.com/322058887863626/picture",
    "assetId": "322058887863626",
    "assetURL": "https://www.facebook.com/322058887863626",
    "assetName": "WJbank"
  }
}"""
    }

    def markStatusInBatch() {
      // print request.JSON
      render '{"data":"ok"}'
    }

    def markCaseStatusInBatch() {
      render '{"data":"ok"}'
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

        render '''{ "total": 9, "data": [ { "assetURL": "asset.url", "caseId": "9691341565324557", "title": "Strange", "priority": 3, "dateCreated": "2012-07-06T09:02:05Z", "articleId": "28011986676_10151726186846677", "commentId": "0", "caseStatus": 1, "assignTo": "Tan Weijian - SG", "createdBy": "Tan Weijian - SG", "type": "facebook", "updateCount": 3, "readStatus": "unread", "articleContent": "When will singtel be rolling out the blackberry 7.1 upgrade for the curve 9360 ? Its out for 9900 but not for the curve. WHY ?", "articleVoiceName": "Vish Upadhya", "articleVoicePicture": "https://graph.facebook.com/700223890/picture", "articleDateTimePost": "2012-07-01T07:19:50Z", "articleVoiceId": "700223890", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ ] }, { "caseId": "9691341482695378", "title": "ddd", "priority": 3, "dateCreated": "2012-07-05T10:04:55Z", "articleId": "104681096700_10150904152071701", "commentId": "0", "caseStatus": 1, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Food for thought for Marketers.", "articleVoiceName": "Brandtology", "articleVoicePicture": "https://graph.facebook.com/104681096700/picture", "articleDateTimePost": "2012-07-04T05:25:38Z", "articleVoiceId": "104681096700", "assetId": "104681096700", "assetPic": "http://graph.facebook.com/104681096700/picture", "comment": [ ] }, { "caseId": "9691341396224413", "title": "case1", "priority": 3, "dateCreated": "2012-07-04T10:03:44Z", "articleId": "28011986676_10151725883386677", "commentId": "28011986676_10151725883386677_22342791", "caseStatus": 1, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Singtel Network Down.!!! I cant make any calls out or receive any calls!! SINTEL What is appening to you guys!! Why is this always happening!!!!!!!", "articleVoiceName": "Lawrence Chia", "articleVoicePicture": "https://graph.facebook.com/1024767404/picture", "articleDateTimePost": "2012-07-01T02:36:34Z", "articleVoiceId": "1024767404", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ { "content": "Caroline, Service is up now. But that does not explain why it was down for for about 1 and a half hours. This is not the explanation i am expecting. I missed my teleconference because of the your downed Network!!", "voiceId": "1024767404", "voiceName": "Lawrence Chia", "datetimePost": "2012-07-01T07:40:56Z", "voicePicture": "https://graph.facebook.com/1024767404/picture" } ] }, { "caseId": "9691341396023367", "title": "newTitle", "priority": 4, "dateCreated": "2012-07-04T10:00:23Z", "articleId": "28011986676_10151726186846677", "commentId": "0", "caseStatus": 1, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "When will singtel be rolling out the blackberry 7.1 upgrade for the curve 9360 ? Its out for 9900 but not for the curve. WHY ?", "articleVoiceName": "Vish Upadhya", "articleVoicePicture": "https://graph.facebook.com/700223890/picture", "articleDateTimePost": "2012-07-01T07:19:50Z", "articleVoiceId": "700223890", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ ] }, { "caseId": "9691341302369330", "title": "case22345", "priority": 4, "dateCreated": "2012-07-03T07:59:29Z", "articleId": "28011986676_10151725883386677", "commentId": "28011986676_10151725883386677_22343077", "caseStatus": 1, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Singtel Network Down.!!! I cant make any calls out or receive any calls!! SINTEL What is appening to you guys!! Why is this always happening!!!!!!!", "articleVoiceName": "Lawrence Chia", "articleVoicePicture": "https://graph.facebook.com/1024767404/picture", "articleDateTimePost": "2012-07-01T02:36:34Z", "articleVoiceId": "1024767404", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ { "content": "Hi Lawrence, earlier this morning around 10.30am, some of our customers in Paya Lebar, Kallang, East Coast and Marine Parade area may have had difficulties using their 3G services. Recovery started from 1130am, and all services were fully restored by 1145am. The root cause is under investigation. During the issue, 2G services were available. Once again, please accept our apologies for the inconvenience caused. - Caroline", "voiceId": "28011986676", "voiceName": "SingTel", "datetimePost": "2012-07-01T08:54:15Z", "voicePicture": "https://graph.facebook.com/28011986676/picture" } ] }, { "caseId": "9691341301184247", "title": "case1", "priority": 2, "dateCreated": "2012-07-03T07:39:44Z", "articleId": "28011986676_10151726285826677", "commentId": "0", "caseStatus": 1, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Cant believe you all wrote/said to ST and said that 2G was available when the network outage occurred this morning. Its was a complete loss of both network mind you! the fact that ST tried to downplay the whole affair reflects on how much ST cant face up to the issue while playing taichi and asking the consumers to keep switching on and off their phone or worse trying to call into the nonexistent helplines and telling us to head to exeter to make a sim change. All this while the issue is on your end of the stick! Yes i am pissed. pissed with how you guys insult the users and trying to twist facts! ", "articleVoiceName": "Perry Teo", "articleVoicePicture": "https://graph.facebook.com/665336665/picture", "articleDateTimePost": "2012-07-01T08:51:10Z", "articleVoiceId": "665336665", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ ] }, { "caseId": "9691341297556920", "title": "qqq", "priority": 5, "dateCreated": "2012-07-03T06:39:16Z", "articleId": "322058887863626_360570517345796", "commentId": "0", "caseStatus": 2, "assignTo": "Chao Liu", "createdBy": "Chao Liu", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Review interest rate, Contact us for more info", "articleVoiceName": "WJ Bank", "articleVoicePicture": "https://graph.facebook.com/322058887863626/picture", "articleDateTimePost": "2012-07-03T03:46:08Z", "articleVoiceId": "322058887863626", "assetId": "322058887863626", "assetPic": "http://graph.facebook.com/322058887863626/picture", "comment": [ ] }, { "caseId": "9691341291444028", "title": "Location", "priority": 3, "dateCreated": "2012-07-03T04:57:24Z", "articleId": "322058887863626_338046902931491", "commentId": "0", "caseStatus": 2, "assignTo": "Tan Weijian - SG", "createdBy": "Tan Weijian - SG", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "Hi how can I apply for credit card from WJ bank?", "articleVoiceName": "Zhou Shuo", "articleVoicePicture": "https://graph.facebook.com/1647738938/picture", "articleDateTimePost": "2012-05-23T03:38:24Z", "articleVoiceId": "1647738938", "assetId": "322058887863626", "assetPic": "http://graph.facebook.com/322058887863626/picture", "comment": [ ] }, { "caseId": "9691340959298765", "title": "hello", "priority": 3, "dateCreated": "2012-06-29T08:41:38Z", "articleId": "28011986676_10151726136881677", "commentId": "28011986676_10151726136881677_22342829", "caseStatus": 0, "assignTo": "Tan Weijian - SG", "createdBy": "Tan Weijian - SG", "type": "facebook", "updateCount": 0, "readStatus": "read", "articleContent": "I experience bad voice and data connection for the last 14 days around Macperson area and Eunos area....you are performing upgrading work?", "articleVoiceName": "Denis Beh", "articleVoicePicture": "https://graph.facebook.com/824347312/picture", "articleDateTimePost": "2012-07-01T06:17:45Z", "articleVoiceId": "824347312", "assetId": "28011986676", "assetPic": "http://graph.facebook.com/28011986676/picture", "comment": [ { "content": "Hi Denis, please provide us your details via the form below so that we can investigate on the network performance in both areas. Thanks - Caroline\\n\\nhttp://on.fb.me/ContactSingTel", "voiceId": "28011986676", "voiceName": "SingTel", "datetimePost": "2012-07-01T07:48:08Z", "voicePicture": "https://graph.facebook.com/28011986676/picture" } ] } ] }'''

    }

    def markCaseRead() {
        render '''{"response":"ok"}'''
    }

    def addNotes() {
        /*
        caseId=9691340714194928&
        type=facebook&
        memo=hello3&
         */

        render '''{
    "caseId": "9691341301184247",
    "title": "case1",
    "priority": 2,
    "caseStatus": 2,
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

    def responseCase() {
        /*
        caseId=9691340714194928&
        type=facebook&
        response=responding&
         */
        render '''{
    "caseId": "9691341301184247",
    "title": "case1",
    "priority": 2,
    "caseStatus": 2,
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
        //def caseHistoryDataJson =  brandtologyApiService.passThroughInvoke('SocialEngage/getCaseHistory', params)
        def result = [:]
        def caseHistoryData = JSON.parse(caseHistoryDataJson)
        result.data = caseHistoryData.data.collect {caseHistoryEntry ->

            println caseHistoryEntry

            def args = []
            args << caseHistoryEntry.params.caseId
            caseHistoryEntry.params.remove('caseId')

            if (caseHistoryEntry.indicator == 3){
                args << g.message(code: "brandtology.engage.case.status.${caseHistoryEntry.params.caseState}")
            }else
                args.addAll(caseHistoryEntry.params.values() as List)


            [
                    createDate: caseHistoryEntry.createDate,
                    createdBy: caseHistoryEntry.createdBy,
                    message: g.message(code: "brandtology.engage.case.history.CH${caseHistoryEntry.indicator}",
                            args: args)
            ]
        }

        render result as JSON

    }

    def updateVoiceDetails() {
        /*
        voiceId=9691340801140613.1340801141467&
        name=hello&
        identifier=iden&
        email=a&
        phone=12345&
         */

        render '''{"response":"ok"}'''

    }

    def updateSocialProfile() {
        /*
        voiceId=9691340801140613.1340801141467&
        name=hi&
        url=www.twitter.com/bye&
        type=twitter&
         */
        render '''{"response":"ok"}'''
    }

    def getVoiceProfile() {
        /*
        type    = facebook
        queryId = 9691340801140613.1340801141467
         */
        render '''{
  "data": {
    "clientAccountId": 969,
    "email": "a",
    "fbId": "180911745311892",
    "fbName": "Manicurious",
    "fbUrl": "http://www.facebook.com/180911745311892",
    "id": "9691340801140613.1340801141467",
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

    def overview() {
        def currentSubModule = 'overview'

        [currentSubModule: currentSubModule]
    }

    def brandtologyApiService

    def passThrough() {


        def clientAccountId = '969'
        def createdBy = '771'

        def additionalParams = [clientAccountId: clientAccountId, createdBy: createdBy]

        if (params.remoteAction == 'getAllPosts'){
            params.remoteAction = 'getAllPost'
            additionalParams += [
                    offset: params.offset?params.offset:0,
                    sort: params.sort?params.sort:'datetimeSort',
                    order:  params.order?params.order:'desc',
                    assetId:params.assetId?params.assetId:'everything',
                    postType:params.postType?params.postType:'everything',
                    readStatus:params.readStatus?params.readStatus:'everything',
                    caseCreated:params.caseCreated?params.caseCreated:'everything']
        }else if (params.remoteAction == 'getAllCase'){
            additionalParams += [
                    clientAccountId: clientAccountId,
                    offset: params.offset?params.offset:0,
                    max: params.max?params.max:20,
                    sort: params.sort?params.sort:'datetimePosted',
                    order:  params.order?params.order:'desc',
                    assetsId:params.assetsId?params.assetsId:'everything',
                    postType: params.postType?params.postType:'everything',
                    platform:params.platform?params.platform:'everything'

            ]
        }else if (params.remoteAction == 'markStatus'){
            params.userId = createdBy
        }else if (params.remoteAction == 'updateCase'){
            additionalParams += [
                    caseId:request.JSON.caseId,
                    name:request.JSON.title]
        }

        def data = params + additionalParams + request.JSON

        def url = "SocialEngage/${params.remoteAction}"

        def json = brandtologyApiService.passThroughInvoke(url, data)
        render json.toString()


    }

    def getStreamUnreadCount() {
      if (params.platform == "facebook") {
        render """{
    "stream": 85,
    "message": 11,
    "casesStream": 9
  }"""
      } else {
        render """{
    "stream": 99,
    "messages": 22
  }"""
      }
    }

    def showNotesHistory() {
      render """{
  "data": 
  [
    {
      "notes": "ppppp",
      "datetimePost": "2013-03-21T08:41:51Z",
      "userName": "Tan Wei Jian - SG",
      "profilePic": "Photo_6517A1BB-3682-CF64-4CC6-8901A5778D23.jpg",
      "emailAddress": "weijian.tan@brandtology.com"
    },
    {
      "notes": "vbbbbb",
      "datetimePost": "2013-03-21T08:44:51Z",
      "userName": "Tan Wei Jian - SG",
      "profilePic": "Photo_6517A1BB-3682-CF64-4CC6-8901A5778D23.jpg",
      "emailAddress": "weijian.tan@brandtology.com"
    }
  ]
}"""
    }

}

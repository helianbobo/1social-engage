package one_social_ui

class SocialAssetsController {

    def getAllAssets() {

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
    }
}

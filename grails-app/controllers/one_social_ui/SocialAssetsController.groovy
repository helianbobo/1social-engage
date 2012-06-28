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
      "accountId": "689247620",
      "pageData":
      [
        {
          "name": "Brandtology",
          "id": "104681096700",
          "likes": 732,
          "type": "facebook",
          "url": "http://www.facebook.com/brandtology",
          "pending": 0,
          "imageURL": "https://graph.facebook.com/104681096700/picture",
          "tokenExpiry": 51
        },
        {
          "name": "WJ Bank",
          "id": "322058887863626",
          "likes": 5,
          "type": "facebook",
          "url": "http://www.facebook.com/pages/WJ-Bank/322058887863626",
          "pending": 0,
          "imageURL": "https://graph.facebook.com/322058887863626/picture",
          "tokenExpiry": 51
        }
      ]
    }
  ]
}
'''
    }
}

package one_social_ui

import javax.activation.FileDataSource;
import java.io.File;
import javax.servlet.AsyncContext
import grails.converters.JSON


class AccountController {

  def index() {redirect(action: 'getAllUsers')}

  def displayPic = {
    def ds
    if(params){
        ds = new FileDataSource("/Users/leegorous/projects/privite/1social-engage/web-app/engage/images/duser.png")
        def is = ds.inputStream
        def os = response.outputStream
        response.contentLength = is.available()
        response.contentType = ds.contentType
        //set cache / pragma headers to cache image in browser?
        os << is
        os.flush()
    }
  }

  def getAllUsers() {
    render """{
  "data": 
  [
    {
      "name": "Liu Qiang - SG",
      "profilePic": "behuman.jpg",
      "id": 79,
      "emailAddress": "qiang.liu@brandtology.com"
    },
    {
      "name": "James Neal",
      "profilePic": null,
      "id": 466,
      "emailAddress": "james.neal@mediamonitors.com.au"
    },
    {
      "name": "Joshua Troy - R&D",
      "profilePic": null,
      "id": 478,
      "emailAddress": "joshuatroybrandtology@gmail.com"
    },
    {
      "name": "Cass Goh - Brandtology R&D",
      "profilePic": "super unglam zoomed.JPG",
      "id": 590,
      "emailAddress": "cass.goh@brandtology.com"
    },
    {
      "name": "Randy Globot SG-1",
      "profilePic": null,
      "id": 608,
      "emailAddress": "randy.globot.sg1@brandtology.com"
    },
    {
      "name": "Randy Globot SG-2",
      "profilePic": null,
      "id": 609,
      "emailAddress": "randy.globot.sg2@brandtology.com"
    },
    {
      "name": "Randy Globot SG-3",
      "profilePic": null,
      "id": 610,
      "emailAddress": "randy.globot.sg3@brandtology.com"
    },
    {
      "name": "Randy Globot AU",
      "profilePic": null,
      "id": 611,
      "emailAddress": "randy.globot.AU@brandtology.com"
    },
    {
      "name": "Randy Globot CN",
      "profilePic": null,
      "id": 612,
      "emailAddress": "randy.globot.CN@brandtology.com"
    },
    {
      "name": "Randy Globot HK",
      "profilePic": null,
      "id": 613,
      "emailAddress": "randy.globot.HK@brandtology.com"
    },
    {
      "name": "Randy Globot MY",
      "profilePic": null,
      "id": 614,
      "emailAddress": "randy.globot.MY@brandtology.com"
    },
    {
      "name": "Randy Globot ID",
      "profilePic": null,
      "id": 615,
      "emailAddress": "randy.globot.ID@brandtology.com"
    },
    {
      "name": "Randy Globot VN",
      "profilePic": null,
      "id": 616,
      "emailAddress": "randy.globot.VN@brandtology.com"
    },
    {
      "name": "Randy Globot TH",
      "profilePic": null,
      "id": 617,
      "emailAddress": "randy.globot.TH@brandtology.com"
    },
    {
      "name": "Randy Globot PH",
      "profilePic": null,
      "id": 618,
      "emailAddress": "randy.globot.PH@brandtology.com"
    },
    {
      "name": "Randy Globot US",
      "profilePic": null,
      "id": 619,
      "emailAddress": "randy.globot.US@brandtology.com"
    },
    {
      "name": "Randy Globot UK",
      "profilePic": null,
      "id": 620,
      "emailAddress": "randy.globot.UK@brandtology.com"
    },
    {
      "name": "Randy Globot NZ",
      "profilePic": null,
      "id": 621,
      "emailAddress": "randy.globot.NZ@brandtology.com"
    },
    {
      "name": "Randy Globot JP",
      "profilePic": null,
      "id": 622,
      "emailAddress": "randy.globot.JP@brandtology.com"
    },
    {
      "name": "Randy Globot KR",
      "profilePic": null,
      "id": 623,
      "emailAddress": "randy.globot.KR@brandtology.com"
    },
    {
      "name": "Lane Cipriani",
      "profilePic": null,
      "id": 637,
      "emailAddress": "Lane.Cipriani@sentiamedia.com"
    },
    {
      "name": "Media Monitors Michael Bade",
      "profilePic": null,
      "id": 638,
      "emailAddress": "michael.bade@sentiamedia.com"
    },
    {
      "name": "Su Yuen",
      "profilePic": null,
      "id": 646,
      "emailAddress": "suyuen@mokomomo.com"
    },
    {
      "name": "Liu Chao - Test",
      "profilePic": null,
      "id": 647,
      "emailAddress": "liuchao36@gmail.com"
    },
    {
      "name": "Jason Lim",
      "profilePic": null,
      "id": 684,
      "emailAddress": "yuenhoe@mokomomo.com"
    },
    {
      "name": "Randy Globot TV",
      "profilePic": null,
      "id": 723,
      "emailAddress": "randy.globot.tv@brandtology.com"
    },
    {
      "name": "Tychogrouwstra",
      "profilePic": null,
      "id": 1139,
      "emailAddress": "tychogrouwstra@gmail.com"
    }
  ]
}"""
  }

}

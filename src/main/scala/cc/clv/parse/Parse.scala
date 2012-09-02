package cc.clv.parse

import cc.clv.parse.config._
import jp.sf.amateras.scala.util.Imports._
import jp.sf.amateras.scala.util.http.SimpleHttpClient

class Parse(val config: ParseConfig) {
  val parseAPIRoot = "https://api.parse.com"
  val requestHeaders = Map(
    "X-Parse-Application-Id" -> config.appId,
    "X-Parse-REST-API-Key" -> config.restAPIKey,
    "Content-Type" -> "application/json"
  )
  
  def getObjects(name: String) = {
    using (new SimpleHttpClient){ client =>
      val content: Option[String] = client.get(
        url = parseAPIRoot + "/1/classes/" + name,
        headers = requestHeaders
      )
      content match {
        case Some(s) => s
        case None => None
      }
    }
  }
}

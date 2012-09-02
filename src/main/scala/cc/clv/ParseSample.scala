package cc.clv

import java.io.File
import com.twitter.util.Eval
import cc.clv.parse.Parse
import cc.clv.parse.config.ParseConfig

object ParseSample extends App {
  val configFileName = "config/config.scala"
  val configFile = new File(configFileName)
  val eval = new Eval
  val config = eval[ParseConfig](configFile)
  
  val parse = new Parse(config)
  
  println(parse.getObjects("Player"))
}

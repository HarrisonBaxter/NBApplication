/**
  * Created by Administrator on 13/06/2016.
  */
import scala.io.Source
Source.fromFile("C:\\Users\\Administrator\\Documents\\Book1.csv").getLines.map(_.split(";")).count(_ => true)
object Stage1 {
  def main(args: Array[String]) {

  }
}

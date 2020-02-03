/*
import scala.collection.mutable.{HashSet, HashMap}

class PairWrapper(var pair:(BigInt, BigInt)) {
  def +(otherpair:(Int, Int)) = (pair._1 + otherpair._1, pair._2 + otherpair._2)
}
object PairWrapper {
  def apply(pair:(BigInt, BigInt)) = new PairWrapper(pair)
}

class Ant() {
  implicit def pair_has_utility(pair:(BigInt, BigInt)) = new PairWrapper(pair)
  var direction = 0
  var point = (BigInt(0), BigInt(0))
  def step = (math.sin(direction * math.Pi / 2).toInt, math.cos(direction * math.Pi / 2).toInt)
  def walk() {
    point = point + step
  }
  def turn(side:Int) {
    direction = (direction + side) % 4
  }
}
class Grid {
  val grid = new HashSet[Pair[BigInt, BigInt]]
  def color(point:Pair[BigInt, BigInt]) = if (grid.contains(point)) -1 else 1
  def flipColor(point:Pair[BigInt, BigInt]) = if (grid.contains(point)) grid -= point else grid += point
}

object __349 {
  def main(args:Array[String]) {
    val ant = new Ant()
    val grid = new Grid()
    grid.flipColor(ant.point)
    
  }
}
*/

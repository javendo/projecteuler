import scala.collection.immutable.HashSet
import scala.collection.mutable.ListBuffer

class PairWrapper(var pair:(BigInt, BigInt)) {
  def +(otherpair:(Int, Int)) = (pair._1 + otherpair._1, pair._2 + otherpair._2)
}

object PairWrapper {
  def apply(pair:(BigInt, BigInt)) = new PairWrapper(pair)
}

class Langton {
  var grid = new HashSet[(BigInt, BigInt)]
  var point = (BigInt(0), BigInt(0))
  var patternList = ListBuffer[Int]()
  var direction = 0
  var pattern = 0
  def move = {
    pattern = Langton.side(grid, point)
    patternList += pattern
    direction = Langton.turn(direction, Langton.side(grid, point))
    grid = Langton.changeColor(grid, point)
    point = Langton.walk(point, direction)
  }
}

object Langton {
  implicit def pairHasUtility(pair:(BigInt, BigInt)) = new PairWrapper(pair)
  def walk(p:(BigInt, BigInt), direction:Int) = p + (math.sin(direction * math.Pi / 2).toInt, math.cos(direction * math.Pi / 2).toInt)
  def turn(direction:Int, side:Int) = (direction + side) % 4
  def side(grid:HashSet[(BigInt, BigInt)], point:(BigInt, BigInt)) = if (grid.contains(point)) 1 else -1
  def changeColor(grid: HashSet[(BigInt, BigInt)], point: (BigInt, BigInt)) = if (grid.contains(point)) grid - point else grid + point
}

object _349 {
  def main(args: Array[String]) {
    val langton = new Langton()
    val begin = BigInt(1)
    var end = BigInt(10).pow(5)
    for (i <- (begin to end).view)
      langton.move
    println(langton.grid.size)
  }
}

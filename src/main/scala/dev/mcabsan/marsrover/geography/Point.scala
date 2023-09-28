package dev.mcabsan.marsrover.geography

case class Point(x: Int, y: Int) {
  def sum(vector: Vector): Point = Point(x + vector.x, y + vector.y)
}

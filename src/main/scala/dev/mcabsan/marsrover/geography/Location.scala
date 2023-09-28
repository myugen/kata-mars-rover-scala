package dev.mcabsan.marsrover.geography

case class Location(point: Point, direction: Direction)

object Location {
  def of(x: Int, y: Int, direction: Direction): Location = Location(Point(x, y), direction)
}

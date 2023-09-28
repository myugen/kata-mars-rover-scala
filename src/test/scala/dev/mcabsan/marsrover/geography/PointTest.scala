package dev.mcabsan.marsrover.geography

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PointTest extends AnyFlatSpec with Matchers {

    "Point" should "sum a vector" in {
      val point = Point(0, 0)
      val newPoint = point.sum(Vector(0, 1))

      newPoint should be(Point(0, 1))
    }
}
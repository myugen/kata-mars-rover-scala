package dev.mcabsan.marsrover.geography

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DirectionTest extends AnyFlatSpec with Matchers {

  "Direction" should "return the correct direction that exists on its left" in {
    North.onLeft should be(West)
    West.onLeft should be(South)
    South.onLeft should be(East)
    East.onLeft should be(North)
  }

  it should "return the correct direction that exists on its right" in {
    North.onRight should be(East)
    East.onRight should be(South)
    South.onRight should be(West)
    West.onRight should be(North)
  }

  it should "return the correct applicable vector" in {
    North.applicableVector should be(Vector(0, 1))
    East.applicableVector should be(Vector(1, 0))
    South.applicableVector should be(Vector(0, -1))
    West.applicableVector should be(Vector(-1, 0))
  }
}

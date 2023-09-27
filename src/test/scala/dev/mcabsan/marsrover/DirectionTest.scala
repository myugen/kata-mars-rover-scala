package dev.mcabsan.marsrover

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DirectionTest extends AnyFlatSpec with Matchers {

  "Direction" should "return the correct direction when turning left" in {
    North.onLeft should be(West)
    West.onLeft should be(South)
    South.onLeft should be(East)
    East.onLeft should be(North)
  }

  it should "return the correct direction when turning right" in {
    North.onRight should be(East)
    East.onRight should be(South)
    South.onRight should be(West)
    West.onRight should be(North)
  }
}

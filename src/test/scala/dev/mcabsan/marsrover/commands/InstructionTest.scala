package dev.mcabsan.marsrover.commands

import dev.mcabsan.marsrover.geography.{East, Location, North, South, West}
import org.scalatest.EitherValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class InstructionTest extends AnyFlatSpec with Matchers with EitherValues {

    "Instruction" should "parse a valid char" in {
      Instruction.of('L').value should be(TurnLeft)
      Instruction.of('R').value should be(TurnRight)
      Instruction.of('F').value should be(MoveForward)
    }

    it should "fail to parse an invalid char" in {
      Instruction.of('X').left.value.reason should be("Invalid instruction: X")
    }

    "TurnRight" should "calculate new location" in {
      TurnRight.calculate(Location.of(0, 0, North)) should be(Location.of(0, 0, East))
      TurnRight.calculate(Location.of(0, 0, East)) should be(Location.of(0, 0, South))
      TurnRight.calculate(Location.of(0, 0, South)) should be(Location.of(0, 0, West))
      TurnRight.calculate(Location.of(0, 0, West)) should be(Location.of(0, 0, North))
    }

    "TurnLeft" should "calculate new location" in {
      TurnLeft.calculate(Location.of(0, 0, North)) should be(Location.of(0, 0, West))
      TurnLeft.calculate(Location.of(0, 0, West)) should be(Location.of(0, 0, South))
      TurnLeft.calculate(Location.of(0, 0, South)) should be(Location.of(0, 0, East))
      TurnLeft.calculate(Location.of(0, 0, East)) should be(Location.of(0, 0, North))
    }
    
    "MoveForward" should "calculate new location" in {
      MoveForward.calculate(Location.of(0, 0, North)) should be(Location.of(0, 1, North))
      MoveForward.calculate(Location.of(0, 0, West)) should be(Location.of(-1, 0, West))
      MoveForward.calculate(Location.of(0, 0, South)) should be(Location.of(0, -1, South))
      MoveForward.calculate(Location.of(0, 0, East)) should be(Location.of(1, 0, East))
    }
}

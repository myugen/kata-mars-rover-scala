package dev.mcabsan.marsrover.commands

import dev.mcabsan.marsrover.geography.{Location, North, West}
import org.scalatest.EitherValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CommandTest extends AnyFlatSpec with Matchers with EitherValues {
  "Command" should "parse a valid command into instruction" in {
    val command = Command.of("LR")

    command.value.instructions should contain theSameElementsInOrderAs List(TurnLeft, TurnRight)
  }

  it should "fail to parse an invalid command" in {
    val command = Command.of("LX")

    command.left.value.reason should be("Invalid command")
    command.left.value.details should be(Seq("Invalid instruction: X"))
  }

  it should "execute instructions for provided location" in {
    val command = Command.of("LLRF")

    val location = Location.of(0, 0, North)
    val newLocation = command.value.execute(location)

    newLocation should be(Location.of(-1, 0, West))
  }
}

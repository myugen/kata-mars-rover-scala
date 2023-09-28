package dev.mcabsan.marsrover

import dev.mcabsan.marsrover.commands.Command
import dev.mcabsan.marsrover.geography.{Location, North, Point, West}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MarsRoverTest extends AnyFlatSpec with Matchers {

  "MarsRover" should "land in initial location" in {
    val rover = MarsRover.land(Location.of(0, 0, North))

    rover.locatedIn should be(Location(Point(0, 0), North))
  }
  
  it should "execution a command" in {
    val rover = MarsRover.land(Location.of(0, 0, North))
    val errorOrCommand = Command.of("LFFRRRFFFLLF")

    rover.execute(errorOrCommand.toOption.get)

    rover.locatedIn should be(Location.of(-2, -2, North))
  }
}

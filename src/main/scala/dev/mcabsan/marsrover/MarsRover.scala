package dev.mcabsan.marsrover

import dev.mcabsan.marsrover.commands.Command
import dev.mcabsan.marsrover.geography.Location

class MarsRover private(initialLocation: Location) {
  private var location: Location = initialLocation

  def locatedIn: Location = location

  def execute(command: Command): Unit = {
    location = command.execute(location)
  }
}

object MarsRover {
  def land(initialLocation: Location): MarsRover = new MarsRover(initialLocation)
}

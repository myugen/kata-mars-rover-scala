package dev.mcabsan.marsrover.commands

import dev.mcabsan.marsrover.geography.Location

case class Command private(instructions: List[Instruction]) {
  def execute(currentLocation: Location): Location = instructions.foldLeft(currentLocation) { (location, instruction) =>
    instruction.calculate(location)
  }
}

object Command {
  def of(entryInstructions: String): Either[InvalidCommand, Command] =
    entryInstructions.map(Instruction.of).toList.partitionMap(identity) match
      case (errors, commands) if errors.isEmpty => Right(Command(commands))
      case (errors, _) => Left(InvalidCommand("Invalid command", errors.map(_.reason)))
}

case class InvalidCommand(reason: String, details: Seq[String])

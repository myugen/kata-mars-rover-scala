package dev.mcabsan.marsrover.commands

import dev.mcabsan.marsrover.geography.Location

sealed trait Instruction {
  def calculate(location: Location): Location
}

object Instruction {
  def of (instruction: Char): Either[InvalidInstruction, Instruction] = {
    instruction.toUpper match {
      case 'R' => Right(TurnRight)
      case 'L' => Right(TurnLeft)
      case 'F' => Right(MoveForward)
      case _ => Left(InvalidInstruction.of(instruction))
    }
  }
}

case object TurnRight extends Instruction {
  override def calculate(location: Location): Location = location.copy(direction = location.direction.onRight)
}

case object TurnLeft extends Instruction {
  override def calculate(location: Location): Location = location.copy(direction = location.direction.onLeft)
}

case object MoveForward extends Instruction {
  override def calculate(location: Location): Location = location.copy(point = location.point.sum(location.direction.applicableVector))
}

case class InvalidInstruction private(reason: String)

object InvalidInstruction {
  def of(instruction: Char): InvalidInstruction = InvalidInstruction(s"Invalid instruction: $instruction")
}

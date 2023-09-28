package dev.mcabsan.marsrover.geography

sealed trait Direction {
  def onLeft: Direction
  def onRight: Direction
  def applicableVector: Vector
}

case object North extends Direction {
  override def onLeft: Direction = West
  override def onRight: Direction = East
  override def applicableVector: Vector = Vector(0, 1)
}

case object East extends Direction {
  override def onLeft: Direction = North
  override def onRight: Direction = South
  override def applicableVector: Vector = Vector(1, 0)
}

case object South extends Direction {
  override def onLeft: Direction = East
  override def onRight: Direction = West
  override def applicableVector: Vector = Vector(0, -1)
}

case object West extends Direction {
  override def onLeft: Direction = South
  override def onRight: Direction = North
  override def applicableVector: Vector = Vector(-1, 0)
}

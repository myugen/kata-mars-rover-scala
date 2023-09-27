package dev.mcabsan.marsrover

sealed trait Direction {
  def onLeft: Direction
  def onRight: Direction
}

case object North extends Direction {
  override def onLeft: Direction = West
  override def onRight: Direction = East
}

case object East extends Direction {
  override def onLeft: Direction = North
  override def onRight: Direction = South
}

case object South extends Direction {
  override def onLeft: Direction = East
  override def onRight: Direction = West
}

case object West extends Direction {
  override def onLeft: Direction = South
  override def onRight: Direction = North
}

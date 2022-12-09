package domain.image

import domain.grid.{CharGrid, Grid}


class AsciiImage (var grid: CharGrid) extends Image[Char]{
  override def getGrid: CharGrid = grid
  def getWidth: Int = grid.width
  def getHeight: Int = grid.height
  override def getElement(x: Int, y: Int): Char = {
    grid.getElement(x, y)
  }
}

package domain.image

import domain.grid.{CharGrid, Grid}


class AsciiImage (var charGrid: CharGrid) extends Image[Char]{
  def getGrid: CharGrid = charGrid
  def getWidth: Int = charGrid.width
  def getHeight: Int = charGrid.height
}

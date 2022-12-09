package domain.image

import domain.grid.Grid
import domain.pixel.Pixel

trait Image[T] {
  def getGrid: Grid[T]

  def getElement(x: Int, y: Int): T = getGrid.getElement(x, y)
}

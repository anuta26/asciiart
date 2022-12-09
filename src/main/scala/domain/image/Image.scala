package domain.image

import domain.grid.Grid
import domain.pixel.Pixel

trait Image [T] {
  def getGrid: Grid[T]
}

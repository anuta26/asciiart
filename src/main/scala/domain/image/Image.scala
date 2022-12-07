package domain.image

import domain.image.grid.Grid

trait Image[T] {
  def getGrid: Grid[T]
}

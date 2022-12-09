package domain.image

import domain.grid.Grid

/** Image which has pixels of type T
 *
 * @tparam T type of pixels
 */
trait Image[T] {
  def getGrid: Grid[T]
  def getElement(x: Int, y: Int): T = getGrid.getElement(x, y)
}

package domain.image

import domain.grid.PixelGrid
import domain.pixel.Pixel

/** Image which has pixels of type T
 *
 * @tparam T type of pixels
 */
trait Image[T <: Pixel] {
  def getGrid: PixelGrid[T]
  def getElement(x: Int, y: Int): T = getGrid.getElement(x, y)
}

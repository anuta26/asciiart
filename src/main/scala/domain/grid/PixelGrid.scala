package domain.grid

import domain.pixel.Pixel

/** Grid of type T
 *
 * @tparam T type of grid elements
 */
trait PixelGrid[T <: Pixel] {
  def getElement(x: Int, y: Int): T
  def width: Int
  def height: Int
}

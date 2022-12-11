package domain.image

import domain.grid.AsciiPixelGrid
import domain.pixel.AsciiPixel

/** Image with Ascii pixels
 *
 * @param grid grid of Ascii pixels
 */
class AsciiImage (var grid: AsciiPixelGrid) extends Image[AsciiPixel]{
  override def getGrid: AsciiPixelGrid = grid
  def getWidth: Int = grid.width
  def getHeight: Int = grid.height
  override def getElement(x: Int, y: Int): AsciiPixel = {
    grid.getElement(x, y)
  }
}

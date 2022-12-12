package domain.image

import domain.grid.GreyscalePixelGrid
import domain.pixel.GreyscalePixel

/** Image with greyscale pixels
 *
 * @param grid grid of greyscale pixels
 */
class GreyscaleImage (private var grid: GreyscalePixelGrid) extends Image[GreyscalePixel]{
  override def getGrid: GreyscalePixelGrid = grid
  def getWidth: Int = grid.width
  def getHeight: Int = grid.height
  override def getElement(x: Int, y: Int): GreyscalePixel = {
    grid.getElement(x,y)
  }
}

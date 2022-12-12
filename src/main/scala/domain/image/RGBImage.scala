package domain.image

import domain.grid.RGBPixelGrid
import domain.pixel.RGBPixel

/** Image with RGB pixels
 *
 * @param grid grid of rgb pixels
 */
class RGBImage(private var grid: RGBPixelGrid) extends Image[RGBPixel]{
  override def getGrid: RGBPixelGrid = grid
  def getHeight: Int = grid.height
  def getWidth: Int = grid.width
  override def getElement(x: Int, y: Int): RGBPixel = {
    grid.getElement(x,y)
  }
}

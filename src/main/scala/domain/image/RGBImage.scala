package domain.image

import domain.grid.RGBPixelGrid
import domain.pixel.RGBPixel

/** Image with RGB pixels
 *
 * @param grid grid of rgb pixels
 */
class RGBImage(var grid: RGBPixelGrid) extends Image[RGBPixel]{
  override def getGrid: RGBPixelGrid = grid
  def getWidth: Int = grid.width
  def getHeight: Int = grid.height
  override def getElement(x: Int, y: Int): RGBPixel = {
    grid.getElement(x,y)
  }
}

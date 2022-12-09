package domain.image

import domain.grid.PixelGrid
import domain.pixel.RGBPixel

class RGBImage(var grid: PixelGrid) extends Image[RGBPixel]{
  override def getGrid: PixelGrid = grid
  def getWidth: Int = grid.width
  def getHeight: Int = grid.height
  override def getElement(x: Int, y: Int): RGBPixel = {
    grid.getElement(x,y)
  }
}

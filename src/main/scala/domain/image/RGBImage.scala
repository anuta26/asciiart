package domain.image

import domain.grid.PixelGrid
import domain.pixel.RGBPixel

class RGBImage(var pixelGrid: PixelGrid) extends Image[RGBPixel]{
  def getGrid: PixelGrid = pixelGrid
  def getWidth: Int = pixelGrid.width
  def getHeight: Int = pixelGrid.height
}

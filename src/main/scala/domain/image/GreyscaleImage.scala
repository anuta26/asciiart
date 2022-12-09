package domain.image

import domain.grid.GreyscaleGrid
import domain.pixel.GreyscalePixel

class GreyscaleImage (var grid: GreyscaleGrid) extends Image[GreyscalePixel]{
  override def getGrid: GreyscaleGrid = grid
  def getWidth: Int = grid.width
  def getHeight: Int = grid.height
  override def getElement(x: Int, y: Int): GreyscalePixel = {
    grid.getElement(x,y)
  }
}

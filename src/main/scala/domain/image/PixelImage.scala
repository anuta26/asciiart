package domain.image

import domain.image.grid.PixelGrid

class PixelImage(var pixelGrid: PixelGrid) extends Image[Pixel]{
  def getGrid: PixelGrid = pixelGrid
  def getWidth: Int = pixelGrid.width
  def getHeight: Int = pixelGrid.height
}

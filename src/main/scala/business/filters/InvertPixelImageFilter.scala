package business.filters

import domain.grid.PixelGrid
import domain.image.RGBImage
import domain.pixel.RGBPixel

class InvertPixelImageFilter extends PixelImageFilter {
  override def apply(image: RGBImage): RGBImage = {
    for {
      y <- 0 until image.getHeight
      x <- 0 until image.getWidth
    } {
      val greyscale = image.getGrid.getElement(x, y).greyscale
      image.getGrid.getElement(x, y).setGreyscale(255 - greyscale)
    }
    image
  }

}

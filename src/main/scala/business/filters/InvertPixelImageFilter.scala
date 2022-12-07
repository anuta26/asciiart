package business.filters

import domain.image.grid.PixelGrid
import domain.image.{Pixel, PixelImage}

class InvertPixelImageFilter extends PixelImageFilter {
  override def apply(image: PixelImage): PixelImage = {
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

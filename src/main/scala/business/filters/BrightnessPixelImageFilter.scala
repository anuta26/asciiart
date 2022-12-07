package business.filters

import domain.image.grid.PixelGrid
import domain.image.{Pixel, PixelImage}

class BrightnessPixelImageFilter(value: Int) extends PixelImageFilter {
  override def apply(image: PixelImage): PixelImage = {
    for {
      y <- 0 until image.getHeight
      x <- 0 until image.getWidth
    } {
      var greyscale = image.getGrid.getElement(x, y).greyscale
      greyscale += value
      if (greyscale > 255) {
        greyscale = 255
      }
      if (greyscale < 0) {
        greyscale = 0
      }
      image.getGrid.getElement(x, y).setGreyscale(greyscale)
    }
    image
  }

}

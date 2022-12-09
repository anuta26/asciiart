package business.filters

import domain.grid.PixelGrid
import domain.image.{GreyscaleImage, RGBImage}
import domain.pixel.RGBPixel

class BrightnessGreyscaleImageFilter(value: Int) extends GreyscaleImageFilter {
  override def apply(image: GreyscaleImage): GreyscaleImage = {
    for {
      y <- 0 until image.getHeight
      x <- 0 until image.getWidth
    } {
      var greyscale = image.getElement(x, y).getGreyscale
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

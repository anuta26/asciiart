package business.filters

import domain.grid.PixelGrid
import domain.image.RGBImage
import domain.pixel.RGBPixel

class BrightnessPixelImageFilter(value: Int) extends PixelImageFilter {
  override def apply(image: RGBImage): RGBImage = {
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

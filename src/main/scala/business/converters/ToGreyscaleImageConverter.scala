package business.converters

import domain.grid.GreyscaleGrid
import domain.image.{GreyscaleImage, RGBImage}
import domain.pixel.GreyscalePixel

class ToGreyscaleImageConverter extends ImageConverter [RGBImage, GreyscaleImage]{
  def convert(image: RGBImage): GreyscaleImage = {
    val pixels = Array.ofDim[GreyscalePixel](image.getHeight, image.getWidth)
    for (y <- 0 until image.getHeight; x <- 0 until image.getWidth) {
      val rgbPixel = image.getElement(x,y)
      pixels(y)(x) = new GreyscalePixel(0.3 * rgbPixel.red + 0.59 * rgbPixel.green + 0.11 * rgbPixel.blue)
    }
    new GreyscaleImage(new GreyscaleGrid(pixels))
  }
}

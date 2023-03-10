package business.converters

import domain.grid.GreyscalePixelGrid
import domain.image.{GreyscaleImage, RGBImage}
import domain.pixel.GreyscalePixel

/** Converter which converts RGBImage to GreyscaleImage
 *
 */
class ToGreyscaleImageConverter
    extends ImageConverter[RGBImage, GreyscaleImage] {
  /** Converts all rgb pixels to greyscale pixels using formula:
   *  0.3 * red + 0.59 * green + 0.11 * blue
   *
   * @param image image to convert
   *  @return result image
   */
  def convert(image: RGBImage): GreyscaleImage = {
    val pixels = Array.ofDim[GreyscalePixel](image.getHeight, image.getWidth)
    for {
      x <- 0 until image.getHeight
      y <- 0 until image.getWidth
    } {
      val rgbPixel = image.getElement(x, y)
      pixels(x)(y) = new GreyscalePixel(
        0.3 * rgbPixel.red + 0.59 * rgbPixel.green + 0.11 * rgbPixel.blue)
    }
    new GreyscaleImage(new GreyscalePixelGrid(pixels.map(array => array.toSeq)))
  }
}

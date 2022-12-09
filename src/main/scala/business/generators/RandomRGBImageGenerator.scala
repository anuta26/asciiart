package business.generators

import domain.grid.RGBPixelGrid
import domain.image.RGBImage
import domain.pixel.RGBPixel

/** Generator which generates RGB image
 *
 */
class RandomRGBImageGenerator extends RandomImageGenerator[RGBImage] {

  /**
   *
   *  @return generated RGB image
   */
  def generate(): RGBImage = {
    val r = scala.util.Random

    //image dimension
    val width = r.between(200, 800)
    val height = r.between(200, 800)
    val pixels = Array.ofDim[RGBPixel](height, width)

    //fill the pixels
    for {
      y <- 0 until height
      x <- 0 until width
    } {
      val red = (Math.random * 256).toInt
      val green = (Math.random * 256).toInt
      val blue = (Math.random * 256).toInt
      pixels(y)(x) = new RGBPixel(red, green, blue)
    }

    new RGBImage(new RGBPixelGrid(pixels.map(array => array.toSeq)))
  }

}

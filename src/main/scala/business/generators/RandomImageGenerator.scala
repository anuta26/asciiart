package business.generators

import domain.grid.PixelGrid
import domain.image.RGBImage
import domain.pixel.RGBPixel

class RandomImageGenerator extends ImageGenerator {

  def generate(): RGBImage = {
    val r = scala.util.Random
    //image dimension
    val width = r.between(200, 800)
    val height = r.between(200, 800)
    val pixels = Array.ofDim[RGBPixel](height, width)
    print(pixels.length + " " + pixels(0).length + "\n")
    for (y <- 0 until height; x <- 0 until width) {
      val r = (Math.random * 256).toInt //red
        val g = (Math.random * 256).toInt //green
        val b = (Math.random * 256).toInt //blue
        pixels(y)(x) = new RGBPixel(r, g, b)
    }
    new RGBImage(new PixelGrid(pixels))
  }

}

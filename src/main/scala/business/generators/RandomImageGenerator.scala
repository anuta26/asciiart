package business.generators

import domain.image.grid.PixelGrid
import domain.image.{PixelImage, Pixel}

class RandomImageGenerator extends ImageGenerator {

  def generate(): PixelImage = {
    val r = scala.util.Random
    //image dimension
    val width = r.between(200, 800)
    val height = r.between(200, 800)
    val pixels = Array.ofDim[Pixel](height, width)
    print(pixels.length + " " + pixels(0).length + "\n")
    for (y <- 0 until height; x <- 0 until width) {
      val r = (Math.random * 256).toInt //red
        val g = (Math.random * 256).toInt //green
        val b = (Math.random * 256).toInt //blue
        pixels(y)(x) = new Pixel(r, g, b)
    }
    new PixelImage(new PixelGrid(pixels))
  }

}

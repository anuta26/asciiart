package business.loaders

import business.generators.RandomImageGenerator
import domain.grid.PixelGrid
import domain.image.RGBImage
import domain.pixel.RGBPixel

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.{File, FileNotFoundException, IOException}
import javax.imageio.ImageIO

class ImageFilePngJpgLoader extends ImageLoader[String] {
  def load(path: String): RGBImage = {
    var image: BufferedImage = null
    try {
      val inputFile = new File(path)
      if (!inputFile.isFile)
        throw new IllegalArgumentException(s"File $path does not exist.")
      image = ImageIO.read(inputFile)
    }
    catch {
      case ex: FileNotFoundException =>
        println("Cannot open file.")


      case ex: IOException =>
        println("Exception while reading from file.")

    }

    val pixels = Array.ofDim[RGBPixel](image.getHeight, image.getWidth)
    for (y <- 0 until image.getHeight)
      for (x <- 0 until image.getWidth) {
        val color = new Color(image.getRGB(x, y))
        pixels(y)(x) = new RGBPixel(color.getRed, color.getGreen, color.getBlue)
      }

    val pixelGrid = new PixelGrid(pixels)
    new RGBImage(pixelGrid)
  }


}

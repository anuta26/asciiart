package business.loaders

import business.generators.RandomImageGenerator
import domain.image.grid.PixelGrid
import domain.image.{Pixel, PixelImage}

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.{File, FileNotFoundException, IOException}
import javax.imageio.ImageIO

class ImageFilePngJpgLoader extends ImageLoader[String] {
  def load(path: String): PixelImage = {
    var image: BufferedImage = null
    try {
      val inputFile = new File(path)
      if (!inputFile.isFile)
        throw new IllegalArgumentException(s"File $path does not exist.")
      image = ImageIO.read(inputFile)
    }
    catch {
      case ex: FileNotFoundException => {
        println("Cannot open file.")
      }

      case ex: IOException => {
        println("Exception while reading from file.")
      }
    }

    val pixels = Array.ofDim[Pixel](image.getHeight, image.getWidth)
    for (y <- 0 until image.getHeight)
      for (x <- 0 until image.getWidth) {
        val color = new Color(image.getRGB(x, y))
        pixels(y)(x) = new Pixel(color.getRed, color.getGreen, color.getBlue)
      }

    val pixelGrid = new PixelGrid(pixels)
    new PixelImage(pixelGrid)
  }


}

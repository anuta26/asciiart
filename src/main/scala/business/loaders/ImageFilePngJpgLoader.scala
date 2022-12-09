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
    val format: String = path.substring(path.length - 3, path.length)
    if ( format != "jpg" && format != "png") {
      throw new IllegalArgumentException("Wrong format of input file.")
    }

    val inputFile = new File(path)
    if (!inputFile.isFile)
      throw new IllegalArgumentException(s"File $path does not exist.")

    val image: BufferedImage = ImageIO.read(inputFile)

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

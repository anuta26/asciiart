package business.loaders

import domain.grid.RGBPixelGrid
import domain.image.RGBImage
import domain.pixel.RGBPixel

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/** Loader which loads rgb image from .png or .jpg file
 *
 */
class RGBImageFilePngJpgLoader extends RGBImageLoader[String] {
  /** Loads image
   *
   * @param path path to file from which image will be loaded
   *  @return loaded image
   */
  def load(path: String): RGBImage = {
    val format: String = path.substring(path.length - 3, path.length)
    if (format != "jpg" && format != "png")
      throw new IllegalArgumentException("Wrong format of input file.")

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

    val pixelGrid = new RGBPixelGrid(pixels.map(array => array.toSeq))
    new RGBImage(pixelGrid)
  }

}

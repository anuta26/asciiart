package business.loaders.images

import domain.grid.RGBPixelGrid
import domain.image.RGBImage
import domain.pixel.RGBPixel

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/** Loader which loads rgb image from file
 *
 * @param path path to file from which image will be loaded
 */
class RGBImageFileLoader(path: String) extends RGBImageLoader{

  /** Loads image
   *
   * @return loaded image
   */
  def load(): RGBImage = {
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

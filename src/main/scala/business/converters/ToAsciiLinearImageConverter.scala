package business.converters

import domain.grid.AsciiPixelGrid
import domain.image.{AsciiImage, GreyscaleImage}
import domain.pixel.AsciiPixel
import domain.tables.LinearConversionTable

/** Converter which converts GreyscaleImage to AsciiImage using linear table
 *
 * @param table linear conversion table which will be used for converting
 */
class ToAsciiLinearImageConverter(table: LinearConversionTable)
    extends ToAsciiImageConverter[LinearConversionTable] {

  /**
   *
   * @param image image to convert
   *  @return result image
   */
  def convert(image: GreyscaleImage): AsciiImage = {
    val chars = Array.ofDim[AsciiPixel](image.getHeight, image.getWidth)
    val lengthOfTable = table.getSymbols.length
    for {
      y <- 0 until image.getHeight
      x <- 0 until image.getWidth
    } chars(y)(x) = new AsciiPixel(
      table.getSymbols(
        (image.getElement(x, y).getGreyscale / (256.0 / lengthOfTable)).toInt))
    new AsciiImage(new AsciiPixelGrid(chars.map(array => array.toSeq)))
  }

}

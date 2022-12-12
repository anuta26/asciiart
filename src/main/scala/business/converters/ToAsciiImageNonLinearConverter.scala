package business.converters

import domain.grid.AsciiPixelGrid
import domain.image.{AsciiImage, GreyscaleImage}
import domain.pixel.AsciiPixel
import domain.tables.NonLinearConversionTable

/** Converter which converts GreyscaleImage to AsciiImage using non-linear table
 *
 * @param table non-linear conversion table which will be used for converting
 */
class ToAsciiImageNonLinearConverter(table: NonLinearConversionTable)
    extends ToAsciiImageConverter[NonLinearConversionTable] {

  /**
   *
   * @param image image to convert
   *  @return result image
   */
  def convert(image: GreyscaleImage): AsciiImage = {
    val chars = Array.ofDim[AsciiPixel](image.getHeight, image.getWidth)
    val lengthOfTable = table.getSymbols.length

    // greyscale from 0 to range will be converted to the first symbol of the conversion table
    for (x <- 0 until image.getHeight)
      for (y <- 0 until image.getWidth){
        if (image.getElement(x, y).getGreyscale < table.getRange)
          chars(x)(y) = new AsciiPixel(table.getSymbols(0))
        else
          chars(x)(y) = new AsciiPixel(table.getSymbols(((image
            .getElement(x, y)
            .getGreyscale - table.getRange) / ((256.0 - table.getRange) / (lengthOfTable - 1))).toInt + 1))
      }
    new AsciiImage(new AsciiPixelGrid(chars.map(array => array.toSeq)))
  }
}

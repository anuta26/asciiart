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
    val chars = Array.ofDim[AsciiPixel](image.getWidth, image.getHeight)
    val lengthOfTable = table.getSymbols.length
    for (x <- 0 until image.getWidth) {
      for(y <- 0 until image.getHeight){

     chars(x)(y) = new AsciiPixel(
      table.getSymbols(
        (image.getElement(x, y).getGreyscale / (256.0 / lengthOfTable)).toInt))}}
    new AsciiImage(new AsciiPixelGrid(chars.map(array => array.toSeq)))
  }

}

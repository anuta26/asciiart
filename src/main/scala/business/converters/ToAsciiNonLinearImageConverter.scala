package business.converters

import domain.grid.CharGrid
import domain.image.{AsciiImage, GreyscaleImage}
import domain.tables.NonLinearConversionTable

class ToAsciiNonLinearImageConverter(table: NonLinearConversionTable) extends ToAsciiImageConverter [NonLinearConversionTable]{
  def convert(image: GreyscaleImage): AsciiImage = {
    val chars = Array.ofDim[Char](image.getHeight, image.getWidth)
    val lengthOfTable = table.getSymbols.length
    for (y <- 0 until image.getHeight; x <- 0 until image.getWidth) {
      if (image.getElement(x,y).getGreyscale < table.getRange) {
        chars(y)(x) = table.getSymbols(0)
      }
      else {
        chars(y)(x) = table.getSymbols(((image.getElement(x,y).getGreyscale - table.getRange) / ((256.0 - table.getRange) / (lengthOfTable - 1))).toInt + 1)
      }
    }
    new AsciiImage(new CharGrid(chars))
  }
}

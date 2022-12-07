package business.converters

import domain.image.grid.CharGrid
import domain.image.{AsciiImage, PixelImage}
import domain.tables.NonLinearConversionTable

class ToAsciiNonLinearConverter(table: NonLinearConversionTable) extends ToASCIIConverter [NonLinearConversionTable]{
  def convert(image: PixelImage): AsciiImage = {
    val chars = Array.ofDim[Char](image.getHeight, image.getWidth)
    val lengthOfTable = table.getSymbols.length
    for (y <- 0 until image.getHeight; x <- 0 until image.getWidth) {
      if (image.getGrid.getElement(x,y).greyscale < table.getRange) {
        chars(y)(x) = table.getSymbols(0)
      }
      else {
        chars(y)(x) = table.getSymbols(((image.getGrid.getElement(x, y).greyscale - table.getRange) / ((256.0 - table.getRange) / (lengthOfTable - 1))).toInt + 1)
      }
    }
    new AsciiImage(new CharGrid(chars))
  }
}

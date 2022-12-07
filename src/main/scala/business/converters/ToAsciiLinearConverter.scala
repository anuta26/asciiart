package business.converters

import domain.image.grid.CharGrid
import domain.image.{AsciiImage, Pixel, PixelImage}
import domain.tables.LinearConversionTable

import java.awt.Color

class ToAsciiLinearConverter(table: LinearConversionTable) extends ToASCIIConverter [LinearConversionTable]{

  def convert (image: PixelImage): AsciiImage = {
    val chars = Array.ofDim[Char](image.getHeight, image.getWidth)
    val lengthOfTable = table.getSymbols.length
    for (y <- 0 until image.getHeight; x <- 0 until image.getWidth) {
      chars(y)(x) = table.getSymbols((image.getGrid.getElement(x,y).greyscale / (256.0 / lengthOfTable)).toInt)
    }
    new AsciiImage( new CharGrid(chars))
  }

}

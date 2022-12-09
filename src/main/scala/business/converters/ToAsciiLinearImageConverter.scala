package business.converters

import domain.grid.CharGrid
import domain.image.{AsciiImage, GreyscaleImage, RGBImage}
import domain.pixel.RGBPixel
import domain.tables.LinearConversionTable

import java.awt.Color

class ToAsciiLinearImageConverter(table: LinearConversionTable) extends ToAsciiImageConverter [LinearConversionTable]{

  def convert (image: GreyscaleImage): AsciiImage = {
    val chars = Array.ofDim[Char](image.getHeight, image.getWidth)
    val lengthOfTable = table.getSymbols.length
    for (y <- 0 until image.getHeight; x <- 0 until image.getWidth) {
      chars(y)(x) = table.getSymbols((image.getElement(x,y).getGreyscale / (256.0 / lengthOfTable)).toInt)
    }
    new AsciiImage( new CharGrid(chars))
  }

}

package business.converters

import domain.image.{AsciiImage, PixelImage}
import domain.tables.{ConversionTable, LinearConversionTable, NonLinearConversionTable}

trait ToASCIIConverter[S <: ConversionTable] extends ImageConverter [PixelImage, AsciiImage] {

}

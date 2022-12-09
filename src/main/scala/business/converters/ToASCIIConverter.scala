package business.converters

import domain.image.{AsciiImage, RGBImage}
import domain.tables.{ConversionTable, LinearConversionTable, NonLinearConversionTable}

trait ToASCIIConverter[S <: ConversionTable] extends ImageConverter [RGBImage, AsciiImage] {

}

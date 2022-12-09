package business.converters

import domain.image.{AsciiImage, RGBImage}
import domain.tables.{ConversionTable, LinearConversionTable, NonLinearConversionTable}

trait ToAsciiConverter[S <: ConversionTable] extends ImageConverter [RGBImage, AsciiImage] {

}

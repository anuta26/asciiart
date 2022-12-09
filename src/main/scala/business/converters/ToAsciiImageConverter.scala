package business.converters

import domain.image.{AsciiImage, GreyscaleImage}
import domain.tables.ConversionTable

trait ToAsciiImageConverter[S <: ConversionTable] extends ImageConverter [GreyscaleImage, AsciiImage] {

}

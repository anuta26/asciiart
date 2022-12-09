package business.converters

import domain.image.{AsciiImage, GreyscaleImage}
import domain.tables.ConversionTable

/** Converter which converts GreyscaleImage to AsciiImage
 *
 * @tparam S type of conversion table which will be used for converting
 */
trait ToAsciiImageConverter[S <: ConversionTable]
    extends ImageConverter[GreyscaleImage, AsciiImage] {}

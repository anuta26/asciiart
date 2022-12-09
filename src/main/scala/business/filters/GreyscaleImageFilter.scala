package business.filters

import domain.image.GreyscaleImage

/** Filter which change Greyscale image
 *
 */
trait GreyscaleImageFilter extends ImageFilter[GreyscaleImage] {
  def apply(image: GreyscaleImage): GreyscaleImage

}

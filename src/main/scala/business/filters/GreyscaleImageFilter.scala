package business.filters

import domain.image.GreyscaleImage

trait GreyscaleImageFilter extends ImageFilter[GreyscaleImage]{
  def apply(image: GreyscaleImage): GreyscaleImage

}

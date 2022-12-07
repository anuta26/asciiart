package business.filters

import domain.image.PixelImage

trait PixelImageFilter extends ImageFilter [PixelImage]{
  def apply(image: PixelImage): PixelImage

}

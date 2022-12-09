package business.filters

import domain.image.RGBImage

trait PixelImageFilter extends ImageFilter [RGBImage]{
  def apply(image: RGBImage): RGBImage

}

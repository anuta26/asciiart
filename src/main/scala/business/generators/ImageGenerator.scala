package business.generators

import domain.image.RGBImage

trait ImageGenerator {
  def generate(): RGBImage
}

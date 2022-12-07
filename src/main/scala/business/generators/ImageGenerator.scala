package business.generators

import domain.image.PixelImage

trait ImageGenerator {
  def generate(): PixelImage
}

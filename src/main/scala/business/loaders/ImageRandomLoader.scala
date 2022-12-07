package business.loaders

import business.generators.ImageGenerator
import domain.image.PixelImage

class ImageRandomLoader extends ImageLoader[ImageGenerator] {

  def load(generator: ImageGenerator): PixelImage = {
    generator.generate()
  }

}

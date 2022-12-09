package business.loaders

import business.generators.ImageGenerator
import domain.image.RGBImage

class ImageRandomLoader extends ImageLoader[ImageGenerator] {

  def load(generator: ImageGenerator): RGBImage = {
    generator.generate()
  }

}

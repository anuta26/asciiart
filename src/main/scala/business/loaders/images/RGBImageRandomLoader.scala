package business.loaders.images

import business.generators.RandomRGBImageGenerator
import domain.image.RGBImage

/**Loader which uses random image generator
 *
 * @param generator random generator to use
 */
class RGBImageRandomLoader(generator: RandomRGBImageGenerator) extends RGBImageLoader {

  /** Loads image
   *
   *  @return loaded image
   */
  def load(): RGBImage =
    generator.generate()

}

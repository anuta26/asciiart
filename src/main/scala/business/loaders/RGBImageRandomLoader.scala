package business.loaders

import business.generators.RandomRGBImageGenerator
import domain.image.RGBImage

/**Loader which uses random image generator
 *
 * @param generator random generator to use
 */
class RGBImageRandomLoader(generator: RandomRGBImageGenerator) extends RGBImageLoader[RandomRGBImageGenerator] {

  /** Loads image
   *
   *  @return loaded image
   */
  def load(): RGBImage =
    generator.generate()

}

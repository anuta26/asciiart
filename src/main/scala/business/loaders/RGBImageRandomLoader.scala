package business.loaders

import business.generators.RandomRGBImageGenerator
import domain.image.RGBImage

/** Loader which uses random image generator
 *
 */
class RGBImageRandomLoader extends RGBImageLoader[RandomRGBImageGenerator] {

  /** Loads image
   *
   * @param generator random generator to use
   *  @return loaded image
   */
  def load(generator: RandomRGBImageGenerator): RGBImage =
    generator.generate()

}

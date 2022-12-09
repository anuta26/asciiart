package business.generators

import domain.image.RGBImage

/** Generator which generates image of type T
 *
 * @tparam T type of image to generate
 */
trait RandomImageGenerator[T] {

  /** Generates image
   *
   * @return generated image of type T
   */
  def generate(): T
}

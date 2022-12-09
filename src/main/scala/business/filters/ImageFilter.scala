package business.filters

/** Filter which change image of type T
 *
 * @tparam T type of image
 */
trait ImageFilter[T] {
  /**
   *
   * @param image image to be filtered
   * @return result image
   */
  def apply(image: T): T
}

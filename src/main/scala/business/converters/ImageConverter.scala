package business.converters

/** Converter which converts object S to object T
 *
 * @tparam S type of object which will be converted
 * @tparam T type of object to convert to
 */
trait ImageConverter[S, T] {

  /** Converts S to T
   *
   * @param input type of object to convert
   * @return converted object
   */
  def convert(input: S): T
}

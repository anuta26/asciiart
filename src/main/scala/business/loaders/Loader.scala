package business.loaders

/** Loader which load object of type T
 *
 * @tparam T type of the object to be loaded
 */
trait Loader[T] {
  /**
   *
   * @return loaded object
   */
  def load(): T

}

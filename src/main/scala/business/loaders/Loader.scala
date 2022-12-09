package business.loaders

/** Loader which load object of type T from path of type S
 *
 * @tparam S type of the path to load
 * @tparam T type of the object to be loaded
 */
trait Loader[S,T] {
  /**
   *
   * @param arg path to load
   * @return loaded object
   */
  def load(arg: S): T

}

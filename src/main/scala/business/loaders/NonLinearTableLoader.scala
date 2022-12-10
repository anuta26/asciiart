package business.loaders

import domain.tables.NonLinearConversionTable

/** Loader which loads non-linear conversion table
 *
 */
class NonLinearTableLoader(arg: String) extends TableLoader [NonLinearConversionTable] {
  /** Loads predefined non-linear conversion table
   *
   * @return loaded table
   */
  def load(): NonLinearConversionTable = {
    new NonLinearConversionTable("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ", 100)
  }

}

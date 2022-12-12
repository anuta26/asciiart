package business.loaders.tables

import business.loaders.Loader
import domain.tables.ConversionTable

/** Loader which loads conversion table of type S from path of type String
 *
 * @tparam S type of the path to load
 */
trait TableLoader[S <: ConversionTable] extends Loader[S]{
}

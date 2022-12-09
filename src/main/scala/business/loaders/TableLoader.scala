package business.loaders

import domain.tables.ConversionTable

/** Loader which loads conversion table of type S from path of type String
 *
 * @tparam S type of the path to load
 */
trait TableLoader[S <: ConversionTable] extends Loader[String,S]{
}

package business.loaders

import domain.tables.ConversionTable

trait TableLoader[S <: ConversionTable] extends Loader[String,S]{
}

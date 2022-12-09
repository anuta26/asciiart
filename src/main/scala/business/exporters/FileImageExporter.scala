package business.exporters

/** Exporter which exports ascii image to file with certain path
 *
 */
trait FileImageExporter extends AsciiImageExporter{
  def pathToFile: String
}

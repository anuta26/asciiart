package business.exporters

trait FileImageExporter extends AsciiImageExporter{
  def pathToFile: String
}

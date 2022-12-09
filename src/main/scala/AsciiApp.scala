import business.converters.{
  ToAsciiLinearImageConverter,
  ToAsciiNonLinearImageConverter,
  ToGreyscaleImageConverter
}
import business.exporters.{ConsoleImageExporter, TxtFileImageExporter}
import business.generators.RandomRGBImageGenerator
import business.loaders.{
  RGBImageFilePngJpgLoader,
  RGBImageRandomLoader,
  LinearTableLoader,
  NonLinearTableLoader
}
import domain.image.{AsciiImage, GreyscaleImage, RGBImage}
import domain.tables.{LinearConversionTable, NonLinearConversionTable}
import ui.ArgumentsParser

/** CLass which contains main commands of application and calls them in certain order
 *
 */
class AsciiApp {
  def run(args: Array[String]): Unit = {

    // parse arguments
    val argsParser = new ArgumentsParser()
    argsParser.parse(args)

    // load an image
    val rgbImage: RGBImage = argsParser.pathToLoad match {
      case "--image-random" =>
        new RGBImageRandomLoader().load(new RandomRGBImageGenerator)
      case _ =>
        new RGBImageFilePngJpgLoader().load(argsParser.pathToLoad)

    }
    var greyscaleImage: GreyscaleImage =
      new ToGreyscaleImageConverter().convert(rgbImage)

    // apply filters
    for (filter <- argsParser.filters)
      greyscaleImage = filter.apply(greyscaleImage)

    // load table
    // convert image
    val asciiImage: AsciiImage = argsParser.table match {
      case "default" | "Paul Bourkes’ table" =>
        val table: LinearConversionTable =
          new LinearTableLoader().load(argsParser.table)
        val converter: ToAsciiLinearImageConverter =
          new ToAsciiLinearImageConverter(table)
        converter.convert(greyscaleImage)

      case "non-linear" =>
        val tableLoader = new NonLinearTableLoader()
        val table: NonLinearConversionTable = tableLoader.load(argsParser.table)
        val converter: ToAsciiNonLinearImageConverter =
          new ToAsciiNonLinearImageConverter(table)
        converter.convert(greyscaleImage)
    }

    // export image
    for (output <- argsParser.outputs)
      output match {
        case "--output-console" =>
          val exporter: ConsoleImageExporter = new ConsoleImageExporter
          exporter.export(asciiImage)
        case _ =>
          val exporter: TxtFileImageExporter = new TxtFileImageExporter(output)
          exporter.export(asciiImage)
      }
  }

}

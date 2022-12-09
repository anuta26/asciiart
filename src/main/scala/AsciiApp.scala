import business.converters.{ToAsciiLinearConverter, ToAsciiNonLinearConverter}
import business.exporters.{ConsoleImageExporter, TxtFileImageExporter}
import business.filters.{InvertPixelImageFilter, RotatePixelImageFilter}
import business.generators.RandomImageGenerator
import business.loaders.{ImageFilePngJpgLoader, ImageRandomLoader, LinearTableLoader, NonLinearTableLoader}
import domain.image.{AsciiImage, RGBImage}
import domain.tables.{LinearConversionTable, NonLinearConversionTable}
import ui.ArgumentsParser

class AsciiApp {
  def run(args: Array[String]) : Unit = {

      // parse arguments
      val argsParser = new ArgumentsParser()
      argsParser.parse(args)

      // load an image
      var image: RGBImage = argsParser.pathToLoad match {
        case "--image-random" =>
          val imageLoader: ImageRandomLoader = new ImageRandomLoader
          imageLoader.load(new RandomImageGenerator)

        case _ =>
          val imageLoader: ImageFilePngJpgLoader = new ImageFilePngJpgLoader
          imageLoader.load(argsParser.pathToLoad)

      }

      // apply filters
      for (filter <- argsParser.filters) {
        image = filter.apply(image)
      }

      // load table
      // convert image
      var asciiImage: AsciiImage = argsParser.table match {
        case "default" | "Paul Bourkes’ table" =>
          val tableLoader = new LinearTableLoader()
          val table: LinearConversionTable = tableLoader.load(argsParser.table)
          val converter: ToAsciiLinearConverter = new ToAsciiLinearConverter(table)
          converter.convert(image)

        case "non-linear" =>
          val tableLoader = new NonLinearTableLoader()
          val table: NonLinearConversionTable = tableLoader.load(argsParser.table)
          val converter: ToAsciiNonLinearConverter = new ToAsciiNonLinearConverter(table)
          converter.convert(image)
      }

      // export image
      for (output <- argsParser.outputs) {
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

}

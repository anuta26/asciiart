import business.converters.{ToAsciiLinearConverter, ToAsciiNonLinearConverter}
import business.exporters.{ConsoleImageExporter, TxtFileImageExporter}
import business.filters.{InvertPixelImageFilter, RotatePixelImageFilter}
import business.generators.RandomImageGenerator
import business.loaders.{ImageFilePngJpgLoader, ImageRandomLoader, LinearTableLoader, NonLinearTableLoader}
import domain.image.{AsciiImage, PixelImage}
import domain.tables.{LinearConversionTable, NonLinearConversionTable}
import ui.parsers.ArgumentsParser
import ui.presenters.ConsolePresenter

class AsciiApp {
  def run(args: Array[String]) : Unit = {

    val presenter: ConsolePresenter = new ConsolePresenter

//    try {
      // parse arguments
      val argsParser = new ArgumentsParser();
      argsParser.parse(args)

      // load an image
      presenter.printStage("Loading image...")
      var image: PixelImage = null
      argsParser.pathToLoad match {
        case "--image-random" =>
          val imageLoader: ImageRandomLoader = new ImageRandomLoader
          image = imageLoader.load(new RandomImageGenerator)

        case _ =>
          val imageLoader: ImageFilePngJpgLoader = new ImageFilePngJpgLoader
          image = imageLoader.load(argsParser.pathToLoad)

      }

      // apply filters
      presenter.printStage("Applying filters...")
      for (filter <- argsParser.filters) {
        image = filter.apply(image)
      }

      // load table
      // convert image
      presenter.printStage("Converting image...")
      var asciiImage: AsciiImage = null
      argsParser.table match {
        case "default" | "Paul Bourkes’ table" =>
          val tableLoader = new LinearTableLoader()
          val table: LinearConversionTable = tableLoader.load(argsParser.table)
          val converter: ToAsciiLinearConverter = new ToAsciiLinearConverter(table)
          asciiImage = converter.convert(image)

        case "non-linear" =>
          val tableLoader = new NonLinearTableLoader()
          val table: NonLinearConversionTable = tableLoader.load(argsParser.table)
          val converter: ToAsciiNonLinearConverter = new ToAsciiNonLinearConverter(table)
          asciiImage = converter.convert(image)
      }

      // export image
      presenter.printStage("Exporting image...")
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
//    }
//    catch {
//      case e =>
//        presenter.printException(e)
//        presenter.printOptions()
//    }


  }

}

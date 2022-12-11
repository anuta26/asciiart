package ui

import business.converters.{ToAsciiLinearImageConverter, ToAsciiNonLinearImageConverter, ToGreyscaleImageConverter}
import business.exporters.{ConsoleImageExporter, TxtFileImageExporter}
import business.generators.RandomRGBImageGenerator
import business.loaders.{LinearTableLoader, NonLinearTableLoader, RGBImageFilePngJpgLoader, RGBImageRandomLoader}
import domain.image.{AsciiImage, GreyscaleImage, RGBImage}
import domain.tables.{LinearConversionTable, NonLinearConversionTable}

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
        new RGBImageRandomLoader(new RandomRGBImageGenerator).load()
      case _ =>
        new RGBImageFilePngJpgLoader(argsParser.pathToLoad).load()

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
          new LinearTableLoader(argsParser.table).load()
        val converter: ToAsciiLinearImageConverter =
          new ToAsciiLinearImageConverter(table)
        converter.convert(greyscaleImage)

      case "non-linear" =>
        val tableLoader = new NonLinearTableLoader(argsParser.table)
        val table: NonLinearConversionTable = tableLoader.load()
        val converter: ToAsciiNonLinearImageConverter =
          new ToAsciiNonLinearImageConverter(table)
        converter.convert(greyscaleImage)
    }

    // export image
    for (output <- argsParser.outputs)
      output match {
        case "--output-console" =>
          val exporter: ConsoleImageExporter = new ConsoleImageExporter(Console.out)
          exporter.export(asciiImage)
        case _ =>
          val exporter: TxtFileImageExporter = new TxtFileImageExporter(output)
          exporter.export(asciiImage)
      }
  }

}

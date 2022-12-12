package ui

import business.converters.{ToAsciiImageLinearConverter, ToAsciiImageNonLinearConverter, ToGreyscaleImageConverter}
import business.exporters.{ConsoleImageExporter, TxtFileImageExporter}
import business.generators.RandomRGBImageGenerator
import business.loaders.images.{RGBImageFileJpgLoader, RGBImageFilePngLoader, RGBImageRandomLoader}
import business.loaders.tables.{LinearTableLoader, NonLinearTableLoader}
import domain.image.{AsciiImage, GreyscaleImage, RGBImage}
import domain.tables.{LinearConversionTable, NonLinearConversionTable}

/** CLass which contains main commands of application and calls them in certain order
 *
 */
class AsciiApp {
  def run(args: Array[String]): Boolean = {

    // parse arguments
    val argsParser = new ArgumentsParser()
    argsParser.parse(args)

    // load an image
    val rgbImage: RGBImage = argsParser.pathToLoad match {
      case "--image-random" =>
        new RGBImageRandomLoader(new RandomRGBImageGenerator).load()
      case _ =>
        val format: String =  argsParser.pathToLoad.substring( argsParser.pathToLoad.length - 3,  argsParser.pathToLoad.length)
        format match {
          case "jpg" => new RGBImageFileJpgLoader(argsParser.pathToLoad).load()
          case "png" => new RGBImageFilePngLoader(argsParser.pathToLoad).load()
          case _ =>  throw new IllegalArgumentException("Wrong format of input file.")
        }
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
        val converter: ToAsciiImageLinearConverter =
          new ToAsciiImageLinearConverter(table)
        converter.convert(greyscaleImage)

      case "non-linear" =>
        val tableLoader = new NonLinearTableLoader()
        val table: NonLinearConversionTable = tableLoader.load()
        val converter: ToAsciiImageNonLinearConverter =
          new ToAsciiImageNonLinearConverter(table)
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

    true
  }

}

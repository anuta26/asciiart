import ui.parsers.ArgumentsParser

class AsciiApp {
  def run(args: Array[String]) : Unit = {

    // parse arguments
    val argsParser = new ArgumentsParser();
    argsParser.parse(args);
    print(argsParser.pathToLoad + " ");
    print(argsParser.outputs.mkString(" , ") + " ")
    print(argsParser.table)
    print(argsParser.filters.mkString(" , ") + " ")


    // load an image
    // apply filters
    // export image

  }

}

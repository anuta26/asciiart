package ui

import business.filters.{
  BrightnessGreyscaleImageFilter,
  GreyscaleImageFilter,
  InvertGreyscaleImageFilter,
  RotateGreyscaleImageFilter
}

/** Argument parser which parses input arguments to
 * pathToLoad (random or path to file),
 * filters,
 * outputs (console or path to file),
 * conversion table (name, default or value of custom table)
 *
 */
class ArgumentsParser {
  private var _pathToLoad: String = ""
  private var _filters: Array[GreyscaleImageFilter] =
    Array[GreyscaleImageFilter]()
  private var _outputs: Array[String] = Array[String]()
  private var _table: String = ""

  def pathToLoad: String = _pathToLoad
  def filters: Array[GreyscaleImageFilter] = _filters
  def outputs: Array[String] = _outputs
  def table: String = _table

  /** Parses all arguments
   *
   * @param args input arguments
   */
  def parse(args: Array[String]): Unit = {
    parsePathToLoad(args)
    parseOutputs(args)
    parseTable(args)
    parseFilters(args)
  }

  /** Finds pathToLoad image in input arguments
   *
   * @param args input arguments
   */
  def parsePathToLoad(args: Array[String]): Unit = {
    val idxImage = args.indexOf("--image")
    val idxImageRandom = args.indexOf("--image-random")

    if (idxImage == -1 & idxImageRandom == -1)
      throw new IllegalArgumentException("No image path is declared.")

    if (idxImageRandom != -1)
      this._pathToLoad = "--image-random"
    else
      this._pathToLoad = args(idxImage + 1)
  }

  /** Finds pall outputs in input arguments
   *
   * @param args input arguments
   */
  def parseOutputs(args: Array[String]): Unit = {
    val idxConsole = args.indexOf("--output-console")
    val idxFile = args.indexOf("--output-file")

    if (idxConsole == -1 & idxFile == -1)
      throw new IllegalArgumentException("No output path is declared.")

    if (idxConsole != -1)
      this._outputs = this._outputs ++ Array("--output-console")

    if (idxFile != -1)
      this._outputs = this._outputs ++ Array(args(idxFile + 1))
  }

  /** Finds value for conversion table or its name in input arguments
   *
   * @param args input arguments
   */
  def parseTable(args: Array[String]): Unit = {
    val idxTable = args.indexOf("--table")
    val idxCustomTable = args.indexOf("--custom-table")

    if (idxTable == -1 && idxCustomTable == -1)
      this._table = "default"

    if (idxTable != -1)
      this._table = args(idxTable + 1)

    if (idxCustomTable != -1)
      this._table = args(idxCustomTable + 1)

  }

  /** Finds and initialize all filters with their values
   *
   * @param args input arguments
   */
  def parseFilters(args: Array[String]): Unit = {

    var i: Int = 0
    while (i < args.length) {
      args(i) match {
        case "--rotate" =>
          _filters = _filters ++ Array(
            new RotateGreyscaleImageFilter(args(i + 1).toInt))
        case "--invert" =>
          _filters = _filters ++ Array(new InvertGreyscaleImageFilter())
        case "--brightness" =>
          _filters = _filters ++ Array(
            new BrightnessGreyscaleImageFilter(args(i + 1).toInt))
        case _ =>
      }
      i += 1
    }
  }

}

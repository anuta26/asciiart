package ui.presenters

class ConsolePresenter extends Presenter {
  def printOptions(): Unit = {
  println("Commands:" + "\n" +
          "   --image-path                   Path to image to load" + "\n" +
          "   --image-random                 Generate random image" + "\n" +
          "   --table <name of table>        Use predefined conversion table (non-linear, Paul Bourkes’ table" + "\n" +
          "   --custom-table <table>         Set custom conversion table" + "\n" +
          "   --output-console               Print image to console" + "\n" +
          "   --output-file <path to file>   Export image to file (txt format is supported)" + "\n" +
          " Filters:" + "\n" +
          "   --invert" + "\n" +
          "   --rotate <value>" + "\n" +
          "   --brightness <value>" + "\n")
  }

  def printStage (stage: String): Unit = {
    println(stage)
  }

  def printException(e: Throwable): Unit = {
    println(e)
  }

}

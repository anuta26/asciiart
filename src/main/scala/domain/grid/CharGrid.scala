package domain.grid

class CharGrid (private var _symbols: Array[Array[Char]]) extends Grid[Char]{
  private val _width: Int = _symbols.length
  private val _height: Int = _symbols(0).length
  def pixels: Array[Array[Char]] = _symbols

  def getElement(x: Int, y: Int): Char = {
    _symbols(x)(y)
  }
  def width: Int = _width
  def height: Int = _height

  }

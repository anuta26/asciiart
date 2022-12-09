package domain.pixel

/** Pixel which contains ascii symbol (char)
 *
 * @param _char symbol which will be in pixel
 */
class AsciiPixel(private var _char: Char) extends Pixel {
  def getChar: Char = _char
}

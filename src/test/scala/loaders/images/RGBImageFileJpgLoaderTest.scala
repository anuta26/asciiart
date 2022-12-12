package loaders.images

import business.loaders.images.RGBImageFileJpgLoader
import domain.image.RGBImage
import org.scalatest.FunSuite

class RGBImageFileJpgLoaderTest extends FunSuite {
  test("Load an image of format jpg from existing path") {
    val image: RGBImage =
      new RGBImageFileJpgLoader("src/test/resources/test-image.jpg").load()

    assert(image.getGrid.pixels.nonEmpty)
    assert(image.getWidth.equals(1920))
    assert(image.getHeight.equals(1200))

  }
  test("Load an image of format jpg from incorrect path") {

    assertThrows[IllegalArgumentException](
      new RGBImageFileJpgLoader("src/test/resources/incorrect.jpg").load())

  }

}

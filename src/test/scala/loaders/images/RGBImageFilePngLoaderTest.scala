package loaders.images

import business.loaders.images.RGBImageFilePngLoader
import domain.image.RGBImage
import org.scalatest.FunSuite

class RGBImageFilePngLoaderTest extends FunSuite {
  test("Load an image of format png from existing path") {
    val image: RGBImage =
      new RGBImageFilePngLoader("src/test/resources/test-image.png").load()

    assert(image.getGrid.pixels.nonEmpty)
    assert(image.getWidth.equals(334))
    assert(image.getHeight.equals(212))

  }
  test("Load an image of format png from incorrect path") {

    assertThrows[IllegalArgumentException](
      new RGBImageFilePngLoader("src/test/resources/incorrect.png").load())

  }
}

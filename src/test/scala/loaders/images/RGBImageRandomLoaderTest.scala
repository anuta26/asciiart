package loaders.images

import business.generators.RandomRGBImageGenerator
import business.loaders.images.RGBImageRandomLoader
import domain.image.RGBImage
import org.scalatest.FunSuite

class RGBImageRandomLoaderTest extends FunSuite {

  val loader:RGBImageRandomLoader = new RGBImageRandomLoader(new RandomRGBImageGenerator)

  test("Load image using random generator") {
    val image: RGBImage = loader.load()

    assert(image.getHeight != 0)
    assert(image.getWidth != 0)
    assert(image.getGrid.pixels.nonEmpty)

  }
}

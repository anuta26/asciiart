package generators

import business.generators.RandomRGBImageGenerator
import domain.image.RGBImage
import org.scalatest.FunSuite

class RandomRGBImageGeneratorTest extends FunSuite {
  val generator: RandomRGBImageGenerator = new RandomRGBImageGenerator
  test("Generate random image with width and height from 200 to 800"){
    val image: RGBImage = generator.generate()
    assert(image.getHeight >= 200)
    assert(image.getHeight < 800)
    assert(image.getWidth >= 200)
    assert(image.getWidth < 800)
  }

}

package business.loaders

import domain.image.RGBImage

/** Loader which loads RGB image
 *
 * @tparam S type of the path to load
 */
trait RGBImageLoader[S] extends Loader[S,RGBImage]{
}

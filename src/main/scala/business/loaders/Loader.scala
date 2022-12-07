package business.loaders

trait Loader[S,T] {
  def load(arg: S): T

}

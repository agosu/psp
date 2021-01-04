package production

import common.Item

trait QualityProduction {

  def adjustItemList(items: List[String]): List[String] = {
    val newList: List[String] = List()
    for (x <- items.indices) {
      newList + ("quality " + x)
    }
    newList
  }

  def getPrecisionCoefficient: Long = {
    3000
  }

  def wrap(item: Item): Unit = {
    item.packaging = "quality packaging"
  }

  def getProductionType: String = {
    "quality production"
  }
}

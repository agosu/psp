package production

import common.Item

trait CheapProduction {

  def adjustItemList(items: List[String]): List[String] = {
    val newList: List[String] = List()
    for (x <- items.indices) {
      newList + ("cheap " + x)
    }
    newList
  }

  def getPrecisionCoefficient: Long = {
    1200
  }

  def wrap(item: Item): Unit = {
    item.packaging = "cheap packaging"
  }

  def getProductionType: String = {
    "cheap production"
  }
}

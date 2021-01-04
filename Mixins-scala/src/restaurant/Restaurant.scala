package restaurant

import common.Item

abstract class Restaurant() {
  var menu: Array[String] = new Array[String](10)
  var dishes: Map[String, List[String]] = Map()
  var numberOfDishes: Integer = 0

  def makeDish(dishName: String): Item = {
    var item: Item = new Item(dishName, "cheap", adjustItemList(dishes(dishName)).toArray)
    Thread.sleep(getPrecisionCoefficient)
    wrap(item)
    item
  }

  def addDishSelection(dishName: String, standardItems: List[String]): Unit = {
    menu(numberOfDishes) = dishName
    dishes += (dishName -> standardItems)
    numberOfDishes += 1
  }

  def adjustItemList(items: List[String]) : List[String]
  def getPrecisionCoefficient: Long
  def wrap(item: Item): Unit
  def getProductionType: String
}
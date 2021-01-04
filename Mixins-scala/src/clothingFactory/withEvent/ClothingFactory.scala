package clothingFactory.withEvent

import common.Item
import events.Event

abstract class ClothingFactory {
  var catalog: Array[String] = new Array[String](10)
  var clothings: Map[String, List[String]] = Map()
  var numberOfClothings: Integer = 0

  def makeClothing(clothingName: String): Item = {
    var item: Item = new Item(clothingName, "cheap", adjustItemList(clothings(clothingName)).toArray)
    Thread.sleep(getPrecisionCoefficient)
    wrap(item)
    item
  }

  def addClothingSelection(clothingName: String, standardItems: List[String]): Unit = {
    catalog(numberOfClothings) = clothingName
    clothings += (clothingName -> standardItems)
    numberOfClothings += 1
  }

  def adjustItemList(items: List[String]) : List[String]
  def getPrecisionCoefficient: Long
  def wrap(item: Item): Unit
  def getProductionType: String
  def organizeEvent(budget: Integer, numberOfAttendees: Integer): Unit
  def getEvents: Array[Event]
  def getEventsType: String
}

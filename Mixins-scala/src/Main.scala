import clothingFactory.CheapClothingFactoryCrazyEvents
import restaurant.QualityRestaurant

object Main {
  def main(args: Array[String]): Unit = {
    val cheapCrazyClothingFactory: CheapClothingFactoryCrazyEvents = new CheapClothingFactoryCrazyEvents()
    val standardItems: List[String] = List("leather", "cotton")
    cheapCrazyClothingFactory.addClothingSelection("dress", standardItems)
    val item = cheapCrazyClothingFactory.makeClothing("dress")
    cheapCrazyClothingFactory.organizeEvent(100, 500)
    val event = cheapCrazyClothingFactory.getEvents(0)

    println("Cheap Production Crazy Events Clothing Factory Result:")
    println("Item: ")
    println("type: " + item.typeOf)
    println("name: " + item.name)
    println("packaging: " + item.packaging)
    println()

    println("Event:")
    println("type: " + event.typeOf)
    println("budget: " + event.budget.toString)
    println("place: " + event.place)
    println()

    val qualityRestaurant: QualityRestaurant = new QualityRestaurant()
    val standardItemsRestaurant: List[String] = List("meat", "salad")
    qualityRestaurant.addDishSelection("pizza", standardItemsRestaurant)
    val dish = qualityRestaurant.makeDish("pizza")

    println("Quality Restaurant Result:")
    println("Dish: ")
    println("type: " + dish.typeOf)
    println("name: " + dish.name)
    println("packaging: " + dish.packaging)
  }
}

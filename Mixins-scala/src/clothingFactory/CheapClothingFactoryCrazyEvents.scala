package clothingFactory

import events.CrazyEvents
import production.CheapProduction

class CheapClothingFactoryCrazyEvents extends withEvent.ClothingFactory with CheapProduction with CrazyEvents {

}

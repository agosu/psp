package clothingFactory

import events.NormalEvents
import production.CheapProduction

class CheapClothingFactoryNormalEvents extends withEvent.ClothingFactory with CheapProduction with NormalEvents {
}

package clothingFactory

import events.CrazyEvents
import production.QualityProduction

class QualityClothingFactoryCrazyEvents extends withEvent.ClothingFactory with QualityProduction with CrazyEvents {

}

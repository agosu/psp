package clothingFactory

import events.NormalEvents
import production.QualityProduction

class QualityClothingFactoryNormalEvents extends withEvent.ClothingFactory with QualityProduction with NormalEvents {

}

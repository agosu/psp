package kotlinExample

    fun main() {
        val delegate = AdditionalFunctionalityImpl()
        Computer(delegate).compute()
        Computer(delegate).getCoordinates()
        Computer(delegate).getCompassDirection()
        Computer(delegate).playMusic()
    }
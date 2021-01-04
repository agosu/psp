package kotlinExample

class CarSystem(delegate: AdditionalFunctionality) : AdditionalFunctionality by delegate {
    fun runHealthCheckup() {
        println("Running health checkup...")
    }
}
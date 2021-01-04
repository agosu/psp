package kotlinExample

class Phone(delegate: AdditionalFunctionality) : AdditionalFunctionality by delegate {
    fun call() {
        println("Calling...")
    }
}
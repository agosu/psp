package kotlinExample

class Computer(delegate: AdditionalFunctionality) : AdditionalFunctionality by delegate {
    fun compute() {
        println("Computing...")
    }
}
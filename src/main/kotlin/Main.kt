import java.lang.NumberFormatException

class Account(var balance: Double)

fun main(args: Array<String>) {
    atm()
}

fun atm() {
    val account = Account(0.0);
    var activeSession = true
    do {
        printMenuOptions()
        when(readLine()) {
            "1" -> checkBalance(account)
            "2" -> makeDeposit(account)
            "3" -> withdraw(account)
            "4" -> println("End of session. Bye").also { activeSession = false }
            else -> println("Invalid option selected. Try with a valid option")
        }
        readLine()
    } while (activeSession)
}

fun printMenuOptions() {
    println("=============================")
    println("ATM options:")
    println("1. Check account balance")
    println("2. Deposit Money")
    println("3. Withdraw Money")
    println("4. Exit")
    println("=============================")
}

fun checkBalance(account: Account) {
    println("The current balance is: $${account.balance}")
}

fun makeDeposit(account: Account) {
    println("Which amount would you like to deposit?")
    val input = readValue()
    if (input > 0) {
        account.balance = account.balance.plus(input)
        println("The amount $$input was deposited in your account")
    } else {
        println("The amount has to be larger than $0")
    }
}

fun  withdraw(account: Account) {
    println("Which amount would you like to withdraw?")
    val input = readValue()
    if (input <= 0 || input > account.balance) {
        println("Sorry, you don't have enough funds")
    } else {
        account.balance = account.balance.minus(input)
        println("Here you go, you have withdrawn $$input")
    }
}

fun readValue(): Double {
    return try {
        readLine().toString().toDouble()
    } catch (e: NumberFormatException) { 0.0 }
}

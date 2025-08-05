class Clock {
    var hour: Byte
    var minute: Byte
    var second: Byte

    constructor() {
        hour = 0
        minute = 0
        second = 0
    }
    constructor(inputHour: Byte, inputMinute: Byte, inputSecond:Byte) {
        this.hour = inputHour
        this.minute = inputMinute
        this.second = inputSecond
    }
    fun resetClock() {
        hour = 0
        minute = 0
        second = 0
    }
    fun addSecond() {
        second++
        if (second >= 60) {
            second = 0
            minute++
            if (minute >= 60) {
                minute =0
                hour++
                if (hour >= 24) {
                    hour = 0
                }
            }
        }
    }
}

fun main() {
    var myClock = Clock()
    var menuSelection: Char
    var inputHour: Byte
    var inputMinute: Byte
    var inputSecond: Byte
    var runProgram = true

    while (runProgram) {
        println("The current time ==> "+myClock.hour+" : "+myClock.minute+" : "+myClock.second)
        println("Enter 's' to set the time.")
        println("Enter 'a' to advance one second.")
        println("Enter 'r' to reset the clock.")
        println("Enter 'q' to quit.")
        menuSelection = readln().first()
        if (menuSelection == 's') {
            println("You can now set the clock\n")
            println("Enter hour (0 - 23): ")
            inputHour = (readln().toByte())
            println("Enter minute (0 - 59): ")
            inputMinute = (readln().toByte())
            println("Enter second (0 - 59): ")
            inputSecond = (readln().toByte())
            if (inputHour in 0..23 && inputMinute in 0..59 && inputSecond in 0..59) {
                myClock = Clock(inputHour, inputMinute, inputSecond)
            }
            else {
                println("Invalid input. Please try again...\n")
            }
        }
        else if (menuSelection == 'a') {
            myClock.addSecond()
        }
        else if (menuSelection == 'r') {
            myClock.resetClock()
        }
        else if (menuSelection == 'q') {
            runProgram = false
        }
        else {
            println("Invalid input. Please try again...\n")
        }
    }
}
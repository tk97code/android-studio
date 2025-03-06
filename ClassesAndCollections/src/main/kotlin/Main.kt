package allan

data class Event {
    title: String,
    description: String?=null,
    daypart: String,
    durationInMinutes: Int
}


fun main() {
    println("Hello World!")
}
package ch09iterator.cafe


class DinerMenu : Menu {
    private val MAX_ITEMS = 6
    private val menuItems = Array<MenuItem?>(MAX_ITEMS) { null }
    private var numberOfItems = 0

    init {
        addItem("Vegetarian BLT", "(Fakin’) Bacon with lettuce & tomato on whole wheat", true, 2.99)
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99)
        addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29)
        addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05)
    }

    override fun createIterator(): MutableIterator<MenuItem> = DinerMenuIterator(menuItems)

    fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        val menuItem = MenuItem(name, description, vegetarian, price)
        if (numberOfItems >= MAX_ITEMS) {
            println("Sorry, menu is full! Can't add item to menu")
        } else {
            menuItems[numberOfItems] = menuItem
            numberOfItems += 1
        }
    }
}
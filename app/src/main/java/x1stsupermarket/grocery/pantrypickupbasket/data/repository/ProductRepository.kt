package x1stsupermarket.grocery.pantrypickupbasket.data.repository

import x1stsupermarket.grocery.pantrypickupbasket.data.model.Product
import x1stsupermarket.grocery.pantrypickupbasket.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(
        Product(
            id = 1,
            title = "Red Apple",
            description = "A crisp red apple with a naturally sweet flavour. It is refreshing on its own and easy to pack for lunch. Slice it into porridge, salads, or simple desserts. Sold as one loose apple.",
            category = ProductCategory.FRESH_PRODUCE,
            price = 0.45,
            imageUrl = "https://images.pexels.com/photos/23322289/pexels-photo-23322289.jpeg",
        ),
        Product(
            id = 2,
            title = "Broccoli",
            description = "Fresh broccoli with firm stalks and tightly packed green florets. Steam or roast it for an easy side dish. It also works well in pasta, stir-fries, and soups. Sold as one head.",
            category = ProductCategory.FRESH_PRODUCE,
            price = 0.85,
            imageUrl = "https://images.pexels.com/photos/3872433/pexels-photo-3872433.jpeg",
        ),
        Product(
            id = 3,
            title = "Sourdough Loaf",
            description = "A crusty sourdough loaf with a chewy crumb and gentle tang. Toast it for breakfast or use thick slices for sandwiches. The sturdy texture is also ideal beside soup. Each loaf is baked for a deep golden crust.",
            category = ProductCategory.BAKERY,
            price = 3.25,
            imageUrl = "https://images.pexels.com/photos/6605206/pexels-photo-6605206.jpeg",
        ),
        Product(
            id = 4,
            title = "Butter Croissant",
            description = "A flaky croissant made with layers of buttery pastry. Warm it briefly for a crisp outside and soft centre. Enjoy it plain or add jam for breakfast. Sold individually for an easy bakery treat.",
            category = ProductCategory.BAKERY,
            price = 1.35,
            imageUrl = "https://images.pexels.com/photos/18058319/pexels-photo-18058319.jpeg",
        ),
        Product(
            id = 5,
            title = "Whole Milk",
            description = "Creamy whole milk for cereal, tea, coffee, and everyday cooking. It brings a rich texture to sauces and baking. Keep refrigerated and use by the date shown on the bottle. Supplied in a one-litre bottle.",
            category = ProductCategory.DAIRY_EGGS,
            price = 1.65,
            imageUrl = "https://images.pexels.com/photos/5946733/pexels-photo-5946733.jpeg",
        ),
        Product(
            id = 6,
            title = "Free-Range Eggs",
            description = "Six free-range eggs with versatile uses throughout the week. Fry, scramble, poach, or boil them for quick meals. They are also a dependable staple for cakes and pancakes. Store the carton in a cool, dry place.",
            category = ProductCategory.DAIRY_EGGS,
            price = 2.40,
            imageUrl = "https://images.pexels.com/photos/3980617/pexels-photo-3980617.jpeg",
        ),
        Product(
            id = 7,
            title = "Chicken Breast",
            description = "Fresh skinless chicken breast with a lean, tender texture. Roast, grill, or slice it into curries and stir-fries. Cook thoroughly until piping hot throughout. The pack contains approximately 500 grams.",
            category = ProductCategory.MEAT_SEAFOOD,
            price = 4.75,
            imageUrl = "https://images.pexels.com/photos/6107734/pexels-photo-6107734.jpeg",
        ),
        Product(
            id = 8,
            title = "Salmon Fillet",
            description = "A fresh salmon fillet with a rich flavour and tender flakes. Bake, pan-fry, or grill it with lemon and herbs. It makes a satisfying centrepiece for a quick dinner. The portion weighs approximately 250 grams.",
            category = ProductCategory.MEAT_SEAFOOD,
            price = 5.50,
            imageUrl = "https://images.pexels.com/photos/14062107/pexels-photo-14062107.jpeg",
        ),
        Product(
            id = 9,
            title = "Basmati Rice",
            description = "Long-grain basmati rice with a light aroma and fluffy finish. Rinse before cooking for the best separated grains. Serve it with curries, roasted vegetables, or grilled meat. The one-kilogram bag is a practical pantry staple.",
            category = ProductCategory.PANTRY_STAPLES,
            price = 2.20,
            imageUrl = "https://images.pexels.com/photos/31555430/pexels-photo-31555430.jpeg",
        ),
        Product(
            id = 10,
            title = "Fusilli Pasta",
            description = "Dried fusilli pasta with twists that hold onto sauce. Boil until al dente for salads, bakes, or simple weeknight meals. Pair it with tomato sauce, pesto, or seasonal vegetables. The pack contains 500 grams.",
            category = ProductCategory.PANTRY_STAPLES,
            price = 1.25,
            imageUrl = "https://images.pexels.com/photos/4039861/pexels-photo-4039861.jpeg",
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}

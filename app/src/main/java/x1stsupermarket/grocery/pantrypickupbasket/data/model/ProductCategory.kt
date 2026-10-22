package x1stsupermarket.grocery.pantrypickupbasket.data.model

import androidx.annotation.StringRes
import x1stsupermarket.grocery.pantrypickupbasket.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    FRESH_PRODUCE(R.string.product_category_fresh_produce_title),
    BAKERY(R.string.product_category_bakery_title),
    DAIRY_EGGS(R.string.product_category_dairy_eggs_title),
    MEAT_SEAFOOD(R.string.product_category_meat_seafood_title),
    PANTRY_STAPLES(R.string.product_category_pantry_staples_title),
}

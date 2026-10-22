package x1stsupermarket.grocery.pantrypickupbasket.data.repository

import x1stsupermarket.grocery.pantrypickupbasket.data.model.Product
import x1stsupermarket.grocery.pantrypickupbasket.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(

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

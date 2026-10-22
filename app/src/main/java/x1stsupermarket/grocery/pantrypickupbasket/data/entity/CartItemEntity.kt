package x1stsupermarket.grocery.pantrypickupbasket.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItemEntity(
    @PrimaryKey val id: Int,
    val quantity: Int,
)
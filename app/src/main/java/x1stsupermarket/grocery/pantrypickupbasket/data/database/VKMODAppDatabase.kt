package x1stsupermarket.grocery.pantrypickupbasket.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import x1stsupermarket.grocery.pantrypickupbasket.data.database.dao.CartItemDao
import x1stsupermarket.grocery.pantrypickupbasket.data.database.dao.OrderDao
import x1stsupermarket.grocery.pantrypickupbasket.data.database.converter.Converters
import x1stsupermarket.grocery.pantrypickupbasket.data.entity.CartItemEntity
import x1stsupermarket.grocery.pantrypickupbasket.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class VKMODAppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}
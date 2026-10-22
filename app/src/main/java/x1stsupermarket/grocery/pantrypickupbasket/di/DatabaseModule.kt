package x1stsupermarket.grocery.pantrypickupbasket.di

import androidx.room.Room
import x1stsupermarket.grocery.pantrypickupbasket.data.database.VKMODAppDatabase
import org.koin.dsl.module

private const val DB_NAME = "vkmod_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = VKMODAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<VKMODAppDatabase>().cartItemDao() }

    single { get<VKMODAppDatabase>().orderDao() }
}
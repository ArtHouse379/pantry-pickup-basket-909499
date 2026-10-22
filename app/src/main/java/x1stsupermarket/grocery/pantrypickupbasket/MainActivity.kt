package x1stsupermarket.grocery.pantrypickupbasket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import x1stsupermarket.grocery.pantrypickupbasket.ui.composable.approot.AppRoot
import x1stsupermarket.grocery.pantrypickupbasket.ui.theme.VKMODAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKMODAppTheme {
                AppRoot()
            }
        }
    }
}

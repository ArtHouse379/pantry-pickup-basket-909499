package x1stsupermarket.grocery.pantrypickupbasket.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Verified
import androidx.compose.ui.graphics.vector.ImageVector

data class Benefit(
    val icon: ImageVector,
    val text: String,
)

val productBenefits = listOf<Benefit>(
    Benefit(
        icon = Icons.Filled.Verified,
        text = "Fresh quality",
    ),
    Benefit(
        icon = Icons.Filled.Security,
        text = "Satisfaction guarantee",
    ),
    Benefit(
        icon = Icons.Filled.ShoppingCart,
        text = "Everyday essentials",
    ),
)

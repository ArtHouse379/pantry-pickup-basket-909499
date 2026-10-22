package x1stsupermarket.grocery.pantrypickupbasket.ui.composable.screen.order.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import x1stsupermarket.grocery.pantrypickupbasket.R
import x1stsupermarket.grocery.pantrypickupbasket.data.entity.OrderEntity
import x1stsupermarket.grocery.pantrypickupbasket.ui.theme.LocalDimens
import x1stsupermarket.grocery.pantrypickupbasket.ui.theme.cardBorderStroke
import java.time.format.DateTimeFormatter
import java.util.Locale

private val AccentBarWidth = 4.dp

@Composable
fun OrderItem(
    order: OrderEntity,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val dateFormatter = DateTimeFormatter.ofPattern(
        stringResource(R.string.order_date_pattern),
        Locale.ENGLISH,
    )

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(AccentBarWidth)
                    .background(MaterialTheme.colorScheme.tertiary),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimens.cardPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(R.string.order_number, order.orderNumber),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleSmall,
                    )

                    Spacer(modifier = Modifier.height(dimens.tightSpacing))

                    Text(
                        text = order.description,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )

                    Text(
                        text = order.timestamp.format(dateFormatter),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall,
                    )

                    Spacer(modifier = Modifier.height(dimens.tightSpacing))

                    Text(
                        text = stringResource(
                            R.string.order_customer,
                            order.customerFirstName,
                            order.customerLastName,
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )

                    Text(
                        text = stringResource(R.string.order_customer_email, order.customerEmail),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                Spacer(modifier = Modifier.width(dimens.contentSpacing))

                Text(
                    text = stringResource(R.string.price, order.price),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}

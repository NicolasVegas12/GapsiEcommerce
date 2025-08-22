package com.nvegas.presentation.ui.pages.main.components.items

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nvegas.core.ui.text.TextComponent
import com.nvegas.domain.models.ProductItemModel
import com.nvegas.presentation.ui.theme.GapsiEcommerceTheme

@Composable
fun ProductsItemsComponent(
    model: ProductItemModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            AsyncImage(
                model.image,
                null,
                modifier = Modifier.size(100.dp)
            )

            VerticalDivider(modifier = Modifier.height(100.dp))
            TextComponent(model.name, modifier = Modifier.weight(1f))
            VerticalDivider(modifier = Modifier.height(100.dp))

            TextComponent("$ ${model.price}", modifier = Modifier.weight(1f))

        }
    }

}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewProductsItemsComponent() {
    GapsiEcommerceTheme {
        ProductsItemsComponent(ProductItemModel("Computer", 150, ""))
    }
}
package com.nvegas.presentation.ui.pages.main.components.items

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nvegas.presentation.ui.theme.GapsiEcommerceTheme

@Composable
fun LoadingItem(
    height: Dp,
    width: Dp
) {


    Column(modifier = Modifier.fillMaxWidth()) {
        CircularProgressIndicator(
            modifier = Modifier
                .height(height)
                .width(width)
        )

    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewLoadingItem() {
    GapsiEcommerceTheme {
        LoadingItem(80.dp, 80.dp)
    }
}
package top.yogiczy.mytv.tv.ui.screen.settings.subcategories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Icon
import androidx.tv.material3.ListItem
import androidx.tv.material3.ListItemDefaults
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import top.yogiczy.mytv.tv.ui.rememberChildPadding
import top.yogiczy.mytv.tv.ui.screen.components.AppScreen
import top.yogiczy.mytv.tv.ui.theme.MyTvTheme
import top.yogiczy.mytv.tv.ui.utils.handleKeyEvents

@Composable
fun SettingsNetworkRetryCountScreen(
    modifier: Modifier = Modifier,
    countProvider: () -> Long = { 20L },
    onCountChanged: (Long) -> Unit = {},
    onBackPressed: () -> Unit = {},
) {
    val childPadding = rememberChildPadding()
    val currentCount = countProvider()
    val countList = listOf(5L, 10L, 15L, 20L, 25L, 30L, 35L, 40L, 45L, 50L)

    AppScreen(
        modifier = modifier.padding(top = 10.dp),
        header = { Text("设置 / 网络 / HTTP请求重试次数") },
        canBack = true,
        onBackPressed = onBackPressed,
    ) {
        LazyVerticalGrid(
            modifier = Modifier,
            columns = GridCells.Fixed(6),
            contentPadding = childPadding.copy(top = 10.dp).paddingValues,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(countList) { count ->
                ListItem(
                    modifier = Modifier
                        .handleKeyEvents(onSelect = { onCountChanged(count) }),
                    headlineContent = {
                        Text(
                            count.toString(),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                        )
                    },
                    trailingContent = {
                        if (currentCount == count) {
                            Icon(
                                Icons.Default.CheckCircle,
                                contentDescription = null,
                            )
                        }
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.onSurface.copy(0.1f),
                    ),
                    selected = false,
                    onClick = { onCountChanged(count) },
                )
            }
        }
    }
}

@Preview(device = "id:Android TV (720p)")
@Composable
private fun SettingsNetworkRetryCountScreenPreview() {
    MyTvTheme {
        SettingsNetworkRetryCountScreen()
    }
}
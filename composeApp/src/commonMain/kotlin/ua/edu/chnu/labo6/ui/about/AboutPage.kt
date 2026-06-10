package ua.edu.chnu.labo6.ui.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.chnu.labo6.Platform
import kotlin.math.max
import kotlin.math.min

@Composable
fun AboutPage(
    onUpButtonClick: () -> Unit,
) {
    // Collect platform info once and log it via the logging library.
    val platform = remember { Platform().also { it.logSystemInfo() } }

    Column {
        Toolbar(onUpButtonClick = onUpButtonClick)
        ContentView(platform = platform)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    onUpButtonClick: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = "About Device") },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                )
            }
        }
    )
}

@Composable
private fun ContentView(platform: Platform) {
    val items = makeItems(platform)

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items) { row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}

private fun makeItems(platform: Platform): List<Pair<String, String>> {
    val items = mutableListOf(
        Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("CPU", platform.cpuType),
    )

    val max = max(platform.screen.width, platform.screen.height)
    val min = min(platform.screen.width, platform.screen.height)

    var displayInfo = "${max}×${min}"
    platform.screen.density?.let {
        displayInfo += " @${it}x"
    }
    items.add(Pair("Display", displayInfo))

    return items
}

@Composable
private fun RowView(
    title: String,
    subtitle: String,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(12.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
        HorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
private fun AboutPreview() {
    AboutPage {}
}

package ua.edu.chnu.labo6

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ua.edu.chnu.labo6.ui.root.AppScaffold

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Labo6 Cross Platform",
    ) {
        AppScaffold()
    }
}

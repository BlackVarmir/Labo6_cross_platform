# Labo6_cross_platform

Kotlin Multiplatform (Compose Multiplatform) project for **Лабораторна робота №6**.

Targets: **Android**, **Desktop (JVM)**, **iOS** (iOS builds require macOS + Xcode).

## What the lab covers

1. **New KMP project** — Compose Multiplatform structure with shared `commonMain` code and per-platform source sets.
2. **Custom theme (colors + fonts)** — `ui/theme/`:
   - `Color.kt` — custom light/dark color palette.
   - `Type.kt` — custom `Typography` (serif headings, sans-serif body, monospace technical values).
   - `Theme.kt` — `Labo6Theme` wrapping `MaterialTheme`, applied at the root in `AppScaffold`.
3. **Logging library** — [Kermit](https://github.com/touchlab/Kermit) (`co.touchlab:kermit`), used in `logSystemInfo()`.
4. **Platform-specific API** — `expect class Platform` / `ScreenInfo` in `commonMain`, with `actual` implementations per platform that read real system information:
   - `Platform.android.kt` — `Build`, `Resources.displayMetrics`.
   - `Platform.jvm.kt` — `System.getProperty(...)`, AWT `Toolkit`.
   - `Platform.ios.kt` — `UIDevice`, `UIScreen`.

   The **About Device** screen displays OS, device, CPU and display info; opening it also logs the data via Kermit.

## Run

Android:

```
.\gradlew.bat :composeApp:assembleDebug
```

Desktop (JVM):

```
.\gradlew.bat :composeApp:run
```

iOS: open the project in Android Studio / Xcode on macOS and run the `iosApp` target.

> Note: this project was set up on Windows. Android and Desktop targets build on Windows; the iOS target requires macOS.

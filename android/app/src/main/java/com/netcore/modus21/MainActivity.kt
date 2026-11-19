package com.netcore.modus21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

private data class Tab(val route: String, val label: String, val icon: ImageVector)

private val tabs = listOf(
    Tab("mission", "Mission", Icons.Filled.Flag),
    Tab("capabilities", "Capabilities", Icons.Filled.GridView),
    Tab("experience", "Experience", Icons.Filled.Verified),
    Tab("careers", "Careers", Icons.Filled.Groups),
    Tab("contact", "Contact", Icons.Filled.Phone)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT)
        )
        setContent {
            Modus21Theme {
                ModusApp()
            }
        }
    }
}

@Composable
private fun ModusApp() {
    val nav = rememberNavController()
    val entry by nav.currentBackStackEntryAsState()
    val route = entry?.destination?.route
    val currentTab = when {
        route == null -> "mission"
        route.startsWith("capability") -> "capabilities"
        route == "privacy" || route == "accessibility" -> "contact"
        else -> route.substringBefore("/")
    }

    Scaffold(
        containerColor = Brand.canvas,
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                tabs.forEach { tab ->
                    NavigationBarItem(
                        selected = currentTab == tab.route,
                        onClick = {
                            if (currentTab == tab.route) {
                                nav.popBackStack(tab.route, inclusive = false)
                            } else {
                                openTab(nav, tab.route)
                            }
                        },
                        icon = { Icon(tab.icon, contentDescription = null) },
                        label = {
                            Text(tab.label, maxLines = 1, overflow = TextOverflow.Ellipsis, fontSize = 10.sp)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Brand.navy,
                            selectedTextColor = Brand.navy,
                            indicatorColor = Brand.navy.copy(alpha = 0.12f),
                            unselectedIconColor = Brand.muted,
                            unselectedTextColor = Brand.muted
                        )
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = nav,
            startDestination = "mission",
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            composable("mission") {
                MissionScreen(
                    onCapabilities = { openTab(nav, "capabilities") },
                    onContact = { openTab(nav, "contact") }
                )
            }
            composable("capabilities") {
                CapabilitiesScreen(onOpen = { index -> nav.navigate("capability/$index") })
            }
            composable(
                "capability/{index}",
                arguments = listOf(navArgument("index") { type = NavType.IntType })
            ) { backStack ->
                val index = backStack.arguments?.getInt("index") ?: 0
                val capability = Company.capabilities.getOrNull(index)
                if (capability != null) {
                    CapabilityDetailScreen(capability, onBack = { nav.popBackStack() })
                }
            }
            composable("experience") { ExperienceScreen() }
            composable("careers") { CareersScreen() }
            composable("contact") {
                ContactScreen(
                    onPrivacy = { nav.navigate("privacy") },
                    onAccessibility = { nav.navigate("accessibility") }
                )
            }
            composable("privacy") { PrivacyScreen(onBack = { nav.popBackStack() }) }
            composable("accessibility") { AccessibilityScreen(onBack = { nav.popBackStack() }) }
        }
    }
}

private fun openTab(nav: NavHostController, route: String) {
    nav.navigate(route) {
        popUpTo(nav.graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}

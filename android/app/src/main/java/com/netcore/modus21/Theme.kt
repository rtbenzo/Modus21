package com.netcore.modus21

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

object Brand {
    val navy = Color(0xFF003D69)
    val orange = Color(0xFFF79441)
    val ink = Color(0xFF1F1F1F)
    val muted = Color(0xFF5F5F5F)
    val canvas = Color(0xFFF4F6F8)
    val line = Color(0x141F1F1F)
}

private val Colors = lightColorScheme(
    primary = Brand.navy,
    onPrimary = Color.White,
    background = Brand.canvas,
    surface = Color.White,
    onBackground = Brand.ink,
    onSurface = Brand.ink
)

@Composable
fun Modus21Theme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = Colors, content = content)
}

@Composable
fun BrandCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val click = if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier
    Column(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .then(click)
            .background(Color.White)
            .border(1.dp, Brand.line, RoundedCornerShape(16.dp))
            .padding(18.dp),
        content = content
    )
}

@Composable
fun Eyebrow(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .padding(end = 8.dp)
                .width(18.dp)
                .height(3.dp)
                .background(Brand.orange, RoundedCornerShape(1.dp))
        )
        androidx.compose.material3.Text(
            text.uppercase(Locale.US),
            color = Brand.navy,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.1.sp
        )
    }
}

@Composable
fun MarkIcon(icon: ImageVector, size: Dp = 36.dp) {
    Box(
        Modifier
            .size(size)
            .background(Brand.navy.copy(alpha = 0.08f), RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, contentDescription = null, tint = Brand.navy)
    }
}

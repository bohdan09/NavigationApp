package com.example.navigationapp.view.bottomNavigation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.RenderVectorGroup
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.navigationapp.R
import com.example.navigationapp.navigation.NavFlowRoute
import com.example.navigationapp.ui.theme.NavigationAppTheme

@Composable
fun MenuItem(
    item: BottomNavFlowItem,
    backgroundTint: Color,
    foregroundTint: Color,
    requiredSize: Dp = 24.dp,
    badgeHeight: Dp = 14.dp,
    textHorizontalPadding: Dp = 4.dp,
    indicatorBorderWidth: Dp = 2.dp
) {
    val backgroundIcon = ImageVector.vectorResource(id = item.backgroundIcon)
    val backgroundPainter = rememberVectorPainter(backgroundIcon, backgroundTint)

    val foregroundIcon = ImageVector.vectorResource(id = item.foregroundIcon)
    val foregroundPainter = rememberVectorPainter(foregroundIcon, foregroundTint)

    var internalFigureSize: Size
    var outerBadgeFigureSize = Size(0f, 0f)
    var pxHeightValue: Float
    val textSize = IntSize(0, 0)
    item.indicatorCount?.let {
        val textPadding = with(LocalDensity.current) { textHorizontalPadding.toPx() }
        val borderWidth = with(LocalDensity.current) { indicatorBorderWidth.toPx() }

        pxHeightValue = with(LocalDensity.current) { badgeHeight.toPx() }
        internalFigureSize =
            Size(height = pxHeightValue - borderWidth, width = textSize.width + (textPadding * 2))
        outerBadgeFigureSize =
            Size(height = pxHeightValue, width = internalFigureSize.width + borderWidth)
    }

    val requiredVerticalPadding =
        with(LocalDensity.current) { requiredSize.value.dp.toPx() - foregroundPainter.intrinsicSize.height } / 2
    val requiredHorizontalPadding =
        with(LocalDensity.current) { requiredSize.value.dp.toPx() - foregroundPainter.intrinsicSize.width } / 2
    val overallDpSize = with(LocalDensity.current) {
        DpSize(
            width = requiredSize + (outerBadgeFigureSize.width).toDp(),
            height = requiredSize + (outerBadgeFigureSize.height / 2).toDp()
        )
    }
    Canvas(
        modifier = Modifier.size(overallDpSize),
        onDraw = {
            translate(
                left = (outerBadgeFigureSize.width / 2).toInt() + (requiredHorizontalPadding),
                top = (outerBadgeFigureSize.height * 0.35).toInt() + requiredVerticalPadding
            ) {
                drawVector(backgroundPainter)
                drawVector(foregroundPainter)
            }
        }
    )
}

@Composable
private fun rememberVectorPainter(
    icon: ImageVector,
    tint: Color
) = rememberVectorPainter(
    defaultWidth = icon.defaultWidth,
    defaultHeight = icon.defaultHeight,
    viewportWidth = icon.viewportWidth,
    viewportHeight = icon.viewportHeight,
    name = icon.name,
    tintColor = tint,
    tintBlendMode = icon.tintBlendMode,
    autoMirror = icon.autoMirror,
    content = { _, _ -> RenderVectorGroup(group = icon.root) }
)

private fun DrawScope.drawVector(
    painter: VectorPainter
) = with(painter) {
    draw(painter.intrinsicSize)
}

@Preview
@Composable
fun Preview_DrawIndicator() = NavigationAppTheme {
    MenuItem(
        item = object : BottomNavFlowItem(
            foregroundIcon = R.drawable.ic_chat_foreground,
            backgroundIcon = R.drawable.ic_chat_background,
            title = R.string.app_name,
            NavFlowRoute(""),
            label = "Chat"
        ) {

        },
        backgroundTint = Color.Green,
        foregroundTint = Color.Gray
    )
}


@Preview
@Composable
fun Preview_DrawIndicator_WithIncator_MoreThan100() = NavigationAppTheme {
    MenuItem(
        item = object : BottomNavFlowItem(
            foregroundIcon = R.drawable.ic_home_foreground,
            backgroundIcon = R.drawable.ic_home_background,
            title = R.string.app_name,
            NavFlowRoute(""),
            label = "Chat",
            indicatorCount = 150
        ) {

        },
        backgroundTint = Color.Green,
        foregroundTint = Color.Gray
    )
}

@Preview
@Composable
fun Preview_DrawIndicator_WithIncator_2Chars() = NavigationAppTheme {
    MenuItem(
        item = object : BottomNavFlowItem(
            foregroundIcon = R.drawable.ic_profile_foreground,
            backgroundIcon = R.drawable.ic_profile_background,
            title = R.string.app_name,
            NavFlowRoute(""),
            label = "Chat",
            indicatorCount = 15
        ) {

        },
        backgroundTint = Color.Green,
        foregroundTint = Color.Gray
    )
}
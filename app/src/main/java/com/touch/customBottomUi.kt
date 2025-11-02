package com.touch
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

// function to make bottom custom curver
class customBottomUi(private val bubbleheight: Dp = 16.dp) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val bubblepx = with(density) { bubbleheight.toPx() }

        val path = Path().apply {
            moveTo(0f, 0f)

            quadraticTo(
                x1 = size.width / 2,
                y1 = -bubblepx,
                x2 = size.width,
                y2 = 0f
            )

            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }

        return Outline.Generic(path)
    }
}
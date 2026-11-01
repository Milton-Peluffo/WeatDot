package com.tomildev.weathy.core.presentation.components.texts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.tomildev.weathy.ui.theme.Alpha

object Texts {

    @Composable
    fun Headline(
        modifier: Modifier = Modifier,
        text: String,
        fontWeight: FontWeight? = null,
        fontFamily: FontFamily? = null,
        style: TextStyle? = null,
        color: Color = Color.Unspecified,
        textAlign: TextAlign = TextAlign.Start
    ) {
        AppText(
            modifier = modifier,
            text = text,
            color = color,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            overrideStyle = style,
            textAlign = textAlign
        )
    }

    @Composable
    fun HeadlineMedium(
        modifier: Modifier = Modifier,
        text: String,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        style: TextStyle? = null,
        textAlign: TextAlign = TextAlign.Start,
        isSecondary: Boolean = false
    ) {
        AppText(
            modifier = modifier,
            text = text,
            color = color,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = fontWeight,
            overrideStyle = style,
            alpha = if (isSecondary) Alpha.AlphaHigh else Alpha.AlphaFull,
            textAlign = textAlign
        )
    }

    @Composable
    fun TitleLarge(
        modifier: Modifier = Modifier,
        text: String,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        style: TextStyle? = null,
        textAlign: TextAlign = TextAlign.Start,
        isSecondary: Boolean = false
    ) {
        AppText(
            modifier = modifier,
            text = text,
            color = color,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = fontWeight,
            overrideStyle = style,
            alpha = if (isSecondary) Alpha.AlphaHigh else Alpha.AlphaFull,
            textAlign = textAlign
        )
    }

    @Composable
    fun TitleMedium(
        modifier: Modifier = Modifier,
        text: String,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        style: TextStyle? = null,
        isSecondary: Boolean = false,
        textAlign: TextAlign = TextAlign.Start,
        maxLines: Int = Int.MAX_VALUE,
        overflow: TextOverflow = TextOverflow.Clip
    ) {
        AppText(
            modifier = modifier,
            text = text,
            color = color,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = fontWeight,
            overrideStyle = style,
            textAlign = textAlign,
            maxLines = maxLines,
            overflow = overflow,
            alpha = if (isSecondary) Alpha.AlphaHigh else Alpha.AlphaFull
        )
    }

    @Composable
    fun TitleSmall(
        modifier: Modifier = Modifier,
        text: String,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        fontFamily: FontFamily? = null,
        style: TextStyle? = null,
        isSecondary: Boolean = false,
        textAlign: TextAlign = TextAlign.Start
    ) {
        AppText(
            modifier = modifier,
            text = text,
            color = color,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            overrideStyle = style,
            textAlign = textAlign,
            alpha = if (isSecondary) Alpha.AlphaHigh else Alpha.AlphaFull
        )
    }

    @Composable
    fun Body(
        modifier: Modifier = Modifier,
        text: String,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        fontFamily: FontFamily? = null,
        style: TextStyle? = null,
        isSecondary: Boolean = false,
        textAlign: TextAlign = TextAlign.Start
    ) {
        AppText(
            modifier = modifier,
            text = text,
            color = color,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            overrideStyle = style,
            textAlign = textAlign,
            alpha = if (isSecondary) Alpha.AlphaMedium else Alpha.AlphaFull
        )
    }

    @Composable
    fun BodySmall(
        modifier: Modifier = Modifier,
        text: String,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        fontFamily: FontFamily? = null,
        style: TextStyle? = null,
        isSecondary: Boolean = false,
        textAlign: TextAlign = TextAlign.Start
    ) {
        AppText(
            modifier = modifier,
            text = text,
            color = color,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            overrideStyle = style,
            textAlign = textAlign,
            alpha = if (isSecondary) Alpha.AlphaHigh else Alpha.AlphaFull
        )
    }

    @Composable
    fun LabelLarge(
        modifier: Modifier = Modifier,
        text: String,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        fontFamily: FontFamily? = null,
        style: TextStyle? = null,
        isSecondary: Boolean = false,
        textAlign: TextAlign = TextAlign.Start
    ) {
        AppText(
            modifier = modifier,
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = color,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            overrideStyle = style,
            textAlign = textAlign,
            alpha = if (isSecondary) Alpha.AlphaHigh else Alpha.AlphaFull
        )
    }

    @Composable
    fun LabelMedium(
        modifier: Modifier = Modifier,
        text: String,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        style: TextStyle? = null,
        isSecondary: Boolean = false,
        textAlign: TextAlign = TextAlign.Start,
        maxLines: Int = Int.MAX_VALUE,
        overflow: TextOverflow = TextOverflow.Clip
    ) {
        AppText(
            modifier = modifier,
            text = text,
            color = color,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = fontWeight,
            overrideStyle = style,
            textAlign = textAlign,
            maxLines = maxLines,
            overflow = overflow,
            alpha = if (isSecondary) Alpha.AlphaHigh else Alpha.AlphaFull
        )
    }

    @Composable
    fun LabelSmall(
        modifier: Modifier = Modifier,
        text: String,
        color: Color = Color.Unspecified,
        fontWeight: FontWeight? = null,
        style: TextStyle? = null,
        isSecondary: Boolean = false,
        textAlign: TextAlign = TextAlign.Start
    ) {
        AppText(
            modifier = modifier,
            text = text,
            style = MaterialTheme.typography.labelSmall,
            color = color,
            fontWeight = fontWeight,
            overrideStyle = style,
            textAlign = textAlign,
            alpha = if (isSecondary) Alpha.AlphaHigh else Alpha.AlphaFull
        )
    }

    @Composable
    fun TextError(modifier: Modifier = Modifier, text: String) {
        LabelLarge(
            modifier = modifier.fillMaxWidth(),
            text = text,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
private fun AppText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    overrideStyle: TextStyle? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    alpha: Float = 1f
) {
    var mergedStyle = overrideStyle ?: style
    if (fontWeight != null) {
        mergedStyle = mergedStyle.copy(fontWeight = fontWeight)
    }

    Text(
        text = text,
        style = mergedStyle,
        color = if (color == Color.Unspecified) {
            MaterialTheme.colorScheme.onSurface.copy(alpha = alpha)
        } else {
            color
        },
        fontFamily = fontFamily,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}

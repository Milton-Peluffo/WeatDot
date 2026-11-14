package com.tomildev.weatdot.core.util

import android.content.Context
import android.text.format.DateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

enum class TimeFormat {
    TWELVE_HOUR,
    TWENTY_FOUR_HOUR
}

data class FormattedTime(
    val hour: String,
    val period: String? = null
)

object TimeFormatter {

    fun getSystemTimeFormat(context: Context): TimeFormat {
        return if (DateFormat.is24HourFormat(context)) {
            TimeFormat.TWENTY_FOUR_HOUR
        } else {
            TimeFormat.TWELVE_HOUR
        }
    }

    fun formatHour(isoTime: String, format: TimeFormat): FormattedTime {
        return try {
            val dateTime = LocalDateTime.parse(isoTime, DateTimeFormatter.ISO_DATE_TIME)
            when (format) {
                TimeFormat.TWELVE_HOUR -> {
                    val hour = dateTime.format(DateTimeFormatter.ofPattern("hh:mm"))
                    val period = dateTime.format(DateTimeFormatter.ofPattern("a"))
                    FormattedTime(hour = hour, period = period)
                }

                TimeFormat.TWENTY_FOUR_HOUR -> {
                    val hour = dateTime.format(DateTimeFormatter.ofPattern("HH:mm"))
                    FormattedTime(hour = hour, period = null)
                }
            }
        } catch (e: Exception) {
            FormattedTime(hour = isoTime.substringAfter("T"), period = null)
        }
    }

    fun formatTimestamp(timestampMs: Long, format: TimeFormat): FormattedTime {
        if (timestampMs == 0L) return FormattedTime(hour = "", period = null)

        return try {
            val dateTime = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(timestampMs),
                ZoneId.systemDefault()
            )
            when (format) {
                TimeFormat.TWELVE_HOUR -> {
                    val hour = dateTime.format(DateTimeFormatter.ofPattern("hh:mm"))
                    val period = dateTime.format(DateTimeFormatter.ofPattern("a"))
                    FormattedTime(hour = hour, period = period)
                }

                TimeFormat.TWENTY_FOUR_HOUR -> {
                    val hour = dateTime.format(DateTimeFormatter.ofPattern("HH:mm"))
                    FormattedTime(hour = hour, period = null)
                }
            }
        } catch (e: Exception) {
            FormattedTime(hour = "", period = null)
        }
    }
}
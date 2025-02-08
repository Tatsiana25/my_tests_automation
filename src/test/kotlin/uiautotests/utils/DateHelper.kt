package uiautotests.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DateHelper {
    companion object {
        fun getTodayDate(formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")): String {
            val date = LocalDateTime.now()
            return formatter.format(date)
        }

        fun getYesterdayDate(formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")): String {
            val yesterday = LocalDateTime.now().minusDays(1)
            return formatter.format(yesterday)
        }

        fun getTomorrowDate(formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")): String {
            val tomorrow = LocalDateTime.now().plusDays(1)
            return formatter.format(tomorrow)
        }

        fun getNextMonthDate(formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")): String {
            val nextMonth = LocalDateTime.now().plusMonths(1)
            return formatter.format(nextMonth)
        }

        /*
        fun getCurrentDayOfWeek(): DayOfWeek {
            return LocalDateTime.now().dayOfWeek
        }

        // Метод для форматирования дня недели
        fun formatDayOfWeek(dayOfWeek: DayOfWeek): String {
            val dayOfWeekName = dayOfWeek.name.lowercase(Locale.ROOT)
            return dayOfWeekName.substring(0, 1).uppercase() + dayOfWeekName.substring(1)
        }
         */

        fun getCurrentDayOfWeekFormatted(formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH)): String {
            val currentDate = LocalDateTime.now()
            return formatter.format(currentDate)
        }

    }
}
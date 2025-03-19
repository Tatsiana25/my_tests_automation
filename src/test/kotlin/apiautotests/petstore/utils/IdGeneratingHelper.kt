package apiautotests.petstore.utils

class IdGeneratingHelper {
    companion object {
        fun generateIdLong(): Long {
            // Цифры объединяем в строку без пробелов
            val first18Digits = (1..18).map { (0..9).random() }.joinToString("")

            val lastDigit = if (first18Digits.all { it == '0' }) {
                (1..9).random()
            } else {
                (0..9).random()
            }

            return "$first18Digits$lastDigit".toLong()
        }
    }
}
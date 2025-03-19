## Описание проекта
Проект написан на Kotlin с использованием Selenium, Selenide, JUnit.

Для запуска ui тестов ChromeDriver скачивать не нужно, т.к. настроен WebDriverManager.

Задачи по ui автотестам взяты с ресурса http://uitestingplayground.com/

### Структура
- Тесты (ui) находятся в src/test/kotlin/uiautotests
- Описание страниц для этих тестов находится в src/test/kotlin/uiautotests/model
- Т.ж. для этих тестов существует конфиг, который находится в src/test/kotlin/uiautotests/config
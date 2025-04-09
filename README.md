## Описание проекта
Проект написан на Kotlin с использованием Selenium, Selenide, JUnit (для ui автотестов) и REST Assured (для api автотестов)

Для запуска ui тестов ChromeDriver скачивать не нужно, т.к. настроен WebDriverManager.

Задачи по ui автотестам взяты с ресурса http://uitestingplayground.com/

Документация по api взята с ресурса http://petstore.swagger.io/

### Структура

#### UI
- Тесты находятся в src/test/kotlin/uiautotests
- Описание страниц для этих тестов находится в src/test/kotlin/uiautotests/model
- Т.ж. для этих тестов существует конфиг, который находится в src/test/kotlin/uiautotests/config

#### API
- Тесты находятся в src/test/kotlin/apiautotests
- Pojo классы для этих тестов находятся в src/test/kotlin/apiautotests/petstore/pojo
- Для тестов существуют спецификации, которые находятся в src/test/kotlin/apiautotests/petstore/Specs.kt
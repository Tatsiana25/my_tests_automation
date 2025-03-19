package apiautotests.petstore

import apiautotests.petstore.pojo.Category
import apiautotests.petstore.pojo.Pet
import apiautotests.petstore.pojo.Tag
import io.restassured.RestAssured
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Тесты для проверки создания питомцев")
class PetTest {
    //private val logger: Logger = LogManager.getLogger(PetTest::class.java)

    @Test
    @DisplayName("Питомец с валидными данными успешно создаётся")
    fun createOfNewPetIsSuccessful() {
        Specs.installSpec(Specs.requestSpec("https://petstore.swagger.io", "/v2"), Specs.responseSpec())

        val petReq = Pet(
            category = Category(name = "Dogs"),
            name = "Bobik",
            photoUrls = listOf("src/test/resources/images/big_dog.jpg"),
            tags = listOf(Tag(name = "Big"))
        )
        val petRes = RestAssured
            .given()
            .`when`()
            .body(petReq)
            .post("/pet")
            .then()
            .statusCode(200)
            .extract().response()
    }
}
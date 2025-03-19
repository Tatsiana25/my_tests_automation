package apiautotests.petstore

import apiautotests.petstore.pojo.Category
import apiautotests.petstore.pojo.Pet
import apiautotests.petstore.pojo.Tag
import io.restassured.RestAssured
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.hamcrest.Matchers
import org.junit.jupiter.api.*
import apiautotests.petstore.utils.IdGeneratingHelper

@DisplayName("Тесты для проверки создания питомцев")
class PetTest {
    private val logger: Logger = LogManager.getLogger(PetTest::class.java)

    companion object {
        var id: Long = 0L

        @BeforeAll
        @JvmStatic
        fun setup() {
            id = IdGeneratingHelper.generateIdLong()

            Specs.installSpec(Specs.requestSpec("https://petstore.swagger.io", "/v2"), Specs.responseSpec())
        }
    }

    @AfterEach
    fun deletePetById() {
        RestAssured
            .given()
            .`when`()
            .delete("/pet/${id}")
            .then()
            .statusCode(200)
        logger.info("\nПитомец удалён\n")
    }

    @Test
    @DisplayName("Питомец с валидными данными успешно создаётся")
    fun createOfNewPetIsSuccessful() {
        val petReq = Pet(
            id = id,
            category = Category(id = id, name = "Dogs"),
            name = "Bobik",
            photoUrls = listOf("src/test/resources/images/big_dog.jpg"),
            tags = listOf(Tag(id = id, name = "Big"))
        )
        val petRes = RestAssured
            .given()
            .`when`()
            .body(petReq)
            .post("/pet")
            .then()
            .statusCode(200)
            .extract().response().`as`(Pet::class.java)
        logger.info("\nПитомец создан\n")

        RestAssured
            .given()
            .`when`()
            .get("/pet/${petReq.id}")
            .then()
            .statusCode(200)
            .body("name", Matchers.equalTo(petReq.name))
            .body("category.name", Matchers.equalTo(petReq.category.name))
            .body("tags[0].name", Matchers.equalTo(petReq.tags[0].name))
        logger.info("\nПитомец вызван\n")
    }
}
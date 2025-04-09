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
        logger.info("\n----------\nПитомец удалён\n----------\n")
    }

    @Test
    @DisplayName("Питомец с валидными данными успешно создаётся")
    fun createOfNewPetIsSuccessful() {
        val pet = Pet(
            id = id,
            category = Category(id = id, name = "Dogs"),
            name = "Bobik",
            photoUrls = listOf("src/test/resources/images/big_dog.jpg"),
            tags = listOf(Tag(id = id, name = "Big"))
        )
        val createPet = RestAssured
            .given()
            .`when`()
            .body(pet)
            .post("/pet")
            .then()
            .statusCode(200)
            .extract().response().`as`(Pet::class.java)
        Assertions.assertEquals(pet, createPet)
        logger.info("\n----------\nПитомец создан\n----------\n")


        RestAssured
            .given()
            .`when`()
            .get("/pet/${pet.id}")
            .then()
            .statusCode(200)
            .body("name", Matchers.equalTo(pet.name))
            .body("category.name", Matchers.equalTo(pet.category.name))
            .body("tags[0].name", Matchers.equalTo(pet.tags[0].name))
        logger.info("\n----------\nПитомец вызван\n----------\n")

        fun waitUntilResourceExists(resourceId: Long, timeout: Long = 10000, interval: Long = 500) {
            val startTime = System.currentTimeMillis()
            while (System.currentTimeMillis() - startTime < timeout) {
                val statusCode = RestAssured
                    .given()
                    .get("/pet/$resourceId")
                    .statusCode
                if (statusCode == 200) {
                    return
                }
                Thread.sleep(interval) // Ждем перед следующей проверкой
            }
            throw AssertionError("Ресурс с id=$resourceId не стал доступен в течение $timeout мс.")
        }
    }
}
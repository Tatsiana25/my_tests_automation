package apiautotests.petstore

import io.restassured.RestAssured
import io.restassured.config.HttpClientConfig
import io.restassured.builder.RequestSpecBuilder
import io.restassured.builder.ResponseSpecBuilder
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import io.restassured.specification.ResponseSpecification

// http://petstore.swagger.io/v2

object Specs {

    fun requestSpec(baseUri: String, basePath: String): RequestSpecification {
        return RequestSpecBuilder()
            .setBaseUri(baseUri)
            .setBasePath(basePath)
            .setContentType(ContentType.JSON)
            .addHeader("Cache-Control", "no-cache")
            .log(LogDetail.ALL)
            .build()
    }

    fun responseSpec(): ResponseSpecification {
        return ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build()
    }

    fun installSpec(request: RequestSpecification, response: ResponseSpecification) {
        RestAssured.requestSpecification = request
        RestAssured.responseSpecification = response
    }
}
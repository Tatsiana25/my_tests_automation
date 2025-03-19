package apiautotests.petstore.pojo

import apiautotests.petstore.utils.IdGeneratingHelper

data class Category (
    val id: Long = IdGeneratingHelper.generateIdLong(),
    val name: String
)
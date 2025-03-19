package apiautotests.petstore.pojo

import apiautotests.petstore.utils.IdGeneratingHelper

data class Tag (
    val id: Long = IdGeneratingHelper.generateIdLong(),
    val name: String
)
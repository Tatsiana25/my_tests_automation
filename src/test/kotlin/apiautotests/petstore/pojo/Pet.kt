package apiautotests.petstore.pojo

import apiautotests.petstore.utils.IdGeneratingHelper

data class Pet (
    val id: Long,
    val category: Category,
    val name: String,
    val photoUrls: List<String>,
    val tags: List<Tag>,
    val status: PetStatus = PetStatus.available
)
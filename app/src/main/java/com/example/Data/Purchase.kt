package data

import repositories.GameRepository
import repositories.PurchaseRepository

data class Purchase(
    val id: Long,
    val userId: Long,
    val gameId: Long,
    val amount: Double,
    val createdDate: String,
){

    override fun toString(): String {
        return "Purchase(id=$id, userId=$userId, gameId=$gameId, amount=$amount, createdDate='$createdDate')"
    }


}

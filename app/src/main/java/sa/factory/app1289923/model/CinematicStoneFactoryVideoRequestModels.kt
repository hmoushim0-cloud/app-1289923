package sa.factory.app1289923.model

import kotlinx.serialization.Serializable

@Serializable
data class MARMARAKB2BLead(
    val id: String,
    val title: String,
    val description: String,
    val priceMinorUnits: Long,
    val iconVector: String = "verified"
)

@Serializable
data class CinematicStoneFactoryVideoRequest(
    val requestId: String,
    val items: List<MARMARAKB2BLead>,
    val customerPhone: String,
    val totalAmountMinorUnits: Long,
    val status: CinematicStoneFactoryVideoRequestStatus = CinematicStoneFactoryVideoRequestStatus.PENDING,
    val createdAtEpochMs: Long = System.currentTimeMillis()
)

enum class CinematicStoneFactoryVideoRequestStatus {
    PENDING,
    ACCEPTED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}

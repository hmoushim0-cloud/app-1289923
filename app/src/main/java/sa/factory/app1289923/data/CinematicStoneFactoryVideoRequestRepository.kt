package sa.factory.app1289923.data

import sa.factory.app1289923.model.CinematicStoneFactoryVideoRequest
import sa.factory.app1289923.model.MARMARAKB2BLead
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

interface CinematicStoneFactoryVideoRequestRepository {
    fun getAvailableCatalog(): Flow<List<MARMARAKB2BLead>>
    fun getActiveRequest(): Flow<CinematicStoneFactoryVideoRequest?>
    suspend fun submitRequest(request: CinematicStoneFactoryVideoRequest): Result<String>
}

class InMemoryCinematicStoneFactoryVideoRequestRepository : CinematicStoneFactoryVideoRequestRepository {
    private val _catalog = MutableStateFlow<List<MARMARAKB2BLead>>(listOf(
        MARMARAKB2BLead("1", "باكدج إعلان سينمائي 30-40 ثانية", "إنتاج فيديو تسويقي مدته 30-40 ثانية موجه لأصحاب مناشر ومصانع الرخام والحجر والجرانيت مع خطة رسائل مصممة لرفع طلبات الاستفسار", 5000L, "verified"),
        MARMARAKB2BLead("2", "باكدج توزيع رسائل حسب الفئة المستهدفة", "نسختان إلى ثلاث نسخ رسائل إعلانية للفئات: معارض السيراميك والبورسلان، ورش الحجر والديكور، وخط معدات وأدوات التصنيع لزيادة ملاءمة العرض ورفع معدلات الرد", 9500L, "bolt")
    ))
    private val _active = MutableStateFlow<CinematicStoneFactoryVideoRequest?>(null)

    override fun getAvailableCatalog(): Flow<List<MARMARAKB2BLead>> = _catalog.asStateFlow()
    override fun getActiveRequest(): Flow<CinematicStoneFactoryVideoRequest?> = _active.asStateFlow()

    override suspend fun submitRequest(request: CinematicStoneFactoryVideoRequest): Result<String> {
        _active.value = request
        return Result.success(request.requestId)
    }
}

package sa.factory.app1289923.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import sa.factory.app1289923.data.CinematicStoneFactoryVideoRequestRepository
import sa.factory.app1289923.model.CinematicStoneFactoryVideoRequest
import sa.factory.app1289923.model.MARMARAKB2BLead
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CinematicStoneFactoryVideoRequestViewModel(
    private val repository: CinematicStoneFactoryVideoRequestRepository
) : ViewModel() {
    val catalog: StateFlow<List<MARMARAKB2BLead>> = repository.getAvailableCatalog()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val activeRequest: StateFlow<CinematicStoneFactoryVideoRequest?> = repository.getActiveRequest()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun submitNewOrder(request: CinematicStoneFactoryVideoRequest) {
        viewModelScope.launch {
            repository.submitRequest(request)
        }
    }
}

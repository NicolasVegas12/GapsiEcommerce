package com.nvegas.presentation.ui.pages.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nvegas.domain.models.ProductItemModel
import com.nvegas.domain.use_cases.GetProductsBySugestionUseCase
import com.nvegas.domain.use_cases.GetSuggestionsUseCase
import com.nvegas.presentation.ui.pages.main.components.pagers.ProductsPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsBySugestionUseCase,
    private val getSuggestionsUseCase: GetSuggestionsUseCase
) : ViewModel() {
    private val _pager = MutableStateFlow<Flow<PagingData<ProductItemModel>>?>(null)
    val pager: StateFlow<Flow<PagingData<ProductItemModel>>?> = _pager

    private val _suggestionText = mutableStateOf("")
    val suggestionText: State<String> = _suggestionText


    private val _suggestions = MutableStateFlow<List<String>>(emptyList())
    val suggestions: StateFlow<List<String>> = _suggestions

    init {
        viewModelScope.launch {
            getSuggestionsUseCase().collect { list ->
                _suggestions.value = list
            }
        }
    }

    fun getProducts() {
        _pager.value = Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                ProductsPagingSource(
                    getProductsUseCase = getProductsUseCase,
                    suggestion = suggestionText.value
                )
            }
        ).flow.cachedIn(viewModelScope)
    }

    fun updateSuggestion(value:String){
        _suggestionText.value = value
    }









}
package com.nvegas.presentation.ui.pages.main.components.pagers

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nvegas.domain.models.ProductItemModel
import com.nvegas.domain.use_cases.GetProductsBySugestionUseCase

class ProductsPagingSource(
    private val getProductsUseCase: GetProductsBySugestionUseCase,
    private val suggestion: String
) : PagingSource<Int, ProductItemModel>() {
    override fun getRefreshKey(state: PagingState<Int, ProductItemModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductItemModel> {
        val page = params.key ?: 1

        val response = getProductsUseCase(
            page = page,
            suggestion = suggestion
        )

        return LoadResult.Page(
            data = response.firstOrNull()?.items ?: emptyList(),
            prevKey = if (page == 1) null else page - 1,
            nextKey = if (response.firstOrNull()?.items?.isEmpty() == true) null else page + 1
        )
    }
}
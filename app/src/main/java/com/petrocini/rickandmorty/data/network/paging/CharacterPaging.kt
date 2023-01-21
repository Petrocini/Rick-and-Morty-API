package com.petrocini.rickandmorty.data.network.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.petrocini.rickandmorty.data.network.service.ApiService
import com.petrocini.rickandmorty.domain.model.Character

class CharacterPaging(
    private val apiService: ApiService
): PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageNumber = params.key ?: 1
        return try {
            val response = apiService.getAllCharacters(pageNumber)
            val pageInfo = response.body()
            val characters = pageInfo?.results

            var nextPageNumber: Int? = null

            if (pageInfo?.info?.next != null) {
                val uri = Uri.parse(pageInfo.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            LoadResult.Page(
                data = characters.orEmpty(),
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
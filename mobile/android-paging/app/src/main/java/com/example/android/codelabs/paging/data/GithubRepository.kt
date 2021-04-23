/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.paging.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android.codelabs.paging.api.GithubService
import com.example.android.codelabs.paging.db.RepoDatabase
import com.example.android.codelabs.paging.model.Repo
import kotlinx.coroutines.flow.Flow

// GitHub page API is 1 based: https://developer.github.com/v3/#pagination
private const val GITHUB_STARTING_PAGE_INDEX = 1

/**
 * Repository class that works with local and remote data sources.
 */
class GithubRepository(private val service: GithubService, private val database: RepoDatabase) {

    // keep the list of all results received
//    private val inMemoryCache = mutableListOf<Repo>()
//
//    // shared flow of results, which allows us to broadcast updates so
//    // the subscriber will have the latest data
//    private val searchResults = MutableSharedFlow<RepoSearchResult>(replay = 1)
//
//    // keep the last requested page. When the request is successful, increment the page number.
//    private var lastRequestedPage = GITHUB_STARTING_PAGE_INDEX
//
//    // avoid triggering multiple requests in the same time
//    private var isRequestInProgress = false

    /**
     * Search repositories whose names match the query, exposed as a stream of data that will emit
     * every time we get more data from the network.
     */
//    suspend fun getSearchResultStream(query: String): Flow<RepoSearchResult> {
//        Log.d("GithubRepository", "New query: $query")
//        lastRequestedPage = 1
//        inMemoryCache.clear()
//        requestAndSaveData(query)
//
//        return searchResults
//    }

    fun getSearchResultStream(query: String): Flow<PagingData<Repo>> {

        // appending '%' so we can allow other characters to be before and after the query string
        val dbQuery = "%${query.replace(' ', '%')}%"
        val pagingSourceFactory =  { database.reposDao().reposByName(dbQuery)}

//        return Pager(
//                config = PagingConfig(
//                        pageSize = NETWORK_PAGE_SIZE,
//                        enablePlaceholders = false
//                ),
//                pagingSourceFactory = { GithubPagingSource(service, query) }
//        ).flow
        @OptIn(ExperimentalPagingApi::class)
        return Pager(
                config = PagingConfig(
                        pageSize = NETWORK_PAGE_SIZE,
                        enablePlaceholders = false
                ),
                remoteMediator = GithubRemoteMediator(
                        query,
                        service,
                        database
                ),
                pagingSourceFactory = pagingSourceFactory
        ).flow
    }

//    suspend fun requestMore(query: String) {
//        if (isRequestInProgress) return
//        val successful = requestAndSaveData(query)
//        if (successful) {
//            lastRequestedPage++
//        }
//    }

//    suspend fun retry(query: String) {
//        if (isRequestInProgress) return
//        requestAndSaveData(query)
//    }
//
//    private suspend fun requestAndSaveData(query: String): Boolean {
//        isRequestInProgress = true
//        var successful = false
//
//        val apiQuery = query + IN_QUALIFIER
//        try {
//            val response = service.searchRepos(apiQuery, lastRequestedPage, NETWORK_PAGE_SIZE)
//            Log.d("GithubRepository", "response $response")
//            val repos = response.items ?: emptyList()
//            inMemoryCache.addAll(repos)
//            val reposByName = reposByName(query)
//            searchResults.emit(RepoSearchResult.Success(reposByName))
//            successful = true
//        } catch (exception: IOException) {
//            searchResults.emit(RepoSearchResult.Error(exception))
//        } catch (exception: HttpException) {
//            searchResults.emit(RepoSearchResult.Error(exception))
//        }
//        isRequestInProgress = false
//        return successful
//    }
//
//    private fun reposByName(query: String): List<Repo> {
//        // from the in memory cache select only the repos whose name or description matches
//        // the query. Then order the results.
//        return inMemoryCache.filter {
//            it.name.contains(query, true) ||
//                (it.description != null && it.description.contains(query, true))
//        }.sortedWith(compareByDescending<Repo> { it.stars }.thenBy { it.name })
//    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}
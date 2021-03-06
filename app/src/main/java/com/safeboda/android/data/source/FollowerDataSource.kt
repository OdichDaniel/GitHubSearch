package com.safeboda.android.data.source

import androidx.paging.PagingSource
import com.safeboda.android.api.NetworkApi
import com.safeboda.android.data.GitFollower
import com.safeboda.android.data.GitHubUser
import javax.inject.Inject

// This is pagination way of implementing a endless scrolling
class FollowerDataSource @Inject constructor(val networkApi: NetworkApi): PagingSource<Int, GitFollower>() {

    // This should have been passed through Assisted Injection
    var gitHubUser: GitHubUser? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GitFollower> {

        try{

            gitHubUser?.let {user ->


                val position = params.key ?: 0

                // Using login here, name does not seem to work
                val response = networkApi.getFollowers(user.login!!, PAGE_SIZE, position)

                response.body()?.let {

                    if(response.isSuccessful){

                        return LoadResult.Page(
                            data = it,
                            prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                            nextKey = if (it.isEmpty()) null else position + 1
                        )
                    }
                }
            }

            return  LoadResult.Error(Throwable("Couldn't load followers"))

        }catch (e: Exception){
            return  LoadResult.Error(Throwable("Couldn't load followers"))
        }


    }

    companion object{

        val STARTING_PAGE_INDEX = 0
        val PAGE_SIZE = 10
    }

}
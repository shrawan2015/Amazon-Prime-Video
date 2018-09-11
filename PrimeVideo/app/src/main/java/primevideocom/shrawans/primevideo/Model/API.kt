package primevideocom.shrawans.primevideo.Model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GithubService {
    @GET("popular?api_key=43dd8bb11c9abefef643794c5e0953d2&language=en-US&page=1")
    fun retrieveNews(): Call<MovieList>
}

class RepositoryRetriever {
    private val service: GithubService

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/movie/"
    }

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL) //1
                .addConverterFactory(GsonConverterFactory.create()) //2
                .build()
        service = retrofit.create(GithubService::class.java) //3
    }

    fun getRepositories(callback: Callback<MovieList>) { //4
        service.retrieveNews().enqueue(callback)
    }
}
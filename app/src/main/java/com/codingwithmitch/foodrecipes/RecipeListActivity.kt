package com.codingwithmitch.foodrecipes

import android.os.Bundle
import android.view.View
import com.codingwithmitch.foodrecipes.requests.ServiceGenerator
import android.util.Log
import com.codingwithmitch.foodrecipes.requests.responses.RecipeResponse
import com.codingwithmitch.foodrecipes.requests.responses.RecipeSearchResponse
import com.codingwithmitch.foodrecipes.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException



class RecipeListActivity : BaseActivity() {

    private val TAG = "RecipeListActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        findViewById<View>(R.id.test).setOnClickListener {
            if (mProgressBar.visibility == View.VISIBLE) {
                showProgressBar(false)
            } else {
                showProgressBar(true)
            }
            testRetrofitRequest2()
        }
    }

    private fun testRetrofitRequest() {
        val recipeApi = ServiceGenerator().getRecipeApi()
        val responseCall = recipeApi.searchRecipe(
                Constants.API_KEY,
                "Chicken breast",
                "1"
        )
        responseCall.enqueue(object : Callback<RecipeSearchResponse> {

            override fun onResponse(call: Call<RecipeSearchResponse>, response: Response<RecipeSearchResponse>) {
                if (response.code() == 200) {
                    val recipe = response.body()?.recipes
                    Log.d(TAG, "onResponse: " + recipe.toString())
                }
                else{
                    try {
                        Log.d(TAG, "onResponse: " + response.errorBody())
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<RecipeSearchResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
            }
        })
    }


    private fun testRetrofitRequest2() {
        val recipeApi = ServiceGenerator().getRecipeApi()
        val responseCall = recipeApi.getRecipe(
                Constants.API_KEY,
                "1234"
        )
        responseCall.enqueue(object : Callback<RecipeResponse> {

            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                if (response.code() == 200) {
                    val recipe = response.body()?.recipe
                    Log.d(TAG, "onResponse: " + recipe.toString())
                }
                else{
                    try {
                        Log.d(TAG, "onResponse: " + response.errorBody())
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
            }
        })
    }

}


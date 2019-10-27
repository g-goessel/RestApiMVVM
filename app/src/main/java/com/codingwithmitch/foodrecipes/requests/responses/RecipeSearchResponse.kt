package com.codingwithmitch.foodrecipes.requests.responses

import com.codingwithmitch.foodrecipes.models.Recipe
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class RecipeSearchResponse {

    @SerializedName("count")
    @Expose
    val count: Int = 0

    @SerializedName("recipes")
    @Expose
    val recipes: List<Recipe>? = null

    override fun toString(): String {
        return "RecipeSearchResponse{" +
                "count=" + count +
                ", recipes=" + recipes +
                '}'.toString()
    }
}
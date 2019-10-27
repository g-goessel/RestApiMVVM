package com.codingwithmitch.foodrecipes.requests.responses

import com.codingwithmitch.foodrecipes.models.Recipe
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class RecipeResponse {

    @SerializedName("recipe")
    @Expose
    val recipe: Recipe? = null

    override fun toString(): String {
        return "RecipeResponse{" +
                "recipe=" + recipe +
                '}'.toString()
    }
}
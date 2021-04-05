package com.manoolsbl4.mynutrition2.viewmodel.detailfragment

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.manoolsbl4.mynutrition2.model.Food
import com.manoolsbl4.mynutrition2.model.Hints
import com.manoolsbl4.mynutrition2.viewmodel.startfragment.FoodDeserializer
import java.lang.reflect.Type

class DetailsHintsDeserializer: JsonDeserializer<Hints> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Hints {
        val jobject = json?.asJsonObject
        val hints = jobject?.get("hints")?.asJsonArray
        val food: Food = FoodDeserializer().deserialize(hints?.get(0)?.asJsonObject)

        return Hints(
            food.label,
            listOf(),
            listOf(food)
        )
    }
}


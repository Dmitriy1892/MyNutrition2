package com.manoolsbl4.mynutrition2.viewmodel.startfragment

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.manoolsbl4.mynutrition2.model.Food
import com.manoolsbl4.mynutrition2.model.Hints
import com.manoolsbl4.mynutrition2.model.Nutrients
import java.lang.reflect.Type


class HintsDeserializer: JsonDeserializer<Hints> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Hints {
        val jobject = json?.asJsonObject

        val jpar = jobject?.get("parsed")?.asJsonArray

        val parsed = mutableListOf<Food>()

        for (i in 0 until jpar?.size()!!) {
            parsed.add(FoodDeserializer().deserialize(jpar.get(i) as JsonObject))
        }

        val jhint = jobject?.get("hints")?.asJsonArray

        val hints = mutableListOf<Food>()

        for (i in 0 until jhint?.size()!!) {
            hints.add(FoodDeserializer().deserialize(jhint.get(i) as JsonObject))
        }

        return Hints(
            jobject?.get("text")?.asString,
            parsed = parsed,
            hints = hints
        )
    }

}

class FoodDeserializer{
    fun deserialize(
        jobj: JsonObject?
    ): Food {
        val jobject = jobj?.get("food")?.asJsonObject

        val jnut = jobject?.get("nutrients")?.asJsonObject

        val nutrients = NutrientsDeserializer().deserialize(jnut)

        return Food(
            jobject?.get("foodId")?.asString,
            jobject?.get("label")?.asString,
            nutrients,
            jobject?.get("image")?.asString
        )
    }
}

class NutrientsDeserializer {
    fun deserialize(json: JsonObject?): Nutrients {
        val jobject = json?.asJsonObject

        return Nutrients(
            jobject?.get("ENERC_KCAL")?.asDouble,
            jobject?.get("PROCNT")?.asDouble,
            jobject?.get("FAT")?.asDouble,
            jobject?.get("CHOCDF")?.asDouble,
            jobject?.get("FIBTG")?.asDouble
        )
    }
}
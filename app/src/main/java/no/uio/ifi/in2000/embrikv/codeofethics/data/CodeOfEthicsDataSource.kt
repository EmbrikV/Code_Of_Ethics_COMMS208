package no.uio.ifi.in2000.embrikv.codeofethics.data

import android.content.Context
import com.google.gson.Gson
import no.uio.ifi.in2000.embrikv.codeofethics.model.Code



class CodeOfEthicsDataSource(private val context: Context) {

    private val gson = Gson()

    fun getCodesFromJson(): List<Code> {
        val json = context.assets.open("Code.json")
            .bufferedReader()
            .use { it.readText() }

        return gson.fromJson(json, Array<Code>::class.java).toList()
    }
}

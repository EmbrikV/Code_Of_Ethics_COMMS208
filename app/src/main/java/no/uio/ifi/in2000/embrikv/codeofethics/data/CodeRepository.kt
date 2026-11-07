package no.uio.ifi.in2000.embrikv.codeofethics.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import no.uio.ifi.in2000.embrikv.codeofethics.model.Code



class CodeRepository(private val source: CodeOfEthicsDataSource) {

    suspend fun getCodes(): List<Code> = withContext(Dispatchers.IO) {
        source.getCodesFromJson()
    }
}


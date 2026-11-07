package no.uio.ifi.in2000.embrikv.codeofethics.model

data class Code(
    val number: Int,
    val title: String,
    val info: String,
    val code: List<String>,
    val color: Long
)
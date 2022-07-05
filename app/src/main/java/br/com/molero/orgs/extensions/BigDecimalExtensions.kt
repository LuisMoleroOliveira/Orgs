package br.com.molero.orgs.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.formatPriceBr(): String {
    val format: NumberFormat = NumberFormat
        .getCurrencyInstance(Locale("pt", "br"))
    return format.format(this)
}
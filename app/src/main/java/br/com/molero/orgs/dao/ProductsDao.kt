package br.com.molero.orgs.dao

import br.com.molero.orgs.model.Product
import java.math.BigDecimal

class ProductsDao {

    fun add(product: Product) {
        Companion.products.add(product)
    }
    fun searchAll() : List<Product>{
      return Companion.products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>(
            //Product(name = "Salada de fruta", description = "Isso é uma salada de frutas", price = BigDecimal("19.99"))
        )
    }
}

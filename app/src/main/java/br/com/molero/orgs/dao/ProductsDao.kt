package br.com.molero.orgs.dao

import br.com.molero.orgs.model.Product

class ProductsDao {

    fun add(product: Product) {
        Companion.products.add(product)
    }
    fun searchAll() : List<Product>{
      return Companion.products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }
}

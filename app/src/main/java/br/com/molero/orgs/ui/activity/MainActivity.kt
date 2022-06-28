package br.com.molero.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.molero.orgs.R
import br.com.molero.orgs.model.Product
import br.com.molero.orgs.ui.recyclerview.adapter.ListProductsAdapter
import java.math.BigDecimal

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListProductsAdapter(
            context = this, products = listOf(
                Product(
                    name = "Salada", description = "Isso é uma Salada", price = BigDecimal("19.99")

                ),
                Product(
                    name = "Frango", description = "Isso é um Frango", price = BigDecimal("35.99")
                )
            )
        )
        //recyclerView.layoutManager = LinearLayoutManager(this) Foi implementado o layoutManager via XML em activity_main dentro do componente da RecyclerView
    }
}
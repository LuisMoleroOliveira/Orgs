package br.com.molero.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.molero.orgs.R
import br.com.molero.orgs.dao.ProductsDao
import br.com.molero.orgs.model.Product
import br.com.molero.orgs.ui.recyclerview.adapter.ListProductsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recyclerView.layoutManager = LinearLayoutManager(this)
        // Foi implementado o layoutManager via XML em activity_main dentro do componente da RecyclerView
    }

    override fun onResume() {
        super.onResume()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dao = ProductsDao()
        recyclerView.adapter = ListProductsAdapter(context = this, products = dao.searchAll())
        val fab = findViewById<FloatingActionButton>(R.id.float_button_add)
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }
}

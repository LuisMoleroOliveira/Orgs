package br.com.molero.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.molero.orgs.R
import br.com.molero.orgs.dao.ProductsDao
import br.com.molero.orgs.ui.recyclerview.adapter.ListProductsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val dao = ProductsDao()
    private val adapter = ListProductsAdapter(context = this, products = dao.searchAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configRecyclerView()
        configFab()
        //recyclerView.layoutManager = LinearLayoutManager(this)
        // Foi implementado o layoutManager via XML em activity_main dentro do componente da RecyclerView
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.searchAll())
    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_main_float_button_add)
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }
}

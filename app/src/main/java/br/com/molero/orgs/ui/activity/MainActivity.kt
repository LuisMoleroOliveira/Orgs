package br.com.molero.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.molero.orgs.dao.ProductsDao
import br.com.molero.orgs.databinding.ActivityMainBinding
import br.com.molero.orgs.ui.recyclerview.adapter.ListProductsAdapter

class MainActivity : AppCompatActivity() {
    private val dao = ProductsDao()
    //private val adapter = ListProductsAdapter(context = this, products = dao.searchAll())
    private val adapter by lazy {
        ListProductsAdapter(this, products = dao.searchAll())    }
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater) // adicionado para o View Binding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) substituído pelo View Binding abaixo
        setContentView(binding.root)
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
        //val fab = findViewById<FloatingActionButton>(R.id.activity_main_float_button_add) substituído pelo View Binding abaixo
        val fab = binding.activityMainFloatButtonAdd
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configRecyclerView() {
        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerView) substituído pelo View Binding abaixo
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
    }
}

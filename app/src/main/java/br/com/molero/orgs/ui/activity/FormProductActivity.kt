package br.com.molero.orgs.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.molero.orgs.dao.ProductsDao
import br.com.molero.orgs.databinding.ActivityFormProductBinding
import br.com.molero.orgs.extensions.tryLoadImage
import br.com.molero.orgs.model.Product
import br.com.molero.orgs.ui.dialog.FormImageDialog
import coil.imageLoader
import coil.load
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityFormProductBinding.inflate(layoutInflater) // adicionado para o View Binding
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_form_product) substituído pelo View Binding abaixo
        setContentView(binding.root)
        title="Cadastrar produto"
        configButtonSave()
        binding.activityFormProductImageView.setOnClickListener(View.OnClickListener {
            FormImageDialog(this).show(url){ image ->
                url = image
                binding.activityFormProductImageView.tryLoadImage(url)
            }
        })
    }

    private fun configButtonSave() {
        //val buttonSave = findViewById<Button>(R.id.activity_form_button_save) substituído pelo View Binding abaixo
        val buttonSave = binding.activityFormButtonSave
        val dao = ProductsDao()

        buttonSave.setOnClickListener {
            val newProduct = createProduct()
            dao.add(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product {
        //val fieldName = findViewById<EditText>(R.id.activity_form_product_name) substituído pelo View Binding abaixo
        val fieldName = binding.activityFormProductName
        val name = fieldName.text.toString()
        //val fieldDescription = findViewById<EditText>(R.id.activity_form_product_description) substituído pelo View Binding abaixo
        val fieldDescription = binding.activityFormProductDescription
        val description = fieldDescription.text.toString()
        //val fieldPrice = findViewById<EditText>(R.id.activity_form_product_price) substituído pelo View Binding abaixo
        val fieldPrice = binding.activityFormProductPrice
        val priceInText = fieldPrice.text.toString()
        val price = if (priceInText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(priceInText)
        }
        return Product(
            name = name,
            description = description,
            price = price,
            image = url
        )
    }
}
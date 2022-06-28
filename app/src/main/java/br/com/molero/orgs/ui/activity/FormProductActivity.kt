package br.com.molero.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.molero.orgs.R
import br.com.molero.orgs.dao.ProductsDao
import br.com.molero.orgs.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_product)
        configButtonSave()
    }

    private fun configButtonSave() {
        val buttonSave = findViewById<Button>(R.id.activity_form_button_save)
        val dao = ProductsDao()

        buttonSave.setOnClickListener {
            val newProduct = createProduct()
            dao.add(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product {
        val fieldName = findViewById<EditText>(R.id.activity_form_product_name)
        val name = fieldName.text.toString()
        val fieldDescription = findViewById<EditText>(R.id.activity_form_product_description)
        val description = fieldDescription.text.toString()
        val fieldPrice = findViewById<EditText>(R.id.activity_form_product_price)
        val priceInText = fieldPrice.text.toString()
        val price = if (priceInText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(priceInText)
        }
        return Product(
            name = name,
            description = description,
            price = price
        )
    }
}

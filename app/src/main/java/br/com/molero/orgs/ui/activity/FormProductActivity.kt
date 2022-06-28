package br.com.molero.orgs.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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

        val buttonSave = findViewById<Button>(R.id.button_save)

        buttonSave.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                val fieldName = findViewById<EditText>(R.id.edit_name)
                val name = fieldName.text.toString()
                val fielddescription = findViewById<EditText>(R.id.edit_description)
                val description = fielddescription.text.toString()
                val fieldprice = findViewById<EditText>(R.id.edit_price)
                val priceInText = fieldprice.text.toString()
                val price = if (priceInText.isBlank()) {
                    BigDecimal.ZERO
                } else {
                    BigDecimal(priceInText)
                }

                val newProduct = Product(
                    name = name,
                    description = description,
                    price = price
                )

                Log.i("nameform", "onClick: $newProduct" )
                val dao = ProductsDao()
                dao.add(newProduct)
                finish()
            }
        })



    }
}

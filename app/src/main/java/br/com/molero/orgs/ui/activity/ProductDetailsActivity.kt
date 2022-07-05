package br.com.molero.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.molero.orgs.extensions.formatPriceBr
import br.com.molero.orgs.databinding.ActivityProductDetailsBinding
import br.com.molero.orgs.extensions.tryLoadImage
import br.com.molero.orgs.model.Product


class ProductDetailsActivity() : AppCompatActivity() {

    private val binding by lazy {
        ActivityProductDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tryLoadProduct()
    }

    private fun tryLoadProduct() {
        intent.getParcelableExtra<Product>(CHAVE_PRODUTO)?.let { productLoaded ->
            fillFields(productLoaded)
        } ?: finish()
    }

    private fun fillFields(productLoaded: Product) {
        with(binding) {

            activityDetailsProductImage.tryLoadImage(productLoaded.image)
            activityDetailsProductName.text = productLoaded.name
            activityDetailsProductDescription.text = productLoaded.description
            activityDetailsProductPrice.text =
                productLoaded.price.formatPriceBr()
        }
    }
}


package br.com.molero.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.molero.orgs.databinding.ProductItemBinding
import br.com.molero.orgs.extensions.tryLoadImage
import br.com.molero.orgs.model.Product
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class ListProductsAdapter(
    private val context: Context,
    products: List<Product>,

) : RecyclerView.Adapter<ListProductsAdapter.ViewHolderList>(){

    private val products = products.toMutableList()

    class ViewHolderList(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binds(product: Product,context: Context) {
            //val name = itemView.findViewById<TextView>(R.id.product_item_name) substituído pelo View Binding
            val name = binding.productItemName
            name.text = product.name
            //val description = itemView.findViewById<TextView>(R.id.product_item_description) substituído pelo View Binding
            val description = binding.productItemDescription
            description.text = product.description
            //val price = itemView.findViewById<TextView>(R.id.product_item_price) substituído pelo View Binding
            val price = binding.productItemPrice
            val formatPrice = formatPriceBr(product.price)
            price.text = formatPrice

            val visibility = if (product.image != null && product.image !="") {
                View.VISIBLE
            } else {
                View.GONE
            }
            binding.productItemImageView.visibility = visibility
            binding.productItemImageView.tryLoadImage(product.image,context)
        }

        private fun formatPriceBr(price: BigDecimal): String? {
            val format = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return format.format(price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
        //val inflater = LayoutInflater.from(context) substituído pelo View Binding abaixo
        //val viewInflate = inflater.inflate(R.layout.product_item, parent, false) substituído pelo View Binding abaixo
        val binding = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolderList(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        val product = products[position]
        holder.binds(product,context)
    }

    override fun getItemCount(): Int = products.size

    fun update(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}




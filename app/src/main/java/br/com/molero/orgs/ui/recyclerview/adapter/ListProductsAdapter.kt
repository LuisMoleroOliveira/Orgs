package br.com.molero.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.molero.orgs.R
import br.com.molero.orgs.model.Product

class ListProductsAdapter(
    val context: Context,
    products: List<Product>
) : RecyclerView.Adapter<ListProductsAdapter.ViewHolderList>() {

    private val products = products.toMutableList()

    class ViewHolderList(view: View) : RecyclerView.ViewHolder(view) {

        fun binds(product: Product) {
            val name = itemView.findViewById<TextView>(R.id.product_item_name)
            name.text = product.name
            val description = itemView.findViewById<TextView>(R.id.product_item_description)
            description.text = product.description
            val price = itemView.findViewById<TextView>(R.id.product_item_price)
            price.text = product.price.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
        val inflater = LayoutInflater.from(context)
        val viewInflate = inflater.inflate(R.layout.product_item, parent, false)

        return ViewHolderList(viewInflate)
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        val product = products[position]
        holder.binds(product)

    }

    override fun getItemCount(): Int = products.size
    fun update(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}


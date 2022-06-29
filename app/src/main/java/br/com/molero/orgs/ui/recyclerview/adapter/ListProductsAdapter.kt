package br.com.molero.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.molero.orgs.databinding.ProductItemBinding
import br.com.molero.orgs.model.Product

class ListProductsAdapter(
    private val context: Context,
    products: List<Product>,
) : RecyclerView.Adapter<ListProductsAdapter.ViewHolderList>() {

    private val products = products.toMutableList()
        class ViewHolderList(binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
            private val name = binding.productItemName
            private val description = binding.productItemDescription
            private val price = binding.productItemPrice

            fun binds(product: Product) {
                //val name = itemView.findViewById<TextView>(R.id.product_item_name) substituído pelo View Binding
                name.text = product.name
                //val description = itemView.findViewById<TextView>(R.id.product_item_description) substituído pelo View Binding
                description.text = product.description
                //val price = itemView.findViewById<TextView>(R.id.product_item_price) substituído pelo View Binding
                price.text = product.price.toPlainString()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {

            //val inflater = LayoutInflater.from(context) substituído pelo View Binding abaixo
            //val viewInflate = inflater.inflate(R.layout.product_item, parent, false) substituído pelo View Binding abaixo

            val binding = ProductItemBinding.inflate(LayoutInflater.from(context),parent,false)
            return ViewHolderList(binding)
        }

        override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
            val product = products[position]
            holder.binds(product)

        }

        override fun getItemCount(): Int = products.size

        fun update(products: List<Product>) {
            this.products.clear()
            this.products.addAll(products)
            //notifyDataSetChanged()
        }
    }




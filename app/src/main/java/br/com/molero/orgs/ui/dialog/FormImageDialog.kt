package br.com.molero.orgs.ui.dialog

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.molero.orgs.databinding.FormImageBinding
import br.com.molero.orgs.extensions.tryLoadImage

class FormImageDialog(private val context: Context) {
    fun show(
        defaultUrl: String? = null,
        whenImageLoaded: (image: String) -> Unit
    ) {
        val bindingFormImage = FormImageBinding.inflate(LayoutInflater.from(context))

        defaultUrl?.let {
            bindingFormImage.formImageImageview.tryLoadImage(it,context)
            bindingFormImage.activityFormImageUrl.setText(it)
        }

        bindingFormImage.formImageButtonLoad.setOnClickListener {
            val url = bindingFormImage.activityFormImageUrl.text.toString()
            bindingFormImage.formImageImageview.tryLoadImage(url,context)
        }
        AlertDialog.Builder(context)
            .setView(bindingFormImage.root)
            .setPositiveButton("Confirmar", DialogInterface.OnClickListener { dialog, which ->
                val url = bindingFormImage.activityFormImageUrl.text.toString()
                whenImageLoaded(url)
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which ->

            })
            .show()
    }
}
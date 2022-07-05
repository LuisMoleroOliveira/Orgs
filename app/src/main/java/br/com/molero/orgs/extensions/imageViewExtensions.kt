package br.com.molero.orgs.extensions

import android.content.Context
import android.icu.number.NumberRangeFormatter
import android.os.Build
import android.widget.ImageView
import br.com.molero.orgs.R
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load

fun ImageView.tryLoadImage(
    url: String? = null,
    fallback: Int = R.drawable.imagem_padrao
) {

    load(url, addGifs(context)) {
        placeholder(R.drawable.loading500px)
        fallback(fallback)
        error(R.drawable.erro)
    }
}

fun addGifs(context: Context): ImageLoader {
    val imageLoader = ImageLoader.Builder(context = context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    return imageLoader
}
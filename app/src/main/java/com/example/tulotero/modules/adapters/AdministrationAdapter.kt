package com.example.tulotero.modules.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tulotero.databinding.ItemAdministrationBinding
import com.example.tulotero.modules.models.Administration
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class AdministrationAdapter(val context: Context) :
    androidx.recyclerview.widget.ListAdapter<Administration, AdministrationAdapter.ViewHolder>(
        CountryDiffCallback()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, getItem(position))
    }

    class ViewHolder private constructor(val binding: ItemAdministrationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            context: Context,
            item: Administration
        ) {

            item.urlPhoto?.let {

                    Glide.with(context)
                        .load(it)
                        .into(binding.imageView)

            }


            binding.name = item.name
            binding.province = "${item.province?.let { it }} (${item.town?.let { it }})"

        }


        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemAdministrationBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }



    }

    class CountryDiffCallback : DiffUtil.ItemCallback<Administration>() {
        override fun areContentsTheSame(oldItem: Administration, newItem: Administration): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Administration, newItem: Administration): Boolean {
            return oldItem == newItem
        }
    }


}



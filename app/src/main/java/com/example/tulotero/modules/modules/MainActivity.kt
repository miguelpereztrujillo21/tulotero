package com.example.tulotero.modules.modules

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tulotero.R
import com.example.tulotero.databinding.ActivityMainBinding
import com.example.tulotero.modules.adapters.AdministrationAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    var adapter: AdministrationAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.lifecycleOwner = this
        binding.mainActivity = this
        binding.viewModel = viewModel

        viewModel.getAdminitrations()

        setUpView()
        initObservers()


    }

    fun setUpView() {
        adapter = AdministrationAdapter(this)
        binding.recyclerMain.adapter = adapter
        viewModel.getAllRoomAdmins()

    }

    fun initObservers() {

        viewModel.administrations.observe(this, Observer { admins ->
            admins?.let { adapter?.submitList(it) }
            binding.textNumberAdmins.text = admins.size.toString()
            if (admins.size == 0) {
                binding.recyclerMain.visibility = View.GONE
                binding.noAdminMain.visibility = View.VISIBLE
            } else {
                binding.recyclerMain.visibility = View.VISIBLE
                binding.noAdminMain.visibility = View.GONE
            }
        })

        viewModel.searchText.observe(this, Observer {
            viewModel.getRoomAdminByName(it)
        })

    }

}
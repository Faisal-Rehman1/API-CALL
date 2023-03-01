package com.MaximusTechnology.apicall.ui.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.MaximusTechnology.apicall.ui.viewModel.CatFactViewModel
import com.MaximusTechnology.apicall.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CatFactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(CatFactViewModel::class.java)


        val factTextView = findViewById<TextView>(R.id.factTextView)
        val reloadButton = findViewById<AppCompatButton>(R.id.reloadButton)


        viewModel.fact.observe(this, { fact ->
            factTextView.text = fact
        })



//        viewMode.observe(this, { fact ->
//            factTextView.text = fact
//        })
//
//


        reloadButton?.setOnClickListener {
            viewModel.getCatFact()
        }

        viewModel.getCatFact()
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit")
        builder.setMessage("Are you sure you want to exit the app?")
        builder.setPositiveButton("Yes") { _, _ ->
            super.onBackPressed()
        }
        builder.setNegativeButton("No") { _, _ -> }
        val dialog = builder.create()
        dialog.show()
    }
}
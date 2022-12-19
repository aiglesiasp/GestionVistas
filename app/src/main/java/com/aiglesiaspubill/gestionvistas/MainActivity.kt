package com.aiglesiaspubill.gestionvistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.aiglesiaspubill.gestionvistas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
    }

    private fun setListener() {
        //CLICK NORMAL
        binding.btnNormalClick.setOnClickListener { showToast("NORMAL CLICK")}
        //CLICK LARGO
        binding.btnLongClick.setOnLongClickListener { 
            showToast("LONG CLICK") 
            true
        }

        binding.editText.doAfterTextChanged { showToast(binding.editText.text.toString())}
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }


}
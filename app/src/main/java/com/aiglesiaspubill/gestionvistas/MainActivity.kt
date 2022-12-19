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




    //FUNCION DE PRUEBA PARA LOS PRIMEROS ELEMENTOS
    private fun setListener() {
        //CLICK NORMAL
        binding.btnNormalClick.setOnClickListener { showToast("NORMAL CLICK")}
        //CLICK LARGO
        binding.btnLongClick.setOnLongClickListener { 
            showToast("LONG CLICK") 
            true
        }
        binding.editText.doAfterTextChanged { showToast(binding.editText.text.toString())}


        //EJERCICIO
        with(binding) {
            editText1.setOnFocusChangeListener { _, focused ->
                if (focused) textView.text = "EditText1"
            }
            editText2.setOnFocusChangeListener { _, focused ->
                if (focused) textView.text = "EditText2"
            }
            editText1.doAfterTextChanged {
                btnEjercicio.isEnabled = editText1.text.isNotEmpty() && editText2.text.isNotEmpty()
            }
            editText2.doAfterTextChanged {
                btnEjercicio.isEnabled = editText1.text.isNotEmpty() && editText2.text.isNotEmpty()
            }
            btnEjercicio.setOnClickListener {
                editText1.setText("${editText1.text} ${editText2.text}")
                editText2.setText("")
            }
        }
    }

    //FUNCION MOSTRAR TOAST
    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }


}
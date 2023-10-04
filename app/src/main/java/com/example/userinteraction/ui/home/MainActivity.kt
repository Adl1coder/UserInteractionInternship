package com.example.userinteraction.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.userinteraction.R
import com.example.userinteraction.databinding.ActivityMainBinding
import com.example.userinteraction.ui.information.InformationScreen

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        clickButton()
    }

    private fun clickButton(){
        binding.btnHome.setOnClickListener {
            val getNameSurname = binding.etNameSurname.text.toString()

            if (getNameSurname.isEmpty()){
                Toast.makeText(this@MainActivity, "Lütfen boş alanı doldurun!", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this@MainActivity, InformationScreen::class.java)
                intent.putExtra("adSoyad", getNameSurname)
                startActivity(intent)
                Toast.makeText(this@MainActivity, "Başarılı!", Toast.LENGTH_SHORT).show()
                binding.etNameSurname.setText("")
            }
        }
    }
}

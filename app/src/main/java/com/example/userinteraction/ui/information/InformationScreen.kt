package com.example.userinteraction.ui.information

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.userinteraction.R
import com.example.userinteraction.data.PersonalInfo
import com.example.userinteraction.databinding.ActivityInformationScreenBinding
import com.example.userinteraction.ui.custom.CustomScreen

class InformationScreen : AppCompatActivity() {

    private lateinit var binding: ActivityInformationScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        clickButton()
    }

    private fun clickButton(){

        val getNameSurnameFromHome = intent.getStringExtra("nameSurname")
        binding.tvNameSurnameInfo.text = getNameSurnameFromHome

        binding.btnInfo.setOnClickListener {
            val getMail = binding.etMail.text.toString()
            val getPhone = binding.etPhone.text.toString()
            val getCity = binding.etCity.text.toString()

            if (getMail.isEmpty() || getPhone.isEmpty() || getCity.isEmpty()){
                Toast.makeText(this@InformationScreen, "Lütfen bilgilerinizi girin!", Toast.LENGTH_SHORT).show()
            }
            else{
                val personalInfo = PersonalInfo(getNameSurnameFromHome, getMail, getPhone, getCity)
                val intent = Intent(this@InformationScreen, CustomScreen::class.java)
                intent.putExtra("personalInfo", personalInfo)
                finish()
                startActivity(intent)
                Toast.makeText(this@InformationScreen, "Başarılı!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

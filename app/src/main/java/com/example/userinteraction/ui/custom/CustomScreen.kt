package com.example.userinteraction.ui.custom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.userinteraction.R
import com.example.userinteraction.data.Info
import com.example.userinteraction.data.PersonalInfo
import com.example.userinteraction.databinding.ActivityCustomScreenBinding
import com.example.userinteraction.ui.result.ResultScreen

class CustomScreen : AppCompatActivity() {

    private lateinit var binding : ActivityCustomScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        clickButton()
    }

    private fun clickButton(){

        val getInfo = intent.getParcelableExtra("personalInfo") as PersonalInfo?
        binding.tvNameSurnameCustom.text = getInfo?.nameSurname.toString()

        binding.btnCustom.setOnClickListener {
            val getBookName = binding.etFirstQuestionAnswer.text.toString()
            val getSongName = binding.etSecondQuestionAnswer.text.toString()
            val getMovieName = binding.etThirdQuestionAnswer.text.toString()

            if (getBookName.isEmpty() || getSongName.isEmpty() || getMovieName.isEmpty()){
                Toast.makeText(this@CustomScreen, "Lütfen boş alanları doldurun!", Toast.LENGTH_SHORT).show()
            }
            else{
                val addAllInfo = getInfo?.let { getPersonalInfo ->
                    Info(
                        getPersonalInfo,
                        getBookName,
                        getSongName,
                        getMovieName
                    )
                }
                val intent = Intent(this@CustomScreen, ResultScreen::class.java)
                intent.putExtra("tümBilgiler",addAllInfo)
                finish()
                startActivity(intent)
                Toast.makeText(this@CustomScreen, "Başarılı!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

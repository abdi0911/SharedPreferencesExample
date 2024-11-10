package com.example.sharedpreferencesexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferencesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val filename = "$packageName-TESTFILE"
        val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)

        // Tombol Simpan
        binding.btnSave.setOnClickListener {
            val editor = pref.edit()
            editor.putString("firstName", binding.etFirstName.text.toString())
            editor.putString("lastName", binding.etLastName.text.toString())
            editor.apply()

            Toast.makeText(this, "Data Tersimpan!", Toast.LENGTH_LONG).show()
        }

        // Tombol Pindah ke SecondActivity
        binding.btnSecondActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        binding.etFirstName.setText("")
        binding.etLastName.setText("")
        binding.tvOutput.text = ""
    }
}


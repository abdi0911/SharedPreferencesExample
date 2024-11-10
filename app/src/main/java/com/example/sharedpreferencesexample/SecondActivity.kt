package com.example.sharedpreferencesexample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferencesexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nama file SharedPreferences yang konsisten
        val filename = "$packageName-TESTFILE"
        val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)

        // Tombol Load Data
        binding.btnLoad.setOnClickListener {
            // Mengambil data yang disimpan dan langsung menampilkannya
            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")

            // Menampilkan hasil di TextView
            binding.tvOutput.text = "$firstName $lastName"
        }
    }

    override fun onResume() {
        super.onResume()
        // Menampilkan pesan default saat aktivitas muncul
        binding.tvOutput.text = "Klik tombol Load Data"
    }
}
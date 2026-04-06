package com.example.kalkulator_sederhana

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "DetektifBug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etAngkaPertama = findViewById<EditText>(R.id.etAngkaPertama)
        val etAngkaKedua = findViewById<EditText>(R.id.etAngkaKedua)
        val btnBagi = findViewById<Button>(R.id.btnBagi)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        Log.d(TAG, "Aplikasi berhasil dijalankan dan masuk ke onCreate")

        btnBagi.setOnClickListener {
            val angkaPertamaStr = etAngkaPertama.text.toString().trim()
            val angkaKeduaStr = etAngkaKedua.text.toString().trim()

            Log.d(TAG, "Input angka pertama: $angkaPertamaStr")
            Log.d(TAG, "Input angka kedua: $angkaKeduaStr")

            if (angkaPertamaStr.isEmpty() || angkaKeduaStr.isEmpty()) {
                Toast.makeText(this, "Masukkan kedua angka terlebih dahulu", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Input kosong")
                return@setOnClickListener
            }

            val angkaPertama = angkaPertamaStr.toDouble()
            val angkaKedua = angkaKeduaStr.toDouble()

            if (angkaKedua == 0.0) {
                Toast.makeText(this, "Angka pembagi tidak boleh 0", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Terjadi pembagian dengan nol")
                return@setOnClickListener
            }

            val hasil = angkaPertama / angkaKedua
            tvHasil.text = "Hasil: $hasil"

            Log.d(TAG, "Hasil pembagian: $hasil")
        }
    }
}
package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirmPassword: TextInputEditText
    private lateinit var btnRegister: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Menghubungkan komponen UI dengan variabel
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)

        // Listener untuk tombol register
        btnRegister.setOnClickListener {
            performRegister()
        }

        // Tautan ke halaman login
        findViewById<TextView>(R.id.Login).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Tutup RegisterActivity setelah berpindah ke MainActivity
        }
    }

    private fun performRegister() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        // Logika pendaftaran sederhana
        if (username.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            if (password == confirmPassword) {
                // Tampilkan pesan sukses (atau bisa integrasi dengan server untuk pendaftaran)
                Toast.makeText(this, "Pendaftaran berhasil untuk $username", Toast.LENGTH_SHORT).show()

                // Alihkan ke halaman login setelah sukses
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Password dan Konfirmasi Password tidak cocok", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
        }
    }
}

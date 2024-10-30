package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            performLogin()
        }

        findViewById<TextView>(R.id.Register).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun performLogin() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Harap masukkan username dan password", Toast.LENGTH_SHORT).show()
        }
    }
}

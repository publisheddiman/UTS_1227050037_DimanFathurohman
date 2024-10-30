package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import lat.pam.utsproject.ConfirmationActivity
import lat.pam.utsproject.R

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("FOOD_NAME") ?: ""
        val foodDescription = intent.getStringExtra("FOOD_DESCRIPTION") ?: ""

        findViewById<EditText>(R.id.etFoodName).setText(foodName)

        findViewById<ImageButton>(R.id.btnBackToList).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnOrder).setOnClickListener {
            val servings = findViewById<EditText>(R.id.etServings).text.toString().trim()
            val orderingName = findViewById<EditText>(R.id.etName).text.toString().trim()
            val notes = findViewById<EditText>(R.id.etNotes).text.toString().trim()

            if (servings.isEmpty()) {
                findViewById<EditText>(R.id.etServings).error = "Jumlah porsi harus diisi"
                return@setOnClickListener
            }

            if (orderingName.isEmpty()) {
                findViewById<EditText>(R.id.etName).error = "Nama pemesan harus diisi"
                return@setOnClickListener
            }

            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("FOOD_NAME", foodName)
                putExtra("SERVINGS", servings)
                putExtra("ORDERING_NAME", orderingName)
                putExtra("NOTES", notes)
            }
            startActivity(intent)
            finish()
        }
    }
}

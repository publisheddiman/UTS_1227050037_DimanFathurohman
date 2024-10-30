package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val foodName = intent.getStringExtra("FOOD_NAME")
        val servings = intent.getStringExtra("SERVINGS")
        val orderingName = intent.getStringExtra("ORDERING_NAME")
        val notes = intent.getStringExtra("NOTES")

        if (validateOrder(foodName, servings)) {
            val tvFoodName = findViewById<TextView>(R.id.tvFoodName)
            val tvServings = findViewById<TextView>(R.id.tvServings)
            val tvOrderingName = findViewById<TextView>(R.id.tvOrderingName)
            val tvNotes = findViewById<TextView>(R.id.tvNotes)

            tvFoodName.text = "Food Name: $foodName"
            tvServings.text = "Number of Servings: $servings"
            tvOrderingName.text = "Ordering Name: $orderingName"
            tvNotes.text = "Additional Notes: $notes"

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        val backToMenuButton = findViewById<Button>(R.id.backtoMenu)
        backToMenuButton.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validateOrder(foodName: String?, servings: String?): Boolean {
        return if (foodName.isNullOrEmpty() || servings.isNullOrEmpty()) {
            Toast.makeText(this, "Harap lengkapi nama makanan dan jumlah porsi", Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }
}

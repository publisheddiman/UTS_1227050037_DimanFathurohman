package lat.pam.utsproject

import lat.pam.utsproject.FoodAdapter
import lat.pam.utsproject.OrderActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Update the food list
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Cireng", "Camilan khas Bandung, dibuat dari tepung tapioka", R.drawable.cireng),
            Food("Donat", "Donat manis yang lembut dan enak", R.drawable.donut),
            Food("Cheesecake", "Kue keju yang lembut dan manis", R.drawable.cheesecake), // Tambahan
            Food("Kopi Hitam", "Kopi hitam yang kuat dan nikmat", R.drawable.kopi_hitam), // Tambahan
            Food("Mie Goreng", "Mie goreng pedas dengan sayuran", R.drawable.mie_goreng), // Tambahan
            Food("Nasi Goreng", "Nasi goreng spesial dengan telur", R.drawable.nasigoreng), // Tambahan
            Food("Sparkling Tea", "Teh berkarbonasi yang segar", R.drawable.sparkling_tea) // Tambahan
        )

        adapter = FoodAdapter(foodList) { selectedFood ->
            val intent = Intent(this, OrderActivity::class.java).apply {
                putExtra("FOOD_NAME", selectedFood.name)
                putExtra("FOOD_DESCRIPTION", selectedFood.description)
                putExtra("FOOD_IMAGE_RES_ID", selectedFood.imageResourceId)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

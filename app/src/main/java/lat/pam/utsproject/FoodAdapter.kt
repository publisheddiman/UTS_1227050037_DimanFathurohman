package lat.pam.utsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lat.pam.utsproject.Food
import lat.pam.utsproject.R

class FoodAdapter(
    private val foodList: List<Food>,
    private val onItemClick: (Food) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val foodName = view.findViewById<TextView>(R.id.foodName)
        private val foodDescription = view.findViewById<TextView>(R.id.foodDescription)
        private val foodImage = view.findViewById<ImageView>(R.id.foodImage)

        fun bind(food: Food) {
            foodName.text = food.name
            foodDescription.text = food.description
            foodImage.setImageResource(food.imageResourceId)

            // Set the click listener for the item
            itemView.setOnClickListener {
                onItemClick(food)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount(): Int = foodList.size
}

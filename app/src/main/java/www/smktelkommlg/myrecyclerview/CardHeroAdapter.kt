package www.smktelkommlg.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import www.smktelkommlg.myrecyclerview.CardHeroAdapter.*


class CardHeroAdapter(val listHeroes: ArrayList<Hero>) : RecyclerView.Adapter<CardHeroAdapter.CardViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_hero, viewGroup, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val hero = listHeroes[position]
        Glide.with(holder.itemView.context)
            .load(listHeroes[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.itemView.context,"Kamu Memilih", Toast.LENGTH_SHORT).show()
        })

        holder.btnFavorite.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.itemView.context,"Favorite", Toast.LENGTH_SHORT).show()
        })

        holder.btnShare.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.itemView.context,"Share", Toast.LENGTH_SHORT).show()
        })
        holder.tv_item_name.text = hero.name
        holder.tv_item_desc.text = hero.from
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)
        var tv_item_name : TextView = itemView.findViewById(R.id.tv_item_name)
        var tv_item_desc : TextView = itemView.findViewById(R.id.tv_item_detail)
    }

}

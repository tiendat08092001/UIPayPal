package com.example.uipaypal.card_activity

import android.util.Log
import android.util.Log.ASSERT
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uipaypal.R
import com.example.uipaypal.data_card.Card
import java.lang.Exception

class CardAdapter(private val onClick: (Card) -> Unit) :
    ListAdapter<Card, CardAdapter.CardViewHolder>(CardDiffCallBack) {

    class CardViewHolder(itemView: View, val onClick: (Card) -> Unit) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val imageCard: ImageView = itemView.findViewById(R.id.master_card)
        private val textViewCategoryCard: TextView =
            itemView.findViewById(R.id.text_view_category_card)
        private val textViewKeyCodeCard: TextView = itemView.findViewById(R.id.card_key_code)

        private val popupMenu: ImageButton = itemView.findViewById(R.id.pop_up_menu)

        private val linearLayoutPopupMenu: LinearLayout = itemView.findViewById(R.id.item_pop_up_menu)

        private val buttonEsc: ImageButton = itemView.findViewById(R.id.btn_esc)

        private var currentCard: Card? = null

        private var oldPosition:Int? = 1

        init {
            itemView.setOnClickListener {
                currentCard?.let {
                    onClick(it)
                }
            }

            buttonEsc.setOnClickListener {
                Log.d("btnESC" , "An nut thoat o vi tri $adapterPosition, cua the ${currentCard?.categoryCard}")
                linearLayoutPopupMenu.visibility = LinearLayout.GONE

            }

            popupMenu.setOnClickListener(this)
        }

        fun bind(card: Card) {
            currentCard = card
            if (card.imageCard != null) {
                imageCard.setImageResource(card.imageCard)
            } else {
                imageCard.setImageResource(R.drawable.ic_visa_card)
            }
            textViewCategoryCard.text = card.categoryCard
            textViewKeyCodeCard.text = card.keyCode
        }

        override fun onClick(view: View?) {
            view?.let {
                linearLayoutPopupMenu.visibility = LinearLayout.VISIBLE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.my_card_adapter, parent, false)
        return CardViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = getItem(position)
        holder.bind(card)
    }
}

object CardDiffCallBack : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }

}
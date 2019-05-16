package com.example.recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import java.util.*
import android.view.LayoutInflater
import com.example.recyclerview.R



class WordListAdapter(private val mWordList: LinkedList<String>) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListAdapter.WordViewHolder {
        return WordViewHolder(LayoutInflater.from(parent.context), parent)

    }

    override fun getItemCount(): Int {
        return mWordList.size
    }

    override fun onBindViewHolder(holder: WordListAdapter.WordViewHolder, position: Int) {
        holder.bind(mWordList[position])
    }

    inner class WordViewHolder(inflater: LayoutInflater,parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.wordlist_item, parent,false)){
        private var mWordView: TextView? = null
        init {
            mWordView = itemView.findViewById(R.id.word)
            itemView.setOnClickListener {
                mWordList[adapterPosition] = "clicked"
                notifyItemChanged(adapterPosition)
            }

        }
        fun bind(text : String){ mWordView?.text = text}

    }


}
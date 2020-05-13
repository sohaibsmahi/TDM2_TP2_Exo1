package com.example.tdm2_tp2_exo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(val words: ArrayList<Word>, var clickListener: OnWordListener):
    RecyclerView.Adapter<WordsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.word, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var word:Word = words[position]
        //holder.word.text = word.word
        //holder.pronunciation.text = word.pronunciation
        //holder.explanation.text = word.explanation

        holder.initialize(word, clickListener)

    }
    class ViewHolder(var item: View): RecyclerView.ViewHolder(item){
        var word: TextView = item.findViewById(R.id.word)
        var pronunciation:TextView = item.findViewById(R.id.pronunciation)
        var explanation:TextView = item.findViewById(R.id.explanation)

        fun initialize(wrd: Word, action: OnWordListener){
            word.text = wrd.word
            pronunciation.text = wrd.pronunciation
            explanation.text = wrd.explanation

            item.setOnClickListener{
                action.onWordClick(wrd, absoluteAdapterPosition)
            }
        }
    }

    interface OnWordListener{
        fun onWordClick(item: Word, position: Int)
    }
}
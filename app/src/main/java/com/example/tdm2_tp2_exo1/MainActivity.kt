package com.example.tdm2_tp2_exo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), WordsAdapter.OnWordListener {
    companion object{
        val INTENT_PARECELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        var words: MutableList<Word> = ArrayList()

        

        words.add(Word("package", "noun", "[/ˈpakɪdʒ/]", R.raw.word1, R.drawable.word1, R.raw.vid, "an object or group of objects wrapped in paper or packed in a box."))
        words.add(Word("trigger", "verb", "[/ˈtrɪɡə/]", R.raw.word2, R.drawable.word2, null, "cause (a device) to function."))
        words.add(Word("build", "verb", "[/bɪld/]", R.raw.word3, R.drawable.word3, null, "construct (something) by putting parts or material together."))
        words.add(Word("school", "noun", "[/skuːl/]", R.raw.word4, R.drawable.word4, null, "any institution at which instruction is given in a particular discipline."))
        words.add(Word("drive", "verb", "[/drʌɪv/]", R.raw.word5, R.drawable.word5, null, "operate and control the direction and speed of a motor vehicle."))
        words.add(Word("write", "verb", "[/rʌɪt/]", R.raw.word6, R.drawable.word6, null, "mark (letters, words, or other symbols) on a surface, typically paper, with a pen, pencil, or similar implement."))
        words.add(Word("allow", "verb", "[/əˈlaʊ/]", R.raw.word7, R.drawable.word7, null, "let (someone) have or do something."))

        recyclerView.adapter = WordsAdapter(words as ArrayList<Word>, this)
    }

    override fun onWordClick(word: Word, position: Int) {
        val intent = Intent(this, WordDetails::class.java)
        intent.putExtra("Word_Details", word)
        startActivity(intent)
        Toast.makeText(this, word.word, Toast.LENGTH_SHORT).show()
    }
}

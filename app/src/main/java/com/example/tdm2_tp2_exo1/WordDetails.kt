package com.example.tdm2_tp2_exo1

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_word_details.*

class WordDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_details)

        val word = intent.getSerializableExtra("Word_Details") as Word?

        word_word.text = word!!.word
        word_type.text = word!!.type
        word_pronunciation.text = word!!.pronunciation
        word_explanation.text = word!!.explanation
        var word_image = word!!.image_file
        Picasso.get().load(word_image).into(image)
        val audio = word!!.pronunciation_audio_file
        word_pronunciation_audio.setOnClickListener {
            val mp: MediaPlayer = MediaPlayer.create(this, audio)
            mp.start()
        }

        if(word!!.video_file == null){
            word_video.visibility = View.GONE
        }
        else{
            var mc = MediaController(this)
            word_video.setMediaController(mc)
            val video = Uri.parse("android.resource://" + this?.packageName + "/"
                    + word!!.video_file) //do not add any extension
            word_video.setVideoURI(video)
            word_video.start()
        }


    }

}

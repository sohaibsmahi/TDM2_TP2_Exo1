package com.example.tdm2_tp2_exo1

import java.io.Serializable

class Word(val word: String, val type: String, val pronunciation: String, val pronunciation_audio_file: Int, val image_file: Int, val video_file: Int?, val explanation: String): Serializable {
}
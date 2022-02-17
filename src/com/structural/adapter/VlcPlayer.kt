package com.structural.adapter

class VlcPlayer : AdvancedMediaPlayer{
    override fun playVlc(fileName: String) {
        println("Playing vlc file. Name: $fileName")
    }

    override fun playMp4(fileName: String) {
        //Do Nothing
    }

}
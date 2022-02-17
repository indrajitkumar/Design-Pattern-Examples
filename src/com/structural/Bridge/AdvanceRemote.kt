package com.structural.Bridge

class AdvancedRemote(private val device: Device) : BasicRemote(device) {
    fun mute() {
        println("Remote: mute")
        device.setVolume(0)
    }
}
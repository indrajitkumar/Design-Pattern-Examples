package com.structural.Bridge

open class BasicRemote(private val device: Device) : Remote {

    override fun power() {
        println("Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    override fun volumeDown() {
        println("Remote: volume down");
        device.setVolume(device.getVolume() - 10); }

    override fun volumeUp() {
        println("Remote: volume up");
        device.setVolume(device.getVolume() + 10); }

    override fun channelDown() {
        println("Remote: channel down");
        device.setChannel(device.getChannel() - 1); }

    override fun channelUp() {
        println("Remote: channel up");
        device.setChannel(device.getChannel() + 1); }
}
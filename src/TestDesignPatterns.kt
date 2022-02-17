import com.structural.Bridge.AdvancedRemote
import com.structural.Bridge.BasicRemote
import com.structural.Bridge.Radio
import com.structural.Bridge.TV
import com.structural.adapter.AudioPlayer


fun main() {
    print("Hello")
    //testAdapterDesignPattern()
    testBridgeDesignPattern()
}

fun testBridgeDesignPattern() {
    val device = TV()
    println("Tests with basic remote.")
    val basicRemote = BasicRemote(device)
    basicRemote.power()
    device.printStatus()

    val radio = Radio()
    println("Tests with advanced remote.")
    val advancedRemote = AdvancedRemote(radio)
    advancedRemote.power()
    advancedRemote.mute()
    radio.printStatus()}

fun testAdapterDesignPattern() {
    val audioPlayer = AudioPlayer()

    audioPlayer.play("mp3", "beyond the horizon.mp3")
    audioPlayer.play("mp4", "alone.mp4")
    audioPlayer.play("vlc", "far far away.vlc")
    audioPlayer.play("avi", "mind me.avi")
}

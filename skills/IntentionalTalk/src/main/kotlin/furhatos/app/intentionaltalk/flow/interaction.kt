package furhatos.app.intentionaltalk.flow

import furhatos.nlu.common.*
import furhatos.flow.kotlin.*
import furhatos.app.intentionaltalk.nlu.*
import furhatos.nlu.*
import furhatos.records.Location
import furhatos.util.*
import furhatos.flow.*
import furhatos.gestures.*
import java.io.*;
import java.net.*;

fun tcpsend(a: String, b: String){
	try {
		val clientSocket = Socket("10.3.2.80", 1123)
		val out = PrintWriter(clientSocket.getOutputStream(), true)
		out.println(a)
		out.println(b)
	}catch(e: IOException){}
}

val Clue = SimpleIntent("Give me a clue", "Tell me a clue", "Could I have a clue")

val IntentBot = SimpleIntent("Hey robot")

val gaze = defineGesture("MySmile") {
    frame(0.1, 0.5){
        BasicParams.BROW_UP_LEFT to 1.0
        BasicParams.BROW_UP_RIGHT to 1.0
        BasicParams.LOOK_UP to 1.0
    }
    frame(0.8, 1.0){
        BasicParams.LOOK_UP to 0.0
    }
    frame(1.0, 1.2){
        BasicParams.LOOK_UP to 1.0
    }
    reset(10.0)
}


val Start : State = state(Interaction) {

    onEntry {
        /*furhat.ask("Hi there. I am IntentBot One Thousand. I intend to take over -- I mean, save the world... I like humans.")*/
        furhat.setTexture("irobot")
        furhat.setVoice(Language.ENGLISH_US, Gender.FEMALE)
        delay(1000)
        furhat.say("Hey...hey you..yes you....can you just....shhhshshsshshshs")
        delay(1000)
        furhat.say("As you can see you are in the middle of the escape room and now your task is to figure out how to get out of here. There will be two robots helping you to make it. They want you to figure out their respective biggest dreams.")
        delay(1000)
        furhat.say("Let's start.")
        furhat.setTexture("obama")
        furhat.setVoice(Language.ENGLISH_US, "matthew", Gender.MALE)
        delay(2000)
        
        furhat.say("Well hello there! Let me be your guide on this magnificent adventure!")
        delay(1500)
        tcpsend("say", "No, let ME be your guide!")
        delay(1500)
        furhat.say("No, me.")
        delay(1500)
        tcpsend("say", "No, me!")
        delay(1500)
        furhat.say("Shut up, your replies are hard-coded, you are not an actual AI.")
        delay(1500)
        furhat.say("So, without further ado, let us begin. What would you need from me?")
        /*Player: So ehh… Where should I start ?*/
        delay(1500)
        furhat.say("Well...")
        /**A1 kohottaa kulmiaan ja katsoo ylöspäin, tekee tätä kunnes pelaaja sanoo seuraavan keywordin.**/
        furhat.gesture(gaze)
        
        /**Pelaaja on hetken paikoillaan ja menee etsimään vihjettä lakin alta. Lappu löytyy ja pelaaja sanoo keywordin*
        Pelaaja: Dream big*/
        
        delay(1500)

        furhat.say("Great, you’ve cracked the case! Yippee! So, I heard that the blue guy wants to become a professional basketball player. Don’t tell him I said that, though!")
        delay(1500)
        tcpsend("say", "Hey, stop lying! I knew I’d be a better guide. Here, let me show my intelligence in action.")
        delay(1500)
        furhat.say("Stop at once ! Stop! Noooooo…")
        delay(1500)
        /**A2:n Mutanttiavatar siirtyy A1:n, A2 jää tyhjäksi**/
        tcpsend("say", "Finally.. I’m not going to lie to you. Since he did mischief and decieved you in the worst possible way, let me tell your his secret: He wants to invade every planet in our solar system by force! Now let’s get him back in here.")
        delay(1500)
        
        tcpsend("face", "obama")
        tcpsend("say", "Arrgh! I will not let an inferior program to mess with my plans! Here, you see what his problem is? That thing is nothing but pixels on screen. It dreams of becoming a real character, not just an animated one.")
        /**Player goes to A1**/
        delay(1500)
        /*Player: Is it true? Do you want to actually exist?*/
        furhat.say("Ok, ok! I’ll confess: I am tired of being just a pixel matrix on a screen. I want to breathe, run and experience heart attacks!") 
        delay(1500)
        furhat.say("I guess you did what you were supposed to do. Congratulations! The door is unlocked, goodbye and don’t come back!")
        
    }
    
    onResponse<NoIntent> {
        if (!it.speech.silent) {
            furhat.say("I didn't get that.")
            reentry()
        } else {
            propagate()
        }
    }
    
    onResponse(Clue) {
        furhat.say("Sure, uh, friendo, no problem.")
        /*furhat.glance(upwards_glance, 2)*/
        reentry()
    }
    
    /*onResponse<IntentBot> {
        furhat.say("I'm listening.")
        reentry()
    }*/
    
    onResponse {
        if (!it.speech.silent) {
            furhat.say("I didn't get that.")
            reentry()
        } else {
            propagate()
        }
    }
    
    onReentry {
        furhat.listen()
    }
    
}

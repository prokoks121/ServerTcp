package main.test

import kotlinx.coroutines.*
import main.repository.Repository
import main.server.ClientSocket
import main.server.Server
import java.net.Socket
import java.util.ArrayList

@DelicateCoroutinesApi
fun main(){

    val server = Server(9999)
            server.startServer()
            println("TEST")
    var listClientsSocket: ArrayList<Socket> = arrayListOf()

       val job =  GlobalScope.launch(Dispatchers.IO) {
delay(3000L)
               val client = Socket("localhost", 9999)
           client.outputStream.write("{\"type\":\"REGISTRACIJA\",\"jsonData\":{\"korisnickoIme\":\"MIhailo\",\"sifra\":\"Sifra\"}}\n".toByteArray())
   delay(10000L)
           }

    runBlocking { job.join()}
    println("> From JSON String:\n" + Repository.clientList)

}


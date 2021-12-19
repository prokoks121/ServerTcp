package main.server

import kotlinx.coroutines.*
import main.model.Client
import java.net.ServerSocket
import java.util.*

class Server(val port:Int = 9999) {

    lateinit var server:ServerSocket
    val listClients:ArrayList<Client> = arrayListOf()
    var listClientsSocket:ArrayList<ClientSocket> = arrayListOf()
    var serverStatus:Boolean = false

    fun startServer(){
        server = ServerSocket(port)
        println("Server running on port ${server.localPort}")
        serverStatus = true
        clientListener()
    }

    fun clientListener(){
        GlobalScope.launch(Dispatchers.IO) {
                while (true){
                    println("Waiting for new client")
                    val client = server.accept()
                    println("Client connected : ${client.inetAddress.hostAddress}")
                    listClientsSocket.add(ClientSocket(client))
            }
        }
    }

    fun closeServer(){
        server.close()
        serverStatus = false
    }

}
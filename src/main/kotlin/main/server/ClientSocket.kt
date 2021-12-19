package main.server

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import main.model.Client
import main.model.ReceiveData
import main.model.TypeData
import main.repository.Repository
import java.net.Socket
import java.util.*

class ClientSocket(val socket: Socket) {

    init {
        socketListener()
    }

    fun socketListener(){
        val scanner = Scanner(socket.inputStream)
        GlobalScope.launch(Dispatchers.IO) {
            while (true){
                val data = scanner.nextLine()
                val receiveData: ReceiveData = Gson().fromJson(data, ReceiveData::class.java)
                checkData(receiveData)
            }
        }
    }

    fun checkData(receiveData: ReceiveData){
        when(receiveData.type) {
            TypeData.PRIJAVA -> {
                val data = Gson().fromJson(receiveData.jsonData.toString(), Client::class.java)
            }
            TypeData.REGISTRACIJA ->{
                val data = Gson().fromJson(receiveData.jsonData.toString(), Client::class.java)
                Repository.addClient(data)
                println("> From JSON String:\n" + Repository.clientList)
            }
        }
    }


}
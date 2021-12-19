package main.repository

import main.model.Client

object Repository {


        val clientList: ArrayList<Client> = arrayListOf()

        fun addClient(client: Client) {
            clientList.add(client)
        }



}
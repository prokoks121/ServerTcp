package main.model

data class Client(
    var korisnickoIme:String,
    var sifra:String,
    var ime:String,
    var prezime:String,
    var JMBG:Long,
    var pol: String,
    var email:String,
    var dozeVakcina:ArrayList<ClientVakcina> = arrayListOf(ClientVakcina(),
        ClientVakcina(),
        ClientVakcina())
)

data class ClientVakcina(
    var vakcinisan:Boolean = false,
    var vrstaVakcine:String = ""
)

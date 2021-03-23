package com.example.listadinamicaheroes

/*Clase que representa datos que estan almacenados (datos persistentes)*/
/*(var name:String, var alterEgo:String) Constructor por defecto de Kotlin*/
data class Heroe(var name:String, var alterEgo:String, var url:String) {

    fun getFullName():String = "$alterEgo $name"
}
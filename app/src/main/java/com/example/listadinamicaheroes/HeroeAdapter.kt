package com.example.listadinamicaheroes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.listadinamicaheroes.databinding.ItemListaBinding

/**/
class HeroeAdapter(private val dataSetHeroes:List<Heroe>, private val listener:OnClickListener) : RecyclerView.Adapter<HeroeAdapter.ViewHolder>(){

    /*El context permite visualizar cualquier parte del proyecto en cualquier momento*/
    private lateinit var  context:Context

    /*Clase interna, permite enlazar los items*/
    inner class  ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        /*Acceder los componentes graficos de la vista*/
        val viewBinding = ItemListaBinding.bind(view)

        /*Funcion que determina la accion de click (evento de escucha)*/
        fun setListener(heroe: Heroe){
            viewBinding.root.setOnClickListener{
                listener.onClick(heroe)
            }

        }
    }

    /*Crea dinamicamente los elementos graficos que deben ser llenados*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        /*LayoutInflater: Crea un componente grafico y lo agreaga a algo*/
        val  view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    /*Lleva el conteo de los elementos que se deben almacenar, dicho valor lo obtiene del dataset*/
    /*Utilizando notacion de linea de Kotlin*/
    override fun getItemCount(): Int = dataSetHeroes.size

    /*Llena la informacion con los datos del dataset*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val heroe = dataSetHeroes.get(position)
        /*Permite coger un objeto para acceder a los atributos y asignarle un valor*/
        with(holder){
            /*Asignar escucha y pasar objeto heroe*/
            setListener(heroe)

            viewBinding.tvName.text = heroe.name
            viewBinding.tvAlterEgo.text = heroe.alterEgo
            /*Glide: Clase que ayuda a cargar imagenes externas*/
            Glide.with(context)
                .load(heroe.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(viewBinding.ivImageHeroe)
        }
    }
}
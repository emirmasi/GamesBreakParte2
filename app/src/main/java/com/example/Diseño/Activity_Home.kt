package com.example.Diseño

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicandodiseo.R

///este es el homeActivity


class Activity_Home : AppCompatActivity() {

    ///tenemos que traer los datos del usuario del activyty de ingresar o crear usuario
    ///asi mostramos los
    ///esto va despues igual.
    ///
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        ///aca tengo que setear el los botones de navegacion y el de cerrar sesion
        ///setear el textView del saldo y el textView de la img

    }



}


///por si se pierde

/*var listaDeJuegos: MutableList<Game> = GameRepository.get()
private lateinit var adapter: GamesAdapter
private var llmanager = GridLayoutManager(this,1,LinearLayoutManager.VERTICAL,false)
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.fragment_gamess)

    val items = listOf("Todos","Survival Horror","Sandbox","Deporte","Shooter","Pelea","Carreras","Accion","Aventura")
    val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete)

    val adapterFil = ArrayAdapter(this,R.layout.list_item,items)
    autoComplete.setAdapter(adapterFil)

    ///filtro
    autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->

        val itemSelectedListener = adapterView.getItemAtPosition(i)

        if (itemSelectedListener.toString() == "Todos") {
            listaDeJuegos = GameRepository.get() as MutableList<Game>
        } else {
            listaDeJuegos = GameRepository.getGameforGener(itemSelectedListener.toString()) as MutableList<Game>
        }
        adapter.setListaFiltrada(listaDeJuegos)
    }
    initRecyclerview()

}

fun initRecyclerview() {
    val rv: RecyclerView = findViewById(R.id.rv_juegos_disponible)
    adapter = GamesAdapter(listaDeJuegos,this)
    rv.layoutManager = llmanager
    rv.adapter = adapter
}
override fun comprarEvento(id: Long, price: Double) {
    ///fragment
    val intent = Intent(this, GamesFragment::class.java)///ahora lo hago
    intent.putExtra("total",price)
    intent.putExtra("id_game",id)
    //aca tengo que pasarle tambien el id del usuario y

    startActivity(intent)
}*/

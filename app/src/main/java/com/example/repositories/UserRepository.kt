package repositories

import android.os.Build
import com.example.Data.User
import src.main.kotlin.src.main.kotlin.repositories.hoyConMiFormato
import java.time.LocalDate

object UserRepository {

    private val users = mutableListOf<User>()
    var usuario:User? = null
    var idGame:Long = 1L

    init {
        users.add(User(1504L, "BRIAN_BAYARRI", "abc123", "Brian", "Bayarri", 350.50, "2022/12/10"))
        users.add(User(2802L, "AHOZ", "lock_password", "Aylen", "Hoz", 200.50, "2021/01/11"))
        users.add(User(1510L, "Diegote", "@12345", "Diego", "Gonzales", 12.0, "2018/04/15"))
        users.add(User(1534L,"NickName","Password","Prueba","Check",1500.0,"2023/01/05"))
    }

    fun login(nickName: String,password: String) : Boolean {
        usuario = users.find{ user -> user.nickName == nickName && user.password == password }
        return usuario != null
    }


    fun addUser(newUser: User):Boolean{
       return  users.add(newUser)
    }
    fun getLastId():Long{
        val ultimo = users.last()
        return ultimo.id+1
    }
    fun crearUsuario(nickname:String,password: String,name: String,surname:String,money:Double){

            val hoy: LocalDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                LocalDate.now()
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            usuario = User(getLastId(),nickname,password,name,surname,money,hoy.hoyConMiFormato())
            addUser(usuario!!)

    }

}
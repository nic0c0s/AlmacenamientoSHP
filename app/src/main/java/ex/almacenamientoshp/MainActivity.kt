package ex.almacenamientoshp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val sharedP = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextView>(R.id.txtName)
        val email = findViewById<TextView>(R.id.txtMail)

        val save = findViewById<Button>(R.id.btnSave)
        val search = findViewById<Button>(R.id.btnSearch)

        val sp = getSharedPreferences(sharedP, Context.MODE_PRIVATE)


        save.setOnClickListener {
            val editor = sp.edit()      //modo edicion de sp.
            editor.putString(name.text.toString(), email.text.toString())    //guardando datos
            editor.apply()       //guardando cambios
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show()
            name.setText("")    //limpiando campos
            email.setText("")

        }

        search.setOnClickListener {
            // recuperando el correo con la clave nombre
            val correo = sp.getString(name.text.toString(), "")

            if(correo!!.isNotEmpty()){
                email.setText(correo) //escribiendo el correo en el campo
            }
            else{
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_LONG).show()
            }
        }
    }
}
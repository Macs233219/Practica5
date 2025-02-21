package mx.edu.itson.potros.practica5

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        var listView: ListView = findViewById(R.id.listview) as ListView

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listView.adapter = adaptador
    }

    fun agregarProductos(option:String?) {
        when(option) {
            "Antojitos"->{
                menu.add(Product("Quesadillas", R.drawable.quesadillas, "Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", 5.69))
                menu.add(Product("Huaraches", R.drawable.huaraches, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big Thick tortilla with beans, your choice", 10.99))
                menu.add(Product("Gringas", R.drawable.gringas, "Tortilla de harina con queso, carne al pastor y piña - Flour tortilla filled with cheese, marinated pork and pineapple", 7.99))
                menu.add(Product("Sincronizada", R.drawable.sincronizadas, "Tortilla de harina y rellena con queso y jamón. Acompañada de lechuga, crema y guacamole - Two flour tortillas filled with ham and cheese. Served with lettuce, sour cream, and guacamole.", 7.99))
                menu.add(Product("Sopes", R.drawable.sopes, "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema - Fried thick tortilla with beans, your choice of meat, lettuce, fresh cheese, and sour cream.", 3.79))
                menu.add(Product("Tostadas", R.drawable.tostadas, "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate - Fried tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes.", 4.59))
            }
            "Especialidades"->{
                menu.add(Product("Mojarra Frita - Fried Fish", R.drawable.quesadillas, "Tilapia frita servida con lechuga, cebolla, jitomate, aguacate y tortillas - Fried tilapia served with lettuce, onions, tomatoes, avocado and tortillas", 6.99))
                menu.add(Product("Ceviche", R.drawable.quesadillas, "Tilapia, camarones. Aguacate y pico de gallo servido con Chips / Tilapia, Shrimp, Avocado and pico de gallo, served with Chips", 6.99))
                menu.add(Product("Botana de camarones a la Diabla", R.drawable.quesadillas, "", 19.99))
                menu.add(Product("Torre de Camarón Negro", R.drawable.quesadillas, "", 19.99))
                menu.add(Product("Botana de Pulpo a la Diabla", R.drawable.quesadillas, "", 16.99))
                menu.add(Product("Botana de Pulpo al Mojo de Ajo", R.drawable.quesadillas, "", 24.99))
                menu.add(Product("Pulpo al Mojo de Ajo", R.drawable.quesadillas, "", 35.00))
                menu.add(Product("Pulpo Zarandeado", R.drawable.quesadillas, "", 35.00))
            }
        }
    }

    private class AdaptadorProductos: BaseAdapter {
        var producto=ArrayList<Product>()
        var contexto: Context?=null

        constructor(contexto: Context, producto: ArrayList<Product>) {
            this.producto=producto
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return producto.size
        }

        override fun getItem(position: Int): Any {
            return producto[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod=producto [position]
            var inflador= LayoutInflater.from(contexto)
            var vista= inflador.inflate(R.layout.producto_view, null)

            var imagen= vista.findViewById(R.id.producto_img) as ImageView
            var nombre= vista.findViewById(R.id.producto_nombre) as TextView
            var desc= vista.findViewById(R.id.producto_desc) as TextView
            var precio= vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}
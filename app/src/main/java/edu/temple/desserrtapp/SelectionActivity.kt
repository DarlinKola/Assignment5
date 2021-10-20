package edu.temple.desserrtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {

    /**
     * Companion objects are used in Kotlin
     * as containers of public static fields
     */
    companion object {
        val ITEM_KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the title for the activity.
        // This is done to ensure that the activity label
        // displayed in the Android launcher is different
        supportActionBar?.title = "Selector"

        val items = generateTestData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            // Item object can be placed directly inside Intent because
            // the Item class implements the Parcelable interface
            val launchIntent = Intent(this, DisplayActivity::class.java)
                .putExtra(ITEM_KEY, items[itemPosition])

            startActivity(launchIntent)
        }

        recyclerView.adapter = ImageAdapter(items, onClickListener)
    }

    /**
     * Generate test info for app
     */
    fun generateTestData(): Array<Item> {
        val itemNames = resources.getStringArray(R.array.names)
        return arrayOf(Item(R.drawable.ccf_original, itemNames[0])
            , Item(R.drawable.ccf_freshstrawberry,itemNames[1])
            , Item(R.drawable.ccf_chocolatecaramelicious,itemNames[2])
            , Item(R.drawable.ccf_pineappleupsidedown,itemNames[3])
            , Item(R.drawable.ccf_celebration,itemNames[4])
            , Item(R.drawable.ccf_caramelapple,itemNames[5])
            , Item(R.drawable.ccf_verycherryghirardellichocolate,itemNames[6])
            , Item(R.drawable.ccf_lowlicious,itemNames[7])
            , Item(R.drawable.ccf_cinnaboncinnamoncwirl,itemNames[8])
            , Item(R.drawable.ccf_godiva,itemNames[9])
            , Item(R.drawable.ccf_coconutcreampie,itemNames[10])
            , Item(R.drawable.ccf_saltedcaramel,itemNames[11]))
    }
}
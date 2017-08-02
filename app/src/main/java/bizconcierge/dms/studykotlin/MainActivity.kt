package bizconcierge.dms.studykotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Kotlin Android Extensions: Say goodbye to findViewById (KAD 04)
 * <a href="https://antonioleiva.com/kotlin-android-extensions/">
 * https://android.jlelse.eu/learn-kotlin-while-developing-an-android-app-part-2-e53317ffcbe9
 *
 * info - The words “extends” and “implement” were replaced by a colon “:” indifferently. In this case we are extending from AppCompatActivity (which is a Java class!)
 */
class MainActivity : AppCompatActivity() {

    // In the case that we don’t want to return any value in Java we would use “void”, here the alternative is “Unit” which works in the same way.
    override fun onCreate(savedInstanceState: Bundle?) : Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // info - Bye Semicolon;
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        // info val:constant
        val price = 100        // Int
//        price = 30             // don't compile! it's a constant
        var total = price * 3  // Int
        val name = "Juancho"   // String

//      info - You can specify the type explicitly:
        // Maybe you notice that there are no primitive types, we don’t use “double” but “Double”.
        // This is because everything in Kotlin is an object. For performance, the compiler will transform some of these objects to primitive types internally.
        val lastname : String = "Keddit" // explicit type definition
        var size : Double = 30.0
        var time : Float = 15f

        // In Kotlin you access properties like accessing a field in Java. Instead of calling the getResources() method from an Activity you directly do:
        resources.getString(R.string.app_name)
        getResources().getString(R.string.app_name) // still allowed

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

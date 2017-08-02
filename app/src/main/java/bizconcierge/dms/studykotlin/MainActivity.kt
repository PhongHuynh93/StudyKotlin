package bizconcierge.dms.studykotlin

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import bizconcierge.dms.studykotlin.features.news.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Kotlin Android Extensions: Say goodbye to findViewById (KAD 04)
 * <a href="https://antonioleiva.com/kotlin-android-extensions/">
 * https://android.jlelse.eu/learn-kotlin-while-developing-an-android-app-part-2-e53317ffcbe9
 *
 * info - The words “extends” and “implement” were replaced by a colon “:” indifferently. In this case we are extending from AppCompatActivity (which is a Java class!)
 */
class MainActivity : AppCompatActivity() {
    private val TAG = "TAG";
    // In the case that we don’t want to return any value in Java we would use “void”, here the alternative is “Unit” which works in the same way.
    override fun onCreate(savedInstanceState: Bundle?) : Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // info - Bye Semicolon;
        setSupportActionBar(toolbar)

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

        // info In Kotlin you access properties like accessing a field in Java. Instead of calling the getResources() method from an Activity you directly do:
        resources.getString(R.string.app_name)
        getResources().getString(R.string.app_name) // still allowed

        // info - This is one of the great things about Kotlin, everything in Kotlin is not nullable unless you specifically declare it in this way.
        // The way to do this is with the “?” question mark which also suggest you that the value could be there or not.

//        val a : String = null  // don't compile!
//        var b : Int          // neither as must be initialized or abstract.
        val ok : String? = null // OK :)

        // info - ko crash
        // To interact with a nullable object is really easy, the “?” question mark will allow you to get the value just in case it exists,
        // otherwise it will ignore it and you are safe to continue running the program:
        val context : Context? = null
        val res = context?.getResources() // not crash, res will be null

        val appName = res?.getString(R.string.app_name)
        val shortName = appName?.substring(0, 2)

        if (context != null) {
            val res = context.getResources()    // Don't need '?' anymore
            val appName = res.getString(R.string.app_name)
            val shortName = appName.substring(0, 2)
        }
        // info - There is another subtle use of let when applied to a nullable reference. The ?. operator
//        lets you make sure that the code in scope is only run if the expression is not null:
        // http://beust.com/weblog/2016/01/14/a-close-look-at-kotlins-let/

        // info - To perform a certain operation only for non-null values, you can use the safe call operator together with let:
        // https://kotlinlang.org/docs/reference/null-safety.html
        context?.let {
            val res = context.getResources()    // Don't need '?' anymore
            val appName = res.getString(R.string.app_name)
            val shortName = appName.substring(0, 2)
        }

        val arrayOfString = arrayOf("hello", "hi")
        val arrayOfInt = arrayOf(1, 2)

        /**
         * https://kotlinlang.org/docs/reference/collections.html
         */
        val numbers = mutableListOf(1, 2, 3)
        val readOnlyView: List<Int> = numbers
        println(numbers)        // prints "[1, 2, 3]"
        numbers.add(4)
        println(readOnlyView)   // prints "[1, 2, 3, 4]"
//        readOnlyView.clear()    // -> does not compile

//        print(add(2, 8))

        // info - Elvis Operator ?:
        // This is the name used for this operator “?:” and you can use it to give an alternative value in case the object is null.
        try {
            // code...
        } catch (e: Throwable) {
            Log.e("TAG", e.message ?: "Error message")
        }

        // tự declare type, để cho kotlin sd đúng hàm, class
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val totalSum = add(1)(2)
        val totalSum2 = add(1)
        Log.e(TAG, "Total value is $totalSum")
        Log.e(TAG, "Total value is $totalSum2")

        if (savedInstanceState == null) {
            changeFragment(NewsFragment())
        }

    }

    fun changeFragment(f: Fragment, cleanStack: Boolean = false) {
        val ft = supportFragmentManager.beginTransaction();
        if (cleanStack) {
            clearBackStack()
        }
        ft.setCustomAnimations(
                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        ft.replace(R.id.activity_base_content, f)
        ft.addToBackStack(null)
        ft.commit()
    }

    // clear all the backstack by get the id of the first entrypoint of the fragment
    private fun clearBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
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

//    fun add(a : Int, b : Int) = a + b

    fun add(a : Int) : (Int) -> Int{
        return { x -> a + x }
    }
}

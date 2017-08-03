// info The name of the Utility class will be the same as the file’s name plus “Kt” suffix or you can override it with an specific annotation:
@file:JvmName("ExtensionsUtils")
package bizconcierge.dms.studykotlin.commons.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by user on 8/3/2017.
 */
// info - Extension Functions (Utility class?)
//Extension functions allow us to extend the functionality of a class by adding new functions. The class doesn’t have to belongs to us (could it be a third party library) and also without requiring us to inherit the class.

/**
 * // Java
ExtensionsKt.inflate(container, R.layout.news_fragment);
// Kotlin
container?.inflate(R.layout.news_fragment)

What we are doing here is to add a new method to ViewGroup (see how we add the ViewGroup with a dot before the “inflate” method name) but we are not modifying the ViewGroup class but adding a new function. This function will be internally a static method but you will be calling it from an instance of a class with the dot-notation, in this case: container.inflate(…) and not ViewGroup.inflate(). This is because the compiler will be creating a Util class for us.
 */
// info - In Kotlin you are able to define default values in the parameters of a function
// info Inside the code block it’s like you are writing code as it is a real new method of the class (like a regular method) that’s why you can access to the instance of the class with the “this” keyword and access to the local variable “context”.
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
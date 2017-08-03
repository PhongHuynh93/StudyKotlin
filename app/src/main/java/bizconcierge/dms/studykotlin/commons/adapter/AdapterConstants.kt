package bizconcierge.dms.studykotlin.commons.adapter

/**
 * Created by user on 8/3/2017.
 * info Singleton is a very useful pattern, and Kotlin (after Scala) makes it easy to declare singletons:
 * https://kotlinlang.org/docs/reference/object-declarations.html
 *
 * an object declaration is not an expression, and cannot be used on the right hand side of an assignment statement.
 *
 * To refer to the object, we use its name directly:
 * DataProviderManager.registerDataProvider(...)
 */
object AdapterConstants {
    val NEWS = 1
    val LOADING = 2
}
package bizconcierge.dms.studykotlin.commons

import android.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by USER on 8/2/2017.
 *
 * open
 * https://kotlinlang.org/docs/reference/classes.html
 * The open annotation on a class is the opposite of Java's final: it allows others to inherit from this class. By default, all classes in Kotlin are final,
 */
open class RxBaseFragment() : Fragment() {
    protected var subscription = CompositeSubscription();

    override fun onResume() {
        super.onResume()
        subscription = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        subscription.clear()
    }
}
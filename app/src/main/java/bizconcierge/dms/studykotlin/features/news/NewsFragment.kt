package bizconcierge.dms.studykotlin.features.news


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bizconcierge.dms.studykotlin.App

import bizconcierge.dms.studykotlin.R
import bizconcierge.dms.studykotlin.commons.RedditNews
import bizconcierge.dms.studykotlin.commons.RxBaseFragment
import kotlinx.android.synthetic.main.fragment_news.*


/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : RxBaseFragment() {
    private var redditNews : RedditNews? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * The other way around though requires that you declare that this nullable variable does not contain null at the point of assignment with !! operator (which pretty much declares : "I am sure this nullable variable is not null at this point")
     * https://gist.github.com/dodyg/5823184
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        // info - lúc này thì inflater ko có null
        val view = inflater!!.inflate(R.layout.fragment_news, container, false)
        news_list?.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }

}// Required empty public constructor

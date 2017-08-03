package bizconcierge.dms.studykotlin.commons

import android.os.Parcel
import android.os.Parcelable
import bizconcierge.dms.studykotlin.commons.adapter.AdapterConstants
import bizconcierge.dms.studykotlin.commons.adapter.ViewType

/**
 * Created by user on 8/3/2017.
 */
data class RedditNews(
        val after : String,
        val before : String,
        val news: List<RedditNewsItem>
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(RedditNewsItem.CREATOR)) {
    }

    override fun writeToParcel(dest: Parcel?, p1: Int) {
        dest?.writeString(after)
        dest?.writeString(before)
        dest?.writeTypedList(news)    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RedditNews> {
        override fun createFromParcel(parcel: Parcel): RedditNews {
            return RedditNews(parcel)
        }

        override fun newArray(size: Int): Array<RedditNews?> {
            return arrayOfNulls(size)
        }
    }

}

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String?
) : ViewType, Parcelable {

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readInt(), source.readLong(), source.readString(), source.readString())

    override fun getViewType(): Int {
        return AdapterConstants.NEWS
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<RedditNewsItem> = object : Parcelable.Creator<RedditNewsItem> {
            override fun createFromParcel(source: Parcel): RedditNewsItem = RedditNewsItem(source)
            override fun newArray(size: Int): Array<RedditNewsItem?> = arrayOfNulls(size)
        }
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(author)
        dest?.writeString(title)
        dest?.writeInt(numComments)
        dest?.writeLong(created)
        dest?.writeString(thumbnail)
        dest?.writeString(url)
    }
}
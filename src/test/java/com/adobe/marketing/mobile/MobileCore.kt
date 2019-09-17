package com.adobe.marketing.mobile

import android.app.Application

class MobileCore {

    companion object {
        var configKey: String? = null

        @JvmStatic
        fun start(callback: AdobeCallback<Any>) {
            callback.call("")
        }

        @JvmStatic
        fun configureWithAppID(key: String) {
            configKey = key
        }

        @JvmStatic
        fun setApplication(application: Application) {}
    }
}


interface AdobeCallback<T> {
    fun call(t: T)
}

open class BaseAdobeExtension {
    companion object {
        @JvmStatic
        fun registerExtension() {}
    }
}

class MobileServices: BaseAdobeExtension()
class Analytics: BaseAdobeExtension()
class UserProfile: BaseAdobeExtension()
class Identity: BaseAdobeExtension()
class Lifecycle: BaseAdobeExtension()
class Signal: BaseAdobeExtension()


class Media: BaseAdobeExtension() {
    companion object {
        @JvmStatic
        fun createTracker(callback: AdobeCallback<MediaTracker>) {
            callback.call(MediaTracker())
        }
    }

    enum class MediaType {
        Video,
        Audio;
    }
}

class MediaTracker


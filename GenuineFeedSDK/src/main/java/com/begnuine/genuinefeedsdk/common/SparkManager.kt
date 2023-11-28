package com.begnuine.genuinefeedsdk.common

import android.app.Activity
import com.begenuine.feedscreensdk.common.Constants
import com.begenuine.feedscreensdk.common.Utility
import com.begnuine.genuinefeedsdk.core.interfaces.ResponseListener
import com.begnuine.genuinefeedsdk.data.model.ChatModel
import com.begnuine.genuinefeedsdk.data.model.CommentModel
import com.begnuine.genuinefeedsdk.data.model.DiscoverModel
import com.begnuine.genuinefeedsdk.data.model.MessageModel
import com.begnuine.genuinefeedsdk.data.remote.BaseAPIService
import org.json.JSONObject

class SparkManager {
    /**
     * type:
     *      1 -> public video
     *      2 -> conversation video
     *      3 -> comment
     */
    companion object {
        fun spark(context: Activity, model: Any, contentId: String, type: Int, spark: Boolean) {
            val jsonObject = JSONObject()
            jsonObject.put("content_id", contentId)
            jsonObject.put("type", type)
            jsonObject.put("spark", spark)
            BaseAPIService(
                context,
                Constants.REACTION_SPARK,
                Utility.getRequestBody(jsonObject.toString()),
                true,
                object : ResponseListener {
                    override fun onSuccess(response: String?) {
                        Utility.showLog("Tag", "Spark/UnSpark Success!")
                    }

                    override fun onFailure(error: String?) {
                        Utility.showLog("Tag", "Spark/UnSpark Failure!")
                        when (model) {
                            is DiscoverModel -> {
                                model.setSparkStatus(!model.isSparked)
                            }

                            is ChatModel -> {
                                model.setSparkStatus(!model.isSparked)
                            }

                            is MessageModel -> {
                                model.setSparkStatus(!model.isSparked)
                            }

                            is CommentModel -> {
                                model.setSparkStatus(!model.isSparked)
                            }
                        }
                    }
                },
                "POST",
                false
            )
        }
    }
}
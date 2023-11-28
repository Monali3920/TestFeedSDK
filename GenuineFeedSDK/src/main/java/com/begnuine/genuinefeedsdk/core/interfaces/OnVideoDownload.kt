package com.begnuine.genuinefeedsdk.core.interfaces

interface OnVideoDownload {
    fun onSuccessfullyDownloadVideo()

    fun onDownloadVideoFailure(code: Int)
}
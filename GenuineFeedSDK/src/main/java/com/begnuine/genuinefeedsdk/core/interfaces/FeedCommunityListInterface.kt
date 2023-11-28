package com.begnuine.genuinefeedsdk.core.interfaces

import com.begnuine.genuinefeedsdk.data.model.CommunityModel


interface FeedCommunityListInterface {
    fun onCommunityListLoaded(communityList: ArrayList<CommunityModel>)
}
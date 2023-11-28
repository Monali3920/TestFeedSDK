package com.begnuine.genuinefeedsdk.core.interfaces;

import com.begnuine.genuinefeedsdk.data.viewmodel.ExploreViewModel;

import java.util.ArrayList;

public interface FeedViewModelListener {
    void onFeedDataLoaded(ArrayList<ExploreViewModel> discoverVOArrayList, boolean isNewDiscover);

    void onFeedCacheDataLoaded(ArrayList<ExploreViewModel> discoverVOArrayList);

    void onEmptyFeedData(boolean isNewDiscover);

    void onFeedDataFailure(String code, boolean isSearch);
}

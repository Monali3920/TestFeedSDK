package com.begnuine.genuinefeedsdk.core.interfaces;

public interface LoopSuggestionPagerEventListener {
    void onButtonClick();
    void onItemScroll();
    void onApiComplete(boolean isSuccess);
    void onGoToFeedClicked();
}

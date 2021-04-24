package com.example.android.uamp.fragments;

import java.lang.System;

/**
 * A fragment representing the current media item being played.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/android/uamp/fragments/NowPlayingFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mainActivityViewModel", "Lcom/example/android/uamp/viewmodels/MainActivityViewModel;", "nowPlayingViewModel", "Lcom/example/android/uamp/viewmodels/NowPlayingFragmentViewModel;", "playerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "positionTextView", "Landroid/widget/TextView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateUI", "metadata", "Lcom/example/android/uamp/viewmodels/NowPlayingFragmentViewModel$NowPlayingMetadata;", "Companion", "app_debug"})
public final class NowPlayingFragment extends androidx.fragment.app.Fragment {
    private com.example.android.uamp.viewmodels.MainActivityViewModel mainActivityViewModel;
    private com.example.android.uamp.viewmodels.NowPlayingFragmentViewModel nowPlayingViewModel;
    private android.widget.TextView positionTextView;
    private androidx.constraintlayout.widget.ConstraintLayout playerView;
    public static final com.example.android.uamp.fragments.NowPlayingFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Internal function used to update all UI elements except for the current item playback
     */
    private final void updateUI(android.view.View view, com.example.android.uamp.viewmodels.NowPlayingFragmentViewModel.NowPlayingMetadata metadata) {
    }
    
    public NowPlayingFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/android/uamp/fragments/NowPlayingFragment$Companion;", "", "()V", "newInstance", "Lcom/example/android/uamp/fragments/NowPlayingFragment;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.android.uamp.fragments.NowPlayingFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
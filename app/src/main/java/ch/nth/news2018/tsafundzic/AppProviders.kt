package ch.nth.news2018.tsafundzic

import ch.nth.news2018.tsafundzic.api.ApiClient.Companion.getArticleInteractor
import ch.nth.news2018.tsafundzic.presentation.MainInterface
import ch.nth.news2018.tsafundzic.presentation.implementation.MainPresenterImpl

fun mainPresenter(): MainInterface.Presenter = MainPresenterImpl(getArticleInteractor())
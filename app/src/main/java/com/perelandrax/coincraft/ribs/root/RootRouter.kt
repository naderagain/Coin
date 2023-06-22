package com.perelandrax.coincraft.ribs.root

import com.perelandrax.coincraft.ribs.NaderMain.NaderMainBuilder
import com.perelandrax.coincraft.ribs.NaderMain.NaderMainRouter
import com.perelandrax.coincraft.ribs.main.MainBuilder
import com.perelandrax.coincraft.ribs.main.MainRouter
import com.perelandrax.coincraft.ribs.mainBottomTab.MainBottomTabBuilder
import com.perelandrax.coincraft.ribs.mainBottomTab.MainBottomTabRouter
import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RootRouter(
  view: RootView,
  interactor: RootInteractor,
  component: RootBuilder.Component,
  private val mainBuilder: MainBottomTabBuilder
) : ViewRouter<RootView, RootInteractor, RootBuilder.Component>(view, interactor, component) {

  private var mainRouter: MainBottomTabRouter? = null

  fun attachMain() {
    mainRouter = mainBuilder.build(view)
    attachChild(mainRouter)
    view.addView(mainRouter?.view)
  }

  fun detachMain() {
    mainRouter?.let {
      detachChild(it)
      mainRouter = null
    }
  }
}

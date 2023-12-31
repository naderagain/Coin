package com.perelandrax.coincraft.ribs.root

import com.perelandrax.coincraft.ribs.main.MainBuilder
import com.perelandrax.coincraft.ribs.main.MainRouter
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
  private val mainBuilder: MainBuilder
) : ViewRouter<RootView, RootInteractor, RootBuilder.Component>(view, interactor, component) {

  private var mainRouter: MainRouter = mainBuilder.build(view)

  fun attachMain() {
    attachChild(mainRouter)
    view.addView(mainRouter.view)
  }
}

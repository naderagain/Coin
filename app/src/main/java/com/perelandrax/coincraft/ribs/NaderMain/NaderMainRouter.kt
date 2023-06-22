package com.perelandrax.coincraft.ribs.NaderMain

import com.perelandrax.coincraft.ribs.main.MainInteractor
import com.perelandrax.coincraft.ribs.mainBottomTab.MainBottomTabBuilder
import com.perelandrax.coincraft.ribs.mainBottomTab.MainBottomTabRouter
import com.uber.rib.core.ViewRouter
import kotlinx.android.synthetic.main.main_rib.view.mainBottomTab


// notice the VIC
class NaderMainRouter(
    view:NaderMainView,
    interactor: NaderMainInteractor,
    component: NaderMainBuilder.Component,

   private val mainBottomTabBuilder: MainBottomTabBuilder
): ViewRouter<NaderMainView, NaderMainInteractor, NaderMainBuilder.Component>(view,interactor, component){

    private var mainBottomTabRouter: MainBottomTabRouter? = null


    fun attachMainBottomTab(){

        // NOTICE THE Router to Builder connection here:

        mainBottomTabRouter = mainBottomTabBuilder.build(view)
        attachChild(mainBottomTabRouter)
        view.mainBottomTab.addView(mainBottomTabRouter?.view)
    }


}
package com.perelandrax.coincraft.ribs.NaderMain

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject


// only nader's PR
@RibInteractor
class NaderMainInteractor: Interactor<NaderMainInteractor.NaderMainPresenter, NaderMainRouter>() {

    @Inject lateinit var presenter: NaderMainPresenter


    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        routeToMainBottomTab()

    }

    // Interactor --> Router

    fun routeToMainBottomTab(){
        router.attachMainBottomTab()
    }


    override fun willResignActive() {
        super.willResignActive()
    }




    interface NaderMainPresenter
}
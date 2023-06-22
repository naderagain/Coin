package com.perelandrax.coincraft.ribs.NaderMain

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.perelandrax.coincraft.ribs.main.MainInteractor
import com.perelandrax.coincraft.ribs.main.MainView

class NaderMainView @JvmOverloads constructor(
    context: Context, attr:AttributeSet?=null, defStyle: Int = 0


) : ConstraintLayout(context, attr, defStyle), NaderMainInteractor.NaderMainPresenter
package com.perelandrax.coincraft.ribs.NaderMain

import android.view.LayoutInflater
import android.view.ViewGroup
import com.perelandrax.coincraft.R

import com.perelandrax.coincraft.ribs.mainBottomTab.MainBottomTabBuilder
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.BINARY

/**
 * Builder for the {@link NaderMainScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class NaderMainBuilder(dependency: ParentComponent) :
    ViewBuilder<NaderMainView, NaderMainRouter, NaderMainBuilder.ParentComponent>(dependency) {

    /**
     * Builds a new [NaderMainRouter].
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new [NaderMainRouter].
     */
    fun build(parentViewGroup: ViewGroup): NaderMainRouter {
        val view = createView(parentViewGroup)
        val interactor = NaderMainInteractor()
        val component = DaggerNaderMainBuilder_Component.builder()
            .parentComponent(dependency)
            .view(view)
            .interactor(interactor)
            .build()
        return component.NaderMainRouter()
    }

    override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): NaderMainView? {
        return inflater.inflate(R.layout.nader_main_rib, parentViewGroup, false) as NaderMainView
    }

    interface ParentComponent {

    }

    @dagger.Module
    abstract class Module {

        @NaderMainScope @Binds
        internal abstract fun presenter(view: NaderMainView): NaderMainInteractor.NaderMainPresenter

        @dagger.Module
        companion object {

            @NaderMainScope @Provides @JvmStatic
            internal fun router(
                component: Component,
                view: NaderMainView,
                interactor: NaderMainInteractor
            ): NaderMainRouter {
                return NaderMainRouter(view, interactor, component, MainBottomTabBuilder(component))
            }

            // TODO: Create provider methods for dependencies created by this Rib. These should be static.
        }
    }

    @NaderMainScope
    @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
    interface Component :
        InteractorBaseComponent<NaderMainInteractor>,
        BuilderComponent,
        MainBottomTabBuilder.ParentComponent {

        @dagger.Component.Builder
        interface Builder {

            @BindsInstance
            fun interactor(interactor: NaderMainInteractor): Builder

            @BindsInstance
            fun view(view: NaderMainView): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun NaderMainRouter(): NaderMainRouter
    }

    @Scope
    @Retention(BINARY)
    internal annotation class NaderMainScope

    @Qualifier
    @Retention(BINARY)
    internal annotation class NaderMainInternal
}

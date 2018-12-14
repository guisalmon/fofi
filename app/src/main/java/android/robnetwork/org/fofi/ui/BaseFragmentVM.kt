package android.robnetwork.org.fofi.ui

import com.airbnb.mvrx.*
import io.reactivex.Single

abstract class BaseFragmentVM<S : MvRxState>(initialState: S): BaseMvRxViewModel<S>(initialState) {

    protected fun <T : Any> Single<T>.asyncRequest(newState: (state: Async<T>) -> Unit) =
        doOnSubscribe { newState(Loading()) }.subscribe({ newState(Success(it)) }, { newState(Fail(it)) }).disposeOnClear()
}
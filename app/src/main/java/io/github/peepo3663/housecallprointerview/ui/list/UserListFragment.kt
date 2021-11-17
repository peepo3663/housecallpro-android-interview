package io.github.peepo3663.housecallprointerview.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import io.github.peepo3663.housecallprointerview.R
import io.github.peepo3663.housecallprointerview.components.DaggerFragmentComponent
import io.github.peepo3663.housecallprointerview.models.User
import io.github.peepo3663.housecallprointerview.modules.FragmentModule
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class UserListFragment : Fragment(), ListContract.View {

    @Inject lateinit var presenter: ListContract.Presenter
    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder().fragmentModule(FragmentModule()).build()
        listComponent.inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_first, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.unsubscribe()
    }

    private fun initView() {
        presenter.loadData()
    }

    override fun showProgress(show: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showErrorMessage(error: String) {
        TODO("Not yet implemented")
    }

    override fun loadUserListDataSuccess(users: List<User>) {
        TODO("Not yet implemented")
    }
}
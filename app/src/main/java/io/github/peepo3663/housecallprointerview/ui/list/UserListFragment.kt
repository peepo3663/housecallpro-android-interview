package io.github.peepo3663.housecallprointerview.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.peepo3663.housecallprointerview.R
import io.github.peepo3663.housecallprointerview.api.ApiService
import io.github.peepo3663.housecallprointerview.components.DaggerFragmentComponent
import io.github.peepo3663.housecallprointerview.models.User
import io.github.peepo3663.housecallprointerview.modules.FragmentModule
import io.github.peepo3663.housecallprointerview.modules.NetworkModule
import kotlinx.android.synthetic.main.fragment_user_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class UserListFragment : Fragment(), ListContract.View {

    @Inject lateinit var presenter: ListContract.Presenter
    @Inject lateinit var api: ApiService
    private lateinit var rootView: View

    companion object {
        const val TAG = "UserListFragment"
    }

    fun newInstance(): UserListFragment {
        return UserListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder().fragmentModule(FragmentModule()).networkModule(NetworkModule()).build()
        listComponent.inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_user_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attach(this, api)
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
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String?) {
        Log.e(TAG, error ?: "Error")
    }

    override fun loadUserListDataSuccess(users: List<User>) {
        val activity = requireActivity()
        val adapter = UserListAdapter(users.toMutableList())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }
}
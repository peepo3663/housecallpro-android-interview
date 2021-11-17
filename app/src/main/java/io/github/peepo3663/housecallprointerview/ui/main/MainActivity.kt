package io.github.peepo3663.housecallprointerview.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import io.github.peepo3663.housecallprointerview.R
import io.github.peepo3663.housecallprointerview.api.ApiService
import io.github.peepo3663.housecallprointerview.components.DaggerActivityComponent
import io.github.peepo3663.housecallprointerview.modules.ActivityModule
import io.github.peepo3663.housecallprointerview.modules.NetworkModule
import io.github.peepo3663.housecallprointerview.ui.list.UserListFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter
    @Inject
    lateinit var api: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        injectDependency()

        presenter.attach(this, api)
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .networkModule(NetworkModule())
            .build()
        activityComponent.inject(this);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showUserListFragment() {
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .replace(R.id.nav_host_fragment, UserListFragment().newInstance(), UserListFragment.TAG)
            .commit()
    }
}
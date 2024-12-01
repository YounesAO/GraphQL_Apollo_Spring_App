package ma.ensa.banque.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.apollographql.apollo3.ApolloClient
import ma.ensa.banque.R
import ma.ensa.banque.adapter.CompteAdapter
import ma.ensa.banque.databinding.ActivityMainBinding
import ma.ensa.banque.repository.CompteRepository
import ma.ensa.banque.utils.Resource
import ma.ensa.banque.viewmodel.CompteViewModel
import ma.ensa.banque.viewmodel.CompteViewModelFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CompteViewModel
    private lateinit var adapter: CompteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setupViewModel()
        setupObservers()
        setupFab()
    }

    private fun setupRecyclerView() {
        adapter = CompteAdapter { id -> viewModel.deleteCompte(id) }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val itemTouchHelper = ItemTouchHelper(CompteAdapter.SwipeToDeleteCallback(adapter,applicationContext ))
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }

    private fun setupViewModel() {
        val apolloClient = ApolloClient.Builder()
            .serverUrl("http://192.168.86.1:8082/graphql")
            .build()
        val repository = CompteRepository(apolloClient)
        viewModel = ViewModelProvider(
            this,
            CompteViewModelFactory(repository)
        )[CompteViewModel::class.java]
        viewModel.loadComptes()

    }

    private fun setupObservers() {
        viewModel.comptes.observe(this) { resource ->
            when (resource) {
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.setData(resource.data ?: emptyList())
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show()
                }
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setupFab() {
        binding.fab.setOnClickListener {
            AddCompteFragment().show(supportFragmentManager, "AddCompteFragment")
        }
    }
}
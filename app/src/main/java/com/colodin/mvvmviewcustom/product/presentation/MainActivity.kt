package com.colodin.mvvmviewcustom.product.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.colodin.mvvmviewcustom.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val viewModel: ProductViewModel by inject { parametersOf(this) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.uiState.collect {
                it.productShowProgress?.consume()?.let { showProgress->
                    binding.progressBar.isVisible = showProgress
                }

                it.productErrorMessage?.consume()?.let { showErrorMessage->
                    Toast.makeText(this@MainActivity, showErrorMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
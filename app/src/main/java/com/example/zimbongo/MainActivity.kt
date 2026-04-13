package com.example.zimbongo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zimbongo.Splash.SplashScreen
import com.example.zimbongo.view.Home
import com.example.zimbongo.Routes.Routes
import com.example.zimbongo.data.local.AppDatabase
import com.example.zimbongo.data.repository.LancamentoRepository
import com.example.zimbongo.view.FormularioScreen
import com.example.zimbongo.view.ListagemScreen
import com.example.zimbongo.viewmodel.LancamentoViewModel
import com.example.zimbongo.viewmodel.LancamentoViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val context = this

            val db = AppDatabase.getDatabase(context)
            val dao = db.lancamentoDao()
            val repository = LancamentoRepository(dao)

            val viewModel: LancamentoViewModel = viewModel(
                factory = LancamentoViewModelFactory(repository)
            )

            NavHost(
                navController = navController,
                startDestination = "splash"
            ) {

                composable("splash") {
                    SplashScreen(navController = navController)
                }

                composable("home") {
                    Home(navController = navController)
                }

                composable(Routes.LISTAGEM) {
                    ListagemScreen(
                        viewModel = viewModel,
                        onAdicionarPressed = { }
                    )
                }


                composable(Routes.FORMULARIO) {
                    FormularioScreen(
                        navController = navController,
                        viewModel = viewModel
                    )

                }

            }
        }
    }
}
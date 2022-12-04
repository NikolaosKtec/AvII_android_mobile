package com.example.segundaprova_jogos


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.segundaprova_jogos.databinding.FragmentCadastrarJogoBinding
import com.example.segundaprova_jogos.view_model.CadastraJogoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CadastrarJogoFragment : Fragment() {


    private lateinit var binding: FragmentCadastrarJogoBinding
    private lateinit var viewModel: CadastraJogoViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {



        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cadastrar_jogo, container, false)

//

        viewModel = ViewModelProvider(this).get(CadastraJogoViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.is_cadastrado.observe(viewLifecycleOwner){
            Log.i("ecadFrag",viewModel.is_cadastrado.value.toString())
            if(it) {

                Toast.makeText(context, "cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(binding.root).popBackStack()
                viewModel.post_cadastro()
            }
        }


        return binding.root
    }
}


